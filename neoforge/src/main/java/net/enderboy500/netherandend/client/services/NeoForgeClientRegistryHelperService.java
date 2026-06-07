package net.enderboy500.netherandend.client.services;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class NeoForgeClientRegistryHelperService implements ClientRegistryHelperService {
    private final List<EntityRendererEntry<?>> ENTITY_RENDERERS = new ArrayList<>();

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<T> type, EntityRendererProvider<T> provider) {
        this.ENTITY_RENDERERS.add(new EntityRendererEntry<>(type, provider));
    }

    @Override
    public void applyEntityRendererRegistrations(EntityRendererRegistrar registrar) {
        for (EntityRendererEntry<?> entry : this.ENTITY_RENDERERS) {
            entry.register(registrar);
        }
    }

    private record EntityRendererEntry<T extends Entity>(EntityType<T> type, EntityRendererProvider<T> provider) {
        private void register(EntityRendererRegistrar registrar) {
            registrar.register(this.type, this.provider);
        }
    }
}
