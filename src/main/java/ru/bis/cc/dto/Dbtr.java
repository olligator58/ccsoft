package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class Dbtr {
    @XmlElement(name = "Nm")
    private String nm;
    @XmlElement(name = "Id")
    private Id id;

    public Dbtr(String payerName) {
        this.nm = payerName;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
