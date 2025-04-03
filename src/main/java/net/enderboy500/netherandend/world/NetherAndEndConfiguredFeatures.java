package net.enderboy500.netherandend.world;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class NetherAndEndConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = register("nether_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = register("nether_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = register("nether_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE_KEY = register("nether_redstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = register("nether_emerald_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_LAPIS_ORE_KEY = register("nether_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = register("nether_diamond_ore");
//    public static final RegistryKey<ConfiguredFeature<?,?>> CRACKED_BEDROCK_KEY = registryKey("cracked_bedrock");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_COAL_ORE_KEY = register("end_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_IRON_ORE_KEY = register("end_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_GOLD_ORE_KEY = register("end_gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_COPPER_ORE_KEY = register("end_copper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_REDSTONE_ORE_KEY = register("end_redstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_EMERALD_ORE_KEY = register("end_emerald_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_LAPIS_ORE_KEY = register("end_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_DIAMOND_ORE_KEY = register("end_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_PEARL_CLUSTER_KEY = register("ender_pearl_cluster");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);
//        RuleTest bedrockReplacables = new BlockMatchRuleTest(Blocks.BEDROCK);

        List<OreFeatureConfig.Target> netherCoalOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_COAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherIronOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherCopperOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherRedstoneOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_REDSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherEmeraldOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_EMERALD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherLapisOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherDiamondOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, NetherAndEndBlocks.NETHER_DIAMOND_ORE.getDefaultState()));
//        List<OreFeatureConfig.Target> crackedBedrock =
//                List.of(OreFeatureConfig.createTarget(bedrockReplacables, ModBlocks.CRACKED_BEDROCK.getDefaultState()));

        List<OreFeatureConfig.Target> endCoalOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_COAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endIronOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endGoldOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endCopperOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endRedstoneOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_REDSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endEmeraldOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_EMERALD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endLapisOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endDiamondOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.END_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> enderPearlCluster =
                List.of(OreFeatureConfig.createTarget(endReplacables, NetherAndEndBlocks.ENDER_PEARL_CLUSTER.getDefaultState()));

        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCoalOres, 19));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherIronOres, 10));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCopperOres, 20));
        register(context, NETHER_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRedstoneOres, 10));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherEmeraldOres, 4));
        register(context, NETHER_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherLapisOres, 9));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherDiamondOres, 8));
//        register(context, CRACKED_BEDROCK_KEY, Feature.ORE, new OreFeatureConfig(crackedBedrock, 15));

        register(context, END_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCoalOres, 19));
        register(context, END_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(endIronOres, 10));
        register(context, END_COPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCopperOres, 15));
        register(context, END_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(endGoldOres, 11));
        register(context, END_REDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRedstoneOres, 10));
        register(context, END_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(endEmeraldOres, 4));
        register(context, END_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(endLapisOres, 9));
        register(context, END_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(endDiamondOres, 8));
        register(context, ENDER_PEARL_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(enderPearlCluster, 7));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> register(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(NetherAndEnd.MOD_ID, id));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature, FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
