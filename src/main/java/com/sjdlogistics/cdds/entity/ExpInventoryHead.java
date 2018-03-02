package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpInventoryHead implements Serializable {
	private String orderNo;

	private String ebpCode;

	private String ebpName;

	private String ebcCode;

	private String ebcName;

	private String productCode;

	private String productName;

	private String logisticsCode;

	private String logisticsName;

	private String logisticsNo;

	private String emsNo;

	private String preNo;

	private String invtNo;

	private String ieFlag;

	private String declTime;

	private String customsCode;

	private String portCode;

	private String ieDate;

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

	private String packageNum;

	private String licenseNo;

	private String arrivedPort;

	private String country;

	private BigDecimal freight;

	private String feeCurrency;

	private String feeFlag;

	private BigDecimal insuredFee;

	private String inrCurrency;

	private String inrFlag;

	private String wrapType;

	private Integer packNo;

	private BigDecimal grossWeight;

	private BigDecimal netWeight;

	private String note;

	private static final long serialVersionUID = 1L;

	public ExpInventoryHead() {
	}

	public ExpInventoryHead(String orderNo, String ebpCode, String ebpName, String ebcCode, String ebcName, String productCode, String productName, String logisticsCode, String logisticsName, String logisticsNo, String emsNo, String preNo, String invtNo, String ieFlag, String declTime, String customsCode, String portCode, String ieDate, String agentCode, String agentName, String areaCode, String areaName, String tradeMode, String trafMode, String trafNo, String voyageNo, String billNo, String loctNo, String packageNum, String licenseNo, String arrivedPort, String country, BigDecimal freight, String feeCurrency, String feeFlag, BigDecimal insuredFee, String inrCurrency, String inrFlag, String wrapType, Integer packNo, BigDecimal grossWeight, BigDecimal netWeight, String note) {
		this.orderNo = orderNo;
		this.ebpCode = ebpCode;
		this.ebpName = ebpName;
		this.ebcCode = ebcCode;
		this.ebcName = ebcName;
		this.productCode = productCode;
		this.productName = productName;
		this.logisticsCode = logisticsCode;
		this.logisticsName = logisticsName;
		this.logisticsNo = logisticsNo;
		this.emsNo = emsNo;
		this.preNo = preNo;
		this.invtNo = invtNo;
		this.ieFlag = ieFlag;
		this.declTime = declTime;
		this.customsCode = customsCode;
		this.portCode = portCode;
		this.ieDate = ieDate;
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
		this.packageNum = packageNum;
		this.licenseNo = licenseNo;
		this.arrivedPort = arrivedPort;
		this.country = country;
		this.freight = freight;
		this.feeCurrency = feeCurrency;
		this.feeFlag = feeFlag;
		this.insuredFee = insuredFee;
		this.inrCurrency = inrCurrency;
		this.inrFlag = inrFlag;
		this.wrapType = wrapType;
		this.packNo = packNo;
		this.grossWeight = grossWeight;
		this.netWeight = netWeight;
		this.note = note;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getEmsNo() {
		return emsNo;
	}

	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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

	public String getPackageNum() {
		return packageNum;
	}

	public void setPackageNum(String packageNum) {
		this.packageNum = packageNum;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getArrivedPort() {
		return arrivedPort;
	}

	public void setArrivedPort(String arrivedPort) {
		this.arrivedPort = arrivedPort;
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

	public String getFeeCurrency() {
		return feeCurrency;
	}

	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}

	public String getFeeFlag() {
		return feeFlag;
	}

	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}

	public BigDecimal getInsuredFee() {
		return insuredFee;
	}

	public void setInsuredFee(BigDecimal insuredFee) {
		this.insuredFee = insuredFee;
	}

	public String getInrCurrency() {
		return inrCurrency;
	}

	public void setInrCurrency(String inrCurrency) {
		this.inrCurrency = inrCurrency;
	}

	public String getInrFlag() {
		return inrFlag;
	}

	public void setInrFlag(String inrFlag) {
		this.inrFlag = inrFlag;
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