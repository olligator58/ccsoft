package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Rcrd {
    @XmlElement(name = "Tp")
    private String tp;
    @XmlElement(name = "Ctgy")
    private String ctgy;
    @XmlElement(name = "CtgyDtls")
    private String ctgyDtls;
    @XmlElement(name = "DbtrSts")
    private String dbtrSts;
    @XmlElement(name = "Prd")
    private Prd prd;

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getCtgy() {
        return ctgy;
    }

    public void setCtgy(String ctgy) {
        this.ctgy = ctgy;
    }

    public String getCtgyDtls() {
        return ctgyDtls;
    }

    public void setCtgyDtls(String ctgyDtls) {
        this.ctgyDtls = ctgyDtls;
    }

    public String getDbtrSts() {
        return dbtrSts;
    }

    public void setDbtrSts(String dbtrSts) {
        this.dbtrSts = dbtrSts;
    }

    public Prd getPrd() {
        return prd;
    }

    public void setPrd(Prd prd) {
        this.prd = prd;
    }

    public boolean isRcrdToOutput() {
        return (tp != null || ctgy != null || ctgyDtls != null || dbtrSts != null || prd != null);
    }

    @Override
    public String toString() {
        return "Rcrd{" +
                "tp='" + tp + '\'' +
                ", ctgy='" + ctgy + '\'' +
                ", ctgyDtls='" + ctgyDtls + '\'' +
                ", dbtrSts='" + dbtrSts + '\'' +
                ", prd=" + prd +
                '}';
    }
}
