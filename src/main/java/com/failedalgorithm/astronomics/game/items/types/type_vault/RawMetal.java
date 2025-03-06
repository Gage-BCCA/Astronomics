package com.failedalgorithm.astronomics.game.items.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RAW_METAL")
public class RawMetal extends Item
{

    //================================================================================
    // Properties
    //================================================================================
    private int baseValue;
    private int unitSize;
    private String description;


    //================================================================================
    // Constructor
    //================================================================================
    public RawMetal()
    {
    }

    
    //================================================================================
    // Overridden Methods for Item Config
    //================================================================================


    
    //================================================================================
    // Overridden Accessors
    //================================================================================

    
}
