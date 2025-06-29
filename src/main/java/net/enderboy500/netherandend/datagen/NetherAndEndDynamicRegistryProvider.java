package net.enderboy500.netherandend.datagen;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.world.NetherAndEndBiomeModifiers;
import net.enderboy500.netherandend.world.feature.NetherAndEndConfiguredFeatures;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NetherAndEndDynamicRegistryProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, NetherAndEndConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, NetherAndEndPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, NetherAndEndBiomeModifiers::bootstrap)
            ;

    public NetherAndEndDynamicRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NetherAndEnd.MOD_ID));
    }
}
