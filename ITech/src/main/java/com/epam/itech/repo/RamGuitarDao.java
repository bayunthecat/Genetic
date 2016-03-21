package com.epam.itech.repo;

import com.epam.itech.entity.Guitar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RamGuitarDao implements GuitarDao {

    private Map<Integer, Guitar> guitarMap = new HashMap<Integer, Guitar>();

    public boolean add(Guitar guitar) {
        //TODO retardish method
        return guitarMap.put(guitarMap.size(), guitar) == null;
    }

    public boolean delete(int guitarId) {
        return guitarMap.remove(guitarId) != null;
    }

    public List<Guitar> getAll() {
        return new ArrayList<Guitar>(guitarMap.values());
    }

    public Guitar getGuitarById(int guitarId) {
        return guitarMap.get(guitarId);
    }

    public List<Guitar> getGuitars(int offset, int limit) {
        return null;
    }
}
