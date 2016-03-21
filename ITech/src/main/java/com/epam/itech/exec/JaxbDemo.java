package com.epam.itech.exec;

import com.epam.itech.entity.GuitarContainer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbDemo {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GuitarContainer.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        GuitarContainer container = (GuitarContainer)unmarshaller.unmarshal(new File("resources/input.xml"));
        System.out.println(container);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(container, new File("resources/output.xml"));
    }

}
