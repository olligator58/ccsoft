package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Purp {
    @XmlElement(name = "Prtry")
    private String prtry;

    public String getPrtry() {
        return prtry;
    }

    public void setPrtry(String priority) {
        this.prtry = priority;
    }

    @Override
    public String toString() {
        return "Purp{" +
                "prtry='" + prtry + '\'' +
                '}';
    }
}
