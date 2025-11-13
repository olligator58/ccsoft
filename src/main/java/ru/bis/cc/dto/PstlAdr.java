package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class PstlAdr {
    @XmlElement(name = "Ctry")
    private String ctry = "RU";

    public String getCtry() {
        return ctry;
    }

    public void setCtry(String ctry) {
        this.ctry = ctry;
    }

    @Override
    public String toString() {
        return "PstlAdr{" +
                "ctry='" + ctry + '\'' +
                '}';
    }
}
