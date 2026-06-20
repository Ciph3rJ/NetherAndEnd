package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.util.NetherAndEndUtils;

public class NetherAndEndCommon {
    // TODO: Fix Warped Candle Cake Particle
    // TODO: Add support for Dutch, Italian, Polish, Swiss French, Swiss German, Swiss Italian, Pirate Speak
    // TODO: Add translation for resource packs
    // TODO: Dragon Charge Dispenser Behavior
    // TODO: Brewing Recipes

    // Fixed the german translation of Raw Strider Meat from Rohos Schreiterfleisch -> Rohes Schreiterfleisch
    // Fixed the german translation of Instant Warping from Sofortige Verziehen -> Sofortige Verziehen
    // Fixed the german translation of Fruitful from Fruchtbar -> Erfolgreich

    public static void init() {
        NetherAndEndItems.loadItems();
        NetherAndEndBlocks.loadBlocks();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}