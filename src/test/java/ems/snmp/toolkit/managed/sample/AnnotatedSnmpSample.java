package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.configuration.ConfigSpaceRepository;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
public class AnnotatedSnmpSample {
    public static void main(String[] args) {
        MonitorSample monitorSample = new MonitorSample();
        String sessionUid = UUID.randomUUID().toString();
        monitorSample.setSessionUid(sessionUid);
        monitorSample.setAddress("udp:127.0.0.1/161");
        monitorSample.setCommunity("public");
        ConfigSpaceRepository.getInstance().addConfiguration(monitorSample);
        IfMib ifMib = new IfMib();
        ifMib.setSpaceKey(sessionUid);
        monitorSample.printValues(ifMib);
        System.out.println("\nGet read value");
        System.out.println("ifNumber = " + ifMib.getIfNumber());
        System.out.println("ifType column = " + Arrays.toString(ifMib.getIfType()));
        System.out.println("ifIndex column = " + Arrays.toString(ifMib.getIfIndex()));
        System.out.println("ifDescr column = " + Arrays.toString(ifMib.getIfDescr()));
        System.out.println("ifTable = " + Arrays.toString(ifMib.getIfTable()));
        System.out.println("ifXTable = " + Arrays.toString(ifMib.getIfXTable()));
        System.out.println("ifStackTable = " + Arrays.toString(ifMib.getIfStackTable()));
    }
}
