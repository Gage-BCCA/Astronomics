package com.failedalgorithm.astronomics.items;

import jakarta.persistence.*;


@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item_name;
}
