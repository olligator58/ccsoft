package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
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

    public SvcLvl getSvcLvl() {
        return svcLvl;
    }

    public CtgyPurp getCtgyPurp() {
        return ctgyPurp;
    }

    @Override
    public String toString() {
        return "PmtTpInf{" +
                "svcLvl=" + svcLvl +
                ", ctgyPurp=" + ctgyPurp +
                '}';
    }
}


