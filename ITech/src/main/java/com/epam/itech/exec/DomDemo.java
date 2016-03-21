package com.epam.itech.exec;

import com.epam.itech.entity.GuitarContainer;
import com.epam.itech.parser.DomParser;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomDemo {
    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException {
        File file = new File("resources/input.xml");
        DomParser dom = new DomParser();
        GuitarContainer container = dom.getGuitars();
        System.out.println(container);
    }
}
