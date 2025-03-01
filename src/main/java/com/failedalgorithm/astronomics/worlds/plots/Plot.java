package com.failedalgorithm.astronomics.worlds.plots;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.Building;
import com.failedalgorithm.astronomics.worlds.zones.Zone;
import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "plots")
public class Plot
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "parent_zone_id")
    private Zone zone;

    private Integer x_coord;
    private Integer y_coord;

    private boolean hasMetal;
    private boolean hasWood;
    private boolean hasStone;
    private boolean isFertile;

    private boolean isOccupied;

    public Plot()
    {
    }

    public Plot(Zone zone, Integer x, Integer y)
    {
        this.zone = zone;
        this.x_coord = x;
        this.y_coord = y;

        Random random = new Random();
        int roll = random.nextInt(100);
        this.hasMetal = roll < zone.getZoneMetalChance();
        this.hasWood = roll < zone.getZoneWoodChance();
        this.isFertile = roll < zone.getZoneFertileChance();
        this.hasStone = roll < zone.getZoneStoneChance();

        this.isOccupied = false;

    }
}
