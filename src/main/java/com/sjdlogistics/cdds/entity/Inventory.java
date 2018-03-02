package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Inventory {

    @XmlElement(name="InventoryHead")
    private InventoryHead inventoryHead;

    @XmlElement(name="InventoryList")
    private List<InventoryList> inventoryLists = new ArrayList<InventoryList>();

    public Inventory() {
    }

    public Inventory(InventoryHead inventoryHead, List<InventoryList> inventoryLists) {
        this.inventoryHead = inventoryHead;
        this.inventoryLists = inventoryLists;
    }

    public InventoryHead getInventoryHead() {
        return inventoryHead;
    }

    public void setInventoryHead(InventoryHead inventoryHead) {
        this.inventoryHead = inventoryHead;
    }

    public List<InventoryList> getInventoryLists() {
        return inventoryLists;
    }

    public void setInventoryLists(List<InventoryList> inventoryLists) {
        this.inventoryLists = inventoryLists;
    }
}
