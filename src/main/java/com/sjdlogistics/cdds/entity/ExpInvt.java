package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpInvt {

    @XmlElement(name="ExpOrderInfo")
    private ExpOrderInfo expOrderInfo;

    @XmlElement(name="ExpInventory")
    private ExpInventory expInventory;


    public ExpInvt(ExpOrderInfo expOrderInfo, ExpInventory expInventory) {
        this.expOrderInfo = expOrderInfo;
        this.expInventory = expInventory;
    }

    public ExpOrderInfo getExpOrderInfo() {
        return expOrderInfo;
    }

    public void setExpOrderInfo(ExpOrderInfo expOrderInfo) {
        this.expOrderInfo = expOrderInfo;
    }

    public ExpInventory getExpInventory() {
        return expInventory;
    }

    public void setExpInventory(ExpInventory expInventory) {
        this.expInventory = expInventory;
    }
}
