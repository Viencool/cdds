package com.sjdlogistics.cdds.entity;
import javax.xml.bind.annotation.*;

@XmlRootElement(namespace="http://www.chinaport.gov.cn/ceb" ,name="CebExpInvtMessage")
@XmlAccessorType(XmlAccessType.FIELD)

public class CebExpInvtMessage {

    @XmlElement(name="ExpInvt")
    private ExpInvt expInvt;

    @XmlElement(name="BaseTransfer")
    private BaseTransfer baseTransfer;

    public CebExpInvtMessage() {
    }

    public CebExpInvtMessage(ExpInvt expInvt, BaseTransfer baseTransfer) {
        this.expInvt = expInvt;
        this.baseTransfer = baseTransfer;
    }

    public BaseTransfer getBaseTransfer() {
        return baseTransfer;
    }

    public ExpInvt getExpInvt() {
        return expInvt;
    }

    public void setBaseTransfer(BaseTransfer baseTransfer) {
        this.baseTransfer = baseTransfer;
    }

    public void setExpInvt(ExpInvt expInvt) {
        this.expInvt = expInvt;
    }
}
