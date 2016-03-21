package com.epam.itech.entity;

import javax.xml.bind.annotation.XmlElement;

public class Guitar {

    private int id;

    private String model;

    private String country;

    private Deck deck;

    private Fingerboard fingerboard;

    private Strings strings;

    @XmlElement(name = "Model")
    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement(name = "Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "Deck", type = Deck.class)
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @XmlElement(name = "Fingerboard", type = Fingerboard.class)
    public void setFingerboard(Fingerboard fingerboard) {
        this.fingerboard = fingerboard;
    }

    @XmlElement(name = "Strings", type = Strings.class)
    public void setStrings(Strings strings) {
        this.strings = strings;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "model='" + model + '\'' +
                ", country='" + country + '\'' +
                ", deck=" + deck +
                ", fingerboard=" + fingerboard +
                ", strings=" + strings +
                '}';
    }
}
