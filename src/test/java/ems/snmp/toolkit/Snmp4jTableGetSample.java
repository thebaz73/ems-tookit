package ems.snmp.toolkit;

import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.transport.TLSTM;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/18/12
 * Time: 7:10 PM
 */
public class Snmp4jTableGetSample {

    public static void main(String[] args) throws IOException {
        Snmp4jTableGetSample snmp4jGetSample = new Snmp4jTableGetSample();
        snmp4jGetSample.execute();
    }

    private void execute() throws IOException {
        Address address = GenericAddress.parse("udp:127.0.0.1/161");
        AbstractTransportMapping transport;
        if (address instanceof TlsAddress) {
            transport = new TLSTM();
        } else if (address instanceof TcpAddress) {
            transport = new DefaultTcpTransportMapping();
        } else {
            transport = new DefaultUdpTransportMapping();
        }
        // Could save some CPU cycles:
        //transport.setAsyncMsgProcessingSupported(false);
        Snmp snmp = new Snmp(transport);
        snmp.listen();
        // create the target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(address);
        target.setVersion(SnmpConstants.version1);
        target.setRetries(2);
        target.setTimeout(1500);
        TableUtils tableUtils = new TableUtils(snmp, new DefaultPDUFactory());


        // send the PDU
        List<TableEvent> responseList = tableUtils.getTable(target, new OID[]{new OID("1.3.6.1.2.1.2.2.1")}, null, null);
        if (responseList != null) {
            System.out.println("\nResponse:\nGot Snmp Set Response from Agent");
            for (TableEvent response : responseList) {
                // Process Agent Response
                if (!response.isError()) {
                    System.out.println("Get index: " + response.getIndex());
                    System.out.println("Get columns: " + Arrays.toString(response.getColumns()));
                } else {
                    System.out.println("Error: " + response.getErrorMessage());
                }
            }
        } else {
            System.out.println("Error: Agent Timeout... ");
        }
    }
}
