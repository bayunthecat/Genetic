package com.epam.itech.entity;

public class Fingerboard {
    private String material;
    private boolean adjustable;

    public String getMaterial() {
        return material;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }
}