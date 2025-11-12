package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class DbtrAcct {
    @XmlElement(name = "Id")
    private Id id;
    @XmlElement(name = "Ccy")
    private String ccy = "RUR";

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @Override
    public String toString() {
        return "DbtrAcct{" +
                "id=" + id +
                ", ccy='" + ccy + '\'' +
                '}';
    }
}
