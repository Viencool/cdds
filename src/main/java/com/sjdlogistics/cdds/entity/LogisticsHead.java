package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class LogisticsHead {

    private String guid;

    private String appType;

    private String appTime;

    private String appStatus;

    private String logisticsCode;

    private String logisticsName;

    private String logisticsNo;

    private String billNo;

    private BigDecimal freight;

    private BigDecimal insuredFee;

    private String currency;

    private BigDecimal weight;

    private Integer packNo;

    private String goodsInfo;

    private String consignee;

    private String consigneeAddress;

    private String consigneeTelephone;

    private String note;

    public LogisticsHead() {
    }

    public LogisticsHead(String guid, String appType, String appTime, String appStatus, String logisticsCode, String logisticsName, String logisticsNo, String billNo, BigDecimal freight, BigDecimal insuredFee, String currency, BigDecimal weight, Integer packNo, String goodsInfo, String consignee, String consigneeAddress, String consigneeTelephone, String note) {
        this.guid = guid;
        this.appType = appType;
        this.appTime = appTime;
        this.appStatus = appStatus;
        this.logisticsCode = logisticsCode;
        this.logisticsName = logisticsName;
        this.logisticsNo = logisticsNo;
        this.billNo = billNo;
        this.freight = freight;
        this.insuredFee = insuredFee;
        this.currency = currency;
        this.weight = weight;
        this.packNo = packNo;
        this.goodsInfo = goodsInfo;
        this.consignee = consignee;
        this.consigneeAddress = consigneeAddress;
        this.consigneeTelephone = consigneeTelephone;
        this.note = note;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getInsuredFee() {
        return insuredFee;
    }

    public void setInsuredFee(BigDecimal insuredFee) {
        this.insuredFee = insuredFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPackNo() {
        return packNo;
    }

    public void setPackNo(Integer packNo) {
        this.packNo = packNo;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneeTelephone() {
        return consigneeTelephone;
    }

    public void setConsigneeTelephone(String consigneeTelephone) {
        this.consigneeTelephone = consigneeTelephone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
