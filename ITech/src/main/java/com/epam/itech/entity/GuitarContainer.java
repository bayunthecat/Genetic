package com.epam.itech.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Guitars", namespace = "http://nure.ua/romanchuk/itech")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuitarContainer {

    @XmlElement(name = "AcousticGuitar")
    private List<Guitar> guitars;

    public void setGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }

    public void add(Guitar guitar) {
        createListIfNotExists();
        guitars.add(guitar);
    }

    private void createListIfNotExists() {
        if(guitars == null) {
            guitars = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "GuitarContainer{" +
                "guitars=" + guitars +
                '}';
    }
}
