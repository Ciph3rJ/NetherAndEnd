package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndUtils;

public class NetherAndEndCommon {
    // TODO: Fix Warped Candle Cake Particle

    public static void init() {
        NetherAndEndItems.loadItems();
        NetherAndEndBlocks.loadBlocks();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}