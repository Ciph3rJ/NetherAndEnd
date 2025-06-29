package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(NetherAndEnd.MOD_ID)
public class NetherAndEnd {
    public static final String MOD_ID = "netherandend";

    private static final Logger LOGGER = LogUtils.getLogger();

    public NetherAndEnd(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        LOGGER.info("Initializing NetherAndEnd");

        NetherAndEndBlocks.loadBlocks(modEventBus);
        NetherAndEndBlockItems.loadBlockItems(modEventBus);

        NetherAndEndEntities.loadEntities(modEventBus);

        NetherAndEndItems.loadItems(modEventBus);

        NetherAndEndCreativeModeTabs.loadCreativeModeTabs(modEventBus);

        NetherAndEndUtils.loadUtils(modEventBus);

        LOGGER.info("Finished Initializing NetherAndEnd");

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(NetherAndEndEntities.DRAGON_CHARGE.get(), ThrownItemRenderer::new);
        }
    }
}
