package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class SvcLvl {
    @XmlElement(name = "Cd")
    private String cd;

    public String getCd() {
        return cd;
    }

    public void setCd(boolean isUrgent) {
        this.cd = (isUrgent) ? "URGP" : "NURG";
    }

    @Override
    public String toString() {
        return "SvcLvl{" +
                "cd='" + cd + '\'' +
                '}';
    }
}
