package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class TaxCdtr {
    @XmlElement(name = "RegnId")
    private String regnId;
    @XmlElement(name = "TaxTp")
    private String taxTp;

    public String getRegnId() {
        return regnId;
    }

    public void setRegnId(String regnId) {
        this.regnId = regnId;
    }

    public String getTaxTp() {
        return taxTp;
    }

    public void setTaxTp(String taxTp) {
        this.taxTp = taxTp;
    }

    @Override
    public String toString() {
        return "TaxCdtr{" +
                "regnId='" + regnId + '\'' +
                ", taxTp='" + taxTp + '\'' +
                '}';
    }
}
