package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.NONE)
public class DocumentDto {
    @XmlElement(name = "CstmrCdtTrfInitn")
    private CstmrCdtTrfInitn cstmrCdtTrfInitn;
    @XmlAttribute
    private String xmlns = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03";

    public CstmrCdtTrfInitn getCstmrCdtTrfInitn() {
        return cstmrCdtTrfInitn;
    }

    public void setCstmrCdtTrfInitn(CstmrCdtTrfInitn cstmrCdtTrfInitn) {
        this.cstmrCdtTrfInitn = cstmrCdtTrfInitn;
    }

    @Override
    public String toString() {
        return "DocumentDto{" +
                "cstmrCdtTrfInitn=" + cstmrCdtTrfInitn +
                ", xmlns='" + xmlns + '\'' +
                '}';
    }
}
