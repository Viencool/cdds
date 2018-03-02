package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.chinaport.gov.cn/ceb" ,name="CEB622Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class CEB622Message {

    @XmlElement(name="InventoryReturn")
    private InventoryReturn inventoryReturn;

    public CEB622Message() {
    }

    public CEB622Message(InventoryReturn inventoryReturn) {
        this.inventoryReturn = inventoryReturn;
    }

    public InventoryReturn getInventoryReturn() {
        return inventoryReturn;
    }

    public void setInventoryReturn(InventoryReturn inventoryReturn) {
        this.inventoryReturn = inventoryReturn;
    }
}
