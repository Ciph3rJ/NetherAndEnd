package net.enderboy500.netherandend.content;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class NetherAndEndItemGroupModifiers {
    private static void modifyBuildingBlocksItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.NETHER_BRICK_FENCE, NetherAndEndBlockItems.NETHER_BRICK_FENCE_GATE);
            entries.addAfter(Items.RED_NETHER_BRICKS, NetherAndEndBlockItems.CRACKED_RED_NETHER_BRICKS);
            entries.addAfter(Items.RED_NETHER_BRICK_WALL, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE);
            entries.addAfter(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE_GATE);
            entries.addAfter(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE_GATE, NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS);
            entries.addAfter(NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CRACKED_CYAN_NETHER_BRICKS);
            entries.addAfter(NetherAndEndBlockItems.CRACKED_CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB, NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE_GATE);
            entries.addAfter(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE_GATE, NetherAndEndBlockItems.CHISELED_CYAN_NETHER_BRICKS);
        });
    }

    public static void loadItemGroupModifiers() {
        modifyBuildingBlocksItemGroup();
    }
}
