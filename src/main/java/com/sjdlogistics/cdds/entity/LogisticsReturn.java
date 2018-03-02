package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class LogisticsReturn {

    private String guid;

    private String logisticsCode;

    private String logisticsNo;

    private String returnStatus;

    private String returnTime;

    private String returnInfo;

    public LogisticsReturn() {
    }

    public LogisticsReturn(String guid, String logisticsCode, String logisticsNo, String returnStatus, String returnTime, String returnInfo) {
        this.guid = guid;
        this.logisticsCode = logisticsCode;
        this.logisticsNo = logisticsNo;
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

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
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
