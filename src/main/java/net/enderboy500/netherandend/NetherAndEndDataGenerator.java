package net.enderboy500.netherandend;

import net.enderboy500.netherandend.data.generators.NetherAndEndRecipeGenerator;
import net.enderboy500.netherandend.data.providers.*;
import net.enderboy500.netherandend.world.feature.NetherAndEndConfiguredFeatures;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class NetherAndEndDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		CompletableFuture<HolderLookup.Provider> completableFuture = CompletableFuture.supplyAsync(
				VanillaRegistries::createLookup, Util.backgroundExecutor());

		pack.addProvider(NetherAndEndBlockLootTableProvider::new);
		pack.addProvider(NetherAndEndBlockTagProvider::new);
		pack.addProvider(NetherAndEndItemTagProvider::new);
		pack.addProvider(NetherAndEndAdvancementProvider::new);
		pack.addProvider(NetherAndEndRegistryProvider::new);
		pack.addProvider(toFactory(NetherAndEndRecipeGenerator.Provider::new, completableFuture));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, NetherAndEndConfiguredFeatures::boostrap);
		registryBuilder.add(Registries.PLACED_FEATURE, NetherAndEndPlacedFeatures::boostrap);
	}

	private static <T extends DataProvider> DataProvider.Factory<T> toFactory(BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> baseFactory, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		return output -> (T)baseFactory.apply(output, registriesFuture);
	}
}
