package net.enderboy500.netherandend.client.services;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public interface ClientRegistryHelperService {
    <T extends Entity> void registerEntityRenderer(EntityType<T> type, EntityRendererProvider<T> provider);

    void applyEntityRendererRegistrations(EntityRendererRegistrar registrar);

    interface EntityRendererRegistrar {
        <T extends Entity> void register(EntityType<T> type, EntityRendererProvider<T> provider);
    }
}
