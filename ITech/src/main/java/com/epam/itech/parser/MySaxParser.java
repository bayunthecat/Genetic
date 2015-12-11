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
        switch (qName) {
            case "itech:Guitars":
                createGuitarContainer();
                break;
            case "AcousticGuitar":
            case "ElectricGuitar":
                createGuitar();
                break;
            case "Deck":
                createDeck();
                break;
            case "Fingerboard":
                createFingerboard();
                break;
            case "Strings":
                createStrings();
                break;
        }
    }

    @Override
    public void characters(char[] chars, int offset, int size) {
        switch (tagName) {
            case "Material":
                setMaterial(new String(chars, offset, size));
                break;
            case "Diameter":
                strings.setDiameter(Double.parseDouble(new String(chars, offset, size)));
                break;
            case "Type":
                deck.setType(new String(chars, offset, size));
                break;
            case "Adjustable":
                fingerboard.setAdjustable(Boolean.parseBoolean(new String (chars, offset, size)));
                break;
            case "Country":
                guitar.setCountry(new String(chars, offset, size));
                break;
            case "Model":
                guitar.setModel(new String(chars, offset, size));
                break;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        switch (qName) {
            case "AcousticGuitar":
            case "ElectricGuitar":
                container.add(guitar);
                guitar = null;
                break;
            case "Deck":
                guitar.setDeck(deck);
                deck = null;
                break;
            case "Fingerboard":
                guitar.setFingerboard(fingerboard);
                guitar = null;
                break;
            case "Strings":
                guitar.setStrings(strings);
                strings = null;
                break;
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
