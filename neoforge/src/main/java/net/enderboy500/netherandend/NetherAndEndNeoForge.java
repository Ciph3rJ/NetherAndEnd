package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.NeoForgeRegistryHelperService;
import net.enderboy500.netherandend.util.NeoForgeEvents;
import net.enderboy500.netherandend.util.dispenser.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.util.dispenser.WitheredBoneMealDispenseBehavior;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Constants.MOD_ID)
public class NetherAndEndNeoForge {
    public NetherAndEndNeoForge(IEventBus eventBus) {
        Constants.LOG.info("Initializing Nether & End");

        NetherAndEndCommon.init();

        NeoForgeRegistryHelperService.register(eventBus);

        NeoForgeBlocks.loadBlocks();
        NeoForgePotions.loadPotions(eventBus);
        NeoForgeMobEffects.loadEffects(eventBus);
        NeoForgeCreativeModeTab.loadCreativeModeTab(eventBus);

        eventBus.addListener(this::commonSetup);

        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyBuildingBlocksCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyNaturalBlockCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyIngredientsCreativeModeTab);
        eventBus.addListener(NeoForgeEvents::addBuiltInPacks);
        eventBus.addListener(NeoForgeEvents::onBlockEntityTypeAddBlocks);

        Constants.LOG.info("Finished Initializing Nether & End");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE.get());
            DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL.get(), new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL.get()));
            DispenserBlock.registerBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get(), new WitheredBoneMealDispenseBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get()));
        });
    }
}