package com.failedalgorithm.astronomics.game.items.types.type_vault;

import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RAW_WOOD")
public class RawWood extends Item
{

    private final String itemName = "RAW_WOOD";

    public RawWood()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
