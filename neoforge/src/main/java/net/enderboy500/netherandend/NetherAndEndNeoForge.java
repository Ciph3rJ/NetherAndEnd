package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.NeoForgeRegistryHelperService;
import net.enderboy500.netherandend.util.NeoForgeEvents;
import net.enderboy500.netherandend.util.ShulkerPearlDispenseBehavior;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

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
        });
    }
}