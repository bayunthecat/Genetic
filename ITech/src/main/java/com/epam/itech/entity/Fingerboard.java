package com.epam.itech.entity;

import javax.xml.bind.annotation.XmlElement;

public class Fingerboard {
    private String material;
    private boolean adjustable;

    public String getMaterial() {
        return material;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    @XmlElement(name = "Material")
    public void setMaterial(String material) {
        this.material = material;
    }

    @XmlElement(name = "Adjustable", type = Boolean.class)
    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    @Override
    public String toString() {
        return "Fingerboard{" +
                "material='" + material + '\'' +
                ", adjustable=" + adjustable +
                '}';
    }
}