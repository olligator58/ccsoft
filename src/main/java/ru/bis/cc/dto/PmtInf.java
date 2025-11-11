package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

import java.time.LocalDate;

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

    public PmtInf(String pmtInfId, LocalDate date) {
        this.pmtInfId = pmtInfId;
        this.reqdExctnDt = date.toString();
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
}
