package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class RgltryRptg {
    @XmlElement(name = "Dtls")
    private Dtls dtls;

    public Dtls getDtls() {
        return dtls;
    }

    public void setDtls(Dtls dtls) {
        this.dtls = dtls;
    }

    @Override
    public String toString() {
        return "RgltryRptg{" +
                "dtls=" + dtls +
                '}';
    }
}
