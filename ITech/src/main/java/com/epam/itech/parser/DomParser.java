package com.epam.itech.parser;

import com.epam.itech.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class DomParser {

    private Document document;

    public DomParser() throws ParserConfigurationException, IOException, SAXException {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("resources/input.xml"));
    }

    public GuitarContainer getGuitars() {
        GuitarContainer container = new GuitarContainer();

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName());
            if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                container.add(getGuitar(nodeList.item(i)));
            }
        }
        return container;
    }

    private Guitar getGuitar(Node guitarNode) {
        Guitar guitar = new Guitar();
        Element guitarElement = (Element) guitarNode;
        Node currentNode;
        currentNode = guitarElement.getElementsByTagName("Model").item(0);
        guitar.setModel(currentNode.getTextContent());
        currentNode = (guitarElement.getElementsByTagName("Country").item(0));
        guitar.setCountry(currentNode.getTextContent());
        guitar.setFingerboard(getFingerboard(guitarElement.getElementsByTagName("Fingerboard").item(0)));
        guitar.setDeck(getDeck(guitarElement.getElementsByTagName("Deck").item(0)));
        guitar.setStrings(getStrings(guitarElement.getElementsByTagName("Strings").item(0)));
        return guitar;
    }

    private Deck getDeck(Node deckNode) {
        Deck deck = new Deck();
        Element deckElement = (Element) deckNode;
        deck.setMaterial(deckElement.getElementsByTagName("Material").item(0).getTextContent());
        deck.setType(deckElement.getElementsByTagName("Type").item(0).getTextContent());
        return deck;
    }

    private Fingerboard getFingerboard(Node fingerboardNode) {
        Fingerboard fingerboard = new Fingerboard();
        Element fingerboardElement = (Element) fingerboardNode;
        fingerboard.setMaterial(fingerboardElement.getElementsByTagName("Material").item(0).getTextContent());
        fingerboard.setAdjustable(Boolean.parseBoolean(fingerboardElement.getElementsByTagName("Adjustable").item(0).getTextContent()));
        return fingerboard;
    }

    private Strings getStrings(Node stringsNode) {
        Strings strings = new Strings();
        Element stringsElement = (Element) stringsNode;
        strings.setMaterial(stringsElement.getElementsByTagName("Material").item(0).getTextContent());
        strings.setDiameter(Double.parseDouble(stringsElement.getElementsByTagName("Diameter").item(0).getTextContent()));
        return strings;
    }
}