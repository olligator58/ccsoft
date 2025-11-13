package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Amt {
    @XmlElement(name = "InstdAmt")
    private String instdAmt;
    @XmlAttribute(name = "Ccy")
    private String ccy;

    public String getInstdAmt() {
        return instdAmt;
    }

    public void setInstdAmt(String instdAmt) {
        this.instdAmt = instdAmt;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @Override
    public String toString() {
        return "Amt{" +
                "instdAmt='" + instdAmt + '\'' +
                ", ccy='" + ccy + '\'' +
                '}';
    }
}
