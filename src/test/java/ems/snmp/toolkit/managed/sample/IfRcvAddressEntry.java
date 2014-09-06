package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.OidBind;

/**
* Created by EMS Mib Compiler.
* Do not edit
*/
@OidBind(oid = "1.3.6.1.2.1.31.1.4.1")
public class IfRcvAddressEntry {


    @OidBind(oid = "1.3.6.1.2.1.31.1.4.1.1")
    private String ifRcvAddressAddress;

    public String getIfRcvAddressAddress() {
        return ifRcvAddressAddress;
    }

    private void setIfRcvAddressAddress(String ifRcvAddressAddress) {
        this.ifRcvAddressAddress = ifRcvAddressAddress;
    }

    enum IF_RCV_ADDRESS_STATUS implements EmsEnum<Integer> {
        ACTIVE (1),
        NOT_IN_SERVICE (2),
        NOT_READY (3),
        CREATE_AND_GO (4),
        CREATE_AND_WAIT (5),
        DESTROY (6);

        private Integer value;

        private IF_RCV_ADDRESS_STATUS(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.4.1.2")
    private IF_RCV_ADDRESS_STATUS ifRcvAddressStatus;

    public IF_RCV_ADDRESS_STATUS getIfRcvAddressStatus() {
        return ifRcvAddressStatus;
    }

    private void setIfRcvAddressStatus(IF_RCV_ADDRESS_STATUS ifRcvAddressStatus) {
        this.ifRcvAddressStatus = ifRcvAddressStatus;
    }

    enum IF_RCV_ADDRESS_TYPE implements EmsEnum<Integer> {
        OTHER (1),
        VOLATILE (2),
        NON_VOLATILE (3);

        private Integer value;

        private IF_RCV_ADDRESS_TYPE(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.4.1.3")
    private IF_RCV_ADDRESS_TYPE ifRcvAddressType;

    public IF_RCV_ADDRESS_TYPE getIfRcvAddressType() {
        return ifRcvAddressType;
    }

    private void setIfRcvAddressType(IF_RCV_ADDRESS_TYPE ifRcvAddressType) {
        this.ifRcvAddressType = ifRcvAddressType;
    }
}
