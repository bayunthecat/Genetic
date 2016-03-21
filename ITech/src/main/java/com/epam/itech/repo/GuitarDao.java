package com.epam.itech.repo;

import com.epam.itech.entity.Guitar;

import java.util.List;

public interface GuitarDao {

    boolean add(Guitar guitar);

    boolean delete(int guitarId);

    List<Guitar> getAll();

    Guitar getGuitarById(int guitarId);

    List<Guitar> getGuitars(int offset, int limit);
}
