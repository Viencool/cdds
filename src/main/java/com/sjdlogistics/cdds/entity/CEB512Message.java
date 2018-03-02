package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://www.chinaport.gov.cn/ceb" ,name="CEB512Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class CEB512Message {

    @XmlElement(name="LogisticsReturn")
    private LogisticsReturn logisticsReturn;

    public CEB512Message() {
    }

    public CEB512Message(LogisticsReturn logisticsReturn) {
        this.logisticsReturn = logisticsReturn;
    }

    public LogisticsReturn getLogisticsReturn() {
        return logisticsReturn;
    }

    public void setLogisticsReturn(LogisticsReturn logisticsReturn) {
        this.logisticsReturn = logisticsReturn;
    }
}
