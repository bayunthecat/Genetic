package com.epam.itech.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Deck {

    private String material;

    private String type;

    @XmlElement(name = "Material")
    public void setMaterial(String material) {
        this.material = material;
    }

    @XmlElement(name = "Type")
    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "material='" + material + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}