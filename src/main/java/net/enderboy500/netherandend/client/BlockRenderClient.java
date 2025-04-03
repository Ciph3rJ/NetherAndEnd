package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BlockRenderClient {
    public static void registerBlockRenderer() {
        BlockRenderLayerMap.INSTANCE.putBlock(NetherAndEndBlocks.CHORUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NetherAndEndBlocks.CHORUS_TRAPDOOR, RenderLayer.getCutout());
    }

    public static void loadBlockRenderer() {registerBlockRenderer();}
}
