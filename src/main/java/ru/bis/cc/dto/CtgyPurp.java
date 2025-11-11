package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class CtgyPurp {
    @XmlElement(name = "Cd")
    private String cd;

    public CtgyPurp(boolean isTax) {
        this.cd = (isTax) ? "TAXS" : "SUPP";
    }
}
