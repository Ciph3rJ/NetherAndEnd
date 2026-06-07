package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.item.NetherAndEndToolMaterials;
import net.enderboy500.netherandend.item.WitheredBoneMealItem;
import net.enderboy500.netherandend.projectile.DragonChargeItem;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.services.util.RegistryHandle;
import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.BundleContents;

public class NetherAndEndItems {
    public static final RegistryHandle<Item> SHULKER_PEARL = Services.REGISTRY.registerItem("shulker_pearl", properties -> new Item(properties.food(NetherAndEndFoodComponents.SHULKER_PEARL, NetherAndEndConsumableComponents.SHULKER_PEARL).stacksTo(16)));
    public static final RegistryHandle<Item> HARDENED_SHULKER_PEARL = Services.REGISTRY.registerItem("hardened_shulker_pearl", properties -> new Item(properties.food(NetherAndEndFoodComponents.HARDENED_SHULKER_PEARL, NetherAndEndConsumableComponents.HARDENED_SHULKER_PEARL).stacksTo(16)));
    public static final RegistryHandle<Item> CHORUS_PIE = Services.REGISTRY.registerItem("chorus_pie", properties -> new Item(properties.food(NetherAndEndFoodComponents.CHORUS_PIE)));
    public static final RegistryHandle<Item> CHORUS_SOUP = Services.REGISTRY.registerItem("chorus_soup", properties -> new Item(properties.food(NetherAndEndFoodComponents.CHORUS_SOUP).stacksTo(1).usingConvertsTo(Items.BOWL)));
    public static final RegistryHandle<Item> ENDER_FRUIT = Services.REGISTRY.registerItem("ender_fruit", properties -> new Item(properties.food(NetherAndEndFoodComponents.ENDER_FRUIT)));
    public static final RegistryHandle<Item> DRAGON_CHARGE = Services.REGISTRY.registerItem("dragon_charge", properties -> new DragonChargeItem(properties.useCooldown(3).rarity(Rarity.UNCOMMON)));
    public static final RegistryHandle<Item> SHULKER_FALCHION = Services.REGISTRY.registerItem("shulker_falchion", properties -> new Item(properties.sword(NetherAndEndToolMaterials.SHULKER_FALCHION, 3.0F, -2.4F).rarity(Rarity.UNCOMMON)));

    public static final RegistryHandle<Item> WARPED_STEW = Services.REGISTRY.registerItem("warped_stew", properties -> new Item(properties.food(NetherAndEndFoodComponents.WARPED_STEW).stacksTo(1).usingConvertsTo(Items.BOWL)));
    public static final RegistryHandle<Item> CRIMSON_PIE = Services.REGISTRY.registerItem("crimson_pie", properties -> new Item(properties.food(NetherAndEndFoodComponents.CRIMSON_PIE)));
    public static final RegistryHandle<Item> RAW_HOGCHOP = Services.REGISTRY.registerItem("raw_hogchop", properties -> new Item(properties.food(NetherAndEndFoodComponents.RAW_HOGCHOP, NetherAndEndConsumableComponents.RAW_HOGCHOP)));
    public static final RegistryHandle<Item> COOKED_HOGCHOP = Services.REGISTRY.registerItem("cooked_hogchop", properties -> new Item(properties.food(NetherAndEndFoodComponents.COOKED_HOGCHOP)));
    public static final RegistryHandle<Item> HOGLIN_SKIN = Services.REGISTRY.registerItem("hoglin_skin", properties -> new Item(properties.fireResistant()));
    public static final RegistryHandle<Item> HOGLIN_BUNDLE = Services.REGISTRY.registerItem("hoglin_bundle", properties -> new BundleItem(properties.fireResistant().stacksTo(1).component(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY)));
    public static final RegistryHandle<Item> RAW_STRIDER_MEAT = Services.REGISTRY.registerItem("raw_strider_meat", properties -> new Item(properties.food(NetherAndEndFoodComponents.RAW_STRIDER_MEAT, NetherAndEndConsumableComponents.RAW_STRIDER_MEAT)));
    public static final RegistryHandle<Item> SMOKED_STRIDER_MEAT = Services.REGISTRY.registerItem("smoked_strider_meat", properties -> new Item(properties.food(NetherAndEndFoodComponents.SMOKED_STRIDER_MEAT, NetherAndEndConsumableComponents.SMOKED_STRIDER_MEAT)));
    public static final RegistryHandle<Item> COOKED_STRIDER_MEAT = Services.REGISTRY.registerItem("cooked_strider_meat", properties -> new Item(properties.food(NetherAndEndFoodComponents.COOKED_STRIDER_MEAT)));
    public static final RegistryHandle<Item> HARDENED_STRIDER_MEAT = Services.REGISTRY.registerItem("hardened_strider_meat", properties -> new Item(properties.food(NetherAndEndFoodComponents.HARDENED_STRIDER_MEAT, NetherAndEndConsumableComponents.HARDENED_STRIDER_MEAT).fireResistant()));

    public static final RegistryHandle<Item> WITHERED_BONE = Services.REGISTRY.registerItem("withered_bone", Item::new);
    public static final RegistryHandle<Item> WITHERED_BONE_MEAL = Services.REGISTRY.registerItem("withered_bone_meal", WitheredBoneMealItem::new);

    public static void loadItems() {}
}
