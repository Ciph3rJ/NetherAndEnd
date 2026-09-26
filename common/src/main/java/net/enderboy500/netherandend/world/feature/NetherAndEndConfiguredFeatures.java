package net.enderboy500.netherandend.world.feature;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class NetherAndEndConfiguredFeatures {
    public static final ResourceKey<Feature> NETHER_COAL_ORE_KEY = register("nether_coal_ore");
    public static final ResourceKey<Feature> NETHER_IRON_ORE_KEY = register("nether_iron_ore");
    public static final ResourceKey<Feature> NETHER_COPPER_ORE_KEY = register("nether_copper_ore");
    public static final ResourceKey<Feature> NETHER_REDSTONE_ORE_KEY = register("nether_redstone_ore");
    public static final ResourceKey<Feature> NETHER_EMERALD_ORE_KEY = register("nether_emerald_ore");
    public static final ResourceKey<Feature> NETHER_LAPIS_ORE_KEY = register("nether_lapis_ore");
    public static final ResourceKey<Feature> NETHER_DIAMOND_ORE_KEY = register("nether_diamond_ore");
    public static final ResourceKey<Feature> CRACKED_BEDROCK_KEY = register("cracked_bedrock");

    public static final ResourceKey<Feature> END_COAL_ORE_KEY = register("end_coal_ore");
    public static final ResourceKey<Feature> END_IRON_ORE_KEY = register("end_iron_ore");
    public static final ResourceKey<Feature> END_GOLD_ORE_KEY = register("end_gold_ore");
    public static final ResourceKey<Feature> END_COPPER_ORE_KEY = register("end_copper_ore");
    public static final ResourceKey<Feature> END_REDSTONE_ORE_KEY = register("end_redstone_ore");
    public static final ResourceKey<Feature> END_EMERALD_ORE_KEY = register("end_emerald_ore");
    public static final ResourceKey<Feature> END_LAPIS_ORE_KEY = register("end_lapis_ore");
    public static final ResourceKey<Feature> END_DIAMOND_ORE_KEY = register("end_diamond_ore");
    public static final ResourceKey<Feature> ENDER_PEARL_CLUSTER_KEY = register("ender_pearl_cluster");

    public static void boostrap(BootstrapContext<Feature> context) {
        RuleTest netherReplacables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest bedrockReplacables = new BlockMatchTest(Blocks.BEDROCK);

        List<BlockReplacement> netherCoalOres = List.of(
                BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_COAL_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherIronOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_IRON_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherCopperOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_COPPER_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherRedstoneOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_REDSTONE_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherEmeraldOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_EMERALD_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherLapisOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_LAPIS_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> netherDiamondOres =
                List.of(BlockReplacement.replace(netherReplacables, NetherAndEndBlocks.NETHER_DIAMOND_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> crackedBedrock =
                List.of(BlockReplacement.replace(bedrockReplacables, NetherAndEndBlocks.CRACKED_BEDROCK.block().get().defaultBlockState()));

        List<BlockReplacement> endCoalOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_COAL_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endIronOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_IRON_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endGoldOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_GOLD_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endCopperOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_COPPER_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endRedstoneOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_REDSTONE_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endEmeraldOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_EMERALD_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endLapisOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_LAPIS_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> endDiamondOres =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.END_DIAMOND_ORE.block().get().defaultBlockState()));
        List<BlockReplacement> enderPearlCluster =
                List.of(BlockReplacement.replace(endReplacables, NetherAndEndBlocks.ENDER_PEARL_CLUSTER.block().get().defaultBlockState()));

        context.register(NETHER_COAL_ORE_KEY, new OreFeature(netherCoalOres, 13));
        context.register(NETHER_IRON_ORE_KEY, new OreFeature(netherIronOres, 9));
        context.register(NETHER_COPPER_ORE_KEY, new OreFeature(netherCopperOres, 15));
        context.register(NETHER_REDSTONE_ORE_KEY, new OreFeature(netherRedstoneOres, 10));
        context.register(NETHER_EMERALD_ORE_KEY, new OreFeature(netherEmeraldOres, 4));
        context.register(NETHER_LAPIS_ORE_KEY, new OreFeature(netherLapisOres, 7));
        context.register(NETHER_DIAMOND_ORE_KEY, new OreFeature(netherDiamondOres, 8));
        context.register(CRACKED_BEDROCK_KEY, new OreFeature(crackedBedrock, 15));

        context.register(END_COAL_ORE_KEY, new OreFeature(endCoalOres, 16));
        context.register(END_IRON_ORE_KEY, new OreFeature(endIronOres, 10));
        context.register(END_COPPER_ORE_KEY, new OreFeature(endCopperOres, 15));
        context.register(END_GOLD_ORE_KEY, new OreFeature(endGoldOres, 11));
        context.register(END_REDSTONE_ORE_KEY, new OreFeature(endRedstoneOres, 11));
        context.register(END_EMERALD_ORE_KEY, new OreFeature(endEmeraldOres, 4));
        context.register(END_LAPIS_ORE_KEY, new OreFeature(endLapisOres, 7));
        context.register(END_DIAMOND_ORE_KEY, new OreFeature(endDiamondOres, 10));
        context.register(ENDER_PEARL_CLUSTER_KEY, new OreFeature(enderPearlCluster, 7));
    }

    private static ResourceKey<Feature> register(String id) {
        return ResourceKey.create(Registries.FEATURE, Constants.id(id));
    }
}
