package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Logistics {

    @XmlElement(name="LogisticsHead")
    private LogisticsHead logisticsHead;

    public Logistics() {
    }

    public LogisticsHead getLogisticsHead() {
        return logisticsHead;
    }

    public void setLogisticsHead(LogisticsHead logisticsHead) {
        this.logisticsHead = logisticsHead;
    }

    public Logistics(LogisticsHead logisticsHead) {

        this.logisticsHead = logisticsHead;
    }
}
