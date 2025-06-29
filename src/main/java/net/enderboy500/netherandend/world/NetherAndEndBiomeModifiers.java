package net.enderboy500.netherandend.world;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.world.feature.NetherAndEndPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class NetherAndEndBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COAL_ORE = register("add_nether_coal_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON_ORE = register("add_nether_iron_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORE = register("add_nether_copper_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_REDSTONE_ORE = register("add_nether_redstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_EMERALD_ORE = register("add_nether_emerald_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_LAPIS_ORE = register("add_nether_lapis_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_DIAMOND_ORE = register("add_nether_diamond_ore");
    public static final ResourceKey<BiomeModifier> ADD_CRACKED_BEDROCK = register("add_cracked_bedrock");

    public static final ResourceKey<BiomeModifier> ADD_END_COAL_ORE = register("add_end_coal_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_IRON_ORE = register("add_end_iron_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_COPPER_ORE = register("add_end_copper_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_GOLD_ORE = register("add_end_gold_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_REDSTONE_ORE = register("add_end_redstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_EMERALD_ORE = register("add_end_emerald_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_LAPIS_ORE = register("add_end_lapis_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_DIAMOND_ORE = register("add_end_diamond_ore");
    public static final ResourceKey<BiomeModifier> ADD_ENDER_PEARL_CLUSTER = register("add_ender_pearl_cluster");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NETHER_COAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_COAL_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_IRON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_IRON_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_COPPER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_COPPER_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_REDSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_REDSTONE_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_EMERALD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_EMERALD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_LAPIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_LAPIS_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_DIAMOND_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.NETHER_DIAMOND_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_CRACKED_BEDROCK, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.CRACKED_BEDROCK_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_COAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_COAL_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_IRON_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_IRON_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_COPPER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_COPPER_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_GOLD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_GOLD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_REDSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_REDSTONE_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_EMERALD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_EMERALD_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_LAPIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_LAPIS_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_DIAMOND_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.END_DIAMOND_ORE_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_ENDER_PEARL_CLUSTER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(NetherAndEndPlacedFeatures.ENDER_PEARL_CLUSTER_PLACED_KEY)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, name));
    }
}
