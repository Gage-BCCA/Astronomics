package com.failedalgorithm.astronomics.game.items.types.type_vault;

import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RAW_FOOD")
public class RawFood extends Item
{
    private String itemName = "RAW_FOOD";

    public RawFood()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
