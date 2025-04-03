package net.enderboy500.netherandend.world;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class NetherAndEndPlacedFeatures {
    public static final RegistryKey<PlacedFeature> NETHER_COAL_ORE_PLACED_KEY = registryKey("nether_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_IRON_ORE_PLACED_KEY = registryKey("nether_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_COPPER_ORE_PLACED_KEY = registryKey("nether_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_REDSTONE_ORE_PLACED_KEY = registryKey("nether_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_EMERALD_ORE_PLACED_KEY = registryKey("nether_emerald_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_LAPIS_ORE_PLACED_KEY = registryKey("nether_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_DIAMOND_ORE_PLACED_KEY = registryKey("nether_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> CRACKED_BEDROCK_PLACED_KEY = registryKey("cracked_bedrock_placed");

    public static final RegistryKey<PlacedFeature> END_COAL_ORE_PLACED_KEY = registryKey("end_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> END_IRON_ORE_PLACED_KEY = registryKey("end_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> END_COPPER_ORE_PLACED_KEY = registryKey("end_copper_ore_placed");
    public static final RegistryKey<PlacedFeature> END_GOLD_ORE_PLACED_KEY = registryKey("end_gold_ore_placed");
    public static final RegistryKey<PlacedFeature> END_REDSTONE_ORE_PLACED_KEY = registryKey("end_redstone_ore_placed");
    public static final RegistryKey<PlacedFeature> END_EMERALD_ORE_PLACED_KEY = registryKey("end_emerald_ore_placed");
    public static final RegistryKey<PlacedFeature> END_LAPIS_ORE_PLACED_KEY = registryKey("end_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> END_DIAMOND_ORE_PLACED_KEY = registryKey("end_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> ENDER_PEARL_CLUSTER_PLACED_KEY = registryKey("ender_pearl_cluster_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, NETHER_COAL_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_COAL_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-115), YOffset.fixed(130))));
        register(context, NETHER_IRON_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_IRON_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(8,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-30), YOffset.fixed(100))));
        register(context, NETHER_COPPER_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_COPPER_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-30), YOffset.fixed(90))));
        register(context, NETHER_REDSTONE_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_REDSTONE_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(100))));
        register(context, NETHER_EMERALD_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_EMERALD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(1,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(10))));
        register(context, NETHER_LAPIS_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_LAPIS_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(6,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(7), YOffset.fixed(60))));
        register(context, NETHER_DIAMOND_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.NETHER_DIAMOND_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(128))));
        /*register(context, CRACKED_BEDROCK_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CRACKED_BEDROCK_KEY),
                ModPlacementModifiers.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(3), YOffset.fixed(130))));*/

        register(context, END_COAL_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_COAL_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-115), YOffset.fixed(130))));
        register(context, END_IRON_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_IRON_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(100))));
        register(context, END_COPPER_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_COPPER_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-30), YOffset.fixed(90))));
        register(context, END_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_GOLD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(200))));
        register(context, END_REDSTONE_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_REDSTONE_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(100))));
        register(context, END_EMERALD_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_EMERALD_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(1,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(40))));
        register(context, END_LAPIS_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_LAPIS_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(7), YOffset.fixed(60))));
        register(context, END_DIAMOND_ORE_PLACED_KEY ,configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.END_DIAMOND_ORE_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(60))));
        register(context, ENDER_PEARL_CLUSTER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(NetherAndEndConfiguredFeatures.ENDER_PEARL_CLUSTER_KEY),
                NetherAndEndPlacementModifiers.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NetherAndEnd.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configured,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configured, List.copyOf(modifiers)));
    }
}
