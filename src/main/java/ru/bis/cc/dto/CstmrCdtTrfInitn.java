package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class CstmrCdtTrfInitn {
    @XmlElement(name = "GrpHdr")
    private GrpHdr grpHdr;
    @XmlElement(name = "PmtInf")
    private PmtInf pmtInf;
    private String uuid = generateUuid();

    public GrpHdr getGrpHdr() {
        return grpHdr;
    }

    public void setGrpHdr(GrpHdr grpHdr) {
        this.grpHdr = grpHdr;
    }

    public PmtInf getPmtInf() {
        return pmtInf;
    }

    public void setPmtInf(PmtInf pmtInf) {
        this.pmtInf = pmtInf;
    }

    public String getUuid() {
        return uuid;
    }

    private String generateUuid() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public String toString() {
        return "CstmrCdtTrfInitn{" +
                "grpHdr=" + grpHdr +
                ", pmtInf=" + pmtInf +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
