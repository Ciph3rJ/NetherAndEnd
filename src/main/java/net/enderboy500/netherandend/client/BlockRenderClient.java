package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class BlockRenderClient {
    public static void registerBlockCutOuts() {
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.WARPED_WART, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_TRAPDOOR, ChunkSectionLayer.CUTOUT);
    }


    public static void loadBlockRenderer() {
        registerBlockCutOuts();
    }
}
