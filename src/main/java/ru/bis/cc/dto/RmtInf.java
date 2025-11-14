package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class RmtInf {
    @XmlElement(name = "Ustrd")
    private List<String> ustrd;
    @XmlElement(name = "Strd")
    private Strd strd;

    public List<String> getUstrd() {
        return ustrd;
    }

    public void setUstrd(List<String> ustrd) {
        this.ustrd = ustrd;
    }

    public Strd getStrd() {
        return strd;
    }

    public void setStrd(Strd strd) {
        this.strd = strd;
    }

    @Override
    public String toString() {
        return "RmtInf{" +
                "ustrd=" + ustrd +
                ", strd=" + strd +
                '}';
    }
}
