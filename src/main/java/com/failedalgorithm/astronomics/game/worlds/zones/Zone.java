package com.failedalgorithm.astronomics.game.worlds.zones;

import com.failedalgorithm.astronomics.game.worlds.World;
import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_name",
        discriminatorType = DiscriminatorType.STRING)
@Table(name = "zones")
public abstract class Zone
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //region Base Values
    //----------------------------------
    @Transient
    private String name;

    @Transient
    private String description;

    private int x;
    private int y;
    //----------------------------------
    //endregion

    //region Relational Values
    //----------------------------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_world_id")
    private World world;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;
    //----------------------------------
    //endregion

    //================================================================================
    // Constructors
    //================================================================================
    public Zone()
    {
    }

    public Zone(World world, Integer x, Integer y, User owner)
    {
        this.name = world.getName() + "-" + x.toString() + "." + y.toString();
        this.world = world;
        this.x = x;
        this.y = y;
        this.owner = owner;
    }


    //================================================================================
    // Overridden Methods (should not be used by base class)
    //================================================================================
    public int fetchMetalChance()
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

    public int fetchWoodChance()
    {
        return 0;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public World getWorld()
    {
        return world;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }
}
