package com.failedalgorithm.astronomics.worlds.colonies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colonies")
public class ColonyController
{

    @Autowired
    ColonyService service;

    @GetMapping
    public Iterable<Colony> getAllColonies()
    {
        return service.getAllColonies();
    }
}
