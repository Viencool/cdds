package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseTransfer {

    private String copCode;

    private String copName;

    private String dxpMode;

    private String dxpId;

    private String note;

    public BaseTransfer() {
    }

    public BaseTransfer(String copCode, String copName, String dxpMode, String dxpId, String note) {
        this.copCode = copCode;
        this.copName = copName;
        this.dxpMode = dxpMode;
        this.dxpId = dxpId;
        this.note = note;
    }

    public String getCopCode() {
        return copCode;
    }

    public String getCopName() {
        return copName;
    }

    public String getDxpId() {
        return dxpId;
    }

    public String getDxpMode() {
        return dxpMode;
    }

    public String getNote() {
        return note;
    }

    public void setCopCode(String copCode) {
        this.copCode = copCode;
    }

    public void setCopName(String copName) {
        this.copName = copName;
    }

    public void setDxpId(String dxpId) {
        this.dxpId = dxpId;
    }

    public void setDxpMode(String dxpMode) {
        this.dxpMode = dxpMode;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
