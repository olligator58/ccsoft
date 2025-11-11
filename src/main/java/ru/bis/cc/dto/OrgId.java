package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class OrgId {
    @XmlElement(name = "Othr")
    private Othr othr;

    public void setOthr(Othr othr) {
        this.othr = othr;
    }
}
