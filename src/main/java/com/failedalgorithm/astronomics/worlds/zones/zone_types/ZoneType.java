package com.failedalgorithm.astronomics.worlds.zones.zone_types;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_name",
        discriminatorType = DiscriminatorType.STRING)
public class ZoneType
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description = "";

    public int hasMetalChance = 0;
    public int hasWoodChance = 0;
    public int hasStoneChance = 0;
    public int isFertileChance = 0;

    public int fetchMetalChance()
    {
        return 0;
    }

    public int fetchWoodChance()
    {
        return 0;
    }

    public int fetchFertileChance()
    {
        return 0;
    }

    public int fetchStoneChance()
    {
        return 0;
    }

    public String getName()
    {
        return "None";
    }

    public String getDescription()
    {
        return description;
    }
}
