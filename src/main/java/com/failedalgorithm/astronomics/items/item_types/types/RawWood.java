package com.failedalgorithm.astronomics.items.item_types.types;

import com.failedalgorithm.astronomics.items.item_types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RAW_WOOD")
public class RawWood extends ItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
