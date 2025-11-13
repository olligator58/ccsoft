package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Tax {
    @XmlElement(name = "Cdtr")
    private TaxCdtr taxCdtr;
    @XmlElement(name = "Dbtr")
    private TaxDbtr taxDbtr;
    @XmlElement(name = "AdmstnZn")
    private String admstnZn;
    @XmlElement(name = "RefNb")
    private String refNb;
    @XmlElement(name = "Dt")
    private String dt;

    public TaxCdtr getTaxCdtr() {
        return taxCdtr;
    }

    public void setTaxCdtr(TaxCdtr taxCdtr) {
        this.taxCdtr = taxCdtr;
    }

    public TaxDbtr getTaxDbtr() {
        return taxDbtr;
    }

    public void setTaxDbtr(TaxDbtr taxDbtr) {
        this.taxDbtr = taxDbtr;
    }

    public String getAdmstnZn() {
        return admstnZn;
    }

    public void setAdmstnZn(String admstnZn) {
        this.admstnZn = admstnZn;
    }

    public String getRefNb() {
        return refNb;
    }

    public void setRefNb(String refNb) {
        this.refNb = refNb;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxCdtr=" + taxCdtr +
                ", taxDbtr=" + taxDbtr +
                ", admstnZn='" + admstnZn + '\'' +
                ", refNb='" + refNb + '\'' +
                ", dt='" + dt + '\'' +
                '}';
    }
}
