package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class CstmrCdtTrfInitn {
    @XmlElement(name = "GrpHdr")
    private GrpHdr grpHdr;
    @XmlElement(name = "PmtInf")
    private PmtInf pmtInf;
    private String uuid = generateUuid();

    public void setGrpHdr(GrpHdr grpHdr) {
        this.grpHdr = grpHdr;
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
}
