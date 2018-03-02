package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryList {
    private Short gnum;

    private String itemRecordNo;

    private String itemNo;

    private String itemName;

    private String gcode;

    private String gname;

    private String gmodel;

    private String barCode;

    private String country;

    private String currency;

    private BigDecimal qty;

    private BigDecimal qty1;

    private BigDecimal qty2;

    private String unit;

    private String unit1;

    private String unit2;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private String note;

    @XmlTransient
    private String orderNo;

    public InventoryList() {

    }

    public InventoryList(Short gnum, String itemRecordNo, String itemNo, String itemName, String gcode, String gname, String gmodel, String barCode, String country, String currency, BigDecimal qty, BigDecimal qty1, BigDecimal qty2, String unit, String unit1, String unit2, BigDecimal price, BigDecimal totalPrice, String note, String orderNo) {
        this.gnum = gnum;
        this.itemRecordNo = itemRecordNo;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.gcode = gcode;
        this.gname = gname;
        this.gmodel = gmodel;
        this.barCode = barCode;
        this.country = country;
        this.currency = currency;
        this.qty = qty;
        this.qty1 = qty1;
        this.qty2 = qty2;
        this.unit = unit;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.price = price;
        this.totalPrice = totalPrice;
        this.note = note;
        this.orderNo = orderNo;
    }

    public Short getGnum() {
        return gnum;
    }

    public void setGnum(Short gnum) {
        this.gnum = gnum;
    }

    public String getItemRecordNo() {
        return itemRecordNo;
    }

    public void setItemRecordNo(String itemRecordNo) {
        this.itemRecordNo = itemRecordNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGmodel() {
        return gmodel;
    }

    public void setGmodel(String gmodel) {
        this.gmodel = gmodel;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getQty1() {
        return qty1;
    }

    public void setQty1(BigDecimal qty1) {
        this.qty1 = qty1;
    }

    public BigDecimal getQty2() {
        return qty2;
    }

    public void setQty2(BigDecimal qty2) {
        this.qty2 = qty2;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}


