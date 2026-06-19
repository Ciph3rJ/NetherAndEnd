package net.enderboy500.netherandend.data;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.world.NeoForgeBiomeModifications;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NeoForgeBuiltInEntriesProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, NeoForgeBiomeModifications::bootstrap);

    public NeoForgeBuiltInEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Constants.MOD_ID));
    }
}
