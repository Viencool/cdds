package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpInvtReturn {
    private String guid;

    private String customsCode;

    private String agentCode;

    private String invtNo;

    private String ebpCode;

    private String ebcCode;

    private String preNo;

    private String returnStatus;

    private String returnTime;

    private String returnInfo;

    public ExpInvtReturn() {
    }

    public ExpInvtReturn(String guid, String customsCode, String agentCode, String invtNo, String ebpCode, String ebcCode, String preNo, String returnStatus, String returnTime, String returnInfo) {
        this.guid = guid;
        this.customsCode = customsCode;
        this.agentCode = agentCode;
        this.invtNo = invtNo;
        this.ebpCode = ebpCode;
        this.ebcCode = ebcCode;
        this.preNo = preNo;
        this.returnStatus = returnStatus;
        this.returnTime = returnTime;
        this.returnInfo = returnInfo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getInvtNo() {
        return invtNo;
    }

    public void setInvtNo(String invtNo) {
        this.invtNo = invtNo;
    }

    public String getEbpCode() {
        return ebpCode;
    }

    public void setEbpCode(String ebpCode) {
        this.ebpCode = ebpCode;
    }

    public String getEbcCode() {
        return ebcCode;
    }

    public void setEbcCode(String ebcCode) {
        this.ebcCode = ebcCode;
    }

    public String getPreNo() {
        return preNo;
    }

    public void setPreNo(String preNo) {
        this.preNo = preNo;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }
}
