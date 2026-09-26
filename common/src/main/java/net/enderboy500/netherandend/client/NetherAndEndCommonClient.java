package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.client.services.ServicesClient;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class NetherAndEndCommonClient {
    private static boolean initialized;

    public static void init() {
        if (initialized) return;
        initialized = true;

        ServicesClient.REGISTRY.registerEntityRenderer(NetherAndEndEntities.DRAGON_CHARGE.get(), ThrownItemRenderer::new);
    }
}
