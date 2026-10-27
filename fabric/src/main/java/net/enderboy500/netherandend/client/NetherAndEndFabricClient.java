package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.NetherAndEndFabric;
import net.enderboy500.netherandend.client.services.ServicesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class NetherAndEndFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NetherAndEndCommonClient.init();

        ParticleProviderRegistry.getInstance().register(NetherAndEndFabric.INVERTED_EYE, SpellParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(NetherAndEndFabric.STERBEN, SpellParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(NetherAndEndFabric.PERDANUS, SpellParticle.Provider::new);

        ServicesClient.REGISTRY.applyEntityRendererRegistrations(EntityRenderers::register);
    }
}
