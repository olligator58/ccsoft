package ru.bis.cc.dto;

import jakarta.xml.bind.annotation.XmlElement;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class GrpHdr {
    @XmlElement(name = "MsgId")
    private String msgId;
    @XmlElement(name = "CreDtTm")
    private String creDtTm;
    @XmlElement(name = "NbOfTxs")
    private String nbOfTxs = "1";
    @XmlElement(name = "InitgPty")
    private String initgPty = "";


    public GrpHdr(String msgId, LocalDate date) {
        this.msgId = msgId;
        this.creDtTm = generateCreDtTm(date);
    }

    private String generateCreDtTm(LocalDate date) {
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("GMT+3"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return zonedDateTime.format(formatter);
    }
}
