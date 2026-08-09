package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.NeoForgePotions;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class NeoForgeEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD, NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), NeoForgePotions.AVERSION_POTION);
        
        event.getBuilder().addMix(Potions.AWKWARD, Items.NETHER_WART, NeoForgePotions.MALNOURISHMENT_POTION);
        event.getBuilder().addMix(NeoForgePotions.MALNOURISHMENT_POTION, Items.REDSTONE, NeoForgePotions.LONG_MALNOURISHMENT_POTION);
        event.getBuilder().addMix(NeoForgePotions.MALNOURISHMENT_POTION, Items.GLOWSTONE_DUST, NeoForgePotions.STRONG_MALNOURISHMENT_POTION);

        event.getBuilder().addMix(Potions.AWKWARD, NetherAndEndBlocks.WARPED_WART.blockItem().get(), NeoForgePotions.SICKNESS_POTION);
        event.getBuilder().addMix(NeoForgePotions.SICKNESS_POTION, Items.REDSTONE, NeoForgePotions.LONG_SICKNESS_POTION);
        event.getBuilder().addMix(NeoForgePotions.SICKNESS_POTION, Items.GLOWSTONE_DUST, NeoForgePotions.STRONG_SICKNESS_POTION);

        event.getBuilder().addMix(Potions.AWKWARD, NetherAndEndItems.SHULKER_PEARL.get(), NeoForgePotions.BUOYANT_POTION);
        event.getBuilder().addMix(NeoForgePotions.BUOYANT_POTION, Items.REDSTONE, NeoForgePotions.LONG_BUOYANT_POTION);
        event.getBuilder().addMix(NeoForgePotions.BUOYANT_POTION, Items.GLOWSTONE_DUST, NeoForgePotions.STRONG_BUOYANT_POTION);

        event.getBuilder().addMix(Potions.AWKWARD, Items.WITHER_ROSE, NeoForgePotions.DECAY_POTION);
        event.getBuilder().addMix(NeoForgePotions.DECAY_POTION, Items.REDSTONE, NeoForgePotions.LONG_DECAY_POTION);
        event.getBuilder().addMix(NeoForgePotions.DECAY_POTION, Items.GLOWSTONE_DUST, NeoForgePotions.STRONG_DECAY_POTION);

        event.getBuilder().addMix(NeoForgePotions.SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NeoForgePotions.INSTANT_CURING_POTION);
        event.getBuilder().addMix(NeoForgePotions.LONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NeoForgePotions.INSTANT_CURING_POTION);
        event.getBuilder().addMix(NeoForgePotions.STRONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NeoForgePotions.INSTANT_CURING_POTION);

        event.getBuilder().addMix(Potions.AWKWARD, NetherAndEndItems.ENDER_FRUIT.get(), NeoForgePotions.INSTANT_WARPING_POTION);

        event.getBuilder().addMix(Potions.AWKWARD, Items.ENDER_EYE, NeoForgePotions.ENDERSIGHT_POTION);
    }

    public static void addBuiltInPacks(AddPackFindersEvent event) {
        event.addPackFinders(Constants.id("resourcepacks/glowing_ores"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.glowing_ores.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(Constants.id("resourcepacks/ore_borders"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.ore_borders.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(Constants.id("resourcepacks/glowing_ore_borders"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.glowing_ore_borders.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(Constants.id("resourcepacks/alternate_cracked_bedrock"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.alternate_cracked_bedrock.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(Constants.id("resourcepacks/bare_bones"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.bare_bones.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(Constants.id("resourcepacks/bare_bones_glowing_ores"), PackType.CLIENT_RESOURCES, Component.translatable("resourcePack.netherandend.bare_bones_glowing_ores.name"), PackSource.BUILT_IN, false, Pack.Position.TOP);
    }

    public static void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityTypes.SHELF, NetherAndEndBlocks.CHORUS_SHELF.block().get());
    }
}
