package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

public class Id {
    @XmlElement(name = "OrgId")
    private OrgId orgId;
    @XmlElement(name = "Othr")
    private Othr othr;

    public void setOrgId(OrgId orgId) {
        this.orgId = orgId;
    }

    public void setOthr(Othr othr) {
        this.othr = othr;
    }
}
