package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class Othr {
    @XmlElement(name = "Id")
    private String id;

    public Othr(String id) {
        this.id = id;
    }
}
