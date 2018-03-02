package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.chinaport.gov.cn/ceb" ,name="CEB621Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class CEB621Message {

    @XmlElement(name="Inventory")
    private Inventory inventory;

    @XmlElement(name="BaseTransfer")
    private BaseTransfer baseTransfer;

    public CEB621Message() {
    }

    public CEB621Message(Inventory inventory, BaseTransfer baseTransfer) {
        this.inventory = inventory;
        this.baseTransfer = baseTransfer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public BaseTransfer getBaseTransfer() {
        return baseTransfer;
    }

    public void setBaseTransfer(BaseTransfer baseTransfer) {
        this.baseTransfer = baseTransfer;
    }
}
