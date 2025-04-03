package net.enderboy500.netherandend.datagen.providers;


import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public NetherAndEndBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(NetherAndEndTags.NETHER_ORES)
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
    }
}
