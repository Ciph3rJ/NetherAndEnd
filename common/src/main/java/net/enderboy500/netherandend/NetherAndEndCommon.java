package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.enderboy500.netherandend.util.ShulkerPearlDispenseBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class NetherAndEndCommon {
    // TODO: Fix Warped Candle Cake Particle

    // Fixed the german translation of Raw Strider Meat from Rohos Schreiterfleisch -> Rohes Schreiterfleisch
    // Fixed the german translation of Instant Warping from Sofortige Verziehen -> Sofortige Verziehen
    // Fixed the german translation of Fruitful from Fruchtbar -> Erfolgreich
    // Fixed Nether Iron Ore drops
    // Fixed Silk Touch drops for all ores that were bugged

    public static void init() {
        NetherAndEndItems.loadItems();
        NetherAndEndBlocks.loadBlocks();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}