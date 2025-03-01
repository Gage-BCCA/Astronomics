package com.failedalgorithm.astronomics.items.DTOs;

public class ItemDTO
{

    private String item_name;
    private String description;
    private int unitSize;

    public ItemDTO(String item_name, String description, int unitSize)
    {
        this.item_name = item_name;
        this.description = description;
        this.unitSize = unitSize;
    }

}
