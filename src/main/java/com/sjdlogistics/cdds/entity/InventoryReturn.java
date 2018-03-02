package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryReturn {

    private String guid;

    private String customsCode;

    private String ebpCode;

    private String ebcCode;

    private String agentCode;

    private String copNo;

    private String preNo;

    private String invtNo;

    private String returnStatus;

    private String returnTime;

    private String returnInfo;

    public InventoryReturn() {
    }

    public InventoryReturn(String guid, String customsCode, String ebpCode, String ebcCode, String agentCode, String copNo, String preNo, String invtNo, String returnStatus, String returnTime, String returnInfo) {
        this.guid = guid;
        this.customsCode = customsCode;
        this.ebpCode = ebpCode;
        this.ebcCode = ebcCode;
        this.agentCode = agentCode;
        this.copNo = copNo;
        this.preNo = preNo;
        this.invtNo = invtNo;
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

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo;
    }

    public String getPreNo() {
        return preNo;
    }

    public void setPreNo(String preNo) {
        this.preNo = preNo;
    }

    public String getInvtNo() {
        return invtNo;
    }

    public void setInvtNo(String invtNo) {
        this.invtNo = invtNo;
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
