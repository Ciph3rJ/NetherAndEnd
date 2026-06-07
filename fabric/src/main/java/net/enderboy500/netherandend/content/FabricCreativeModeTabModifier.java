package net.enderboy500.netherandend.content;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class FabricCreativeModeTabModifier {
    private static void modifyBuildingBlocksCreativeModeTab() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.insertAfter(Items.NETHER_BRICK_FENCE, NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.blockItem().get());    
            entries.insertAfter(Items.RED_NETHER_BRICKS, NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS.blockItem().get());
            entries.insertAfter(Items.RED_NETHER_BRICK_WALL, NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.blockItem().get(), NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.blockItem().get(), NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.blockItem().get(), NetherAndEndBlocks.CYAN_NETHER_BRICKS.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICKS.blockItem().get(), NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get());
/*            entries.insertAfter(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS);
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS, NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB);*/
            entries.insertAfter(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get(), NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.blockItem().get(), NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.blockItem().get(), NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.blockItem().get(), NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.blockItem().get());
            entries.insertAfter(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.blockItem().get(), NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.blockItem().get());
        });
    }

    private static void modifyNaturalBlockCreativeModeTab() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.insertAfter(Items.BONE_BLOCK, NetherAndEndBlocks.WITHERED_BONE_BLOCK.blockItem().get());
        });
    }

    private static void modifyIngredientsCreativeModeTab() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.insertAfter(Items.BONE_MEAL, NetherAndEndItems.WITHERED_BONE.get());
            entries.insertAfter(NetherAndEndItems.WITHERED_BONE.get(), NetherAndEndItems.WITHERED_BONE_MEAL.get());
        });
    }

    public static void loadCreativeModeTabModifier() {
        modifyBuildingBlocksCreativeModeTab();
        modifyNaturalBlockCreativeModeTab();
        modifyIngredientsCreativeModeTab();
    }
}
