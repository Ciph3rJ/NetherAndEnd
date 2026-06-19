package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class BlockRenderClient {
    public static void registerBlockCutOuts() {
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.WARPED_WART, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_TRAPDOOR, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, NetherAndEndBlocks.NETHER_COAL_ORE, NetherAndEndBlocks.NETHER_IRON_ORE, NetherAndEndBlocks.NETHER_COPPER_ORE,
                NetherAndEndBlocks.NETHER_REDSTONE_ORE, NetherAndEndBlocks.NETHER_EMERALD_ORE, NetherAndEndBlocks.NETHER_LAPIS_ORE, NetherAndEndBlocks.NETHER_DIAMOND_ORE,
                NetherAndEndBlocks.CRACKED_BEDROCK, NetherAndEndBlocks.CRUMBLING_BASALT, NetherAndEndBlocks.END_COAL_ORE, NetherAndEndBlocks.END_IRON_ORE,
                NetherAndEndBlocks.END_COPPER_ORE, NetherAndEndBlocks.END_GOLD_ORE, NetherAndEndBlocks.END_REDSTONE_ORE, NetherAndEndBlocks.END_EMERALD_ORE,
                NetherAndEndBlocks.END_LAPIS_ORE, NetherAndEndBlocks.END_DIAMOND_ORE, NetherAndEndBlocks.ENDER_PEARL_CLUSTER);
    }


    public static void loadBlockRenderer() {
        registerBlockCutOuts();
    }
}
