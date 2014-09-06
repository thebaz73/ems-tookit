package ems.snmp.toolkit.monitor.mixin;

import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.OctetString;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/18/12
 * Time: 10:41 AM
 */
privileged aspect ConfigurationAwareMonitor {

    private String SnmpConfiguration.sessionUid;
    private String SnmpConfiguration.address;
    private int SnmpConfiguration.version = SnmpConstants.version1;
    private int SnmpConfiguration.retries = 2;
    private int SnmpConfiguration.timeout = 1500;
    private String SnmpConfiguration.community;
    private int SnmpConfiguration.securityLevel;
    private OctetString SnmpConfiguration.userName;
    private OctetString SnmpConfiguration.engineID;
    private UsmUser SnmpConfiguration.user;
    private OctetString SnmpConfiguration.securityName;

    public String SnmpConfiguration.getSessionUid() {
        return sessionUid;
    }

    public void SnmpConfiguration.setSessionUid(String sessionUid) {
        this.sessionUid = sessionUid;
    }

    public String SnmpConfiguration.getAddress() {
        return address;
    }

    public void SnmpConfiguration.setAddress(String address) {
        this.address = address;
    }

    public int SnmpConfiguration.getVersion() {
        return version;
    }

    public void SnmpConfiguration.setVersion(int version) {
        this.version = version;
    }

    public int SnmpConfiguration.getRetries() {
        return retries;
    }

    public void SnmpConfiguration.setRetries(int retries) {
        this.retries = retries;
    }

    public int SnmpConfiguration.getTimeout() {
        return timeout;
    }

    public void SnmpConfiguration.setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String SnmpConfiguration.getCommunity() {
        return community;
    }

    public void SnmpConfiguration.setCommunity(String community) {
        this.community = community;
    }

    public int SnmpConfiguration.getSecurityLevel() {
        return securityLevel;
    }

    public void SnmpConfiguration.setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public OctetString SnmpConfiguration.getUserName() {
        return userName;
    }

    public void SnmpConfiguration.setUserName(OctetString userName) {
        this.userName = userName;
    }

    public OctetString SnmpConfiguration.getEngineID() {
        return engineID;
    }

    public void SnmpConfiguration.setEngineID(OctetString engineID) {
        this.engineID = engineID;
    }

    public UsmUser SnmpConfiguration.getUser() {
        return user;
    }

    public void SnmpConfiguration.setUser(UsmUser user) {
        this.user = user;
    }

    public OctetString SnmpConfiguration.getSecurityName() {
        return securityName;
    }

    public void SnmpConfiguration.setSecurityName(OctetString securityName) {
        this.securityName = securityName;
    }

    declare parents: @ems.snmp.monitor.annotation.Monitor * implements SnmpConfiguration;
}
