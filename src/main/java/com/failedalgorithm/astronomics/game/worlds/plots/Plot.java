package com.failedalgorithm.astronomics.game.worlds.plots;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "plots")
public class Plot
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //region Relational Values
    //------------------------------------
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "parent_zone_id")
    private Zone zone;
    //------------------------------------
    //endregion

    //region Base Values
    //------------------------------------
    private Integer x;
    private Integer y;
    private boolean isOccupied;
    //------------------------------------
    //endregion

    //region Resources Percent Chance Values
    //------------------------------------
    private boolean hasMetal;
    private boolean hasWood;
    private boolean hasStone;
    private boolean isFertile;
    //------------------------------------
    //endregion

    //================================================================================
    // Constructors
    //================================================================================
    public Plot() {}

    public Plot(Zone zone, Integer x, Integer y)
    {
        this.zone = zone;
        this.x = x;
        this.y = y;
        this.isOccupied = false;

        Random random = new Random();
        int roll = random.nextInt(100);

        this.hasMetal = roll < zone.fetchMetalChance();
        this.hasWood = roll < zone.fetchWoodChance();
        this.isFertile = roll < zone.fetchFertileChance();
        this.hasStone = roll < zone.fetchStoneChance();

    }

    //================================================================================
    // Accessors
    //================================================================================
    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void setOccupied(boolean occupied)
    {
        isOccupied = occupied;
    }

    public Integer getY()
    {
        return y;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }

    public Integer getX()
    {
        return x;
    }

    public void setX(Integer x)
    {
        this.x = x;
    }

    public Zone getZone()
    {
        return zone;
    }

    public void setZone(Zone zone)
    {
        this.zone = zone;
    }

    public Building getBuilding()
    {
        return building;
    }

    public void setBuilding(Building building)
    {
        this.building = building;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
