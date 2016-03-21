package com.epam.itech.service;

import com.epam.itech.entity.Guitar;

import java.util.List;

public interface GuitarService {

    boolean add(Guitar guitar);

    boolean delete(int guitarId);

    List<Guitar> getAll();

    Guitar getGuitarById(int guitarId);

    List<Guitar> getGuitars(int page, int size);
}
