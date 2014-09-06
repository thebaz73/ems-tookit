package ems.snmp.toolkit.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
public class LoggingResponseHandler implements ResponseHandler {
    Log log = LogFactory.getLog(getClass());

    private final Object snmpEnquirerAdaptor;

    public LoggingResponseHandler(Object snmpEnquirerAdaptor) {
        this.snmpEnquirerAdaptor = snmpEnquirerAdaptor;
    }

    /**
     * Callback method called when a snmp command on the specified
     * oid ends with a timeout
     *
     * @param oid oid
     */
    @Override
    public void onTimeout(String oid) {
        if (log.isWarnEnabled()) {
            log.warn(String.format("Timeout reading: %s on %s", oid, snmpEnquirerAdaptor.toString()));
        }
    }

    /**
     * Callback method called when a snmp command on the specified
     * oid ends with a success
     *
     * @param oid oid
     */
    @Override
    public void onSuccess(String oid) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("Successful reading: %s on %s", oid, snmpEnquirerAdaptor.toString()));
        }
    }

    /**
     * Callback method called when a snmp command on the specified
     * oid ends with an error
     *
     * @param oid              oid
     * @param errorCode        error code
     * @param errorDescription error description
     */
    @Override
    public void onError(String oid, int errorCode, String errorDescription) {
        if (log.isErrorEnabled()) {
            log.error(String.format("Error reading: %s on %s. [%d - %s]", oid, snmpEnquirerAdaptor.toString(), errorCode, errorDescription));
        }
    }
}
