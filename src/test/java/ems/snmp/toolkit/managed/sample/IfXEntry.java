package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.OidBind;

/**
* Created by EMS Mib Compiler.
* Do not edit
*/
@OidBind(oid = "1.3.6.1.2.1.31.1.1.1")
public class IfXEntry {


    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.1")
    private String ifName;

    public String getIfName() {
        return ifName;
    }

    private void setIfName(String ifName) {
        this.ifName = ifName;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.2")
    private Integer ifInMulticastPkts;

    public Integer getIfInMulticastPkts() {
        return ifInMulticastPkts;
    }

    private void setIfInMulticastPkts(Integer ifInMulticastPkts) {
        this.ifInMulticastPkts = ifInMulticastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.3")
    private Integer ifInBroadcastPkts;

    public Integer getIfInBroadcastPkts() {
        return ifInBroadcastPkts;
    }

    private void setIfInBroadcastPkts(Integer ifInBroadcastPkts) {
        this.ifInBroadcastPkts = ifInBroadcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.4")
    private Integer ifOutMulticastPkts;

    public Integer getIfOutMulticastPkts() {
        return ifOutMulticastPkts;
    }

    private void setIfOutMulticastPkts(Integer ifOutMulticastPkts) {
        this.ifOutMulticastPkts = ifOutMulticastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.5")
    private Integer ifOutBroadcastPkts;

    public Integer getIfOutBroadcastPkts() {
        return ifOutBroadcastPkts;
    }

    private void setIfOutBroadcastPkts(Integer ifOutBroadcastPkts) {
        this.ifOutBroadcastPkts = ifOutBroadcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.6")
    private Long ifHCInOctets;

    public Long getIfHCInOctets() {
        return ifHCInOctets;
    }

    private void setIfHCInOctets(Long ifHCInOctets) {
        this.ifHCInOctets = ifHCInOctets;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.7")
    private Long ifHCInUcastPkts;

    public Long getIfHCInUcastPkts() {
        return ifHCInUcastPkts;
    }

    private void setIfHCInUcastPkts(Long ifHCInUcastPkts) {
        this.ifHCInUcastPkts = ifHCInUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.8")
    private Long ifHCInMulticastPkts;

    public Long getIfHCInMulticastPkts() {
        return ifHCInMulticastPkts;
    }

    private void setIfHCInMulticastPkts(Long ifHCInMulticastPkts) {
        this.ifHCInMulticastPkts = ifHCInMulticastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.9")
    private Long ifHCInBroadcastPkts;

    public Long getIfHCInBroadcastPkts() {
        return ifHCInBroadcastPkts;
    }

    private void setIfHCInBroadcastPkts(Long ifHCInBroadcastPkts) {
        this.ifHCInBroadcastPkts = ifHCInBroadcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.10")
    private Long ifHCOutOctets;

    public Long getIfHCOutOctets() {
        return ifHCOutOctets;
    }

    private void setIfHCOutOctets(Long ifHCOutOctets) {
        this.ifHCOutOctets = ifHCOutOctets;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.11")
    private Long ifHCOutUcastPkts;

    public Long getIfHCOutUcastPkts() {
        return ifHCOutUcastPkts;
    }

    private void setIfHCOutUcastPkts(Long ifHCOutUcastPkts) {
        this.ifHCOutUcastPkts = ifHCOutUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.12")
    private Long ifHCOutMulticastPkts;

    public Long getIfHCOutMulticastPkts() {
        return ifHCOutMulticastPkts;
    }

    private void setIfHCOutMulticastPkts(Long ifHCOutMulticastPkts) {
        this.ifHCOutMulticastPkts = ifHCOutMulticastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.13")
    private Long ifHCOutBroadcastPkts;

    public Long getIfHCOutBroadcastPkts() {
        return ifHCOutBroadcastPkts;
    }

    private void setIfHCOutBroadcastPkts(Long ifHCOutBroadcastPkts) {
        this.ifHCOutBroadcastPkts = ifHCOutBroadcastPkts;
    }

    enum IF_LINK_UP_DOWN_TRAP_ENABLE implements EmsEnum<Integer> {
        ENABLED (1),
        DISABLED (2);

        private Integer value;

        private IF_LINK_UP_DOWN_TRAP_ENABLE(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.14")
    private IF_LINK_UP_DOWN_TRAP_ENABLE ifLinkUpDownTrapEnable;

    public IF_LINK_UP_DOWN_TRAP_ENABLE getIfLinkUpDownTrapEnable() {
        return ifLinkUpDownTrapEnable;
    }

    private void setIfLinkUpDownTrapEnable(IF_LINK_UP_DOWN_TRAP_ENABLE ifLinkUpDownTrapEnable) {
        this.ifLinkUpDownTrapEnable = ifLinkUpDownTrapEnable;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.15")
    private Long ifHighSpeed;

    public Long getIfHighSpeed() {
        return ifHighSpeed;
    }

    private void setIfHighSpeed(Long ifHighSpeed) {
        this.ifHighSpeed = ifHighSpeed;
    }

    enum IF_PROMISCUOUS_MODE implements EmsEnum<Integer> {
        TRUE (1),
        FALSE (2);

        private Integer value;

        private IF_PROMISCUOUS_MODE(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.16")
    private IF_PROMISCUOUS_MODE ifPromiscuousMode;

    public IF_PROMISCUOUS_MODE getIfPromiscuousMode() {
        return ifPromiscuousMode;
    }

    private void setIfPromiscuousMode(IF_PROMISCUOUS_MODE ifPromiscuousMode) {
        this.ifPromiscuousMode = ifPromiscuousMode;
    }

    enum IF_CONNECTOR_PRESENT implements EmsEnum<Integer> {
        TRUE (1),
        FALSE (2);

        private Integer value;

        private IF_CONNECTOR_PRESENT(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.17")
    private IF_CONNECTOR_PRESENT ifConnectorPresent;

    public IF_CONNECTOR_PRESENT getIfConnectorPresent() {
        return ifConnectorPresent;
    }

    private void setIfConnectorPresent(IF_CONNECTOR_PRESENT ifConnectorPresent) {
        this.ifConnectorPresent = ifConnectorPresent;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.18")
    private String ifAlias;

    public String getIfAlias() {
        return ifAlias;
    }

    private void setIfAlias(String ifAlias) {
        this.ifAlias = ifAlias;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.1.1.19")
    private Long ifCounterDiscontinuityTime;

    public Long getIfCounterDiscontinuityTime() {
        return ifCounterDiscontinuityTime;
    }

    private void setIfCounterDiscontinuityTime(Long ifCounterDiscontinuityTime) {
        this.ifCounterDiscontinuityTime = ifCounterDiscontinuityTime;
    }
}
