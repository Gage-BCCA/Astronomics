package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REFINED_FOOD")
public class RefinedFood extends Item
{
    private String itemName = "REFINED_FOOD";

    public RefinedFood()
    {
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }
}
