package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.NeoForgeRegistryHelperService;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
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

        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyBuildingBlocksCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyNaturalBlockCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyIngredientsCreativeModeTab);
        eventBus.addListener(this::onBlockEntityTypeAddBlocks);

        Constants.LOG.info("Finished Initializing Nether & End");
    }

    private void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.SHELF, NetherAndEndBlocks.CHORUS_SHELF.block().get());
    }
}