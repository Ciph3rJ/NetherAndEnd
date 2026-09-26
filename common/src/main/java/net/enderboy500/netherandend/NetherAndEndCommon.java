package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class NetherAndEndCommon {
    public static void init() {
        // TODO: Fix Icons not working

        // DONE: Make Crumbling Basalt act like Magma Blocks in Sulfur Cubes
        // FIXED: Farmer's Delight Compatibility
        // FIXED: Burnt Strider Meat is now obtainable and it's advancement now works
        // FIXED: Hoglins didn't drop porkchop

        NetherAndEndBlocks.loadBlocks();
        NetherAndEndItems.loadItems();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}