package com.failedalgorithm.astronomics.items.item_types.types.advanced_types;

import com.failedalgorithm.astronomics.items.item_types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REFINED_FOOD")
public class RefinedFood extends ItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
