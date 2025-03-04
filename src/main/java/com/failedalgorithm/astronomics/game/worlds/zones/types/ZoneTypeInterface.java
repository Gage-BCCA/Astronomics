package com.failedalgorithm.astronomics.game.worlds.zones.types;


public interface ZoneTypeInterface
{

    int fetchMetalChance();

    int fetchWoodChance();

    int fetchFertileChance();

    int fetchStoneChance();

    String getName();

    public String getDescription();
}
