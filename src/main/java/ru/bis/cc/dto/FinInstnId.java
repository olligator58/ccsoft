package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class FinInstnId {
    @XmlElement(name = "ClrSysMmbId")
    private ClrSysMmbId clrSysMmbId;
    @XmlElement(name = "Nm")
    private String nm;
    @XmlElement(name = "PstlAdr")
    private PstlAdr pstlAdr;

    public ClrSysMmbId getClrSysMmbId() {
        return clrSysMmbId;
    }

    public void setClrSysMmbId(ClrSysMmbId clrSysMmbId) {
        this.clrSysMmbId = clrSysMmbId;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String payerBankName) {
        this.nm = payerBankName;;
    }

    public PstlAdr getPstlAdr() {
        return pstlAdr;
    }

    public void setPstlAdr(PstlAdr pstlAdr) {
        this.pstlAdr = pstlAdr;
    }

    @Override
    public String toString() {
        return "FinInstnId{" +
                "clrSysMmbId=" + clrSysMmbId +
                ", nm='" + nm + '\'' +
                ", pstlAdr=" + pstlAdr +
                '}';
    }
}
