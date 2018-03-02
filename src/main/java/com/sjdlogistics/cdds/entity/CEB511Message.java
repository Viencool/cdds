package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.chinaport.gov.cn/ceb", name = "CEB511Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class CEB511Message {

    @XmlElement(name = "Logistics")
    private Logistics logistics;

    @XmlElement(name = "BaseTransfer")
    private BaseTransfer baseTransfer;

    public CEB511Message(Logistics logistics, BaseTransfer baseTransfer) {
        this.logistics = logistics;
        this.baseTransfer = baseTransfer;
    }

    public CEB511Message() {

    }

    public Logistics getLogistics() {
        return logistics;
    }

    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
    }

    public BaseTransfer getBaseTransfer() {
        return baseTransfer;
    }

    public void setBaseTransfer(BaseTransfer baseTransfer) {
        this.baseTransfer = baseTransfer;
    }
}
