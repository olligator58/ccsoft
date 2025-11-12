package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class CtgyPurp {
    @XmlElement(name = "Cd")
    private String cd;

    public String getCd() {
        return cd;
    }

    public void setCd(boolean isTax) {
        this.cd = (isTax) ? "TAXS" : "SUPP";
    }

    @Override
    public String toString() {
        return "CtgyPurp{" +
                "cd='" + cd + '\'' +
                '}';
    }
}
