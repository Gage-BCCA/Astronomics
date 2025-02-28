package com.failedalgorithm.astronomics.buildings.building_types.types;

import com.failedalgorithm.astronomics.buildings.Building;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOLAR_FARM")
public class SolarFarm extends Building {}
