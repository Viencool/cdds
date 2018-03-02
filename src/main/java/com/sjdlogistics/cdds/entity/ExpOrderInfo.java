package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpOrderInfo implements Serializable {

    private String orderNo;

    private String payTime;

    private Integer goodsNum;

    private String currency;

    private BigDecimal rate;

    private BigDecimal orderTotalAmount;

    private String consignee;

    private String consigneeCountry;

    private String consigneeAddress;

    private String consigneeTel;

    private String consigneeEmail;

    private String ebpCode;

    private String ebpName;

    private static final long serialVersionUID = 1L;

    public ExpOrderInfo() {
    }

    public ExpOrderInfo(String orderNo, String payTime, Integer goodsNum, String currency, BigDecimal rate, BigDecimal orderTotalAmount, String consignee, String consigneeCountry, String consigneeAddress, String consigneeTel, String consigneeEmail, String ebpCode, String ebpName) {
        this.orderNo = orderNo;
        this.payTime = payTime;
        this.goodsNum = goodsNum;
        this.currency = currency;
        this.rate = rate;
        this.orderTotalAmount = orderTotalAmount;
        this.consignee = consignee;
        this.consigneeCountry = consigneeCountry;
        this.consigneeAddress = consigneeAddress;
        this.consigneeTel = consigneeTel;
        this.consigneeEmail = consigneeEmail;
        this.ebpCode = ebpCode;
        this.ebpName = ebpName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneeCountry() {
        return consigneeCountry;
    }

    public void setConsigneeCountry(String consigneeCountry) {
        this.consigneeCountry = consigneeCountry;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public String getConsigneeEmail() {
        return consigneeEmail;
    }

    public void setConsigneeEmail(String consigneeEmail) {
        this.consigneeEmail = consigneeEmail;
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
}