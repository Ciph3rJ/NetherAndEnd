package net.enderboy500.netherandend.world.feature;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class NetherAndEndPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NETHER_COAL_ORE_PLACED_KEY = register("nether_coal_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_ORE_PLACED_KEY = register("nether_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED_KEY = register("nether_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_REDSTONE_ORE_PLACED_KEY = register("nether_redstone_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_EMERALD_ORE_PLACED_KEY = register("nether_emerald_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LAPIS_ORE_PLACED_KEY = register("nether_lapis_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND_ORE_PLACED_KEY = register("nether_diamond_ore_placed");
    public static final ResourceKey<PlacedFeature> CRACKED_BEDROCK_PLACED_KEY = register("cracked_bedrock_placed");

    public static final ResourceKey<PlacedFeature> END_COAL_ORE_PLACED_KEY = register("end_coal_ore_placed");
    public static final ResourceKey<PlacedFeature> END_IRON_ORE_PLACED_KEY = register("end_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> END_COPPER_ORE_PLACED_KEY = register("end_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> END_GOLD_ORE_PLACED_KEY = register("end_gold_ore_placed");
    public static final ResourceKey<PlacedFeature> END_REDSTONE_ORE_PLACED_KEY = register("end_redstone_ore_placed");
    public static final ResourceKey<PlacedFeature> END_EMERALD_ORE_PLACED_KEY = register("end_emerald_ore_placed");
    public static final ResourceKey<PlacedFeature> END_LAPIS_ORE_PLACED_KEY = register("end_lapis_ore_placed");
    public static final ResourceKey<PlacedFeature> END_DIAMOND_ORE_PLACED_KEY = register("end_diamond_ore_placed");
    public static final ResourceKey<PlacedFeature> ENDER_PEARL_CLUSTER_PLACED_KEY = register("ender_pearl_cluster_placed");

    public static void boostrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureRegistryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NETHER_COAL_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_COAL_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-115), VerticalAnchor.absolute(130))));
        register(context, NETHER_IRON_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_IRON_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(100))));
        register(context, NETHER_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_COPPER_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(90))));
        register(context, NETHER_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_REDSTONE_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        register(context, NETHER_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_EMERALD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(1,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(10))));
        register(context, NETHER_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_LAPIS_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(7), VerticalAnchor.absolute(60))));
        register(context, NETHER_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_DIAMOND_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));
        register(context, CRACKED_BEDROCK_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.CRACKED_BEDROCK_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(2,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(3), VerticalAnchor.absolute(130))));

        register(context, END_COAL_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_COAL_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-115), VerticalAnchor.absolute(130))));
        register(context, END_IRON_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_IRON_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(100))));
        register(context, END_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_COPPER_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(90))));
        register(context, END_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_GOLD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(200))));
        register(context, END_REDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_REDSTONE_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        register(context, END_EMERALD_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_EMERALD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(1,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(40))));
        register(context, END_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_LAPIS_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(7), VerticalAnchor.absolute(60))));
        register(context, END_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_DIAMOND_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        register(context, ENDER_PEARL_CLUSTER_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow(NetherAndEndConfiguredFeatures.ENDER_PEARL_CLUSTER_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));
    }

    public static ResourceKey<PlacedFeature> register(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, id));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configured,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configured, List.copyOf(modifiers)));
    }
}
