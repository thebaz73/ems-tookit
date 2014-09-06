package ems.snmp.toolkit;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.transport.TLSTM;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/18/12
 * Time: 7:10 PM
 */
public class Snmp4jGetSample {

    public static void main(String[] args) throws IOException {
        Snmp4jGetSample snmp4jGetSample = new Snmp4jGetSample();
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
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(".1.3.6.1.2.1.1.1.0")));
        pdu.setType(PDU.GET);

        // send the PDU
        ResponseEvent response = snmp.send(pdu, target);
        // Process Agent Response
        if (response != null) {
            System.out.println("\nResponse:\nGot Snmp Set Response from Agent");
            PDU responsePDU = response.getResponse();

            if (responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
                int errorIndex = responsePDU.getErrorIndex();
                String errorStatusText = responsePDU.getErrorStatusText();

                if (errorStatus == PDU.noError) {
                    System.out.println("Snmp Get Response = " + responsePDU.getVariableBindings());
                } else {
                    System.out.println("Error: Request Failed");
                    System.out.println("Error Status = " + errorStatus);
                    System.out.println("Error Index = " + errorIndex);
                    System.out.println("Error Status Text = " + errorStatusText);
                }
            } else {
                System.out.println("Error: Response PDU is null");
            }
        } else {
            System.out.println("Error: Agent Timeout... ");
        }
    }
}
