package net.enderboy500.netherandend.content;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class NeoForgeCreativeModeTabModifier {
    @SubscribeEvent
    public static void modifyBuildingBlocksCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(Items.NETHER_BRICK_FENCE.getDefaultInstance(), NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RED_NETHER_BRICKS.getDefaultInstance(), NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RED_NETHER_BRICK_WALL.getDefaultInstance(), NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.blockItem().get().getDefaultInstance(), NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @SubscribeEvent
    public static void modifyNaturalBlockCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(Items.BONE_BLOCK.getDefaultInstance(), NetherAndEndBlocks.WITHERED_BONE_BLOCK.blockItem().get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @SubscribeEvent
    public static void modifyIngredientsCreativeModeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.BONE_MEAL.getDefaultInstance(), NetherAndEndItems.WITHERED_BONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(NetherAndEndItems.WITHERED_BONE.get().getDefaultInstance(), NetherAndEndItems.WITHERED_BONE_MEAL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
