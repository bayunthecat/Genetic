package com.epam.itech.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AcousticGuitar")
public class Guitar {

    private String model;

    private String country;

    private Deck deck;

    private Fingerboard fingerboard;

    private Strings strings;

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setFingerboard(Fingerboard fingerboard) {
        this.fingerboard = fingerboard;
    }

    public void setStrings(Strings strings) {
        this.strings = strings;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public Deck getDeck() {
        return deck;
    }

    public Fingerboard getFingerboard() {
        return fingerboard;
    }

    public Strings getStrings() {
        return strings;
    }
}
