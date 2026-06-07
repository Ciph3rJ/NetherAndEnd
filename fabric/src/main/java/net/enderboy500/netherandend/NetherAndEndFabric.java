package net.enderboy500.netherandend;

import net.enderboy500.netherandend.compat.NEFDRFCompat;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.Services;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;

import java.util.Objects;

public class NetherAndEndFabric implements ModInitializer {
    public static final GameRule<Boolean> DISABLE_ELYTRA = GameRules.registerBoolean("disable_elytras", GameRuleCategory.PLAYER, false);

    @Override
    public void onInitialize() {
        Constants.LOG.info("Initializing Nether & End");

        NetherAndEndCommon.init();
        BlockEntityType.SHELF.addValidBlock(NetherAndEndBlocks.CHORUS_SHELF.block().get());

        FabricBlocks.loadBlocks();
        FabricPotions.loadPotions();
        FabricMobEffects.loadMobEffects();
        FabricCreativeModeTab.loadCreativeModeTab();
        FabricCreativeModeTabModifier.loadCreativeModeTabModifier();

        if (Services.PLATFORM.isModLoaded("farmersdelight")) NEFDRFCompat.loadNEFDRFCompat();

        Constants.LOG.info("Finished Initializing Nether & End");
    }
}
