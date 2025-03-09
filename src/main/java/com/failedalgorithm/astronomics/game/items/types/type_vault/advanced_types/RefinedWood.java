package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REFINED_WOOD")
public class RefinedWood extends Item
{
    private final String itemName = "REFINED_WOOD";

    public RefinedWood()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
