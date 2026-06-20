package net.enderboy500.netherandend.world;

import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FabricBiomeModifications {
    public static void oreGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_COAL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_IRON_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_COPPER_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_REDSTONE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_EMERALD_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_LAPIS_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.NETHER_DIAMOND_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.CRACKED_BEDROCK_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_COAL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_IRON_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_COPPER_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_REDSTONE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_EMERALD_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_LAPIS_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.END_DIAMOND_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, NetherAndEndPlacedFeatures.ENDER_PEARL_CLUSTER_PLACED_KEY);
    }

    public static void loadBiomeModifications() {
        oreGeneration();
    }
}
