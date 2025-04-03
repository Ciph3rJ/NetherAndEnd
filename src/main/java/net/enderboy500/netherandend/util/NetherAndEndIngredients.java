package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;

public class NetherAndEndIngredients {
    public static final Ingredient RAW_HOGCHOP = register(NetherAndEndItems.RAW_HOGCHOP);

    public static final Ingredient RAW_STRIDER_MEAT = register(NetherAndEndItems.RAW_STRIDER_MEAT);
    public static final Ingredient COOKED_STRIDER_MEAT = register(NetherAndEndItems.COOKED_STRIDER_MEAT);
    public static final Ingredient SMOKED_STRIDER_MEAT = register(NetherAndEndItems.SMOKED_STRIDER_MEAT);

    public static final Ingredient NETHER_COAL_ORE = register(NetherAndEndBlockItems.NETHER_COAL_ORE);
    public static final Ingredient NETHER_IRON_ORE = register(NetherAndEndBlockItems.NETHER_IRON_ORE);
    public static final Ingredient NETHER_COPPER_ORE = register(NetherAndEndBlockItems.NETHER_COPPER_ORE);
    public static final Ingredient NETHER_REDSTONE_ORE = register(NetherAndEndBlockItems.NETHER_REDSTONE_ORE);
    public static final Ingredient NETHER_EMERALD_ORE = register(NetherAndEndBlockItems.NETHER_EMERALD_ORE);
    public static final Ingredient NETHER_LAPIS_ORE = register(NetherAndEndBlockItems.NETHER_LAPIS_ORE);
    public static final Ingredient NETHER_DIAMOND_ORE = register(NetherAndEndBlockItems.NETHER_DIAMOND_ORE);

    public static final Ingredient END_COAL_ORE = register(NetherAndEndBlockItems.END_COAL_ORE);
    public static final Ingredient END_IRON_ORE = register(NetherAndEndBlockItems.END_IRON_ORE);
    public static final Ingredient END_COPPER_ORE = register(NetherAndEndBlockItems.END_COPPER_ORE);
    public static final Ingredient END_GOLD_ORE = register(NetherAndEndBlockItems.END_GOLD_ORE);
    public static final Ingredient END_REDSTONE_ORE = register(NetherAndEndBlockItems.END_REDSTONE_ORE);
    public static final Ingredient END_EMERALD_ORE = register(NetherAndEndBlockItems.END_EMERALD_ORE);
    public static final Ingredient END_LAPIS_ORE = register(NetherAndEndBlockItems.END_LAPIS_ORE);
    public static final Ingredient END_DIAMOND_ORE = register(NetherAndEndBlockItems.END_DIAMOND_ORE);

    public static Ingredient register(ItemConvertible item) {
        return Ingredient.ofItems(item);
    }

    public static void loadIngredients() {}
}
