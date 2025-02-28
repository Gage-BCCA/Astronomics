package com.failedalgorithm.astronomics.worlds.plots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlotService {

    @Autowired
    PlotRepository repository;

    // This needs to be done via Zone id instead of all
    public Iterable<Plot> getAllPlots() {
        return repository.findAll();
    }
}
