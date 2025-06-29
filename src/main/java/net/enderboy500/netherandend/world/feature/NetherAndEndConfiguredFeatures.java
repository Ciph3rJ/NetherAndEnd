package net.enderboy500.netherandend.world.feature;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class NetherAndEndConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = register("nether_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = register("nether_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = register("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE_KEY = register("nether_redstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = register("nether_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LAPIS_ORE_KEY = register("nether_lapis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = register("nether_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRACKED_BEDROCK_KEY = register("cracked_bedrock");

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_COAL_ORE_KEY = register("end_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_IRON_ORE_KEY = register("end_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_COPPER_ORE_KEY = register("end_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_GOLD_ORE_KEY = register("end_gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_REDSTONE_ORE_KEY = register("end_redstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_EMERALD_ORE_KEY = register("end_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_LAPIS_ORE_KEY = register("end_lapis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_DIAMOND_ORE_KEY = register("end_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDER_PEARL_CLUSTER_KEY = register("ender_pearl_cluster");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest bedrockReplaceables = new BlockMatchTest(Blocks.BEDROCK);

        List<OreConfiguration.TargetBlockState> netherCoalOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_COAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherIronOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_IRON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherCopperOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_COPPER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherRedstoneOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_REDSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherEmeraldOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_EMERALD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherLapisOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_LAPIS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherDiamondOres = List.of(OreConfiguration.target(netherrackReplaceables, NetherAndEndBlocks.NETHER_DIAMOND_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> crackedBedrock = List.of(OreConfiguration.target(bedrockReplaceables, NetherAndEndBlocks.CRACKED_BEDROCK.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endCoalOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_COAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endIronOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_IRON_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endCopperOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_COPPER_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endGoldOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_GOLD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endRedstoneOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_REDSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endEmeraldOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_EMERALD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endLapisOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_LAPIS_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endDiamondOres = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.END_DIAMOND_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> enderPearlClusters = List.of(OreConfiguration.target(endStoneReplaceables, NetherAndEndBlocks.ENDER_PEARL_CLUSTER.get().defaultBlockState()));


        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherCoalOres, 19));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(netherIronOres, 10));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(netherCopperOres, 20));
        register(context, NETHER_REDSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(netherRedstoneOres, 10));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreConfiguration(netherEmeraldOres, 4));
        register(context, NETHER_LAPIS_ORE_KEY, Feature.ORE, new OreConfiguration(netherLapisOres, 9));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, new OreConfiguration(netherDiamondOres, 8));
        register(context, CRACKED_BEDROCK_KEY, Feature.ORE, new OreConfiguration(crackedBedrock, 15));

        register(context, END_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(endCoalOres, 19));
        register(context, END_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(endIronOres, 10));
        register(context, END_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(endCopperOres, 15));
        register(context, END_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(endGoldOres, 11));
        register(context, END_REDSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(endRedstoneOres, 10));
        register(context, END_EMERALD_ORE_KEY, Feature.ORE, new OreConfiguration(endEmeraldOres, 4));
        register(context, END_LAPIS_ORE_KEY, Feature.ORE, new OreConfiguration(endLapisOres, 9));
        register(context, END_DIAMOND_ORE_KEY, Feature.ORE, new OreConfiguration(endDiamondOres, 8));
        register(context, ENDER_PEARL_CLUSTER_KEY, Feature.ORE, new OreConfiguration(enderPearlClusters, 7));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> register(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
