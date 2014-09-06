package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.OidBind;

/**
* Created by EMS Mib Compiler.
* Do not edit
*/
@OidBind(oid = "1.3.6.1.2.1.2.2.1")
public class IfEntry {


    @OidBind(oid = "1.3.6.1.2.1.2.2.1.1")
    private Integer ifIndex;

    public Integer getIfIndex() {
        return ifIndex;
    }

    private void setIfIndex(Integer ifIndex) {
        this.ifIndex = ifIndex;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.2")
    private String ifDescr;

    public String getIfDescr() {
        return ifDescr;
    }

    private void setIfDescr(String ifDescr) {
        this.ifDescr = ifDescr;
    }

    enum IF_TYPE implements EmsEnum<Integer> {
        OTHER (1),
        REGULAR_1822 (2),
        HDH_1822 (3),
        DDN_X_25 (4),
        RFC_877_X_25 (5),
        ETHERNET_CSMACD (6),
        ISO_88023_CSMACD (7),
        ISO_88024_TOKEN_BUS (8),
        ISO_88025_TOKEN_RING (9),
        ISO_88026_MAN (10),
        STAR_LAN (11),
        PROTEON_10_MBIT (12),
        PROTEON_80_MBIT (13),
        HYPERCHANNEL (14),
        FDDI (15),
        LAPB (16),
        SDLC (17),
        DS_1 (18),
        E_1 (19),
        BASIC_ISDN (20),
        PRIMARY_ISDN (21),
        PROP_POINT_TO_POINT_SERIAL (22),
        PPP (23),
        SOFTWARE_LOOPBACK (24),
        EON (25),
        ETHERNET_3_MBIT (26),
        NSIP (27),
        SLIP (28),
        ULTRA (29),
        DS_3 (30),
        SIP (31),
        FRAME_RELAY (32),
        RS_232 (33),
        PARA (34),
        ARCNET (35),
        ARCNET_PLUS (36),
        ATM (37),
        MIOX_25 (38),
        SONET (39),
        X_25_PLE (40),
        ISO_88022_LLC (41),
        LOCAL_TALK (42),
        SMDS_DXI (43),
        FRAME_RELAY_SERVICE (44),
        V_35 (45),
        HSSI (46),
        HIPPI (47),
        MODEM (48),
        AAL_5 (49),
        SONET_PATH (50),
        SONET_VT (51),
        SMDS_ICIP (52),
        PROP_VIRTUAL (53),
        PROP_MULTIPLEXOR (54),
        IEEE_80212 (55),
        FIBRE_CHANNEL (56),
        HIPPI_INTERFACE (57),
        FRAME_RELAY_INTERCONNECT (58),
        AFLANE_8023 (59),
        AFLANE_8025 (60),
        CCT_EMUL (61),
        FAST_ETHER (62),
        ISDN (63),
        V_11 (64),
        V_36 (65),
        G_703_AT_64_K (66),
        G_703_AT_2_MB (67),
        QLLC (68),
        FAST_ETHER_FX (69),
        CHANNEL (70),
        IEEE_80211 (71),
        IBM_370_PAR_CHAN (72),
        ESCON (73),
        DLSW (74),
        ISDNS (75),
        ISDNU (76),
        LAPD (77),
        IP_SWITCH (78),
        RSRB (79),
        ATM_LOGICAL (80),
        DS_0 (81),
        DS_0_BUNDLE (82),
        BSC (83),
        ASYNC (84),
        CNR (85),
        ISO_88025_DTR (86),
        EPLRS (87),
        ARAP (88),
        PROP_CNLS (89),
        HOST_PAD (90),
        TERM_PAD (91),
        FRAME_RELAY_MPI (92),
        X_213 (93),
        ADSL (94),
        RADSL (95),
        SDSL (96),
        VDSL (97),
        ISO_88025_CRFP_INT (98),
        MYRINET (99),
        VOICE_EM (100),
        VOICE_FXO (101),
        VOICE_FXS (102),
        VOICE_ENCAP (103),
        VOICE_OVER_IP (104),
        ATM_DXI (105),
        ATM_FUNI (106),
        ATM_IMA (107),
        PPP_MULTILINK_BUNDLE (108),
        IP_OVER_CDLC (109),
        IP_OVER_CLAW (110),
        STACK_TO_STACK (111),
        VIRTUAL_IP_ADDRESS (112),
        MPC (113),
        IP_OVER_ATM (114),
        ISO_88025_FIBER (115),
        TDLC (116),
        GIGABIT_ETHERNET (117),
        HDLC (118),
        LAPF (119),
        V_37 (120),
        X_25_MLP (121),
        X_25_HUNT_GROUP (122),
        TRASNP_HDLC (123),
        INTERLEAVE (124),
        FAST (125),
        IP (126),
        DOCS_CABLE_MACLAYER (127),
        DOCS_CABLE_DOWNSTREAM (128),
        DOCS_CABLE_UPSTREAM (129),
        A_12_MPP_SWITCH (130),
        TUNNEL (131),
        COFFEE (132),
        CES (133),
        ATM_SUB_INTERFACE (134),
        L_2_VLAN (135),
        L_3_IPVLAN (136),
        L_3_IPXVLAN (137),
        DIGITAL_POWERLINE (138),
        MEDIA_MAIL_OVER_IP (139),
        DTM (140),
        DCN (141),
        IP_FORWARD (142),
        MSDSL (143),
        IEEE_1394 (144),
        IF_GSN (145),
        DVB_RCC_MAC_LAYER (146),
        DVB_RCC_DOWNSTREAM (147),
        DVB_RCC_UPSTREAM (148),
        ATM_VIRTUAL (149),
        MPLS_TUNNEL (150),
        SRP (151),
        VOICE_OVER_ATM (152),
        VOICE_OVER_FRAME_RELAY (153),
        IDSL (154),
        COMPOSITE_LINK (155),
        SS_7_SIG_LINK (156),
        PROP_WIRELESS_P_2_P (157),
        FR_FORWARD (158),
        RFC_1483 (159),
        USB (160),
        IEEE_8023_AD_LAG (161),
        BGPPOLICYACCOUNTING (162),
        FRF_16_MFR_BUNDLE (163),
        H_323_GATEKEEPER (164),
        H_323_PROXY (165),
        MPLS (166),
        MF_SIG_LINK (167),
        HDSL_2 (168),
        SHDSL (169),
        DS_1_FDL (170),
        POS (171),
        DVB_ASI_IN (172),
        DVB_ASI_OUT (173),
        PLC (174),
        NFAS (175),
        TR_008 (176),
        GR_303_RDT (177),
        GR_303_IDT (178),
        ISUP (179),
        PROP_DOCS_WIRELESS_MACLAYER (180),
        PROP_DOCS_WIRELESS_DOWNSTREAM (181),
        PROP_DOCS_WIRELESS_UPSTREAM (182),
        HIPERLAN_2 (183),
        PROP_BW_AP_2_MP (184),
        SONET_OVERHEAD_CHANNEL (185),
        DIGITAL_WRAPPER_OVERHEAD_CHANNEL (186),
        AAL_2 (187),
        RADIO_MAC (188),
        ATM_RADIO (189),
        IMT (190),
        MVL (191),
        REACH_DSL (192),
        FR_DLCI_END_PT (193),
        ATM_VCI_END_PT (194),
        OPTICAL_CHANNEL (195),
        OPTICAL_TRANSPORT (196),
        PROP_ATM (197),
        VOICE_OVER_CABLE (198),
        INFINIBAND (199),
        TE_LINK (200),
        Q_2931 (201),
        VIRTUAL_TG (202),
        SIP_TG (203),
        SIP_SIG (204),
        DOCS_CABLE_UPSTREAM_CHANNEL (205),
        ECONET (206),
        PON_155 (207),
        PON_622 (208),
        BRIDGE (209),
        LINEGROUP (210),
        VOICE_EMFGD (211),
        VOICE_FGDEANA (212),
        VOICE_DID (213),
        MPEG_TRANSPORT (214),
        SIX_TO_FOUR (215),
        GTP (216),
        PDN_ETHER_LOOP_1 (217),
        PDN_ETHER_LOOP_2 (218),
        OPTICAL_CHANNEL_GROUP (219),
        HOMEPNA (220),
        GFP (221),
        CISCO_IS_LVLAN (222),
        ACTELIS_META_LOOP (223),
        FCIP_LINK (224),
        RPR (225),
        QAM (226),
        LMP (227),
        CBL_VECTA_STAR (228),
        DOCS_CABLE_M_CMTS_DOWNSTREAM (229),
        ADSL_2 (230),
        MAC_SEC_CONTROLLED_IF (231),
        MAC_SEC_UNCONTROLLED_IF (232);

        private Integer value;

        private IF_TYPE(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.3")
    private IF_TYPE ifType;

    public IF_TYPE getIfType() {
        return ifType;
    }

    private void setIfType(IF_TYPE ifType) {
        this.ifType = ifType;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.4")
    private Integer ifMtu;

    public Integer getIfMtu() {
        return ifMtu;
    }

    private void setIfMtu(Integer ifMtu) {
        this.ifMtu = ifMtu;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.5")
    private Long ifSpeed;

    public Long getIfSpeed() {
        return ifSpeed;
    }

    private void setIfSpeed(Long ifSpeed) {
        this.ifSpeed = ifSpeed;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.6")
    private String ifPhysAddress;

    public String getIfPhysAddress() {
        return ifPhysAddress;
    }

    private void setIfPhysAddress(String ifPhysAddress) {
        this.ifPhysAddress = ifPhysAddress;
    }

    enum IF_ADMIN_STATUS implements EmsEnum<Integer> {
        UP (1),
        DOWN (2),
        TESTING (3);

        private Integer value;

        private IF_ADMIN_STATUS(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.7")
    private IF_ADMIN_STATUS ifAdminStatus;

    public IF_ADMIN_STATUS getIfAdminStatus() {
        return ifAdminStatus;
    }

    private void setIfAdminStatus(IF_ADMIN_STATUS ifAdminStatus) {
        this.ifAdminStatus = ifAdminStatus;
    }

    enum IF_OPER_STATUS implements EmsEnum<Integer> {
        UP (1),
        DOWN (2),
        TESTING (3),
        UNKNOWN (4),
        DORMANT (5),
        NOT_PRESENT (6),
        LOWER_LAYER_DOWN (7);

        private Integer value;

        private IF_OPER_STATUS(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.8")
    private IF_OPER_STATUS ifOperStatus;

    public IF_OPER_STATUS getIfOperStatus() {
        return ifOperStatus;
    }

    private void setIfOperStatus(IF_OPER_STATUS ifOperStatus) {
        this.ifOperStatus = ifOperStatus;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.9")
    private Long ifLastChange;

    public Long getIfLastChange() {
        return ifLastChange;
    }

    private void setIfLastChange(Long ifLastChange) {
        this.ifLastChange = ifLastChange;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.10")
    private Integer ifInOctets;

    public Integer getIfInOctets() {
        return ifInOctets;
    }

    private void setIfInOctets(Integer ifInOctets) {
        this.ifInOctets = ifInOctets;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.11")
    private Integer ifInUcastPkts;

    public Integer getIfInUcastPkts() {
        return ifInUcastPkts;
    }

    private void setIfInUcastPkts(Integer ifInUcastPkts) {
        this.ifInUcastPkts = ifInUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.12")
    private Integer ifInNUcastPkts;

    public Integer getIfInNUcastPkts() {
        return ifInNUcastPkts;
    }

    private void setIfInNUcastPkts(Integer ifInNUcastPkts) {
        this.ifInNUcastPkts = ifInNUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.13")
    private Integer ifInDiscards;

    public Integer getIfInDiscards() {
        return ifInDiscards;
    }

    private void setIfInDiscards(Integer ifInDiscards) {
        this.ifInDiscards = ifInDiscards;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.14")
    private Integer ifInErrors;

    public Integer getIfInErrors() {
        return ifInErrors;
    }

    private void setIfInErrors(Integer ifInErrors) {
        this.ifInErrors = ifInErrors;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.15")
    private Integer ifInUnknownProtos;

    public Integer getIfInUnknownProtos() {
        return ifInUnknownProtos;
    }

    private void setIfInUnknownProtos(Integer ifInUnknownProtos) {
        this.ifInUnknownProtos = ifInUnknownProtos;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.16")
    private Integer ifOutOctets;

    public Integer getIfOutOctets() {
        return ifOutOctets;
    }

    private void setIfOutOctets(Integer ifOutOctets) {
        this.ifOutOctets = ifOutOctets;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.17")
    private Integer ifOutUcastPkts;

    public Integer getIfOutUcastPkts() {
        return ifOutUcastPkts;
    }

    private void setIfOutUcastPkts(Integer ifOutUcastPkts) {
        this.ifOutUcastPkts = ifOutUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.18")
    private Integer ifOutNUcastPkts;

    public Integer getIfOutNUcastPkts() {
        return ifOutNUcastPkts;
    }

    private void setIfOutNUcastPkts(Integer ifOutNUcastPkts) {
        this.ifOutNUcastPkts = ifOutNUcastPkts;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.19")
    private Integer ifOutDiscards;

    public Integer getIfOutDiscards() {
        return ifOutDiscards;
    }

    private void setIfOutDiscards(Integer ifOutDiscards) {
        this.ifOutDiscards = ifOutDiscards;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.20")
    private Integer ifOutErrors;

    public Integer getIfOutErrors() {
        return ifOutErrors;
    }

    private void setIfOutErrors(Integer ifOutErrors) {
        this.ifOutErrors = ifOutErrors;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.21")
    private Long ifOutQLen;

    public Long getIfOutQLen() {
        return ifOutQLen;
    }

    private void setIfOutQLen(Long ifOutQLen) {
        this.ifOutQLen = ifOutQLen;
    }

    @OidBind(oid = "1.3.6.1.2.1.2.2.1.22")
    private Object ifSpecific;

    public Object getIfSpecific() {
        return ifSpecific;
    }

    private void setIfSpecific(Object ifSpecific) {
        this.ifSpecific = ifSpecific;
    }
}
