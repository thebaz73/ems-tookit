package ems.snmp.toolkit.managed.mixin;

import ems.snmp.toolkit.configuration.ConfigSpaceRepository;
import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.handler.ResponseHandler;
import ems.snmp.toolkit.managed.annotation.OidBind;
import ems.snmp.toolkit.managed.annotation.OidProperty;
import ems.snmp.toolkit.managed.exception.GenericException;
import ems.snmp.toolkit.monitor.mixin.SnmpConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.transport.TLSTM;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/18/12
 * Time: 10:58 AM
 */
privileged aspect SnmpEnquirerAspect {
    private final Map<Object, Map<String, PropertyDescriptor>> SnmpEnquirer.pdCache = Collections.synchronizedMap(new WeakHashMap<Object, Map<String, PropertyDescriptor>>());
    private final Object SnmpEnquirer.gate = new Object();
    private final Log SnmpEnquirer.log = LogFactory.getLog(getClass());
    private Snmp SnmpEnquirer.snmp;
    private AbstractTarget SnmpEnquirer.target;

    private final List<ResponseHandler> ConfigurationAware.responseHandlers = new ArrayList<ResponseHandler>();
    private String ConfigurationAware.spaceKey;

    declare parents: @ems.snmp.managed.annotation.ManagedObject * implements SnmpEnquirer;
    declare parents: @ems.snmp.managed.annotation.ManagedObject * implements ConfigurationAware;

    public void SnmpEnquirer.loadConfiguration(Object targetObj) {
        try {
            synchronized (gate) {
                String sessionUid = ((ConfigurationAware)targetObj).getSpaceKey();
                createSession(ConfigSpaceRepository.getInstance().getConfiguration(sessionUid));
                fillPropertyDescriptorCache(targetObj);
            }
        } catch (Exception ex) {
            if (log.isErrorEnabled()) {
                log.error("Error creating SNMP Session: " + ex.getMessage());
            }
            if (log.isDebugEnabled()) {
                log.debug("Error creating SNMP Session: ", ex);
            }
        }
    }

    public void SnmpEnquirer.injectValue(OidProperty oidProperty, Object targetObj, String methodName) throws GenericException {
        try {
            ResponseEvent response = snmpGet(oidProperty.oid());
            if (response != null) {
                if(log.isDebugEnabled()) {
                    log.debug("Got Snmp Get Response from Agent");
                }
                PDU responsePDU = response.getResponse();

                if (responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();

                    if (errorStatus == PDU.noError) {
                        Vector<? extends VariableBinding> variableBindings = responsePDU.getVariableBindings();
                        if(log.isDebugEnabled()) {
                            log.debug(String.format("Snmp Get Response = %s", variableBindings));
                        }
                        VariableBinding variableBinding = variableBindings.get(0);
                        Variable variable = variableBinding.getVariable();
                        Object value = convert(variable, getValueType(variable));
                        invokeSetValue(pdCache.get(targetObj), oidProperty.fieldName(), targetObj, methodName, value);
                    } else {
                        notifySnmpErrorCode((ConfigurationAware)targetObj, response, oidProperty.oid());
                    }
                } else {
                    if(log.isDebugEnabled()) {
                        log.debug("Error: Response PDU is null");
                    }
                }
            } else {
                notifySnmpErrorCode((ConfigurationAware)targetObj, response, oidProperty.oid());
            }
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    public void SnmpEnquirer.injectTableColumnValue(OidProperty oidProperty, Object targetObj, String methodName) throws GenericException {
        try {
            Method method = targetObj.getClass().getMethod(methodName);
            Class returnType = method.getReturnType();
            if (!returnType.isArray()) {
                throw new GenericException("Reading oid: " + oidProperty.oid() + " return type must be an array");
            }
            List<TableEvent> responseList = snmpGetTable(oidProperty.oid());
            if (responseList != null) {
                if(log.isDebugEnabled()) {
                    log.debug("Got Snmp Get Table Response from Agent");
                }
                List<VariableBinding> variableBindings = new ArrayList<VariableBinding>();
                for (TableEvent response : responseList) {
                    // Process Agent Response
                    if (!response.isError()) {
                        if(log.isDebugEnabled()) {
                            log.debug(String.format("Get index: %s", response.getIndex()));
                        }
                        Collections.addAll(variableBindings, response.getColumns());
                    } else {
                        notifySnmpTableErrorCode((ConfigurationAware)targetObj, response, oidProperty.oid());
                    }
                }
                Object toInject = Array.newInstance(returnType.getComponentType(), variableBindings.size());
                for (int i = 0; i < variableBindings.size(); i++) {
                    VariableBinding variableBinding = variableBindings.get(i);
                    Variable variable = variableBinding.getVariable();
                    Object value = convert(variable, getValueType(variable));
                    if(EmsEnum.class.isAssignableFrom(returnType.getComponentType())) {
                        Object[] enumConstants = returnType.getComponentType().getEnumConstants();
                        for (Object enumConstant : enumConstants) {
                            EmsEnum emsEnum = (EmsEnum) enumConstant;
                            if(emsEnum.getValue().equals(value)) {
                                Array.set(toInject, i, emsEnum);
                                break;
                            }
                        }
                    }
                    else {
                        Array.set(toInject, i, value);
                    }
                }
                invokeSetValue(pdCache.get(targetObj), oidProperty.fieldName(), targetObj, methodName, toInject);
            } else {
                notifySnmpTableErrorCode((ConfigurationAware)targetObj, null, oidProperty.oid());
            }
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    public void SnmpEnquirer.injectTableRowValue(OidProperty oidProperty, Object targetObj, String methodName) throws GenericException {
        try {
            Method method = targetObj.getClass().getMethod(methodName);
            Class returnType = method.getReturnType();
            if (!returnType.isArray()) {
                throw new GenericException("Reading oid: " + oidProperty.oid() + " return type must be an array");
            }
            List<TableEvent> responseList = snmpGetTable(oidProperty.oid());
            if (responseList != null) {
                if(log.isDebugEnabled()) {
                    log.debug("Got Snmp Get Table Response from Agent");
                }
                Map<String ,List<VariableBinding>> map = new HashMap<String, List<VariableBinding>>();
                for (TableEvent response : responseList) {
                    // Process Agent Response
                    if (!response.isError()) {
                        if(log.isDebugEnabled()) {
                            log.debug(String.format("Get index: %s", response.getIndex()));
                        }
                        String index = response.getIndex().toString();
                        String subIndex = index.substring(index.lastIndexOf("."));
                        if(!map.containsKey(subIndex)) {
                            map.put(subIndex, new ArrayList<VariableBinding>());
                        }
                        map.get(subIndex).addAll(Arrays.asList(response.getColumns()));
                    } else {
                        notifySnmpTableErrorCode((ConfigurationAware) targetObj, response, oidProperty.oid());
                    }
                }
                Object toInject = Array.newInstance(returnType.getComponentType(), map.size());
                int i = 0;
                for (Map.Entry<String, List<VariableBinding>> entry : map.entrySet()) {
                    Object object = createValueObject(returnType, entry);
                    Array.set(toInject, i++, object);
                }
                invokeSetValue(pdCache.get(targetObj), oidProperty.fieldName(), targetObj, methodName, toInject);
            } else {
                notifySnmpTableErrorCode((ConfigurationAware) targetObj, null, oidProperty.oid());
            }
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    /*public void SnmpEnquirer.setValue(OidProperty oidProperty, Object targetObj, ManagedObject managedObject, String methodName, Object value) throws GenericException {
        throw new UnsupportedOperationException();
        try {
            //TODO MIB aware operation
            ResponseEvent response = snmpSet(oidProperty.oid(), new OctetString(value.toString()));
            if (response != null) {
                if(log.isDebugEnabled()) {
                    log.debug("Got Snmp Set Response from Agent");
                }
                PDU responsePDU = response.getResponse();

                if (responsePDU != null) {
                    int errorStatus = responsePDU.getErrorStatus();

                    if (errorStatus == PDU.noError) {
                        Vector<? extends VariableBinding> variableBindings = responsePDU.getVariableBindings();
                        if(log.isDebugEnabled()) {
                            log.debug(String.format("Snmp Get Response = %s", variableBindings));
                        }
                        *//*VariableBinding variableBinding = variableBindings.get(0);
                        Variable variable = variableBinding.getVariable();*//*
                    } else {
                        notifySnmpErrorCode((ConfigurationAware)targetObj, response, oidProperty.oid());
                    }
                } else {
                    if(log.isDebugEnabled()) {
                        log.debug("Error: Response PDU is null");
                    }
                }
            } else {
                notifySnmpErrorCode((ConfigurationAware)targetObj, response, oidProperty.oid());
            }
        } catch (IOException e) {
            throw new GenericException(e);
        }
    }*/

    public List<ResponseHandler> ConfigurationAware.getResponseHandlers() {
        return responseHandlers;
    }

    public void ConfigurationAware.addResponseHandler(ResponseHandler responseHandler) {
        synchronized (responseHandlers) {
            responseHandlers.add(responseHandler);
        }
    }

    public void ConfigurationAware.removeResponseHandler(ResponseHandler responseHandler) {
        synchronized (responseHandlers) {
            responseHandlers.remove(responseHandler);
        }
    }

    public String ConfigurationAware.getSpaceKey() {
        return spaceKey;
    }

    public void ConfigurationAware.setSpaceKey(String spaceKey) {
        this.spaceKey = spaceKey;
    }

    private void SnmpEnquirer.createSession(SnmpConfiguration configuration) throws IOException {
        if (snmp == null) {
            Address address = GenericAddress.parse(configuration.getAddress());
            AbstractTransportMapping transport;
            if (address instanceof TlsAddress) {
                transport = new TLSTM();
            } else if (address instanceof TcpAddress) {
                transport = new DefaultTcpTransportMapping();
            } else {
                transport = new DefaultUdpTransportMapping();
            }
            // Could save some CPU cycles:
            transport.setAsyncMsgProcessingSupported(false);
            snmp = new Snmp(transport);
            snmp.listen();
            if (configuration.getVersion() == SnmpConstants.version3) {
                snmp.getUSM().addUser(configuration.getUserName(), configuration.getUser());
                // create the target
                target = new UserTarget();
                target.setSecurityLevel(configuration.getSecurityLevel());
                target.setSecurityName(configuration.getSecurityName());
            } else {
                // create the target
                target = new CommunityTarget();
                ((CommunityTarget) target).setCommunity(new OctetString(configuration.getCommunity()));
            }
            target.setAddress(address);
            target.setVersion(configuration.getVersion());
            target.setRetries(configuration.getRetries());
            target.setTimeout(configuration.getTimeout());
        }
    }

    private void SnmpEnquirer.fillPropertyDescriptorCache(Object object) throws IntrospectionException {
        Map<String, PropertyDescriptor> result = pdCache.get(object);
        if (result == null) {
            if (log.isDebugEnabled())
                log.debug("Analyzing object " + object.getClass().getName() + "[" + object.hashCode() + "]");
            result = analyzeBean(object);
            pdCache.put(object, result);
        }
    }

    private Map<String, PropertyDescriptor> SnmpEnquirer.analyzeBean(Object targetObj) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(targetObj.getClass(), Introspector.USE_ALL_BEANINFO);
        Map<String, PropertyDescriptor> result = new HashMap<String, PropertyDescriptor>();
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            if (log.isTraceEnabled()) {
                log.trace("Found bean property '" + pd.getName() + "'" +
                        (pd.getPropertyType() != null ?
                                " of type [" + pd.getPropertyType().getName() + "]" : "") +
                        (pd.getPropertyEditorClass() != null ?
                                "; editor [" + pd.getPropertyEditorClass().getName() + "]" : ""));
            }
            if (pd.getWriteMethod() == null) {
                addPrivateWriteMethod(pd, targetObj);
            }
            result.put(pd.getName(), pd);
        }
        return result;
    }

    private void SnmpEnquirer.addPrivateWriteMethod(PropertyDescriptor pd, Object targetObj) {
        try {
            String property = pd.getName();
            String setMethodName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
            Method method = targetObj.getClass().getDeclaredMethod(setMethodName, pd.getPropertyType());
            pd.setWriteMethod(method);
        } catch (NoSuchMethodException e) {
            //ignore
        } catch (IntrospectionException e) {
            //ignore
        }
    }

    private Class<?> SnmpEnquirer.getValueType(Variable variable) {
        switch (variable.getSyntax()) {
            case SMIConstants.EXCEPTION_END_OF_MIB_VIEW:
                return Exception.class;
            case SMIConstants.EXCEPTION_NO_SUCH_INSTANCE:
                return Exception.class;
            case SMIConstants.EXCEPTION_NO_SUCH_OBJECT:
                return Exception.class;
            //case SMIConstants.SYNTAX_BITS:
            case SMIConstants.SYNTAX_OCTET_STRING:
                return String.class;
            case SMIConstants.SYNTAX_COUNTER32:
                return Integer.class;
            case SMIConstants.SYNTAX_COUNTER64:
                return Long.class;
            //case SMIConstants.SYNTAX_GAUGE32:
            case SMIConstants.SYNTAX_UNSIGNED_INTEGER32:
                return Long.class;
            //case SMIConstants.SYNTAX_INTEGER:
            case SMIConstants.SYNTAX_INTEGER32:
                return Integer.class;
            case SMIConstants.SYNTAX_IPADDRESS:
                return InetAddress.class;
            case SMIConstants.SYNTAX_NULL:
                return String.class;
            case SMIConstants.SYNTAX_OBJECT_IDENTIFIER:
                return String.class;
            case SMIConstants.SYNTAX_OPAQUE:
                return String.class;
            case SMIConstants.SYNTAX_TIMETICKS:
                return Long.class;
            default:
                return Object.class;
        }
    }

    /**
     * Converts variable to right object value
     *
     * @param variable snmp var
     * @param clazz    class type to narrow to
     * @return object value
     * @throws ClassCastException if error
     * @throws java.net.UnknownHostException if error
     */
    @SuppressWarnings("UnnecessaryBoxing")
    private <T> T SnmpEnquirer.convert(Variable variable, Class<T> clazz) throws ClassCastException, UnknownHostException {
        switch (variable.getSyntax()) {
            case org.snmp4j.smi.SMIConstants.EXCEPTION_END_OF_MIB_VIEW:
            case org.snmp4j.smi.SMIConstants.EXCEPTION_NO_SUCH_INSTANCE:
            case org.snmp4j.smi.SMIConstants.EXCEPTION_NO_SUCH_OBJECT:
                return clazz.cast(new Exception(variable.toString()));
            //case org.snmp4j.smi.SMIConstants.SYNTAX_BITS:
            case org.snmp4j.smi.SMIConstants.SYNTAX_OCTET_STRING:
                if (variable instanceof BitString) {
                    BitString bitString = (BitString) variable;
                    return clazz.cast(bitString.toString());
                }
                return clazz.cast(variable.toString());
            case org.snmp4j.smi.SMIConstants.SYNTAX_COUNTER32:
                return clazz.cast(new Integer(variable.toInt()));
            case org.snmp4j.smi.SMIConstants.SYNTAX_COUNTER64:
                return clazz.cast(new Long(variable.toLong()));
            //case org.snmp4j.smi.SMIConstants.SYNTAX_GAUGE32:
            case org.snmp4j.smi.SMIConstants.SYNTAX_UNSIGNED_INTEGER32:
                if (variable instanceof Gauge32) {
                    Gauge32 bitString = (Gauge32) variable;
                    return clazz.cast(new Long(bitString.toLong()));
                }
                return clazz.cast(new Long(variable.toLong()));
            //case org.snmp4j.smi.SMIConstants.SYNTAX_INTEGER:
            case org.snmp4j.smi.SMIConstants.SYNTAX_INTEGER32:
                return clazz.cast(new Integer(variable.toInt()));
            case org.snmp4j.smi.SMIConstants.SYNTAX_IPADDRESS:
                IpAddress ipAddress = (IpAddress) variable;
                return clazz.cast(InetAddress.getByAddress(ipAddress.toByteArray()));
            case org.snmp4j.smi.SMIConstants.SYNTAX_NULL:
                return clazz.cast(variable.toString());
            case org.snmp4j.smi.SMIConstants.SYNTAX_OBJECT_IDENTIFIER:
                return clazz.cast(variable.toString());
            case org.snmp4j.smi.SMIConstants.SYNTAX_OPAQUE:
                return clazz.cast(variable.toString());
            case org.snmp4j.smi.SMIConstants.SYNTAX_TIMETICKS:
                return clazz.cast(new Long(variable.toLong()));
            default:
                throw new IllegalStateException();
        }

    }

    private ResponseEvent SnmpEnquirer.snmpGet(String targetOid) throws IOException {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(targetOid)));
        pdu.setType(PDU.GET);
        // send the PDU
        return snmp.send(pdu, target);
    }

    private List<TableEvent> SnmpEnquirer.snmpGetTable(String targetOid) throws IOException {
        TableUtils tableUtils = new TableUtils(snmp, new DefaultPDUFactory());
        // send the PDU
        return tableUtils.getTable(target, new OID[]{new OID(targetOid)}, null, null);
    }

    /*private ResponseEvent SnmpEnquirer.snmpSet(String targetOid, Variable variable) throws IOException {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(targetOid), variable));
        pdu.setType(PDU.SET);
        // send the PDU
        return snmp.send(pdu, target);
    }*/

    private void SnmpEnquirer.invokeSetValue(Map<String, PropertyDescriptor> descriptorCache, String fieldName, Object targetObj, String methodName, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            if (fieldName.equals("")) {
                fieldName = methodName.substring("get".length());
            }
            Method method = descriptorCache.get(fieldName).getWriteMethod();
            if (method != null) {
                method.setAccessible(true);
                Class type = descriptorCache.get(fieldName).getPropertyType();
                if (type.isEnum()) {
                    Object[] enumConstants = type.getEnumConstants();
                    for (Object enumConstant : enumConstants) {
                        if (!(enumConstant instanceof EmsEnum)) {
                            log.warn("Enumeration " + type.getName() + " is not of type EmsEnum");
                            break;
                        }
                        EmsEnum emsEnum = (EmsEnum) enumConstant;
                        if (emsEnum.getValue().equals(value)) {
                            method.invoke(targetObj, emsEnum);
                        }
                    }
                } else {
                    log.debug("field name: " + fieldName);
                    method.invoke(targetObj, value);
                }
            }
        } catch (InvocationTargetException e) {
            //ignore
        }
    }

    private void SnmpEnquirer.notifySnmpErrorCode(ConfigurationAware targetObj, ResponseEvent response, String targetOid) {
        if (response == null) {
            for (Object eh : targetObj.getResponseHandlers()) {
                if (eh instanceof ResponseHandler)
                    ((ResponseHandler) eh).onTimeout(targetOid);
            }
        } else {
            PDU responsePDU = response.getResponse();
            int errorStatus = responsePDU.getErrorStatus();
            int errorIndex = responsePDU.getErrorIndex();
            String errorStatusText = responsePDU.getErrorStatusText();
            switch (errorStatus) {
                case SnmpConstants.SNMP_ERROR_SUCCESS:
                    for (Object eh : targetObj.getResponseHandlers()) {
                        if (eh instanceof ResponseHandler)
                            ((ResponseHandler) eh).onSuccess(targetOid);
                    }
                    break;
                default:
                    if(log.isDebugEnabled()) {
                        log.debug("Error: Request Failed");
                        log.debug("Error Status = " + errorStatus);
                        log.debug("Error Index = " + errorIndex);
                        log.debug("Error Status Text = " + errorStatusText);
                    }
                    for (Object eh : targetObj.getResponseHandlers()) {
                        if (eh instanceof ResponseHandler)
                            ((ResponseHandler) eh).onError(targetOid, errorStatus, errorStatusText);
                    }
                    break;
            }
        }
    }

    private void SnmpEnquirer.notifySnmpTableErrorCode(ConfigurationAware targetObj, TableEvent response, String targetOid) {
        if (response == null) {
            for (Object eh : targetObj.getResponseHandlers()) {
                if (eh instanceof ResponseHandler)
                    ((ResponseHandler) eh).onTimeout(targetOid);
            }
        } else {
            if (response.isError()) {
                for (Object eh : targetObj.getResponseHandlers()) {
                    if (eh instanceof ResponseHandler)
                        ((ResponseHandler) eh).onError(targetOid, response.getStatus(), response.getErrorMessage());
                }
            } else {
                for (Object eh : targetObj.getResponseHandlers()) {
                    if (eh instanceof ResponseHandler)
                        ((ResponseHandler) eh).onSuccess(targetOid);
                }
            }
        }
    }

    private Object SnmpEnquirer.createValueObject(Class returnType, Map.Entry<String, List<VariableBinding>> entry) throws Exception {
        Object object = returnType.getComponentType().newInstance();
        Map<String, PropertyDescriptor> descriptorMap = analyzeBean(object);
        for (int j = 0; j < entry.getValue().size(); j++) {
            VariableBinding variableBinding = entry.getValue().get(j);
            String readOid = variableBinding.getOid().toString();
            Variable variable = variableBinding.getVariable();
            Object value = convert(variable, getValueType(variable));
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                OidBind oidBind = field.getAnnotation(OidBind.class);
                if(oidBind != null && readOid.startsWith(oidBind.oid()+ ".")) {
                    String fieldName = field.getName();
                    invokeSetValue(descriptorMap, fieldName, object, descriptorMap.get(fieldName).getWriteMethod().getName(), value);
                    break;
                }
            }
        }
        return object;
    }
}
