package net.enderboy500.netherandend.content;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class NetherAndEndCreativeModeTabModifiers {
    private static void modifyBuildingBlocksCreativeModeTab() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.insertAfter(Items.NETHER_BRICK_FENCE, NetherAndEndBlockItems.NETHER_BRICK_FENCE_GATE);
            entries.insertAfter(Items.RED_NETHER_BRICKS, NetherAndEndBlockItems.CRACKED_RED_NETHER_BRICKS);
            entries.insertAfter(Items.RED_NETHER_BRICK_WALL, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE);
            entries.insertAfter(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE_GATE);
            entries.insertAfter(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE_GATE, NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS);
            entries.insertAfter(NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CRACKED_CYAN_NETHER_BRICKS);
            entries.insertAfter(NetherAndEndBlockItems.CRACKED_CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB, NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE_GATE);
            entries.insertAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE_GATE, NetherAndEndBlockItems.CHISELED_CYAN_NETHER_BRICKS);
        });
    }

    public static void loadCreativeModeTabModifiers() {
        modifyBuildingBlocksCreativeModeTab();
    }
}
