package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.client.services.ServicesClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforgespi.language.IConfigurable;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.IModLanguageLoader;
import net.neoforged.neoforgespi.locating.ForgeFeature;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class NetherAndEndNeoForgeClient {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        NetherAndEndCommonClient.init();

        ServicesClient.REGISTRY.applyEntityRendererRegistrations(event::registerEntityRenderer);
    }
}
