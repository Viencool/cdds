package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpInventory {

    @XmlElement(name="ExpInventoryHead")
    private ExpInventoryHead expInventoryHead;

    @XmlElement(name="ExpInventoryList")
    private List<ExpInventoryList> expInventoryLists;

    public ExpInventory(ExpInventoryHead expInventoryHead, List<ExpInventoryList> expInventoryLists) {
        this.expInventoryHead = expInventoryHead;
        this.expInventoryLists = expInventoryLists;
    }

    public ExpInventoryHead getExpInventoryHead() {
        return expInventoryHead;
    }

    public void setExpInventoryHead(ExpInventoryHead expInventoryHead) {
        this.expInventoryHead = expInventoryHead;
    }

    public List<ExpInventoryList> getExpInventoryLists() {
        return expInventoryLists;
    }

    public void setExpInventoryLists(List<ExpInventoryList> expInventoryLists) {
        this.expInventoryLists = expInventoryLists;
    }
}
