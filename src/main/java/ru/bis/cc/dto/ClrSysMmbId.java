package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class ClrSysMmbId {
    @XmlElement(name = "MmbId")
    private String mmbId;

    public String getMmbId() {
        return mmbId;
    }

    public void setMmbId(String payerBankBic) {
        this.mmbId = payerBankBic;
    }

    @Override
    public String toString() {
        return "ClrSysMmbId{" +
                "mmbId='" + mmbId + '\'' +
                '}';
    }
}
