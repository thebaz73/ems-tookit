package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.handler.LoggingResponseHandler;
import ems.snmp.toolkit.monitor.annotation.Monitor;
import ems.snmp.toolkit.monitor.mixin.SnmpConfiguration;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
@Monitor
public class MonitorSample implements SnmpConfiguration {
    public void printValues(IfMib ifMib) {
        LoggingResponseHandler responseHandler = new LoggingResponseHandler(ifMib);
        ifMib.addResponseHandler(responseHandler);
        System.out.println("ifNumber = " + ifMib.getIfNumber());
        System.out.println("ifType column = " + Arrays.toString(ifMib.getIfType()));
        System.out.println("ifIndex column = " + Arrays.toString(ifMib.getIfIndex()));
        System.out.println("ifDescr column = " + Arrays.toString(ifMib.getIfDescr()));
        System.out.println("ifTable = " + Arrays.toString(ifMib.getIfTable()));
        System.out.println("ifXTable = " + Arrays.toString(ifMib.getIfXTable()));
        System.out.println("ifStackTable = " + Arrays.toString(ifMib.getIfStackTable()));
        ifMib.removeResponseHandler(responseHandler);
    }
}
