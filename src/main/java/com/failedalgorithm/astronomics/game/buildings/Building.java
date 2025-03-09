package com.failedalgorithm.astronomics.game.buildings;


import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorage;
import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import jakarta.persistence.*;
import com.failedalgorithm.astronomics.game.colonies.Colony;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "buildings")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_name",
        discriminatorType = DiscriminatorType.STRING)
public class Building
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //region Base Values
    //------------------------------------------
    private boolean isBuilt;
    private boolean isActive;
    private String buildingIdentifier;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProductionTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTimestamp;

    @Transient
    private float craftSpeed;

    @Transient
    private int maxStorage;

    @Transient
    private int maxProductionRun;

    //------------------------------------------
    //endregion

    //region Relation Values
    //------------------------------------------
    @OneToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Transient
    private Item item;

    @OneToMany(mappedBy = "building")
    Set<BuildingStorage> itemsInStorage;

    //------------------------------------------
    //endregion


    //================================================================================
    // Constructors
    //================================================================================
    public Building()
    {

    }


    //================================================================================
    // Methods to be Overridden
    //================================================================================
    public Long produce()
    {
        return 0L;
    }

    public int getMaxStorage()
    {
        return maxStorage;
    }

    public String getBuildingType()
    {
        return "Default";
    }

    public float getCraftSpeed()
    {
        return craftSpeed;
    }

    public void setCraftSpeed()
    {
        this.craftSpeed = 0;
    }

    public void setMaxStorage()
    {
        this.maxStorage = 0;
    }

    public void setItem()
    {
        this.item = null;
    }

    public void setCraftSpeed(float craftSpeed)
    {
        this.craftSpeed = craftSpeed;
    }

    public void setMaxStorage(int maxStorage)
    {
        this.maxStorage = maxStorage;
    }

    public int getMaxProductionRun()
    {
        return maxProductionRun;
    }

    public void setMaxProductionRun(int maxProductionRun)
    {
        this.maxProductionRun = maxProductionRun;
    }

    public void setItem(Item item)
    {
        this.item = item;
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

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Date getLastProductionTimestamp()
    {
        return lastProductionTimestamp;
    }

    public void setLastProductionTimestamp(Date lastProductionTimestamp)
    {
        this.lastProductionTimestamp = lastProductionTimestamp;
    }

    public Date getLastModifiedTimestamp()
    {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Date lastModifiedTimestamp)
    {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public Item getItem()
    {
        return item;
    }

    public Set<BuildingStorage> getItemsInStorage()
    {
        return itemsInStorage;
    }

    public void setItemsInStorage(Set<BuildingStorage> itemsInStorage)
    {
        this.itemsInStorage = itemsInStorage;
    }


}
