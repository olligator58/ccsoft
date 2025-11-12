package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Dbtr {
    @XmlElement(name = "Nm")
    private String nm;
    @XmlElement(name = "Id")
    private Id id;

    public String getNm() {
        return nm;
    }

    public void setNm(String payerName) {
        this.nm = payerName;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dbtr{" +
                "nm='" + nm + '\'' +
                ", id=" + id +
                '}';
    }
}
