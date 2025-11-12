package ru.bis.cc;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.bis.cc.dto.DocumentDto;
import ru.bis.cc.utils.FileHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class XMLTest {
    public static void main(String[] args) {
        Cat cat = new Cat("Murka", 3);
        Address address = new Address("USA", "New York", "Mandella st.", "28", "134");
        cat.setAddress(address);
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(cat, writer);
            System.out.println(writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String fileName = FileHelper.chooseSourceFile("Выберите файл ISO");
        try {
            String doc = new String(Files.readAllBytes(Path.of(fileName)), "UTF-8");
            // убираем элемент на котором падает парсинг
            doc = doc.replace(" xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\"", "");
            System.out.println(doc);
            StringReader reader = new StringReader(doc);
            JAXBContext jaxbContext = JAXBContext.newInstance(DocumentDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DocumentDto dto = (DocumentDto) unmarshaller.unmarshal(reader);
            System.out.println(dto.getCstmrCdtTrfInitn().getPmtInf().getPmtTpInf().getSvcLvl().getCd());
            System.out.println(dto.getCstmrCdtTrfInitn().getPmtInf().getDbtr().getNm());
            System.out.println(dto.getCstmrCdtTrfInitn().getPmtInf().getDbtr().getId().getOrgId().getOthr().getId());
            System.out.println(dto.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcct().getId().getOthr().getId());
            System.out.println(dto);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private static class Address {
        @XmlElement
        private String country;
        @XmlElement
        private String city;
        @XmlElement
        private String street;
        @XmlElement
        private String building;
        @XmlAttribute
        private String flat;

        public Address() {
        }

        public Address(String country, String city, String street, String building, String flat) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.building = building;
            this.flat = flat;
        }
    }

    @XmlRootElement
    private static class Cat {
        @XmlElement
        private String name;
        @XmlElement
        private int age;
        @XmlElement
        private Address address;

        public Cat() {

        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }
}


