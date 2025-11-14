package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Prd {
    @XmlElement(name = "Yr")
    private String yr;
    @XmlElement(name = "Tp")
    private String tp;
    @XmlElement(name = "FrToDt")
    private FrToDt frToDt;

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public FrToDt getFrToDt() {
        return frToDt;
    }

    public void setFrToDt(FrToDt frToDt) {
        this.frToDt = frToDt;
    }

    public boolean isPrdToOutput() {
        return (yr != null || tp != null || frToDt != null);
    }

    @Override
    public String toString() {
        return "Prd{" +
                "yr='" + yr + '\'' +
                ", tp='" + tp + '\'' +
                ", frToDt=" + frToDt +
                '}';
    }
}
