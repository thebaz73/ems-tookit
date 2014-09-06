package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.ManagedObject;
import ems.snmp.toolkit.managed.annotation.OidProperty;
import ems.snmp.toolkit.managed.annotation.TableColumn;
import ems.snmp.toolkit.managed.annotation.TableRow;
import ems.snmp.toolkit.managed.mixin.ConfigurationAware;
import ems.snmp.toolkit.managed.mixin.SnmpEnquirer;

/**
 * Created by EMS Mib Compiler.
 * Do not edit
 */
@SuppressWarnings("UnusedDeclaration")
@ManagedObject
public class IfMib implements ConfigurationAware, SnmpEnquirer {

    /*
    * Property accessors for: ifNumber
    * Node type: SNMPv2-SMI: Integer32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.1
    * Access: read-only
    * Description: The number of network interfaces (regardless of their
            current state) present on this system.
    */

    private Integer ifNumber;

    @OidProperty(oid = "1.3.6.1.2.1.2.1.0", oidName = "ifNumber", fieldName = "ifNumber")
    public Integer getIfNumber() {
        return ifNumber;
    }

    private void setIfNumber(Integer ifNumber) {
        this.ifNumber = ifNumber;
    }

    /*
    * Property accessors for: ifTableLastChange
    * Node type: SNMPv2-SMI: TimeTicks
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.5
    * Access: read-only
    * Description: The value of sysUpTime at the time of the last creation or
            deletion of an entry in the ifTable.  If the number of
            entries has been unchanged since the last re-initialization
            of the local network management subsystem, then this object
            contains a zero value.
    */

    private Long ifTableLastChange;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.5.0", oidName = "ifTableLastChange", fieldName = "ifTableLastChange")
    public Long getIfTableLastChange() {
        return ifTableLastChange;
    }

    private void setIfTableLastChange(Long ifTableLastChange) {
        this.ifTableLastChange = ifTableLastChange;
    }

    /*
    * Property accessors for: ifStackLastChange
    * Node type: SNMPv2-SMI: TimeTicks
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.6
    * Access: read-only
    * Description: The value of sysUpTime at the time of the last change of
            the (whole) interface stack.  A change of the interface
            stack is defined to be any creation, deletion, or change in
            value of any instance of ifStackStatus.  If the interface
            stack has been unchanged since the last re-initialization of
            the local network management subsystem, then this object
            contains a zero value.
    */

    private Long ifStackLastChange;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.6.0", oidName = "ifStackLastChange", fieldName = "ifStackLastChange")
    public Long getIfStackLastChange() {
        return ifStackLastChange;
    }

    private void setIfStackLastChange(Long ifStackLastChange) {
        this.ifStackLastChange = ifStackLastChange;
    }


    /*
    * Property accessors for: ifIndex
    * Node type: IF-MIB: InterfaceIndex
    * Node base type: SNMPv2-SMI: Integer32
    * OID: 1.3.6.1.2.1.2.2.1.1
    * Access: read-only
    * Description: A unique value, greater than zero, for each interface.  It
            is recommended that values are assigned contiguously
            starting from 1.  The value for each interface sub-layer
            must remain constant at least from one re-initialization of
            the entity's network management system to the next re-
            initialization.
    */

    private Integer [] ifIndex;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.1", oidName = "ifIndex", fieldName = "ifIndex")
    public @TableColumn Integer [] getIfIndex() {
        return ifIndex;
    }

    private void setIfIndex(Integer [] ifIndex) {
        this.ifIndex = ifIndex;
    }

    /*
    * Property accessors for: ifDescr
    * Node type: IF-MIB: null
    * Node base type: SNMPv2-TC: DisplayString
    * OID: 1.3.6.1.2.1.2.2.1.2
    * Access: read-only
    * Description: A textual string containing information about the
            interface.  This string should include the name of the
            manufacturer, the product name and the version of the
            interface hardware/software.
    */

    private String [] ifDescr;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.2", oidName = "ifDescr", fieldName = "ifDescr")
    public @TableColumn String [] getIfDescr() {
        return ifDescr;
    }

    private void setIfDescr(String [] ifDescr) {
        this.ifDescr = ifDescr;
    }

    /*
    * Property accessors for: ifType
    * Node type: IANAifType-MIB: IANAifType
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.3
    * Access: read-only
    * Description: The type of interface.  Additional values for ifType are
            assigned by the Internet Assigned Numbers Authority (IANA),
            through updating the syntax of the IANAifType textual
            convention.
    */

    enum IfTypeEnum implements EmsEnum<Integer> {
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

        private IfTypeEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfTypeEnum [] ifType;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.3", oidName = "ifType", fieldName = "ifType")
    public @TableColumn IfTypeEnum [] getIfType() {
        return ifType;
    }

    private void setIfType(IfTypeEnum [] ifType) {
        this.ifType = ifType;
    }

    /*
    * Property accessors for: ifMtu
    * Node type: SNMPv2-SMI: Integer32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.4
    * Access: read-only
    * Description: The size of the largest packet which can be sent/received
            on the interface, specified in octets.  For interfaces that
            are used for transmitting network datagrams, this is the
            size of the largest network datagram that can be sent on the
            interface.
    */

    private Integer [] ifMtu;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.4", oidName = "ifMtu", fieldName = "ifMtu")
    public @TableColumn Integer [] getIfMtu() {
        return ifMtu;
    }

    private void setIfMtu(Integer [] ifMtu) {
        this.ifMtu = ifMtu;
    }

    /*
    * Property accessors for: ifSpeed
    * Node type: SNMPv2-SMI: Gauge32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.5
    * Access: read-only
    * Description: An estimate of the interface's current bandwidth in bits
            per second.  For interfaces which do not vary in bandwidth
            or for those where no accurate estimation can be made, this
            object should contain the nominal bandwidth.  If the
            bandwidth of the interface is greater than the maximum value
            reportable by this object then this object should report its
            maximum value (4,294,967,295) and ifHighSpeed must be used
            to report the interace's speed.  For a sub-layer which has
            no concept of bandwidth, this object should be zero.
    */

    private Long [] ifSpeed;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.5", oidName = "ifSpeed", fieldName = "ifSpeed")
    public @TableColumn Long [] getIfSpeed() {
        return ifSpeed;
    }

    private void setIfSpeed(Long [] ifSpeed) {
        this.ifSpeed = ifSpeed;
    }

    /*
    * Property accessors for: ifPhysAddress
    * Node type: SNMPv2-TC: PhysAddress
    * Node base type: JSMIPARSER_HARDCODED_MIB: OCTET STRING
    * OID: 1.3.6.1.2.1.2.2.1.6
    * Access: read-only
    * Description: The interface's address at its protocol sub-layer.  For
            example, for an 802.x interface, this object normally
            contains a MAC address.  The interface's media-specific MIB
            must define the bit and byte ordering and the format of the
            value of this object.  For interfaces which do not have such
            an address (e.g., a serial line), this object should contain
            an octet string of zero length.
    */

    private String [] ifPhysAddress;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.6", oidName = "ifPhysAddress", fieldName = "ifPhysAddress")
    public @TableColumn String [] getIfPhysAddress() {
        return ifPhysAddress;
    }

    private void setIfPhysAddress(String [] ifPhysAddress) {
        this.ifPhysAddress = ifPhysAddress;
    }

    /*
    * Property accessors for: ifAdminStatus
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.7
    * Access: read-write
    * Description: The desired state of the interface.  The testing(3) state
            indicates that no operational packets can be passed.  When a
            managed system initializes, all interfaces start with
            ifAdminStatus in the down(2) state.  As a result of either
            explicit management action or per configuration information
            retained by the managed system, ifAdminStatus is then
            changed to either the up(1) or testing(3) states (or remains
            in the down(2) state).
    */

    enum IfAdminStatusEnum implements EmsEnum<Integer> {
        UP (1),
        DOWN (2),
        TESTING (3);

        private Integer value;

        private IfAdminStatusEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfAdminStatusEnum [] ifAdminStatus;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.7", oidName = "ifAdminStatus", fieldName = "ifAdminStatus")
    public @TableColumn IfAdminStatusEnum [] getIfAdminStatus() {
        return ifAdminStatus;
    }

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.7", oidName = "ifAdminStatus", fieldName = "ifAdminStatus")
    public void setIfAdminStatus(@TableColumn IfAdminStatusEnum [] ifAdminStatus) {
        this.ifAdminStatus = ifAdminStatus;
    }

    /*
    * Property accessors for: ifOperStatus
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.8
    * Access: read-only
    * Description: The current operational state of the interface.  The
            testing(3) state indicates that no operational packets can
            be passed.  If ifAdminStatus is down(2) then ifOperStatus
            should be down(2).  If ifAdminStatus is changed to up(1)
            then ifOperStatus should change to up(1) if the interface is
            ready to transmit and receive network traffic; it should
            change to dormant(5) if the interface is waiting for
            external actions (such as a serial line waiting for an
            incoming connection); it should remain in the down(2) state
            if and only if there is a fault that prevents it from going
            to the up(1) state; it should remain in the notPresent(6)
            state if the interface has missing (typically, hardware)
            components.
    */

    enum IfOperStatusEnum implements EmsEnum<Integer> {
        UP (1),
        DOWN (2),
        TESTING (3),
        UNKNOWN (4),
        DORMANT (5),
        NOT_PRESENT (6),
        LOWER_LAYER_DOWN (7);

        private Integer value;

        private IfOperStatusEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfOperStatusEnum [] ifOperStatus;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.8", oidName = "ifOperStatus", fieldName = "ifOperStatus")
    public @TableColumn IfOperStatusEnum [] getIfOperStatus() {
        return ifOperStatus;
    }

    private void setIfOperStatus(IfOperStatusEnum [] ifOperStatus) {
        this.ifOperStatus = ifOperStatus;
    }

    /*
    * Property accessors for: ifLastChange
    * Node type: SNMPv2-SMI: TimeTicks
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.9
    * Access: read-only
    * Description: The value of sysUpTime at the time the interface entered
            its current operational state.  If the current state was
            entered prior to the last re-initialization of the local
            network management subsystem, then this object contains a
            zero value.
    */

    private Long [] ifLastChange;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.9", oidName = "ifLastChange", fieldName = "ifLastChange")
    public @TableColumn Long [] getIfLastChange() {
        return ifLastChange;
    }

    private void setIfLastChange(Long [] ifLastChange) {
        this.ifLastChange = ifLastChange;
    }

    /*
    * Property accessors for: ifInOctets
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.10
    * Access: read-only
    * Description: The total number of octets received on the interface,


            including framing characters.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInOctets;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.10", oidName = "ifInOctets", fieldName = "ifInOctets")
    public @TableColumn Integer [] getIfInOctets() {
        return ifInOctets;
    }

    private void setIfInOctets(Integer [] ifInOctets) {
        this.ifInOctets = ifInOctets;
    }

    /*
    * Property accessors for: ifInUcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.11
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were not addressed to a multicast
            or broadcast address at this sub-layer.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.11", oidName = "ifInUcastPkts", fieldName = "ifInUcastPkts")
    public @TableColumn Integer [] getIfInUcastPkts() {
        return ifInUcastPkts;
    }

    private void setIfInUcastPkts(Integer [] ifInUcastPkts) {
        this.ifInUcastPkts = ifInUcastPkts;
    }

    /*
    * Property accessors for: ifInNUcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.12
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were addressed to a multicast or
            broadcast address at this sub-layer.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.

            This object is deprecated in favour of ifInMulticastPkts and
            ifInBroadcastPkts.
    */

    private Integer [] ifInNUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.12", oidName = "ifInNUcastPkts", fieldName = "ifInNUcastPkts")
    public @TableColumn Integer [] getIfInNUcastPkts() {
        return ifInNUcastPkts;
    }

    private void setIfInNUcastPkts(Integer [] ifInNUcastPkts) {
        this.ifInNUcastPkts = ifInNUcastPkts;
    }

    /*
    * Property accessors for: ifInDiscards
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.13
    * Access: read-only
    * Description: The number of inbound packets which were chosen to be
            discarded even though no errors had been detected to prevent


            their being deliverable to a higher-layer protocol.  One
            possible reason for discarding such a packet could be to
            free up buffer space.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInDiscards;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.13", oidName = "ifInDiscards", fieldName = "ifInDiscards")
    public @TableColumn Integer [] getIfInDiscards() {
        return ifInDiscards;
    }

    private void setIfInDiscards(Integer [] ifInDiscards) {
        this.ifInDiscards = ifInDiscards;
    }

    /*
    * Property accessors for: ifInErrors
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.14
    * Access: read-only
    * Description: For packet-oriented interfaces, the number of inbound
            packets that contained errors preventing them from being
            deliverable to a higher-layer protocol.  For character-
            oriented or fixed-length interfaces, the number of inbound
            transmission units that contained errors preventing them
            from being deliverable to a higher-layer protocol.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInErrors;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.14", oidName = "ifInErrors", fieldName = "ifInErrors")
    public @TableColumn Integer [] getIfInErrors() {
        return ifInErrors;
    }

    private void setIfInErrors(Integer [] ifInErrors) {
        this.ifInErrors = ifInErrors;
    }

    /*
    * Property accessors for: ifInUnknownProtos
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.15
    * Access: read-only
    * Description: For packet-oriented interfaces, the number of packets
            received via the interface which were discarded because of
            an unknown or unsupported protocol.  For character-oriented
            or fixed-length interfaces that support protocol
            multiplexing the number of transmission units received via
            the interface which were discarded because of an unknown or
            unsupported protocol.  For any interface that does not
            support protocol multiplexing, this counter will always be
            0.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInUnknownProtos;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.15", oidName = "ifInUnknownProtos", fieldName = "ifInUnknownProtos")
    public @TableColumn Integer [] getIfInUnknownProtos() {
        return ifInUnknownProtos;
    }

    private void setIfInUnknownProtos(Integer [] ifInUnknownProtos) {
        this.ifInUnknownProtos = ifInUnknownProtos;
    }

    /*
    * Property accessors for: ifOutOctets
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.16
    * Access: read-only
    * Description: The total number of octets transmitted out of the
            interface, including framing characters.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutOctets;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.16", oidName = "ifOutOctets", fieldName = "ifOutOctets")
    public @TableColumn Integer [] getIfOutOctets() {
        return ifOutOctets;
    }

    private void setIfOutOctets(Integer [] ifOutOctets) {
        this.ifOutOctets = ifOutOctets;
    }

    /*
    * Property accessors for: ifOutUcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.17
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were not addressed to a
            multicast or broadcast address at this sub-layer, including
            those that were discarded or not sent.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.17", oidName = "ifOutUcastPkts", fieldName = "ifOutUcastPkts")
    public @TableColumn Integer [] getIfOutUcastPkts() {
        return ifOutUcastPkts;
    }

    private void setIfOutUcastPkts(Integer [] ifOutUcastPkts) {
        this.ifOutUcastPkts = ifOutUcastPkts;
    }

    /*
    * Property accessors for: ifOutNUcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.18
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were addressed to a
            multicast or broadcast address at this sub-layer, including
            those that were discarded or not sent.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.

            This object is deprecated in favour of ifOutMulticastPkts
            and ifOutBroadcastPkts.
    */

    private Integer [] ifOutNUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.18", oidName = "ifOutNUcastPkts", fieldName = "ifOutNUcastPkts")
    public @TableColumn Integer [] getIfOutNUcastPkts() {
        return ifOutNUcastPkts;
    }

    private void setIfOutNUcastPkts(Integer [] ifOutNUcastPkts) {
        this.ifOutNUcastPkts = ifOutNUcastPkts;
    }

    /*
    * Property accessors for: ifOutDiscards
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.19
    * Access: read-only
    * Description: The number of outbound packets which were chosen to be
            discarded even though no errors had been detected to prevent
            their being transmitted.  One possible reason for discarding
            such a packet could be to free up buffer space.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutDiscards;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.19", oidName = "ifOutDiscards", fieldName = "ifOutDiscards")
    public @TableColumn Integer [] getIfOutDiscards() {
        return ifOutDiscards;
    }

    private void setIfOutDiscards(Integer [] ifOutDiscards) {
        this.ifOutDiscards = ifOutDiscards;
    }

    /*
    * Property accessors for: ifOutErrors
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.20
    * Access: read-only
    * Description: For packet-oriented interfaces, the number of outbound
            packets that could not be transmitted because of errors.
            For character-oriented or fixed-length interfaces, the
            number of outbound transmission units that could not be
            transmitted because of errors.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutErrors;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.20", oidName = "ifOutErrors", fieldName = "ifOutErrors")
    public @TableColumn Integer [] getIfOutErrors() {
        return ifOutErrors;
    }

    private void setIfOutErrors(Integer [] ifOutErrors) {
        this.ifOutErrors = ifOutErrors;
    }

    /*
    * Property accessors for: ifOutQLen
    * Node type: SNMPv2-SMI: Gauge32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.2.1.21
    * Access: read-only
    * Description: The length of the output packet queue (in packets).
    */

    private Long [] ifOutQLen;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.21", oidName = "ifOutQLen", fieldName = "ifOutQLen")
    public @TableColumn Long [] getIfOutQLen() {
        return ifOutQLen;
    }

    private void setIfOutQLen(Long [] ifOutQLen) {
        this.ifOutQLen = ifOutQLen;
    }

    /*
    * Property accessors for: ifSpecific
    * Node type: JSMIPARSER_HARDCODED_MIB: OBJECT IDENTIFIER
    * Node base type: $columnType.getBaseType()
    * OID: 1.3.6.1.2.1.2.2.1.22
    * Access: read-only
    * Description: A reference to MIB definitions specific to the particular
            media being used to realize the interface.  It is


            recommended that this value point to an instance of a MIB
            object in the media-specific MIB, i.e., that this object
            have the semantics associated with the InstancePointer
            textual convention defined in RFC 2579.  In fact, it is
            recommended that the media-specific MIB specify what value
            ifSpecific should/can take for values of ifType.  If no MIB
            definitions specific to the particular media are available,
            the value should be set to the OBJECT IDENTIFIER { 0 0 }.
    */

    private Object [] ifSpecific;

    @OidProperty(oid = "1.3.6.1.2.1.2.2.1.22", oidName = "ifSpecific", fieldName = "ifSpecific")
    public @TableColumn Object [] getIfSpecific() {
        return ifSpecific;
    }

    private void setIfSpecific(Object [] ifSpecific) {
        this.ifSpecific = ifSpecific;
    }

    /*
    * Property accessors for: ifName
    * Node type: SNMPv2-TC: DisplayString
    * Node base type: JSMIPARSER_HARDCODED_MIB: OCTET STRING
    * OID: 1.3.6.1.2.1.31.1.1.1.1
    * Access: read-only
    * Description: The textual name of the interface.  The value of this
            object should be the name of the interface as assigned by
            the local device and should be suitable for use in commands
            entered at the device's `console'.  This might be a text
            name, such as `le0' or a simple port number, such as `1',
            depending on the interface naming syntax of the device.  If
            several entries in the ifTable together represent a single
            interface as named by the device, then each will have the
            same value of ifName.  Note that for an agent which responds
            to SNMP queries concerning an interface on some other
            (proxied) device, then the value of ifName for such an
            interface is the proxied device's local name for it.

            If there is no local name, or this object is otherwise not
            applicable, then this object contains a zero-length string.
    */

    private String [] ifName;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.1", oidName = "ifName", fieldName = "ifName")
    public @TableColumn String [] getIfName() {
        return ifName;
    }

    private void setIfName(String [] ifName) {
        this.ifName = ifName;
    }

    /*
    * Property accessors for: ifInMulticastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.2
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were addressed to a multicast
            address at this sub-layer.  For a MAC layer protocol, this
            includes both Group and Functional addresses.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other


            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInMulticastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.2", oidName = "ifInMulticastPkts", fieldName = "ifInMulticastPkts")
    public @TableColumn Integer [] getIfInMulticastPkts() {
        return ifInMulticastPkts;
    }

    private void setIfInMulticastPkts(Integer [] ifInMulticastPkts) {
        this.ifInMulticastPkts = ifInMulticastPkts;
    }

    /*
    * Property accessors for: ifInBroadcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.3
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were addressed to a broadcast
            address at this sub-layer.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifInBroadcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.3", oidName = "ifInBroadcastPkts", fieldName = "ifInBroadcastPkts")
    public @TableColumn Integer [] getIfInBroadcastPkts() {
        return ifInBroadcastPkts;
    }

    private void setIfInBroadcastPkts(Integer [] ifInBroadcastPkts) {
        this.ifInBroadcastPkts = ifInBroadcastPkts;
    }

    /*
    * Property accessors for: ifOutMulticastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.4
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were addressed to a
            multicast address at this sub-layer, including those that
            were discarded or not sent.  For a MAC layer protocol, this
            includes both Group and Functional addresses.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutMulticastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.4", oidName = "ifOutMulticastPkts", fieldName = "ifOutMulticastPkts")
    public @TableColumn Integer [] getIfOutMulticastPkts() {
        return ifOutMulticastPkts;
    }

    private void setIfOutMulticastPkts(Integer [] ifOutMulticastPkts) {
        this.ifOutMulticastPkts = ifOutMulticastPkts;
    }

    /*
    * Property accessors for: ifOutBroadcastPkts
    * Node type: SNMPv2-SMI: Counter32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.5
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were addressed to a
            broadcast address at this sub-layer, including those that
            were discarded or not sent.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other


            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Integer [] ifOutBroadcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.5", oidName = "ifOutBroadcastPkts", fieldName = "ifOutBroadcastPkts")
    public @TableColumn Integer [] getIfOutBroadcastPkts() {
        return ifOutBroadcastPkts;
    }

    private void setIfOutBroadcastPkts(Integer [] ifOutBroadcastPkts) {
        this.ifOutBroadcastPkts = ifOutBroadcastPkts;
    }

    /*
    * Property accessors for: ifHCInOctets
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.6
    * Access: read-only
    * Description: The total number of octets received on the interface,
            including framing characters.  This object is a 64-bit
            version of ifInOctets.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCInOctets;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.6", oidName = "ifHCInOctets", fieldName = "ifHCInOctets")
    public @TableColumn Long [] getIfHCInOctets() {
        return ifHCInOctets;
    }

    private void setIfHCInOctets(Long [] ifHCInOctets) {
        this.ifHCInOctets = ifHCInOctets;
    }

    /*
    * Property accessors for: ifHCInUcastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.7
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were not addressed to a multicast
            or broadcast address at this sub-layer.  This object is a
            64-bit version of ifInUcastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCInUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.7", oidName = "ifHCInUcastPkts", fieldName = "ifHCInUcastPkts")
    public @TableColumn Long [] getIfHCInUcastPkts() {
        return ifHCInUcastPkts;
    }

    private void setIfHCInUcastPkts(Long [] ifHCInUcastPkts) {
        this.ifHCInUcastPkts = ifHCInUcastPkts;
    }

    /*
    * Property accessors for: ifHCInMulticastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.8
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were addressed to a multicast
            address at this sub-layer.  For a MAC layer protocol, this
            includes both Group and Functional addresses.  This object
            is a 64-bit version of ifInMulticastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCInMulticastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.8", oidName = "ifHCInMulticastPkts", fieldName = "ifHCInMulticastPkts")
    public @TableColumn Long [] getIfHCInMulticastPkts() {
        return ifHCInMulticastPkts;
    }

    private void setIfHCInMulticastPkts(Long [] ifHCInMulticastPkts) {
        this.ifHCInMulticastPkts = ifHCInMulticastPkts;
    }

    /*
    * Property accessors for: ifHCInBroadcastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.9
    * Access: read-only
    * Description: The number of packets, delivered by this sub-layer to a
            higher (sub-)layer, which were addressed to a broadcast
            address at this sub-layer.  This object is a 64-bit version
            of ifInBroadcastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCInBroadcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.9", oidName = "ifHCInBroadcastPkts", fieldName = "ifHCInBroadcastPkts")
    public @TableColumn Long [] getIfHCInBroadcastPkts() {
        return ifHCInBroadcastPkts;
    }

    private void setIfHCInBroadcastPkts(Long [] ifHCInBroadcastPkts) {
        this.ifHCInBroadcastPkts = ifHCInBroadcastPkts;
    }

    /*
    * Property accessors for: ifHCOutOctets
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.10
    * Access: read-only
    * Description: The total number of octets transmitted out of the
            interface, including framing characters.  This object is a
            64-bit version of ifOutOctets.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCOutOctets;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.10", oidName = "ifHCOutOctets", fieldName = "ifHCOutOctets")
    public @TableColumn Long [] getIfHCOutOctets() {
        return ifHCOutOctets;
    }

    private void setIfHCOutOctets(Long [] ifHCOutOctets) {
        this.ifHCOutOctets = ifHCOutOctets;
    }

    /*
    * Property accessors for: ifHCOutUcastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.11
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were not addressed to a
            multicast or broadcast address at this sub-layer, including
            those that were discarded or not sent.  This object is a
            64-bit version of ifOutUcastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCOutUcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.11", oidName = "ifHCOutUcastPkts", fieldName = "ifHCOutUcastPkts")
    public @TableColumn Long [] getIfHCOutUcastPkts() {
        return ifHCOutUcastPkts;
    }

    private void setIfHCOutUcastPkts(Long [] ifHCOutUcastPkts) {
        this.ifHCOutUcastPkts = ifHCOutUcastPkts;
    }

    /*
    * Property accessors for: ifHCOutMulticastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.12
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were addressed to a
            multicast address at this sub-layer, including those that
            were discarded or not sent.  For a MAC layer protocol, this
            includes both Group and Functional addresses.  This object
            is a 64-bit version of ifOutMulticastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCOutMulticastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.12", oidName = "ifHCOutMulticastPkts", fieldName = "ifHCOutMulticastPkts")
    public @TableColumn Long [] getIfHCOutMulticastPkts() {
        return ifHCOutMulticastPkts;
    }

    private void setIfHCOutMulticastPkts(Long [] ifHCOutMulticastPkts) {
        this.ifHCOutMulticastPkts = ifHCOutMulticastPkts;
    }

    /*
    * Property accessors for: ifHCOutBroadcastPkts
    * Node type: SNMPv2-SMI: Counter64
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.13
    * Access: read-only
    * Description: The total number of packets that higher-level protocols
            requested be transmitted, and which were addressed to a
            broadcast address at this sub-layer, including those that
            were discarded or not sent.  This object is a 64-bit version
            of ifOutBroadcastPkts.

            Discontinuities in the value of this counter can occur at
            re-initialization of the management system, and at other
            times as indicated by the value of
            ifCounterDiscontinuityTime.
    */

    private Long [] ifHCOutBroadcastPkts;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.13", oidName = "ifHCOutBroadcastPkts", fieldName = "ifHCOutBroadcastPkts")
    public @TableColumn Long [] getIfHCOutBroadcastPkts() {
        return ifHCOutBroadcastPkts;
    }

    private void setIfHCOutBroadcastPkts(Long [] ifHCOutBroadcastPkts) {
        this.ifHCOutBroadcastPkts = ifHCOutBroadcastPkts;
    }

    /*
    * Property accessors for: ifLinkUpDownTrapEnable
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.14
    * Access: read-write
    * Description: Indicates whether linkUp/linkDown traps should be generated
            for this interface.

            By default, this object should have the value enabled(1) for
            interfaces which do not operate on 'top' of any other
            interface (as defined in the ifStackTable), and disabled(2)
            otherwise.
    */

    enum IfLinkUpDownTrapEnableEnum implements EmsEnum<Integer> {
        ENABLED (1),
        DISABLED (2);

        private Integer value;

        private IfLinkUpDownTrapEnableEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfLinkUpDownTrapEnableEnum [] ifLinkUpDownTrapEnable;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.14", oidName = "ifLinkUpDownTrapEnable", fieldName = "ifLinkUpDownTrapEnable")
    public @TableColumn IfLinkUpDownTrapEnableEnum [] getIfLinkUpDownTrapEnable() {
        return ifLinkUpDownTrapEnable;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.14", oidName = "ifLinkUpDownTrapEnable", fieldName = "ifLinkUpDownTrapEnable")
    public void setIfLinkUpDownTrapEnable(@TableColumn IfLinkUpDownTrapEnableEnum [] ifLinkUpDownTrapEnable) {
        this.ifLinkUpDownTrapEnable = ifLinkUpDownTrapEnable;
    }

    /*
    * Property accessors for: ifHighSpeed
    * Node type: SNMPv2-SMI: Gauge32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.15
    * Access: read-only
    * Description: An estimate of the interface's current bandwidth in units
            of 1,000,000 bits per second.  If this object reports a
            value of `n' then the speed of the interface is somewhere in
            the range of `n-500,000' to `n+499,999'.  For interfaces
            which do not vary in bandwidth or for those where no
            accurate estimation can be made, this object should contain
            the nominal bandwidth.  For a sub-layer which has no concept
            of bandwidth, this object should be zero.
    */

    private Long [] ifHighSpeed;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.15", oidName = "ifHighSpeed", fieldName = "ifHighSpeed")
    public @TableColumn Long [] getIfHighSpeed() {
        return ifHighSpeed;
    }

    private void setIfHighSpeed(Long [] ifHighSpeed) {
        this.ifHighSpeed = ifHighSpeed;
    }

    /*
    * Property accessors for: ifPromiscuousMode
    * Node type: SNMPv2-TC: TruthValue
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.16
    * Access: read-write
    * Description: This object has a value of false(2) if this interface only
            accepts packets/frames that are addressed to this station.
            This object has a value of true(1) when the station accepts
            all packets/frames transmitted on the media.  The value
            true(1) is only legal on certain types of media.  If legal,
            setting this object to a value of true(1) may require the
            interface to be reset before becoming effective.

            The value of ifPromiscuousMode does not affect the reception
            of broadcast and multicast packets/frames by the interface.
    */

    enum IfPromiscuousModeEnum implements EmsEnum<Integer> {
        TRUE (1),
        FALSE (2);

        private Integer value;

        private IfPromiscuousModeEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfPromiscuousModeEnum [] ifPromiscuousMode;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.16", oidName = "ifPromiscuousMode", fieldName = "ifPromiscuousMode")
    public @TableColumn IfPromiscuousModeEnum [] getIfPromiscuousMode() {
        return ifPromiscuousMode;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.16", oidName = "ifPromiscuousMode", fieldName = "ifPromiscuousMode")
    public void setIfPromiscuousMode(@TableColumn IfPromiscuousModeEnum [] ifPromiscuousMode) {
        this.ifPromiscuousMode = ifPromiscuousMode;
    }

    /*
    * Property accessors for: ifConnectorPresent
    * Node type: SNMPv2-TC: TruthValue
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.1.1.17
    * Access: read-only
    * Description: This object has the value 'true(1)' if the interface
            sublayer has a physical connector and the value 'false(2)'
            otherwise.
    */

    enum IfConnectorPresentEnum implements EmsEnum<Integer> {
        TRUE (1),
        FALSE (2);

        private Integer value;

        private IfConnectorPresentEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfConnectorPresentEnum [] ifConnectorPresent;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.17", oidName = "ifConnectorPresent", fieldName = "ifConnectorPresent")
    public @TableColumn IfConnectorPresentEnum [] getIfConnectorPresent() {
        return ifConnectorPresent;
    }

    private void setIfConnectorPresent(IfConnectorPresentEnum [] ifConnectorPresent) {
        this.ifConnectorPresent = ifConnectorPresent;
    }

    /*
    * Property accessors for: ifAlias
    * Node type: IF-MIB: null
    * Node base type: SNMPv2-TC: DisplayString
    * OID: 1.3.6.1.2.1.31.1.1.1.18
    * Access: read-write
    * Description: This object is an 'alias' name for the interface as
            specified by a network manager, and provides a non-volatile
            'handle' for the interface.

            On the first instantiation of an interface, the value of
            ifAlias associated with that interface is the zero-length
            string.  As and when a value is written into an instance of
            ifAlias through a network management set operation, then the
            agent must retain the supplied value in the ifAlias instance
            associated with the same interface for as long as that
            interface remains instantiated, including across all re-
            initializations/reboots of the network management system,
            including those which result in a change of the interface's
            ifIndex value.

            An example of the value which a network manager might store
            in this object for a WAN interface is the (Telco's) circuit
            number/identifier of the interface.

            Some agents may support write-access only for interfaces
            having particular values of ifType.  An agent which supports
            write access to this object is required to keep the value in
            non-volatile storage, but it may limit the length of new
            values depending on how much storage is already occupied by
            the current values for other interfaces.
    */

    private String [] ifAlias;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.18", oidName = "ifAlias", fieldName = "ifAlias")
    public @TableColumn String [] getIfAlias() {
        return ifAlias;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.18", oidName = "ifAlias", fieldName = "ifAlias")
    public void setIfAlias(@TableColumn String [] ifAlias) {
        this.ifAlias = ifAlias;
    }

    /*
    * Property accessors for: ifCounterDiscontinuityTime
    * Node type: SNMPv2-TC: TimeStamp
    * Node base type: SNMPv2-SMI: TimeTicks
    * OID: 1.3.6.1.2.1.31.1.1.1.19
    * Access: read-only
    * Description: The value of sysUpTime on the most recent occasion at which
            any one or more of this interface's counters suffered a
            discontinuity.  The relevant counters are the specific
            instances associated with this interface of any Counter32 or


            Counter64 object contained in the ifTable or ifXTable.  If
            no such discontinuities have occurred since the last re-
            initialization of the local management subsystem, then this
            object contains a zero value.
    */

    private Long [] ifCounterDiscontinuityTime;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1.1.19", oidName = "ifCounterDiscontinuityTime", fieldName = "ifCounterDiscontinuityTime")
    public @TableColumn Long [] getIfCounterDiscontinuityTime() {
        return ifCounterDiscontinuityTime;
    }

    private void setIfCounterDiscontinuityTime(Long [] ifCounterDiscontinuityTime) {
        this.ifCounterDiscontinuityTime = ifCounterDiscontinuityTime;
    }

    /*
    * Property accessors for: ifStackHigherLayer
    * Node type: IF-MIB: InterfaceIndexOrZero
    * Node base type: SNMPv2-SMI: Integer32
    * OID: 1.3.6.1.2.1.31.1.2.1.1
    * Access: not-accessible
    * Description: The value of ifIndex corresponding to the higher sub-layer
            of the relationship, i.e., the sub-layer which runs on 'top'
            of the sub-layer identified by the corresponding instance of
            ifStackLowerLayer.  If there is no higher sub-layer (below
            the internetwork layer), then this object has the value 0.
    */

    private Integer [] ifStackHigherLayer;


    /*
    * Property accessors for: ifStackLowerLayer
    * Node type: IF-MIB: InterfaceIndexOrZero
    * Node base type: SNMPv2-SMI: Integer32
    * OID: 1.3.6.1.2.1.31.1.2.1.2
    * Access: not-accessible
    * Description: The value of ifIndex corresponding to the lower sub-layer
            of the relationship, i.e., the sub-layer which runs 'below'
            the sub-layer identified by the corresponding instance of
            ifStackHigherLayer.  If there is no lower sub-layer, then
            this object has the value 0.
    */

    private Integer [] ifStackLowerLayer;


    /*
    * Property accessors for: ifStackStatus
    * Node type: SNMPv2-TC: RowStatus
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.2.1.3
    * Access: read-create
    * Description: The status of the relationship between two sub-layers.

            Changing the value of this object from 'active' to
            'notInService' or 'destroy' will likely have consequences up
            and down the interface stack.  Thus, write access to this
            object is likely to be inappropriate for some types of
            interfaces, and many implementations will choose not to
            support write-access for any type of interface.
    */

    enum IfStackStatusEnum implements EmsEnum<Integer> {
        ACTIVE (1),
        NOT_IN_SERVICE (2),
        NOT_READY (3),
        CREATE_AND_GO (4),
        CREATE_AND_WAIT (5),
        DESTROY (6);

        private Integer value;

        private IfStackStatusEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfStackStatusEnum [] ifStackStatus;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.2.1.3", oidName = "ifStackStatus", fieldName = "ifStackStatus")
    public @TableColumn IfStackStatusEnum [] getIfStackStatus() {
        return ifStackStatus;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.2.1.3", oidName = "ifStackStatus", fieldName = "ifStackStatus")
    public void setIfStackStatus(@TableColumn IfStackStatusEnum [] ifStackStatus) {
        this.ifStackStatus = ifStackStatus;
    }

    /*
    * Property accessors for: ifRcvAddressAddress
    * Node type: SNMPv2-TC: PhysAddress
    * Node base type: JSMIPARSER_HARDCODED_MIB: OCTET STRING
    * OID: 1.3.6.1.2.1.31.1.4.1.1
    * Access: not-accessible
    * Description: An address for which the system will accept packets/frames
            on this entry's interface.
    */

    private String [] ifRcvAddressAddress;


    /*
    * Property accessors for: ifRcvAddressStatus
    * Node type: SNMPv2-TC: RowStatus
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.4.1.2
    * Access: read-create
    * Description: This object is used to create and delete rows in the
            ifRcvAddressTable.
    */

    enum IfRcvAddressStatusEnum implements EmsEnum<Integer> {
        ACTIVE (1),
        NOT_IN_SERVICE (2),
        NOT_READY (3),
        CREATE_AND_GO (4),
        CREATE_AND_WAIT (5),
        DESTROY (6);

        private Integer value;

        private IfRcvAddressStatusEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfRcvAddressStatusEnum [] ifRcvAddressStatus;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.4.1.2", oidName = "ifRcvAddressStatus", fieldName = "ifRcvAddressStatus")
    public @TableColumn IfRcvAddressStatusEnum [] getIfRcvAddressStatus() {
        return ifRcvAddressStatus;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.4.1.2", oidName = "ifRcvAddressStatus", fieldName = "ifRcvAddressStatus")
    public void setIfRcvAddressStatus(@TableColumn IfRcvAddressStatusEnum [] ifRcvAddressStatus) {
        this.ifRcvAddressStatus = ifRcvAddressStatus;
    }

    /*
    * Property accessors for: ifRcvAddressType
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.4.1.3
    * Access: read-create
    * Description: This object has the value nonVolatile(3) for those entries
            in the table which are valid and will not be deleted by the
            next restart of the managed system.  Entries having the
            value volatile(2) are valid and exist, but have not been
            saved, so that will not exist after the next restart of the
            managed system.  Entries having the value other(1) are valid
            and exist but are not classified as to whether they will
            continue to exist after the next restart.
    */

    enum IfRcvAddressTypeEnum implements EmsEnum<Integer> {
        OTHER (1),
        VOLATILE (2),
        NON_VOLATILE (3);

        private Integer value;

        private IfRcvAddressTypeEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfRcvAddressTypeEnum [] ifRcvAddressType;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.4.1.3", oidName = "ifRcvAddressType", fieldName = "ifRcvAddressType")
    public @TableColumn IfRcvAddressTypeEnum [] getIfRcvAddressType() {
        return ifRcvAddressType;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.4.1.3", oidName = "ifRcvAddressType", fieldName = "ifRcvAddressType")
    public void setIfRcvAddressType(@TableColumn IfRcvAddressTypeEnum [] ifRcvAddressType) {
        this.ifRcvAddressType = ifRcvAddressType;
    }

    /*
    * Property accessors for: ifTestId
    * Node type: SNMPv2-TC: TestAndIncr
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.3.1.1
    * Access: read-write
    * Description: This object identifies the current invocation of the
            interface's test.
    */

    private Integer [] ifTestId;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.1", oidName = "ifTestId", fieldName = "ifTestId")
    public @TableColumn Integer [] getIfTestId() {
        return ifTestId;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.1", oidName = "ifTestId", fieldName = "ifTestId")
    public void setIfTestId(@TableColumn Integer [] ifTestId) {
        this.ifTestId = ifTestId;
    }

    /*
    * Property accessors for: ifTestStatus
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.3.1.2
    * Access: read-write
    * Description: This object indicates whether or not some manager currently
            has the necessary 'ownership' required to invoke a test on
            this interface.  A write to this object is only successful
            when it changes its value from 'notInUse(1)' to 'inUse(2)'.
            After completion of a test, the agent resets the value back
            to 'notInUse(1)'.
    */

    enum IfTestStatusEnum implements EmsEnum<Integer> {
        NOT_IN_USE (1),
        IN_USE (2);

        private Integer value;

        private IfTestStatusEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfTestStatusEnum [] ifTestStatus;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.2", oidName = "ifTestStatus", fieldName = "ifTestStatus")
    public @TableColumn IfTestStatusEnum [] getIfTestStatus() {
        return ifTestStatus;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.2", oidName = "ifTestStatus", fieldName = "ifTestStatus")
    public void setIfTestStatus(@TableColumn IfTestStatusEnum [] ifTestStatus) {
        this.ifTestStatus = ifTestStatus;
    }

    /*
    * Property accessors for: ifTestType
    * Node type: SNMPv2-TC: AutonomousType
    * Node base type: JSMIPARSER_HARDCODED_MIB: OBJECT IDENTIFIER
    * OID: 1.3.6.1.2.1.31.1.3.1.3
    * Access: read-write
    * Description: A control variable used to start and stop operator-
            initiated interface tests.  Most OBJECT IDENTIFIER values
            assigned to tests are defined elsewhere, in association with
            specific types of interface.  However, this document assigns
            a value for a full-duplex loopback test, and defines the
            special meanings of the subject identifier:

                noTest  OBJECT IDENTIFIER ::= { 0 0 }

            When the value noTest is written to this object, no action
            is taken unless a test is in progress, in which case the
            test is aborted.  Writing any other value to this object is


            only valid when no test is currently in progress, in which
            case the indicated test is initiated.

            When read, this object always returns the most recent value
            that ifTestType was set to.  If it has not been set since
            the last initialization of the network management subsystem
            on the agent, a value of noTest is returned.
    */

    private Object [] ifTestType;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.3", oidName = "ifTestType", fieldName = "ifTestType")
    public @TableColumn Object [] getIfTestType() {
        return ifTestType;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.3", oidName = "ifTestType", fieldName = "ifTestType")
    public void setIfTestType(@TableColumn Object [] ifTestType) {
        this.ifTestType = ifTestType;
    }

    /*
    * Property accessors for: ifTestResult
    * Node type: IF-MIB: null
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.31.1.3.1.4
    * Access: read-only
    * Description: This object contains the result of the most recently
            requested test, or the value none(1) if no tests have been
            requested since the last reset.  Note that this facility
            provides no provision for saving the results of one test
            when starting another, as could be required if used by
            multiple managers concurrently.
    */

    enum IfTestResultEnum implements EmsEnum<Integer> {
        NONE (1),
        SUCCESS (2),
        IN_PROGRESS (3),
        NOT_SUPPORTED (4),
        UN_ABLE_TO_RUN (5),
        ABORTED (6),
        FAILED (7);

        private Integer value;

        private IfTestResultEnum(Integer i) {
            value = i;
        }

        public Integer getValue() {
            return value;
        }
    }

    private IfTestResultEnum [] ifTestResult;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.4", oidName = "ifTestResult", fieldName = "ifTestResult")
    public @TableColumn IfTestResultEnum [] getIfTestResult() {
        return ifTestResult;
    }

    private void setIfTestResult(IfTestResultEnum [] ifTestResult) {
        this.ifTestResult = ifTestResult;
    }

    /*
    * Property accessors for: ifTestCode
    * Node type: JSMIPARSER_HARDCODED_MIB: OBJECT IDENTIFIER
    * Node base type: $columnType.getBaseType()
    * OID: 1.3.6.1.2.1.31.1.3.1.5
    * Access: read-only
    * Description: This object contains a code which contains more specific
            information on the test result, for example an error-code
            after a failed test.  Error codes and other values this
            object may take are specific to the type of interface and/or
            test.  The value may have the semantics of either the
            AutonomousType or InstancePointer textual conventions as
            defined in RFC 2579.  The identifier:

                testCodeUnknown  OBJECT IDENTIFIER ::= { 0 0 }

            is defined for use if no additional result code is
            available.
    */

    private Object [] ifTestCode;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.5", oidName = "ifTestCode", fieldName = "ifTestCode")
    public @TableColumn Object [] getIfTestCode() {
        return ifTestCode;
    }

    private void setIfTestCode(Object [] ifTestCode) {
        this.ifTestCode = ifTestCode;
    }

    /*
    * Property accessors for: ifTestOwner
    * Node type: IF-MIB: OwnerString
    * Node base type: JSMIPARSER_HARDCODED_MIB: OCTET STRING
    * OID: 1.3.6.1.2.1.31.1.3.1.6
    * Access: read-write
    * Description: The entity which currently has the 'ownership' required to
            invoke a test on this interface.
    */

    private String [] ifTestOwner;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.6", oidName = "ifTestOwner", fieldName = "ifTestOwner")
    public @TableColumn String [] getIfTestOwner() {
        return ifTestOwner;
    }

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3.1.6", oidName = "ifTestOwner", fieldName = "ifTestOwner")
    public void setIfTestOwner(@TableColumn String [] ifTestOwner) {
        this.ifTestOwner = ifTestOwner;
    }


    /*
    * Property accessors for: ifTable
    * Table OID: 1.3.6.1.2.1.2.2
    * Row OID: 1.3.6.1.2.1.2.2.1
    * Access: not-accessible
    * Description: A list of interface entries.  The number of entries is
            given by the value of ifNumber.
    */

    private IfEntry [] ifTable;

    @OidProperty(oid = "1.3.6.1.2.1.2.2", oidName = "ifTable", fieldName = "ifTable")
    public
    @TableRow
    IfEntry [] getIfTable() {
        return ifTable;
    }

    private void setIfTable(IfEntry [] rows) {
        this.ifTable = rows;
    }

    /*
    * Property accessors for: ifXTable
    * Table OID: 1.3.6.1.2.1.31.1.1
    * Row OID: 1.3.6.1.2.1.31.1.1.1
    * Access: not-accessible
    * Description: A list of interface entries.  The number of entries is
            given by the value of ifNumber.  This table contains
            additional objects for the interface table.
    */

    private IfXEntry [] ifXTable;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.1", oidName = "ifXTable", fieldName = "ifXTable")
    public
    @TableRow
    IfXEntry [] getIfXTable() {
        return ifXTable;
    }

    private void setIfXTable(IfXEntry [] rows) {
        this.ifXTable = rows;
    }

    /*
    * Property accessors for: ifStackTable
    * Table OID: 1.3.6.1.2.1.31.1.2
    * Row OID: 1.3.6.1.2.1.31.1.2.1
    * Access: not-accessible
    * Description: The table containing information on the relationships
            between the multiple sub-layers of network interfaces.  In
            particular, it contains information on which sub-layers run
            'on top of' which other sub-layers, where each sub-layer
            corresponds to a conceptual row in the ifTable.  For
            example, when the sub-layer with ifIndex value x runs over
            the sub-layer with ifIndex value y, then this table
            contains:

              ifStackStatus.x.y=active

            For each ifIndex value, I, which identifies an active
            interface, there are always at least two instantiated rows
            in this table associated with I.  For one of these rows, I
            is the value of ifStackHigherLayer; for the other, I is the
            value of ifStackLowerLayer.  (If I is not involved in
            multiplexing, then these are the only two rows associated
            with I.)

            For example, two rows exist even for an interface which has
            no others stacked on top or below it:

              ifStackStatus.0.x=active
              ifStackStatus.x.0=active
    */

    private IfStackEntry [] ifStackTable;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.2", oidName = "ifStackTable", fieldName = "ifStackTable")
    public
    @TableRow
    IfStackEntry [] getIfStackTable() {
        return ifStackTable;
    }

    private void setIfStackTable(IfStackEntry [] rows) {
        this.ifStackTable = rows;
    }

    /*
    * Property accessors for: ifRcvAddressTable
    * Table OID: 1.3.6.1.2.1.31.1.4
    * Row OID: 1.3.6.1.2.1.31.1.4.1
    * Access: not-accessible
    * Description: This table contains an entry for each address (broadcast,
            multicast, or uni-cast) for which the system will receive
            packets/frames on a particular interface, except as follows:

            - for an interface operating in promiscuous mode, entries
            are only required for those addresses for which the system
            would receive frames were it not operating in promiscuous
            mode.


            - for 802.5 functional addresses, only one entry is
            required, for the address which has the functional address
            bit ANDed with the bit mask of all functional addresses for
            which the interface will accept frames.

            A system is normally able to use any unicast address which
            corresponds to an entry in this table as a source address.
    */

    private IfRcvAddressEntry [] ifRcvAddressTable;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.4", oidName = "ifRcvAddressTable", fieldName = "ifRcvAddressTable")
    public
    @TableRow
    IfRcvAddressEntry [] getIfRcvAddressTable() {
        return ifRcvAddressTable;
    }

    private void setIfRcvAddressTable(IfRcvAddressEntry [] rows) {
        this.ifRcvAddressTable = rows;
    }

    /*
    * Property accessors for: ifTestTable
    * Table OID: 1.3.6.1.2.1.31.1.3
    * Row OID: 1.3.6.1.2.1.31.1.3.1
    * Access: not-accessible
    * Description: This table contains one entry per interface.  It defines
            objects which allow a network manager to instruct an agent
            to test an interface for various faults.  Tests for an
            interface are defined in the media-specific MIB for that
            interface.  After invoking a test, the object ifTestResult
            can be read to determine the outcome.  If an agent can not
            perform the test, ifTestResult is set to so indicate.  The
            object ifTestCode can be used to provide further test-
            specific or interface-specific (or even enterprise-specific)
            information concerning the outcome of the test.  Only one
            test can be in progress on each interface at any one time.
            If one test is in progress when another test is invoked, the
            second test is rejected.  Some agents may reject a test when
            a prior test is active on another interface.

            Before starting a test, a manager-station must first obtain
            'ownership' of the entry in the ifTestTable for the
            interface to be tested.  This is accomplished with the
            ifTestId and ifTestStatus objects as follows:

          try_again:
              get (ifTestId, ifTestStatus)
              while (ifTestStatus != notInUse)

                   * Loop while a test is running or some other
                   * manager is configuring a test.

                  short delay
                  get (ifTestId, ifTestStatus)
              }


               * Is not being used right now -- let's compete
               * to see who gets it.

              lock_value = ifTestId

              if ( set(ifTestId = lock_value, ifTestStatus = inUse,


                       ifTestOwner = 'my-IP-address') == FAILURE)

                   * Another manager got the ifTestEntry -- go
                   * try again

                  goto try_again;


               * I have the lock

              set up any test parameters.


               * This starts the test

              set(ifTestType = test_to_run);

              wait for test completion by polling ifTestResult

              when test completes, agent sets ifTestResult
                   agent also sets ifTestStatus = 'notInUse'

              retrieve any additional test results, and ifTestId

              if (ifTestId == lock_value+1) results are valid

            A manager station first retrieves the value of the
            appropriate ifTestId and ifTestStatus objects, periodically
            repeating the retrieval if necessary, until the value of
            ifTestStatus is 'notInUse'.  The manager station then tries
            to set the same ifTestId object to the value it just
            retrieved, the same ifTestStatus object to 'inUse', and the
            corresponding ifTestOwner object to a value indicating
            itself.  If the set operation succeeds then the manager has
            obtained ownership of the ifTestEntry, and the value of the
            ifTestId object is incremented by the agent (per the
            semantics of TestAndIncr).  Failure of the set operation
            indicates that some other manager has obtained ownership of
            the ifTestEntry.

            Once ownership is obtained, any test parameters can be
            setup, and then the test is initiated by setting ifTestType.
            On completion of the test, the agent sets ifTestStatus to
            'notInUse'.  Once this occurs, the manager can retrieve the
            results.  In the (rare) event that the invocation of tests
            by two network managers were to overlap, then there would be
            a possibility that the first test's results might be
            overwritten by the second test's results prior to the first


            results being read.  This unlikely circumstance can be
            detected by a network manager retrieving ifTestId at the
            same time as retrieving the test results, and ensuring that
            the results are for the desired request.

            If ifTestType is not set within an abnormally long period of
            time after ownership is obtained, the agent should time-out
            the manager, and reset the value of the ifTestStatus object
            back to 'notInUse'.  It is suggested that this time-out
            period be 5 minutes.

            In general, a management station must not retransmit a
            request to invoke a test for which it does not receive a
            response; instead, it properly inspects an agent's MIB to
            determine if the invocation was successful.  Only if the
            invocation was unsuccessful, is the invocation request
            retransmitted.

            Some tests may require the interface to be taken off-line in
            order to execute them, or may even require the agent to
            reboot after completion of the test.  In these
            circumstances, communication with the management station
            invoking the test may be lost until after completion of the
            test.  An agent is not required to support such tests.
            However, if such tests are supported, then the agent should
            make every effort to transmit a response to the request
            which invoked the test prior to losing communication.  When
            the agent is restored to normal service, the results of the
            test are properly made available in the appropriate objects.
            Note that this requires that the ifIndex value assigned to
            an interface must be unchanged even if the test causes a
            reboot.  An agent must reject any test for which it cannot,
            perhaps due to resource constraints, make available at least
            the minimum amount of information after that test
            completes.
    */

    private IfTestEntry [] ifTestTable;

    @OidProperty(oid = "1.3.6.1.2.1.31.1.3", oidName = "ifTestTable", fieldName = "ifTestTable")
    public
    @TableRow
    IfTestEntry [] getIfTestTable() {
        return ifTestTable;
    }

    private void setIfTestTable(IfTestEntry [] rows) {
        this.ifTestTable = rows;
    }
}
