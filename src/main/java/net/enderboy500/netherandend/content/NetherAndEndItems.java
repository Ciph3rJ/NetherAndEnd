package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.item.ShulkerFalchionItem;
import net.enderboy500.netherandend.projectile.DragonChargeItem;
import net.enderboy500.netherandend.util.property.NetherAndEndConsumeEffectProperties;
import net.enderboy500.netherandend.util.property.NetherAndEndFoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NetherAndEndItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NetherAndEnd.MOD_ID);

    public static final DeferredItem<Item> SHULKER_PEARL = ITEMS.registerItem("shulker_pearl",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.SHULKER_PEARL, NetherAndEndConsumeEffectProperties.SHULKER_PEARL));
    public static final DeferredItem<Item> HARDENED_SHULKER_PEARL = ITEMS.registerItem("hardened_shulker_pearl",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.HARDENED_SHULKER_PEARL, NetherAndEndConsumeEffectProperties.HARDENED_SHULKER_PEARL));
    public static final DeferredItem<Item> CHORUS_PIE = ITEMS.registerItem("chorus_pie",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.CHORUS_PIE));
    public static final DeferredItem<Item> CHORUS_SOUP = ITEMS.registerItem("chorus_soup",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.CHORUS_SOUP));
    public static final DeferredItem<Item> ENDER_FRUIT = ITEMS.registerItem("ender_fruit",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.ENDER_FRUIT));
    public static final DeferredItem<Item> DRAGON_CHARGE = ITEMS.registerItem("dragon_charge", DragonChargeItem::new, new Item.Properties());
    public static final DeferredItem<Item> SHULKER_FALCHION = ITEMS.registerItem("shulker_falchion",
            properties -> new ShulkerFalchionItem(ToolMaterial.DIAMOND, 3, -2.4f, properties));


    public static final DeferredItem<Item> WARPED_WART = ITEMS.registerItem("warped_wart", Item::new, new Item.Properties());
    public static final DeferredItem<Item> WARPED_STEW = ITEMS.registerItem("warped_stew",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.WARPED_STEW));
    public static final DeferredItem<Item> RAW_HOGCHOP = ITEMS.registerItem("raw_hogchop",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.RAW_HOGCHOP, NetherAndEndConsumeEffectProperties.RAW_HOGCHOP));
    public static final DeferredItem<Item> COOKED_HOGCHOP = ITEMS.registerItem("cooked_hogchop",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.COOKED_HOGCHOP));
    public static final DeferredItem<Item> HOGLIN_SKIN = ITEMS.registerItem("hoglin_skin",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> RAW_STRIDER_MEAT = ITEMS.registerItem("raw_strider_meat",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.RAW_STRIDER_MEAT, NetherAndEndConsumeEffectProperties.RAW_STRIDER_MEAT));
    public static final DeferredItem<Item> SMOKED_STRIDER_MEAT = ITEMS.registerItem("smoked_strider_meat",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.SMOKED_STRIDER_MEAT, NetherAndEndConsumeEffectProperties.SMOKED_STRIDER_MEAT));
    public static final DeferredItem<Item> COOKED_STRIDER_MEAT = ITEMS.registerItem("cooked_strider_meat",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.COOKED_STRIDER_MEAT));
    public static final DeferredItem<Item> HARDENED_STRIDER_MEAT = ITEMS.registerItem("hardened_strider_meat",
            Item::new, new Item.Properties().food(NetherAndEndFoodProperties.HARDENED_STRIDER_MEAT, NetherAndEndConsumeEffectProperties.HARDENED_STRIDER_MEAT));

    public static void loadItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}