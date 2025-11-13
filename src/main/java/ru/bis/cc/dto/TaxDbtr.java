package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class TaxDbtr {
    @XmlElement(name = "TaxTp")
    private String taxTp;

    public String getTaxTp() {
        return taxTp;
    }

    public void setTaxTp(String taxTp) {
        this.taxTp = taxTp;
    }

    @Override
    public String toString() {
        return "TaxDbtr{" +
                "taxTp='" + taxTp + '\'' +
                '}';
    }
}
