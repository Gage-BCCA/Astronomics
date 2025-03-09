package com.failedalgorithm.astronomics;


import com.failedalgorithm.astronomics.game.buildings.types.produced_items.ProducedItem;
import com.failedalgorithm.astronomics.game.buildings.types.produced_items.ProducedItemRepository;
import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.items.recipes.Recipe;
import com.failedalgorithm.astronomics.game.items.recipes.RecipeRepository;
import com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types.RefinedMetal;
import com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types.RefinedStone;
import com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types.RefinedWood;
import com.failedalgorithm.astronomics.users.auth.ApiKey;
import com.failedalgorithm.astronomics.users.auth.ApiKeyRepository;
import com.failedalgorithm.astronomics.game.buildings.BuildingRepository;
import com.failedalgorithm.astronomics.game.colonies.ColonyRepository;
import com.failedalgorithm.astronomics.game.items.ItemRepository;
import com.failedalgorithm.astronomics.game.jobs.JobRepository;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserRepository;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.plots.PlotRepository;
import com.failedalgorithm.astronomics.game.worlds.World;
import com.failedalgorithm.astronomics.game.worlds.WorldRepository;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.ZoneRepository;
import com.failedalgorithm.astronomics.game.worlds.zones.types.ZoneTypeFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.failedalgorithm.astronomics.game.items.types.type_vault.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataGenerator {

    @Bean
    CommandLineRunner generateData(
            WorldRepository worldRepository,
            ZoneRepository zoneRepository,
            ZoneTypeFactory zoneTypeFactory,
            PlotRepository plotRepository,
            BuildingRepository buildingRepository,
            ColonyRepository colonyRepository,
            JobRepository jobRepository,
            ItemRepository itemRepository,
            UserRepository userRepository,
            ApiKeyRepository apiKeyRepository,
            RecipeRepository recipeRepository,
            ProducedItemRepository producedItemRepository
    ) {
        return args ->
        {
            // Create SYSTEM user
            User systemUser = new User();
            systemUser.setName("SYSTEM");
            userRepository.save(systemUser);

            ApiKey apiKey = new ApiKey();
            apiKey.setUser(systemUser);
            apiKeyRepository.save(apiKey);

            World world = worldRepository.save(new World("Epsilon-8"));
            List<Zone> zones = new ArrayList<>();
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    Zone newZone;
                    if (y % 2 == 0)
                    {
                       newZone = zoneTypeFactory.createZoneClass("BARREN");
                    }
                    else
                    {
                        newZone = zoneTypeFactory.createZoneClass("FORREST");
                    }
                    newZone.setWorld(world);
                    newZone.setX(x);
                    newZone.setY(y);
                    newZone.setOwner(systemUser);
                    zones.add(newZone);
                }
            }
            zoneRepository.saveAll(zones);

            List<Plot> plots = new ArrayList<>();
            for (Zone zone : zones) {
                for (int x = 0; x < 25; x++) {
                    for (int y = 0; y < 25; y++) {
                        plots.add(new Plot(zone, x, y));
                    }
                }
            }
            plotRepository.saveAll(plots);

            Item basicMetal = new RawMetal();
            Item basicWood = new RawWood();
            Item basicStone = new RawStone();
            Item refinedMetal = new RefinedMetal();
            Item refinedWood = new RefinedWood();
            Item refinedStone = new RefinedStone();
            basicStone = itemRepository.save(basicStone);
            basicWood = itemRepository.save(basicWood);
            basicMetal = itemRepository.save(basicMetal);
            refinedMetal = itemRepository.save(refinedMetal);
            refinedWood = itemRepository.save(refinedWood);
            refinedStone = itemRepository.save(refinedStone);

            Recipe refinedMetalRecipe = new Recipe();
            refinedMetalRecipe.setMainIngredient(basicMetal);
            refinedMetalRecipe.setMainIngredientQty(5);
            refinedMetalRecipe.setProducedItem(refinedMetal);
            recipeRepository.save(refinedMetalRecipe);

            Recipe refinedWoodRecipe = new Recipe();
            refinedWoodRecipe.setMainIngredientQty(5);
            refinedWoodRecipe.setMainIngredient(basicWood);
            refinedWoodRecipe.setProducedItem(refinedWood);
            recipeRepository.save(refinedWoodRecipe);

            ProducedItem metalToDrill = new ProducedItem();
            metalToDrill.setBuildingType("MINING_DRILL");
            metalToDrill.setItem(basicMetal);
            producedItemRepository.save(metalToDrill);

        };

    }
}
