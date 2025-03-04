package com.failedalgorithm.astronomics.game.worlds.plots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plots")
public class PlotController
{

    @Autowired
    PlotService service;

    // This needs to be done by Zone id
    @GetMapping
    public Iterable<Plot> getAllPlots()
    {
        return service.getAllPlots();
    }
}
