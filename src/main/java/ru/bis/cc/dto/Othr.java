package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Othr {
    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "SchmeNm")
    private SchmeNm schmeNm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SchmeNm getSchmeNm() {
        return schmeNm;
    }

    public void setSchmeNm(SchmeNm schmeNm) {
        this.schmeNm = schmeNm;
    }

    @Override
    public String toString() {
        return "Othr{" +
                "id='" + id + '\'' +
                ", schmeNm=" + schmeNm +
                '}';
    }
}
