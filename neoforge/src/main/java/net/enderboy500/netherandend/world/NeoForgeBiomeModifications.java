package net.enderboy500.netherandend.world;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class NeoForgeBiomeModifications {
    public static final ResourceKey<BiomeModifier> NETHER_COAL_ORE = register("nether_coal_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_IRON_ORE = register("nether_iron_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_COPPER_ORE = register("nether_copper_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_REDSTONE_ORE = register("nether_redstone_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_EMERALD_ORE = register("nether_emerald_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_LAPIS_ORE = register("nether_lapis_ore_placed");
    public static final ResourceKey<BiomeModifier> NETHER_DIAMOND_ORE = register("nether_diamond_ore_placed");
    public static final ResourceKey<BiomeModifier> CRACKED_BEDROCK = register("cracked_bedrock_placed");

    public static final ResourceKey<BiomeModifier> END_COAL_ORE = register("end_coal_ore_placed");
    public static final ResourceKey<BiomeModifier> END_IRON_ORE = register("end_iron_ore_placed");
    public static final ResourceKey<BiomeModifier> END_COPPER_ORE = register("end_copper_ore_placed");
    public static final ResourceKey<BiomeModifier> END_GOLD_ORE = register("end_gold_ore_placed");
    public static final ResourceKey<BiomeModifier> END_REDSTONE_ORE = register("end_redstone_ore_placed");
    public static final ResourceKey<BiomeModifier> END_EMERALD_ORE = register("end_emerald_ore_placed");
    public static final ResourceKey<BiomeModifier> END_LAPIS_ORE = register("end_lapis_ore_placed");
    public static final ResourceKey<BiomeModifier> END_DIAMOND_ORE = register("end_diamond_ore_placed");
    public static final ResourceKey<BiomeModifier> ENDER_PEARL_CLUSTER = register("ender_pearl_cluster_placed");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(NETHER_COAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_COAL_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_IRON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_IRON_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_COPPER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_COPPER_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_REDSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_REDSTONE_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_EMERALD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_EMERALD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_LAPIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_LAPIS_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(NETHER_DIAMOND_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_DIAMOND_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(CRACKED_BEDROCK, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.CRACKED_BEDROCK_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(END_COAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_COAL_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_IRON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_IRON_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_COPPER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_COPPER_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_GOLD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_GOLD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_REDSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_REDSTONE_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_EMERALD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_EMERALD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_LAPIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_LAPIS_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(END_DIAMOND_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_DIAMOND_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ENDER_PEARL_CLUSTER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.ENDER_PEARL_CLUSTER_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Constants.id(name));
    }
}
