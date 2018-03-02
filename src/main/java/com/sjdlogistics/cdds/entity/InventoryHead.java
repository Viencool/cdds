package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryHead implements Serializable {
    private String guid;

    private String appType;

    private String appTime;

    private String appStatus;

    private String orderNo;

    private String ebpCode;

    private String ebpName;

    private String ebcCode;

    private String ebcName;

    private String logisticsNo;

    private String logisticsCode;

    private String logisticsName;

    private String copNo;

    private String preNo;

    private String assureCode;

    private String emsNo;

    private String invtNo;

    private String ieFlag;

    private String declTime;

    private String customsCode;

    private String portCode;

    private String ieDate;

    private String buyerIdType;

    private String buyerIdNumber;

    private String buyerName;

    private String buyerTelephone;

    private String consigneeAddress;

    private String agentCode;

    private String agentName;

    private String areaCode;

    private String areaName;

    private String tradeMode;

    private String trafMode;

    private String trafNo;

    private String voyageNo;

    private String billNo;

    private String loctNo;

    private String licenseNo;

    private String country;

    private BigDecimal freight;

    private BigDecimal insuredFee;

    private String currency;

    private String wrapType;

    private Integer packNo;

    private BigDecimal grossWeight;

    private BigDecimal netWeight;

    private String note;

    private static final long serialVersionUID = 1L;

    public InventoryHead() {
    }

    public InventoryHead(String guid, String appType, String appTime, String appStatus, String orderNo, String ebpCode, String ebpName, String ebcCode, String ebcName, String logisticsNo, String logisticsCode, String logisticsName, String copNo, String preNo, String assureCode, String emsNo, String invtNo, String ieFlag, String declTime, String customsCode, String portCode, String ieDate, String buyerIdType, String buyerIdNumber, String buyerName, String buyerTelephone, String consigneeAddress, String agentCode, String agentName, String areaCode, String areaName, String tradeMode, String trafMode, String trafNo, String voyageNo, String billNo, String loctNo, String licenseNo, String country, BigDecimal freight, BigDecimal insuredFee, String currency, String wrapType, Integer packNo, BigDecimal grossWeight, BigDecimal netWeight, String note) {
        this.guid = guid;
        this.appType = appType;
        this.appTime = appTime;
        this.appStatus = appStatus;
        this.orderNo = orderNo;
        this.ebpCode = ebpCode;
        this.ebpName = ebpName;
        this.ebcCode = ebcCode;
        this.ebcName = ebcName;
        this.logisticsNo = logisticsNo;
        this.logisticsCode = logisticsCode;
        this.logisticsName = logisticsName;
        this.copNo = copNo;
        this.preNo = preNo;
        this.assureCode = assureCode;
        this.emsNo = emsNo;
        this.invtNo = invtNo;
        this.ieFlag = ieFlag;
        this.declTime = declTime;
        this.customsCode = customsCode;
        this.portCode = portCode;
        this.ieDate = ieDate;
        this.buyerIdType = buyerIdType;
        this.buyerIdNumber = buyerIdNumber;
        this.buyerName = buyerName;
        this.buyerTelephone = buyerTelephone;
        this.consigneeAddress = consigneeAddress;
        this.agentCode = agentCode;
        this.agentName = agentName;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.tradeMode = tradeMode;
        this.trafMode = trafMode;
        this.trafNo = trafNo;
        this.voyageNo = voyageNo;
        this.billNo = billNo;
        this.loctNo = loctNo;
        this.licenseNo = licenseNo;
        this.country = country;
        this.freight = freight;
        this.insuredFee = insuredFee;
        this.currency = currency;
        this.wrapType = wrapType;
        this.packNo = packNo;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEbpCode() {
        return ebpCode;
    }

    public void setEbpCode(String ebpCode) {
        this.ebpCode = ebpCode;
    }

    public String getEbpName() {
        return ebpName;
    }

    public void setEbpName(String ebpName) {
        this.ebpName = ebpName;
    }

    public String getEbcCode() {
        return ebcCode;
    }

    public void setEbcCode(String ebcCode) {
        this.ebcCode = ebcCode;
    }

    public String getEbcName() {
        return ebcName;
    }

    public void setEbcName(String ebcName) {
        this.ebcName = ebcName;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
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

    public String getAssureCode() {
        return assureCode;
    }

    public void setAssureCode(String assureCode) {
        this.assureCode = assureCode;
    }

    public String getEmsNo() {
        return emsNo;
    }

    public void setEmsNo(String emsNo) {
        this.emsNo = emsNo;
    }

    public String getInvtNo() {
        return invtNo;
    }

    public void setInvtNo(String invtNo) {
        this.invtNo = invtNo;
    }

    public String getIeFlag() {
        return ieFlag;
    }

    public void setIeFlag(String ieFlag) {
        this.ieFlag = ieFlag;
    }

    public String getDeclTime() {
        return declTime;
    }

    public void setDeclTime(String declTime) {
        this.declTime = declTime;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getIeDate() {
        return ieDate;
    }

    public void setIeDate(String ieDate) {
        this.ieDate = ieDate;
    }

    public String getBuyerIdType() {
        return buyerIdType;
    }

    public void setBuyerIdType(String buyerIdType) {
        this.buyerIdType = buyerIdType;
    }

    public String getBuyerIdNumber() {
        return buyerIdNumber;
    }

    public void setBuyerIdNumber(String buyerIdNumber) {
        this.buyerIdNumber = buyerIdNumber;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
    }

    public String getTrafMode() {
        return trafMode;
    }

    public void setTrafMode(String trafMode) {
        this.trafMode = trafMode;
    }

    public String getTrafNo() {
        return trafNo;
    }

    public void setTrafNo(String trafNo) {
        this.trafNo = trafNo;
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public void setVoyageNo(String voyageNo) {
        this.voyageNo = voyageNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getLoctNo() {
        return loctNo;
    }

    public void setLoctNo(String loctNo) {
        this.loctNo = loctNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getWrapType() {
        return wrapType;
    }

    public void setWrapType(String wrapType) {
        this.wrapType = wrapType;
    }

    public Integer getPackNo() {
        return packNo;
    }

    public void setPackNo(Integer packNo) {
        this.packNo = packNo;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}