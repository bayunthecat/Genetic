package com.epam.itech.entity;

import com.epam.itech.xml.annotations.Root;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Root(rootElement = "Guitars")
@XmlRootElement(name = "Guitars", namespace = "itech")
public class GuitarContainer {

    List<Guitar> guitars;

    @XmlElement(name = "AcousticGuitar")
    public void setGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }

    public void add(Guitar guitar) {
        createListIfnotExists();
        guitars.add(guitar);
    }

    private void createListIfnotExists() {
        if(guitars == null) {
            guitars = new ArrayList<Guitar>();
        }
    }
}
