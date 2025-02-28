package com.failedalgorithm.astronomics.buildings.building_types.types;

import com.failedalgorithm.astronomics.buildings.Building;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MINING_DRILL")
public class MiningDrill extends Building {}
