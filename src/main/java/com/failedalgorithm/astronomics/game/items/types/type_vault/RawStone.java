package com.failedalgorithm.astronomics.game.items.types.type_vault;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RAW_STONE")
public class RawStone extends Item
{

    private final String itemName = "RAW_STONE";

    public RawStone()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
