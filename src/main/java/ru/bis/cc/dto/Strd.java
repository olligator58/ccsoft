package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Strd {
    @XmlElement(name = "CdtrRefInf")
    private CdtrRefInf cdtrRefInf;

    public CdtrRefInf getCdtrRefInf() {
        return cdtrRefInf;
    }

    public void setCdtrRefInf(CdtrRefInf cdtrRefInf) {
        this.cdtrRefInf = cdtrRefInf;
    }

    @Override
    public String toString() {
        return "Strd{" +
                "cdtrRefInf=" + cdtrRefInf +
                '}';
    }
}
