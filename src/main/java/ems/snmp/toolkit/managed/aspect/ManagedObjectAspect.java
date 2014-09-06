package ems.snmp.toolkit.managed.aspect;

import ems.snmp.toolkit.managed.annotation.OidProperty;
import ems.snmp.toolkit.managed.mixin.SnmpEnquirer;
import ems.snmp.toolkit.monitor.annotation.Monitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */

@Aspect
public class ManagedObjectAspect {
    //private final Log log = LogFactory.getLog(getClass());

//    @DeclareParents(value = "@ems.snmp.toolkit.managed.annotation.ManagedObject *", defaultImpl = SnmpEnquirerAdaptor.class)
//    public SnmpEnquirer snmpEnquirer;

    @Around("execution(@ems.snmp.toolkit.managed.annotation.OidProperty !@ems.snmp.toolkit.managed.annotation.TableColumn (!@ems.snmp.toolkit.managed.annotation.TableColumn *) *.get*()) && " +
            "execution(@ems.snmp.toolkit.managed.annotation.OidProperty !@ems.snmp.toolkit.managed.annotation.TableRow (!@ems.snmp.toolkit.managed.annotation.TableRow *) *.get*()) && " +
            "@annotation(annotation)")
    public Object snmpGet(ProceedingJoinPoint pjp, OidProperty annotation) throws Throwable {
        boolean configuration = stackFlow(Monitor.class);
        if (configuration) {
            SnmpEnquirer snmpEnquirer = (SnmpEnquirer) pjp.getTarget();
            String methodName = pjp.getStaticPart().getSignature().getName();
            //ManagedObject managedObject = snmpEnquirer.getClass().getAnnotation(ManagedObject.class);
            snmpEnquirer.loadConfiguration(snmpEnquirer);
            snmpEnquirer.injectValue(annotation, pjp.getTarget(), methodName);
        }
        return pjp.proceed();
    }

    @Around("execution(@ems.snmp.toolkit.managed.annotation.OidProperty @ems.snmp.toolkit.managed.annotation.TableColumn * *.get*()) && @annotation(annotation)")
    public Object snmpGetTableColumn(ProceedingJoinPoint pjp, OidProperty annotation) throws Throwable {
        boolean configuration = stackFlow(Monitor.class);
        if (configuration) {
            SnmpEnquirer snmpEnquirer = (SnmpEnquirer) pjp.getTarget();
            String methodName = pjp.getStaticPart().getSignature().getName();
            //ManagedObject managedObject = snmpEnquirer.getClass().getAnnotation(ManagedObject.class);
            snmpEnquirer.loadConfiguration(snmpEnquirer);
            snmpEnquirer.injectTableColumnValue(annotation, pjp.getTarget(), methodName);
        }
        return pjp.proceed();
    }

    @Around("execution(@ems.snmp.toolkit.managed.annotation.OidProperty @ems.snmp.toolkit.managed.annotation.TableRow * *.get*()) && @annotation(annotation)")
    public Object snmpGetTableRow(ProceedingJoinPoint pjp, OidProperty annotation) throws Throwable {
        boolean configuration = stackFlow(Monitor.class);
        if (configuration) {
            SnmpEnquirer snmpEnquirer = (SnmpEnquirer) pjp.getTarget();
            String methodName = pjp.getStaticPart().getSignature().getName();
            //ManagedObject managedObject = snmpEnquirer.getClass().getAnnotation(ManagedObject.class);
            snmpEnquirer.loadConfiguration(snmpEnquirer);
            snmpEnquirer.injectTableRowValue(annotation, pjp.getTarget(), methodName);
        }
        return pjp.proceed();
    }

    @Around("execution(@ems.snmp.toolkit.managed.annotation.OidProperty void *.set*(..)) && @annotation(oidProperty)")
    public Object snmpSetValue(ProceedingJoinPoint pjp, OidProperty oidProperty) throws Throwable {
        //Object retValue = pjp.proceed();
        /*boolean configuration = stackFlow(Monitor.class);
        if (configuration) {
            SnmpEnquirer snmpEnquirer = (SnmpEnquirer) pjp.getTarget();
            String methodName = pjp.getStaticPart().getSignature().getName();
            ManagedObject managedObject = snmpEnquirer.getClass().getAnnotation(ManagedObject.class);
            snmpEnquirer.loadConfiguration(snmpEnquirer);
            snmpEnquirer.setValue(oidProperty, pjp.getTarget(), managedObject, methodName, pjp.getArgs()[0]);
        }*/
        return pjp.proceed();
    }

    /**
     * AspectJ bug. LTW fails with cflow declaration
     *
     * @param annotation annotation class
     * @return true if in flow
     */
    @SuppressWarnings("unchecked")
    private boolean stackFlow(Class<Monitor> annotation) {
        boolean getMethodPresent = false;
        boolean setMethodPresent = false;
        for (StackTraceElement traceElement : Thread.currentThread().getStackTrace()) {
            String traceClassName = traceElement.getClassName();
            String methodName = traceElement.getMethodName();
            if (traceClassName.equalsIgnoreCase(ManagedObjectAspect.class.getName())) {
                if (methodName.equalsIgnoreCase("snmpGet") ||
                        methodName.equalsIgnoreCase("snmpGetTableColumn") ||
                        methodName.equalsIgnoreCase("snmpGetTableRow")) {
                    getMethodPresent = true;
                }
                if (methodName.equalsIgnoreCase("snmpSetValue")) {
                    setMethodPresent = true;
                }
            }
            if (getMethodPresent && setMethodPresent) {
                return false;
            }
            if (traceClassName.startsWith("ems")) {
                try {
                    Class caller = Class.forName(traceClassName);
                    if (caller.getAnnotation(annotation) != null)
                        return true;
                } catch (ClassNotFoundException e) {
                    //ignore
                }
            }
        }
        return false;
    }

}