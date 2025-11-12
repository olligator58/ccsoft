package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Id {
    @XmlElement(name = "OrgId")
    private OrgId orgId;
    @XmlElement(name = "Othr")
    private Othr othr;

    public OrgId getOrgId() {
        return orgId;
    }

    public void setOrgId(OrgId orgId) {
        this.orgId = orgId;
    }

    public Othr getOthr() {
        return othr;
    }

    public void setOthr(Othr othr) {
        this.othr = othr;
    }

    @Override
    public String toString() {
        return "Id{" +
                "orgId=" + orgId +
                ", othr=" + othr +
                '}';
    }
}
