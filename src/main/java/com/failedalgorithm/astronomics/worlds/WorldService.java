package com.failedalgorithm.astronomics.worlds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldService
{

    @Autowired
    WorldRepository repository;

    public Iterable<World> getAllWorlds()
    {
        return repository.findAll();
    }
}
