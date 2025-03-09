package com.failedalgorithm.astronomics.game.items.types.type_vault;

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
    private final String itemName = "RAW_METAL";


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
    @Override
    public String getItemName()
    {
        return itemName;
    }
}
