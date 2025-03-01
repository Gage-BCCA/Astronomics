package com.failedalgorithm.astronomics.worlds.zones;

import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.worlds.World;
import com.failedalgorithm.astronomics.worlds.zones.zone_types.ZoneType;
import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_world_id")
    private World world;

    private int xCoord;
    private int yCoord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_type")
    private ZoneType zoneType;

    private boolean isOccupied;
    private String occupiedType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Zone()
    {
    }

    public Zone(World world, Integer x, Integer y, ZoneType zoneType, User owner)
    {
        this.name = world.getName() + "-" + x.toString() + "." + y.toString();
        this.world = world;
        this.xCoord = x;
        this.yCoord = y;
        this.zoneType = zoneType;
        this.isOccupied = false;
        this.occupiedType = "NONE";
        this.owner = owner;
    }

    public int getZoneMetalChance()
    {
        return this.zoneType.fetchMetalChance();
    }

    public int getZoneFertileChance()
    {
        return zoneType.fetchFertileChance();
    }

    public int getZoneStoneChance()
    {
        return zoneType.fetchStoneChance();
    }

    public int getZoneWoodChance()
    {
        return zoneType.fetchWoodChance();
    }

    public Long getId()
    {
        return id;
    }

    public int getxCoord()
    {
        return xCoord;
    }

    public int getyCoord()
    {
        return yCoord;
    }

    public boolean isOccupied()
    {
        return isOccupied;
    }

    public World getWorld()
    {
        return world;
    }

    public ZoneType getZoneType()
    {
        return zoneType;
    }

    public String getOccupiedType()
    {
        return occupiedType;
    }

    public User getOwner()
    {
        return owner;
    }

    public String getName()
    {
        return name;
    }

    public String getZoneTypeDescription()
    {
        return this.zoneType.getDescription();
    }
}
