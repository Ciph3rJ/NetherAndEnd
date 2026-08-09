package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.util.NetherAndEndUtils;

public class NetherAndEndCommon {
    public static void init() {
        // FIXED: Cracked Nether Bricks Recipe Not Working

        NetherAndEndItems.loadItems();
        NetherAndEndBlocks.loadBlocks();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}