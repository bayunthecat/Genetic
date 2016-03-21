package com.epam.itech.entity;

import javax.xml.bind.annotation.XmlElement;

public class Strings {
    private String material;
    private double diameter;

    public String getMaterial() {
        return material;
    }

    public double getDiameter() {
        return diameter;
    }

    @XmlElement(name = "Material")
    public void setMaterial(String material) {
        this.material = material;
    }

    @XmlElement(name = "Diameter")
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Strings{" +
                "material='" + material + '\'' +
                ", diameter=" + diameter +
                '}';
    }
}
