package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.time.*;
import java.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.NONE)
public class GrpHdr {
    @XmlElement(name = "MsgId")
    private String msgId;
    @XmlElement(name = "CreDtTm")
    private String creDtTm;
    @XmlElement(name = "NbOfTxs")
    private String nbOfTxs = "1";
    @XmlElement(name = "InitgPty")
    private String initgPty = "";

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCreDtTm() {
        return creDtTm;
    }

    public void setCreDtTm(LocalDate date) {
        this.creDtTm = generateCreDtTm(date);
    }

    public String getNbOfTxs() {
        return nbOfTxs;
    }

    public void setNbOfTxs(String nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }

    public String getInitgPty() {
        return initgPty;
    }

    public void setInitgPty(String initgPty) {
        this.initgPty = initgPty;
    }

    private String generateCreDtTm(LocalDate date) {
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("GMT+3"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return zonedDateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "GrpHdr{" +
                "msgId='" + msgId + '\'' +
                ", creDtTm='" + creDtTm + '\'' +
                ", nbOfTxs='" + nbOfTxs + '\'' +
                ", initgPty='" + initgPty + '\'' +
                '}';
    }
}
