package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.client.services.ServicesClient;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class NetherAndEndFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NetherAndEndCommonClient.init();

        ServicesClient.REGISTRY.applyEntityRendererRegistrations(EntityRenderers::register);
    }
}
