package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CdtTrfTxInf {
    @XmlElement(name = "PmtId")
    private PmtId pmtId;
    @XmlElement(name = "Amt")
    private Amt amt;
    @XmlElement(name = "CdtrAgt")
    private CdtrAgt cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    private CdtrAgtAcct cdtrAgtAcct;
    @XmlElement(name = "Cdtr")
    private Cdtr cdtr;

    public PmtId getPmtId() {
        return pmtId;
    }

    public void setPmtId(PmtId pmtId) {
        this.pmtId = pmtId;
    }

    public Amt getAmt() {
        return amt;
    }

    public void setAmt(Amt amt) {
        this.amt = amt;
    }

    public CdtrAgt getCdtrAgt() {
        return cdtrAgt;
    }

    public void setCdtrAgt(CdtrAgt cdtrAgt) {
        this.cdtrAgt = cdtrAgt;
    }

    public CdtrAgtAcct getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    public void setCdtrAgtAcct(CdtrAgtAcct cdtrAgtAcct) {
        this.cdtrAgtAcct = cdtrAgtAcct;
    }

    public Cdtr getCdtr() {
        return cdtr;
    }

    public void setCdtr(Cdtr cdtr) {
        this.cdtr = cdtr;
    }

    @Override
    public String toString() {
        return "CdtTrfTxInf{" +
                "pmtId=" + pmtId +
                ", amt=" + amt +
                ", cdtrAgt=" + cdtrAgt +
                ", cdtrAgtAcct=" + cdtrAgtAcct +
                ", cdtr=" + cdtr +
                '}';
    }
}
