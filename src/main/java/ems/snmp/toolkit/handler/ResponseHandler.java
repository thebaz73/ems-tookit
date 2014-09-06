package ems.snmp.toolkit.handler;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
public interface ResponseHandler {
    /**
     * Callback method called when a snmp command on the specified
     * oid ends with a timeout
     *
     * @param oid oid
     */
    public void onTimeout(String oid);

    /**
     * Callback method called when a snmp command on the specified
     * oid ends with a success
     *
     * @param oid oid
     */
    public void onSuccess(String oid);

    /**
     * Callback method called when a snmp command on the specified
     * oid ends with an error
     *
     * @param oid              oid
     * @param errorCode        error code
     * @param errorDescription error description
     */
    public void onError(String oid, int errorCode, String errorDescription);
}
