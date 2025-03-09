package com.failedalgorithm.astronomics.game.colonies;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "colonies")
public class Colony
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //region Base Values
    //------------------------------------------
    @Column(unique = true, nullable = false)
    private String colonyName;
    //------------------------------------------
    //endregion

    //region Relational Values
    //------------------------------------------
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Building> buildings;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private User owner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_zone_id")
    @JsonIgnore
    private Zone zone;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Plot plot;
    //------------------------------------------
    //endregion


    //================================================================================
    // Constructors
    //================================================================================
    public Colony()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getColonyName()
    {
        return colonyName;
    }

    public void setColonyName(String colonyName)
    {
        this.colonyName = colonyName;
    }

    public List<Building> getBuildings()
    {
        return buildings;
    }

    public void setBuildings(List<Building> buildings)
    {
        this.buildings = buildings;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public Zone getZone()
    {
        return zone;
    }

    public void setZone(Zone zone)
    {
        this.zone = zone;
    }

    public Plot getPlot()
    {
        return plot;
    }

    public void setPlot(Plot plot)
    {
        this.plot = plot;
    }
}
