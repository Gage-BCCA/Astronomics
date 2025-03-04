package com.failedalgorithm.astronomics.game.buildings;


import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import jakarta.persistence.*;
import com.failedalgorithm.astronomics.game.colonies.Colony;

@Entity
@Table(name = "buildings")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_name",
        discriminatorType = DiscriminatorType.STRING)
public class Building
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private boolean isBuilt;
    private boolean isActive;
    private String buildingIdentifier;

    @OneToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Building()
    {

    }

    public Long getId()
    {

        return id;
    }

    public void setId(Long id)
    {

        this.id = id;
    }

    public Colony getColony()
    {

        return colony;
    }

    public void setColony(Colony colony)
    {

        this.colony = colony;
    }

    public String getBuildingIdentifier()
    {

        return buildingIdentifier;
    }

    public void setBuildingIdentifier(String buildingIdentifier)
    {

        this.buildingIdentifier = buildingIdentifier;
    }

    public boolean isBuilt()
    {

        return isBuilt;
    }

    public void setBuilt(boolean built)
    {

        isBuilt = built;
    }

    public boolean isActive()
    {

        return isActive;
    }

    public void setActive(boolean active)
    {

        isActive = active;
    }

    public String getBuildingType()
    {

        return "Default";
    }

    public User getOwner()
    {

        return owner;
    }

    public void setOwner(User owner)
    {

        this.owner = owner;
    }

    public Plot getPlot()
    {

        return plot;
    }

    public void setPlot(Plot plot)
    {

        this.plot = plot;
    }

    public Zone getZone()
    {

        return zone;
    }

    public void setZone(Zone zone)
    {

        this.zone = zone;
    }


}
