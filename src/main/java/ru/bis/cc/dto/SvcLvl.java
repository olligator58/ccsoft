package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class SvcLvl {
    @XmlElement(name = "Cd")
    private String cd;

    public SvcLvl(boolean isUrgent) {
        this.cd = (isUrgent) ? "URGP" : "NURG";
    }
}
