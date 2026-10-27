package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.options.NetherAndEndOptions;
import net.enderboy500.netherandend.util.NetherAndEndUtils;

public class NetherAndEndCommon {
    public static NetherAndEndOptions options;

    public static void init() {

        // TODO: Fix Icons not working
        // TODO: Do lang for all languages

        // DONE: Added Sterben and Perdurans effects
        // DONE: Changed textures of: all strider meats, all chorus blocks except for chorus block, warped stew, and hardened shulker pearl
        // DONE: Fixed Inconsistencies in shulker pearl

        NetherAndEndBlocks.loadBlocks();
        NetherAndEndItems.loadItems();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}