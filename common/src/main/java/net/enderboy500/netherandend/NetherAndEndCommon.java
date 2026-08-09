package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;

public class NetherAndEndCommon {
    // TODO: Redo BB Chorus Block Texture
    // TODO: Do Resource Pack Icons

    // DONE / FIXED

    // DONE: Swiss French
    // FIXED: Fix Warped Candle Cake Particle Position
    // DONE: New Withered Bone Meal -> Black Dye Recipe
    // FIXED: Fix cake eating when not hungry
    // DONE: Eat Warped Cake Statistic
    // FIXED: Fix Redstone Ores
    // DONE: Do BB Icon Textures
    // DONE: Do BB Warped Wart Block Textures
    // FIXED: Fixed inconsistencies and mistakes in Crimson Pie and Chorus Pie Textures + Crimson Icon Texture
    // DONE: Do BB Warped Cake Block Textures
    // DONE: BB Glowing Ores Pack
    // DONE: Do Lang For All New Stuff: Packs and Stat
    // FIXED: The French Translation for the "Double Wart" Advancement Description to change "Warped" to the appropriate words "Biscornu" and "Tordu" for Standard and Canadian French respectively
    // DONE: Withered bone meal dispenser behavior
    // FIXED: Mod Icon not showing in Mod Menu
    // FIXED: Chorus Shelf in specific states
    // FIXED: Cyan Nether Brick Fence Gate recipe output count from 3 -> 1
    // FIXED: Withered Bone -> Withered Bone Meal recipe now works
    // FIXED: Hoglin Bundle recipe is now shaped
    // FIXED: Warped Candle Cake not reducing durability for Flint & Steel and not destroying Fire Charge on lighting the candle

    public static void init() {
        NetherAndEndItems.loadItems();
        NetherAndEndBlocks.loadBlocks();
        NetherAndEndEntities.loadEntities();

        NetherAndEndUtils.loadUtils();
    }
}