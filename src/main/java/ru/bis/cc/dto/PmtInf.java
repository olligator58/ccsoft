package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.NONE)
public class PmtInf {
    @XmlElement(name = "PmtInfId")
    private String pmtInfId;
    @XmlElement(name = "PmtMtd")
    private String pmtMtd = "TRF";
    @XmlElement(name = "NbOfTxs")
    private String nbOfTxs = "1";
    @XmlElement(name = "PmtTpInf")
    private PmtTpInf pmtTpInf;
    @XmlElement(name = "ReqdExctnDt")
    private String reqdExctnDt;
    @XmlElement(name = "Dbtr")
    private Dbtr dbtr;
    @XmlElement(name = "DbtrAcct")
    private DbtrAcct dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    private DbtrAgt dbtrAgt;

    public String getPmtInfId() {
        return pmtInfId;
    }

    public void setPmtInfId(String pmtInfId) {
        this.pmtInfId = pmtInfId;
    }

    public String getPmtMtd() {
        return pmtMtd;
    }

    public void setPmtMtd(String pmtMtd) {
        this.pmtMtd = pmtMtd;
    }

    public String getNbOfTxs() {
        return nbOfTxs;
    }

    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    public PmtTpInf getPmtTpInf() {
        return pmtTpInf;
    }

    public String getReqdExctnDt() {
        return reqdExctnDt;
    }

    public void setReqdExctnDt(LocalDate reqdExctnDt) {
        this.reqdExctnDt = reqdExctnDt.toString();
    }

    public Dbtr getDbtr() {
        return dbtr;
    }

    public DbtrAcct getDbtrAcct() {
        return dbtrAcct;
    }

    public void setPmtTpInf(PmtTpInf pmtTpInf) {
        this.pmtTpInf = pmtTpInf;
    }

    public void setDbtr(Dbtr dbtr) {
        this.dbtr = dbtr;
    }

    public void setDbtrAcct(DbtrAcct dbtrAcct) {
        this.dbtrAcct = dbtrAcct;
    }

    public DbtrAgt getDbtrAgt() {
        return dbtrAgt;
    }

    public void setDbtrAgt(DbtrAgt dbtrAgt) {
        this.dbtrAgt = dbtrAgt;
    }

    @Override
    public String toString() {
        return "PmtInf{" +
                "pmtInfId='" + pmtInfId + '\'' +
                ", pmtMtd='" + pmtMtd + '\'' +
                ", nbOfTxs='" + nbOfTxs + '\'' +
                ", pmtTpInf=" + pmtTpInf +
                ", reqdExctnDt='" + reqdExctnDt + '\'' +
                ", dbtr=" + dbtr +
                ", dbtrAcct=" + dbtrAcct +
                ", dbtrAgt=" + dbtrAgt +
                '}';
    }
}
