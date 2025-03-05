package com.failedalgorithm.astronomics.game.buildings.requests;

public class BuildingReadManyRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private String typeName;
    private String identifier;
    private String itemProducedId;

    //================================================================================
    // Constructors
    //================================================================================
    public BuildingReadManyRequest()
    {
    }

    //================================================================================
    // Accessors
    //================================================================================
    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String type)
    {
        this.typeName = type;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    public String getItemProducedId()
    {
        return itemProducedId;
    }

    public void setItemProducedId(String itemProducedId)
    {
        this.itemProducedId = itemProducedId;
    }
}
