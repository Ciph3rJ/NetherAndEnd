package net.enderboy500.netherandend;

import net.enderboy500.netherandend.datagen.providers.*;
import net.enderboy500.netherandend.datagen.generators.NetherAndEndRecipeGenerator;
import net.enderboy500.netherandend.world.feature.NetherAndEndConfiguredFeatures;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class NetherAndEndDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture = CompletableFuture.supplyAsync(
				BuiltinRegistries::createWrapperLookup, Util.getMainWorkerExecutor()
		);

		pack.addProvider(NetherAndEndBlockLootTableProvider::new);
		pack.addProvider(NetherAndEndBlockTagProvider::new);
		pack.addProvider(NetherAndEndItemTagProvider::new);
		pack.addProvider(NetherAndEndAdvancementProvider::new);

		pack.addProvider(toFactory(NetherAndEndRecipeGenerator.Provider::new, completableFuture));
		pack.addProvider(NetherAndEndRegistryProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, NetherAndEndConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, NetherAndEndPlacedFeatures::boostrap);
	}

	private static <T extends DataProvider> DataProvider.Factory<T> toFactory(BiFunction<DataOutput, CompletableFuture<RegistryWrapper.WrapperLookup>, T> baseFactory, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		return output -> (T)baseFactory.apply(output, registriesFuture);
	}
}

