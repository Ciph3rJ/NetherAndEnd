package net.enderboy500.netherandend.data;

import net.enderboy500.netherandend.data.generator.NetherAndEndRecipeGenerator;
import net.enderboy500.netherandend.data.provider.*;
import net.enderboy500.netherandend.world.feature.NetherAndEndConfiguredFeatures;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class NetherAndEndFabricDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

//        pack.addProvider(NetherAndEndRecipeGenerator::new);
//        pack.addProvider(NetherAndEndAdvancementProvider::new);
/*        pack.addProvider(NetherAndEndDynamicRegistryProvider::new);
        pack.addProvider(NetherAndEndBlockLootTableProvider::new);
        pack.addProvider(NetherAndEndBlockTagProvider::new);
        pack.addProvider(NetherAndEndItemTagProvider::new);*/
//        pack.addProvider(NetherAndEndModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.FEATURE, NetherAndEndConfiguredFeatures::boostrap);
        registryBuilder.add(Registries.PLACED_FEATURE, NetherAndEndPlacedFeatures::boostrap);
    }
}
