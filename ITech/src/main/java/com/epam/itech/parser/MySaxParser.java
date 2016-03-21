package com.epam.itech.parser;

import com.epam.itech.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxParser extends DefaultHandler {

    private GuitarContainer container;

    private Guitar guitar;

    private Deck deck;

    private Fingerboard fingerboard;

    private Strings strings;

    private String tagName = "";

    public GuitarContainer getResult() {
        return container;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagName = qName;
        if(qName.equals("itech:Guitars")) {
            createGuitarContainer();
        }
        if(qName.equals("AcousticGuitar")) {
            createGuitar();
        }
        if(qName.equals("ElectricGuitar")) {
            createGuitar();
        }
        if(qName.equals("Deck")) {
            createDeck();
        }
        if(qName.equals("Fingerboard")) {
            createFingerboard();
        }
        if(qName.equals("Strings")) {
            createStrings();
        }
    }

    //beware magic!
    @Override
    public void characters(char[] chars, int offset, int size) {
        String elementText = new String(chars, offset, size);
        if(elementText.isEmpty()) {
            return;
        }
        if(tagName.equals("Diameter")) {
            strings.setDiameter(Double.parseDouble(elementText));
        }
        if(tagName.equals("Type")) {
            deck.setType(elementText);
        }
        if(tagName.equals("Country")) {
            guitar.setCountry(elementText);
        }
        if(tagName.equals("Model")) {
            guitar.setModel(elementText);
        }
        if(tagName.equals("Adjustable")) {
            fingerboard.setAdjustable(Boolean.parseBoolean(elementText));
        }
        if(tagName.equals("Material")) {
            setMaterial(elementText);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if(qName.equals("AcousticGuitar")) {
            container.add(guitar);
            return;
        }
        if(qName.equals("ElectricGuitar")) {
            container.add(guitar);
            return;
        }
        if(qName.equals("Deck")) {
            guitar.setDeck(deck);
            deck = null;
        }
        if(qName.equals("Fingerboard")) {
            guitar.setFingerboard(fingerboard);
            fingerboard = null;
        }
        if(qName.equals("Strings")) {
            guitar.setStrings(strings);
            strings = null;
        }
        this.tagName = "";
    }

    private void setMaterial(String material) {
        if(strings != null) {
            strings.setMaterial(material);
            return;
        }
        if(fingerboard != null) {
            fingerboard.setMaterial(material);
            return;
        }
        if(deck != null) {
            deck.setMaterial(material);
        }
    }

    private void createGuitarContainer() {
        container = new GuitarContainer();
    }

    private void createGuitar() {
        guitar = new Guitar();
    }

    private void createDeck() {
        deck = new Deck();
    }

    private void createFingerboard() {
        fingerboard = new Fingerboard();
    }

    private void createStrings() {
        strings = new Strings();
    }
}
