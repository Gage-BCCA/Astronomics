package com.failedalgorithm.astronomics.worlds.colonies.buildings;


import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.BuildingType;
import com.failedalgorithm.astronomics.worlds.plots.Plot;
import jakarta.persistence.*;
import com.failedalgorithm.astronomics.worlds.colonies.Colony;

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

    private String buildingIdentifier;

    private boolean isBuilt;

    private boolean isActive;

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
}
