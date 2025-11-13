package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class PmtId {
    @XmlElement(name = "InstrId")
    private String instrId;
    @XmlElement(name = "EndToEndId")
    private String endToEndId = "NOTPROVIDED";

    public String getInstrId() {
        return instrId;
    }

    public void setInstrId(String instrId) {
        this.instrId = instrId;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    @Override
    public String toString() {
        return "PmtId{" +
                "instrId='" + instrId + '\'' +
                ", endToEndId='" + endToEndId + '\'' +
                '}';
    }
}
