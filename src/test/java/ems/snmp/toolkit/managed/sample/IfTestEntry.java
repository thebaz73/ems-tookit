package ems.snmp.toolkit.managed.sample;

import ems.snmp.toolkit.domain.EmsEnum;
import ems.snmp.toolkit.managed.annotation.OidBind;

/**
* Created by EMS Mib Compiler.
* Do not edit
*/
@OidBind(oid = "1.3.6.1.2.1.31.1.3.1")
public class IfTestEntry {


    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.1")
    private Integer ifTestId;

    public Integer getIfTestId() {
        return ifTestId;
    }

    private void setIfTestId(Integer ifTestId) {
        this.ifTestId = ifTestId;
    }

    enum IF_TEST_STATUS implements EmsEnum<Integer> {
        NOT_IN_USE (1),
        IN_USE (2);

        private Integer value;

        private IF_TEST_STATUS(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.2")
    private IF_TEST_STATUS ifTestStatus;

    public IF_TEST_STATUS getIfTestStatus() {
        return ifTestStatus;
    }

    private void setIfTestStatus(IF_TEST_STATUS ifTestStatus) {
        this.ifTestStatus = ifTestStatus;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.3")
    private Object ifTestType;

    public Object getIfTestType() {
        return ifTestType;
    }

    private void setIfTestType(Object ifTestType) {
        this.ifTestType = ifTestType;
    }

    enum IF_TEST_RESULT implements EmsEnum<Integer> {
        NONE (1),
        SUCCESS (2),
        IN_PROGRESS (3),
        NOT_SUPPORTED (4),
        UN_ABLE_TO_RUN (5),
        ABORTED (6),
        FAILED (7);

        private Integer value;

        private IF_TEST_RESULT(Integer i) {
        value = i;
        }

        public String toString() {
        return String.valueOf(value);
        }

        public Integer getValue() {
        return value;
        }
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.4")
    private IF_TEST_RESULT ifTestResult;

    public IF_TEST_RESULT getIfTestResult() {
        return ifTestResult;
    }

    private void setIfTestResult(IF_TEST_RESULT ifTestResult) {
        this.ifTestResult = ifTestResult;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.5")
    private Object ifTestCode;

    public Object getIfTestCode() {
        return ifTestCode;
    }

    private void setIfTestCode(Object ifTestCode) {
        this.ifTestCode = ifTestCode;
    }

    @OidBind(oid = "1.3.6.1.2.1.31.1.3.1.6")
    private String ifTestOwner;

    public String getIfTestOwner() {
        return ifTestOwner;
    }

    private void setIfTestOwner(String ifTestOwner) {
        this.ifTestOwner = ifTestOwner;
    }
}
