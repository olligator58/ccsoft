package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class FrToDt {
    @XmlElement(name = "FrDt")
    private String frDt;
    @XmlElement(name = "ToDt")
    private String toDt;

    public String getFrDt() {
        return frDt;
    }

    public void setFrDt(String frDt) {
        this.frDt = frDt;
    }

    public String getToDt() {
        return toDt;
    }

    public void setToDt(String toDt) {
        this.toDt = toDt;
    }

    @Override
    public String toString() {
        return "FrToDt{" +
                "frDt='" + frDt + '\'' +
                ", toDt='" + toDt + '\'' +
                '}';
    }
}
