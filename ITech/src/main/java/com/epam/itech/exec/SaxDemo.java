package com.epam.itech.exec;

import com.epam.itech.parser.MySaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxDemo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MySaxParser par = new MySaxParser();
        parser.parse(new File("resources/input.xml"), par);
        System.out.println(par.getResult());
    }

}
