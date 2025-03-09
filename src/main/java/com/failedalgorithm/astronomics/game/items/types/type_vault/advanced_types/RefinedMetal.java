package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REFINED_METAL")
public class RefinedMetal extends Item
{
    private final String itemName = "REFINED_METAL";

    public RefinedMetal()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
