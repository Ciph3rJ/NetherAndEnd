package net.enderboy500.netherandend.client;

import net.fabricmc.api.ClientModInitializer;

public class NetherAndEndClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderClient.loadBlockRenderer();
        EntityRenderClient.loadEntityRenderer();
    }
}
