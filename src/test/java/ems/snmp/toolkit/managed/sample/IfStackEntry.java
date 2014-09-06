package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.OidBind;

/**
* Created by EMS Mib Compiler.
* Do not edit
*/
@OidBind(oid = "1.3.6.1.2.1.31.1.2.1")
public class IfStackEntry {


    @OidBind(oid = "1.3.6.1.2.1.31.1.2.1.1")
    private Integer ifStackHigherLayer;

    public Integer getIfStackHigherLayer() {
        return ifStackHigherLayer;
    }

    private void setIfStackHigherLayer(Integer ifStackHigherLayer) {
        this.ifStackHigherLayer = ifStackHigherLayer;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.2.1.2")
    private Integer ifStackLowerLayer;

    public Integer getIfStackLowerLayer() {
        return ifStackLowerLayer;
    }

    private void setIfStackLowerLayer(Integer ifStackLowerLayer) {
        this.ifStackLowerLayer = ifStackLowerLayer;
    }

    enum IF_STACK_STATUS implements EmsEnum<Integer> {
        ACTIVE (1),
        NOT_IN_SERVICE (2),
        NOT_READY (3),
        CREATE_AND_GO (4),
        CREATE_AND_WAIT (5),
        DESTROY (6);

        private Integer value;

        private IF_STACK_STATUS(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.2.1.3")
    private IF_STACK_STATUS ifStackStatus;

    public IF_STACK_STATUS getIfStackStatus() {
        return ifStackStatus;
    }

    private void setIfStackStatus(IF_STACK_STATUS ifStackStatus) {
        this.ifStackStatus = ifStackStatus;
    }
}
