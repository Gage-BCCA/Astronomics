package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REFINED_STONE")
public class RefinedStone extends Item
{
    private final String itemName = "REFINED_STONE";

    public RefinedStone()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
