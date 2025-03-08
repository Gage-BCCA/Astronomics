package com.failedalgorithm.astronomics.jobs.attached_resources;

import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.jobs.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class AttachedResources
{

    //================================================================================
    // Properties
    //================================================================================
    private Long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Job job;

    private Integer amount;


    //================================================================================
    // Constructors
    //================================================================================
    public AttachedResources() {}

    public AttachedResources(Job job, Item item)
    {
        this.item = item;
        this.job = job;
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

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Job getJob()
    {
        return job;
    }

    public void setJob(Job job)
    {
        this.job = job;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}
