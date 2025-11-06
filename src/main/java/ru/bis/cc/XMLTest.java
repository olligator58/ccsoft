package ru.bis.cc;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.StringWriter;

public class XMLTest {
    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat("Murka", 3);
        Address address = new Address("USA", "New York", "Mandella st.", "28", "134");
        cat.setAddress(address);
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(cat, writer);
        System.out.println(writer);
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


