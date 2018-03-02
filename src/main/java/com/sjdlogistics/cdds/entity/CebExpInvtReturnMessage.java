package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.chinaport.gov.cn/ceb" ,name="CebExpInvtReturnMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class CebExpInvtReturnMessage {

    @XmlElement(name="ExpInvtReturn")
    private ExpInvtReturn expInvtReturn;

    public CebExpInvtReturnMessage(ExpInvtReturn expInvtReturn) {
        this.expInvtReturn = expInvtReturn;
    }

    public CebExpInvtReturnMessage() {
    }

    public ExpInvtReturn getExpInvtReturn() {
        return expInvtReturn;
    }

    public void setExpInvtReturn(ExpInvtReturn expInvtReturn) {
        this.expInvtReturn = expInvtReturn;
    }
}
