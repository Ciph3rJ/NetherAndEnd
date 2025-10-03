package net.enderboy500.netherandend.data.providers;


import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public NetherAndEndBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(NetherAndEndTags.CHORUS)
                .add(NetherAndEndBlocks.CHORUS_BLOCK)
                .add(NetherAndEndBlocks.CHORUS_PLANKS)
                .add(NetherAndEndBlocks.CHORUS_STAIRS)
                .add(NetherAndEndBlocks.CHORUS_SLAB)
                .add(NetherAndEndBlocks.CHORUS_FENCE)
                .add(NetherAndEndBlocks.CHORUS_FENCE_GATE)
                .add(NetherAndEndBlocks.CHORUS_BUTTON)
                .add(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE)
                .add(NetherAndEndBlocks.CHORUS_DOOR)
                .add(NetherAndEndBlocks.CHORUS_TRAPDOOR)
        ;

        valueLookupBuilder(NetherAndEndTags.NETHER_ORES)
                .add(NetherAndEndBlocks.NETHER_COAL_ORE)
                .add(NetherAndEndBlocks.NETHER_IRON_ORE)
                .add(NetherAndEndBlocks.NETHER_COPPER_ORE)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(NetherAndEndBlocks.NETHER_REDSTONE_ORE)
                .add(NetherAndEndBlocks.NETHER_EMERALD_ORE)
                .add(NetherAndEndBlocks.NETHER_LAPIS_ORE)
                .add(NetherAndEndBlocks.NETHER_DIAMOND_ORE)
                .add(Blocks.NETHER_QUARTZ_ORE)
        ;

        valueLookupBuilder(NetherAndEndTags.END_ORES)
                .add(NetherAndEndBlocks.END_COAL_ORE)
                .add(NetherAndEndBlocks.END_IRON_ORE)
                .add(NetherAndEndBlocks.END_COPPER_ORE)
                .add(NetherAndEndBlocks.END_GOLD_ORE)
                .add(NetherAndEndBlocks.END_REDSTONE_ORE)
                .add(NetherAndEndBlocks.END_EMERALD_ORE)
                .add(NetherAndEndBlocks.END_LAPIS_ORE)
                .add(NetherAndEndBlocks.END_DIAMOND_ORE)
        ;

        valueLookupBuilder(BlockTags.COAL_ORES)
                .add(NetherAndEndBlocks.NETHER_COAL_ORE)
                .add(NetherAndEndBlocks.END_COAL_ORE)
        ;
        valueLookupBuilder(BlockTags.IRON_ORES)
                .add(NetherAndEndBlocks.NETHER_IRON_ORE)
                .add(NetherAndEndBlocks.END_IRON_ORE)
        ;
        valueLookupBuilder(BlockTags.COPPER_ORES)
                .add(NetherAndEndBlocks.NETHER_COPPER_ORE)
                .add(NetherAndEndBlocks.END_COPPER_ORE)
        ;
        valueLookupBuilder(BlockTags.GOLD_ORES)
                .add(NetherAndEndBlocks.END_GOLD_ORE)
        ;
        valueLookupBuilder(BlockTags.LAPIS_ORES)
                .add(NetherAndEndBlocks.NETHER_LAPIS_ORE)
                .add(NetherAndEndBlocks.END_LAPIS_ORE)
        ;
        valueLookupBuilder(BlockTags.EMERALD_ORES)
                .add(NetherAndEndBlocks.NETHER_EMERALD_ORE)
                .add(NetherAndEndBlocks.END_EMERALD_ORE)
        ;
        valueLookupBuilder(BlockTags.REDSTONE_ORES)
                .add(NetherAndEndBlocks.NETHER_REDSTONE_ORE)
                .add(NetherAndEndBlocks.END_REDSTONE_ORE)
        ;
        valueLookupBuilder(BlockTags.DIAMOND_ORES)
                .add(NetherAndEndBlocks.NETHER_DIAMOND_ORE)
                .add(NetherAndEndBlocks.END_DIAMOND_ORE)
        ;

        valueLookupBuilder(ConventionalBlockTags.ORES)
                .add(NetherAndEndBlocks.ENDER_PEARL_CLUSTER)
        ;
    }
}
