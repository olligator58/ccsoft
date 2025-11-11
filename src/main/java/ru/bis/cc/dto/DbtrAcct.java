package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class DbtrAcct {
    @XmlElement(name = "Id")
    private Id id;
    @XmlElement(name = "Ccy")
    private String ccy = "RUR";

    public void setId(Id id) {
        this.id = id;
    }
}
