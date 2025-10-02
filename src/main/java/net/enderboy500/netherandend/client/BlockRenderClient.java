package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class BlockRenderClient {
    public static void registerBlockCutOuts() {
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(NetherAndEndBlocks.CHORUS_TRAPDOOR, BlockRenderLayer.CUTOUT);
    }


    public static void loadBlockRenderer() {
        registerBlockCutOuts();
    }
}
