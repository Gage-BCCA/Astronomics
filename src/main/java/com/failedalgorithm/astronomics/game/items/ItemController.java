package com.failedalgorithm.astronomics.game.items;

import com.failedalgorithm.astronomics.game.items.DTOs.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController
{

    @Autowired
    ItemService service;

    @GetMapping
    public Iterable<ItemDTO> getAllItems()
    {
        return service.getAllItems();
    }

}
