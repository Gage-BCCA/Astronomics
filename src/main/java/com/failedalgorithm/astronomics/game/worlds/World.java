package com.failedalgorithm.astronomics.game.worlds;

import jakarta.persistence.*;

@Entity
@Table(name = "worlds")
public class World
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //================================================================================
    // Constructors
    //================================================================================
    public World() {}

    public World(String name)
    {
        this.name = name;
    }


    //================================================================================
    // Accessors
    //================================================================================
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
