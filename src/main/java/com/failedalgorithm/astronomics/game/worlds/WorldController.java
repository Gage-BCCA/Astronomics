package com.failedalgorithm.astronomics.game.worlds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class WorldController
{

    @Autowired
    WorldService service;


    @GetMapping
    public Iterable<World> getAllWorlds()
    {
        return service.getAllWorlds();
    }
}
