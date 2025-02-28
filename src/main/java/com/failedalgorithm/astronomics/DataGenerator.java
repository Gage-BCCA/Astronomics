package com.failedalgorithm.astronomics;


import com.failedalgorithm.astronomics.buildings.BuildingRepository;
import com.failedalgorithm.astronomics.buildings.building_types.BuildingTypeRepository;
import com.failedalgorithm.astronomics.colonies.ColonyRepository;
import com.failedalgorithm.astronomics.items.ItemRepository;
import com.failedalgorithm.astronomics.jobs.JobRepository;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserRepository;
import com.failedalgorithm.astronomics.worlds.plots.Plot;
import com.failedalgorithm.astronomics.worlds.plots.PlotRepository;
import com.failedalgorithm.astronomics.worlds.World;
import com.failedalgorithm.astronomics.worlds.WorldRepository;
import com.failedalgorithm.astronomics.worlds.zones.Zone;
import com.failedalgorithm.astronomics.worlds.zones.ZoneRepository;
import com.failedalgorithm.astronomics.worlds.zones.zone_types.ZoneType;
import com.failedalgorithm.astronomics.worlds.zones.zone_types.ZoneTypeRepository;
import com.failedalgorithm.astronomics.worlds.zones.zone_types.types.Barren;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataGenerator {

    @Bean
    CommandLineRunner generateData(
            WorldRepository worldRepository,
            ZoneRepository zoneRepository,
            ZoneTypeRepository zoneTypeRepository,
            PlotRepository plotRepository,
            BuildingRepository buildingRepository,
            BuildingTypeRepository buildingTypeRepository,
            ColonyRepository colonyRepository,
            JobRepository jobRepository,
            ItemRepository itemRepository,
            UserRepository userRepository
    ) {
        return args -> {
            // Create SYSTEM user
            User systemUser = new User();
            systemUser.setName("SYSTEM");
            userRepository.save(systemUser);

            World world = worldRepository.save(new World("Epsilon-8"));
            ZoneType barren = zoneTypeRepository.save(new Barren());
            List<Zone> zones = new ArrayList<>();
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    zones.add(zoneRepository.save(new Zone(
                            world,
                            x,
                            y,
                            barren,
                            systemUser
                    )));
                }
            }

            List<Plot> plots = new ArrayList<>();
            for (Zone zone: zones) {
                for (int x = 0; x < 25; x++){
                    for (int y = 0; y < 25; y++) {
                        plots.add(new Plot(zone, x, y));
                    }
                }
            }
            plotRepository.saveAll(plots);
        };

    }
}
