package com.failedalgorithm.astronomics.game.items.recipes;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item producedItem;

    @ManyToOne
    private Item mainIngredient;

    @ManyToOne
    private Item secondaryIngredient;

    @ManyToOne
    private Item tertiaryIngredient;

    private int mainIngredientQty;
    private int secondaryIngredientQty;
    private int tertiaryIngredientQty;


    //================================================================================
    // Constructors
    //================================================================================
    public Recipe()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Item getProducedItem()
    {
        return producedItem;
    }

    public void setProducedItem(Item producedItem)
    {
        this.producedItem = producedItem;
    }

    public Item getMainIngredient()
    {
        return mainIngredient;
    }

    public void setMainIngredient(Item mainIngredient)
    {
        this.mainIngredient = mainIngredient;
    }

    public Item getSecondaryIngredient()
    {
        return secondaryIngredient;
    }

    public void setSecondaryIngredient(Item secondaryIngredient)
    {
        this.secondaryIngredient = secondaryIngredient;
    }

    public Item getTertiaryIngredient()
    {
        return tertiaryIngredient;
    }

    public void setTertiaryIngredient(Item tertiaryIngredient)
    {
        this.tertiaryIngredient = tertiaryIngredient;
    }

    public int getMainIngredientQty()
    {
        return mainIngredientQty;
    }

    public void setMainIngredientQty(int mainIngredientQty)
    {
        this.mainIngredientQty = mainIngredientQty;
    }

    public int getSecondaryIngredientQty()
    {
        return secondaryIngredientQty;
    }

    public void setSecondaryIngredientQty(int secondaryIngredientQty)
    {
        this.secondaryIngredientQty = secondaryIngredientQty;
    }

    public int getTertiaryIngredientQty()
    {
        return tertiaryIngredientQty;
    }

    public void setTertiaryIngredientQty(int tertiaryIngredientQty)
    {
        this.tertiaryIngredientQty = tertiaryIngredientQty;
    }
}
