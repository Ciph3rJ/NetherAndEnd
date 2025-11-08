package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class EntityRenderClient {
    public static void registerEntityRenderer() {
        EntityRendererRegistry.register(NetherAndEndEntities.DRAGON_CHARGE, ThrownItemRenderer::new);
    }

    public static void loadEntityRenderer() {
        registerEntityRenderer();
    }
}
