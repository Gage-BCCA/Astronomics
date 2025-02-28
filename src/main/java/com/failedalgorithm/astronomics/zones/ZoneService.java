package com.failedalgorithm.astronomics.zones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository repository;

    public Iterable<Zone> getAllZones() {
        return repository.findAll();
    }
}
