package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.client.services.ServicesClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class NetherAndEndNeoForgeClient {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        NetherAndEndCommonClient.init();
        ServicesClient.REGISTRY.applyEntityRendererRegistrations(event::registerEntityRenderer);
    }
}
