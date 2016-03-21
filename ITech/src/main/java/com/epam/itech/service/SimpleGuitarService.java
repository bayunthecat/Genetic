package com.epam.itech.service;

import com.epam.itech.entity.Guitar;
import com.epam.itech.repo.GuitarDao;
import com.epam.itech.repo.RamGuitarDao;

import java.util.List;

public class SimpleGuitarService implements GuitarService {

    private GuitarDao guitarDao;

    public SimpleGuitarService() {
        guitarDao = new RamGuitarDao();

    }

    public boolean add(Guitar guitar) {
        return guitarDao.add(guitar);
    }

    public boolean delete(int guitarId) {
        return guitarDao.delete(guitarId);
    }

    public List<Guitar> getAll() {
        return guitarDao.getAll();
    }

    public Guitar getGuitarById(int guitarId) {
        return guitarDao.getGuitarById(guitarId);
    }

    public List<Guitar> getGuitars(int page, int size) {
        return guitarDao.getGuitars(page, size);
    }
}
