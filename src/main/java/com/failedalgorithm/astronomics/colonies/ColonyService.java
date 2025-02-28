package com.failedalgorithm.astronomics.colonies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColonyService {

    @Autowired
    ColonyRepository repository;

    public Iterable<Colony> getAllColonies() {
        return repository.findAll();
    }
}
