package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class PmtTpInf {
    @XmlElement(name = "SvcLvl")
    private SvcLvl svcLvl;
    @XmlElement(name = "CtgyPurp")
    private CtgyPurp ctgyPurp;

    public void setSvcLvl(SvcLvl svcLvl) {
        this.svcLvl = svcLvl;
    }

    public void setCtgyPurp(CtgyPurp ctgyPurp) {
        this.ctgyPurp = ctgyPurp;
    }
}


