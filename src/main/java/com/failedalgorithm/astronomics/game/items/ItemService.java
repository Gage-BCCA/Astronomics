package com.failedalgorithm.astronomics.game.items;

import com.failedalgorithm.astronomics.game.items.DTOs.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService
{

    @Autowired
    ItemRepository repository;

    public Iterable<ItemDTO> getAllItems()
    {

        Iterable<Item> items = repository.findAll();
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for (Item item : items)
        {
            itemDTOs.add(new ItemDTO(
                    item.getItemName(), item.getDescription(), item.getUnitSize()
            ));
        }

        return itemDTOs;
    }
}
