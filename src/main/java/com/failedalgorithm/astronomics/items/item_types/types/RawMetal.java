package com.failedalgorithm.astronomics.items.item_types.types;

import com.failedalgorithm.astronomics.items.item_types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RAW_METAL")
public class RawMetal extends ItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
