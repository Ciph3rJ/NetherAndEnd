package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.combat.NetherAndEndToolMaterials;
import net.enderboy500.netherandend.projectiles.DragonChargeItem;
import net.enderboy500.netherandend.combat.ShulkerFalchionItem;
import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class NetherAndEndItems {
    public static final Item SHULKER_PEARL = register("shulker_pearl", Item::new, new Settings().food(NetherAndEndFoodComponents.SHULKER_PEARL, NetherAndEndConsumableComponents.SHULKER_PEARL).maxCount(16));
    public static final Item HARDENED_SHULKER_PEARL = register("hardened_shulker_pearl", Item::new, new Settings().food(NetherAndEndFoodComponents.HARDENED_SHULKER_PEARL, NetherAndEndConsumableComponents.HARDENED_SHULKER_PEARL).maxCount(16));
    public static final Item CHORUS_PIE = register("chorus_pie", Item::new, new Settings().food(NetherAndEndFoodComponents.CHORUS_PIE));
    public static final Item CHORUS_SOUP = register("chorus_soup", Item::new, new Settings().food(NetherAndEndFoodComponents.CHORUS_SOUP).maxCount(1));
    public static final Item ENDER_FRUIT = register("ender_fruit", Item::new, new Settings().food(NetherAndEndFoodComponents.ENDER_FRUIT));
    public static final Item DRAGON_CHARGE = register("dragon_charge", DragonChargeItem::new, new Settings().useCooldown(3).rarity(Rarity.UNCOMMON));
    public static final Item SHULKER_FALCHION = register("shulker_falchion", ShulkerFalchionItem::new, new Settings().rarity(Rarity.UNCOMMON).sword(NetherAndEndToolMaterials.SHULKER_FALCHION, 3.0F, -2.4F));

    public static final Item WARPED_WART = register("warped_wart");;
    public static final Item WARPED_STEW = register("warped_stew", Item::new, new Settings().food(NetherAndEndFoodComponents.WARPED_STEW).maxCount(1).useRemainder(Items.BOWL));
    public static final Item RAW_HOGCHOP = register("raw_hogchop", Item::new, new Settings().food(NetherAndEndFoodComponents.RAW_HOGCHOP, NetherAndEndConsumableComponents.RAW_HOGCHOP));
    public static final Item COOKED_HOGCHOP = register("cooked_hogchop", Item::new, new Settings().food(NetherAndEndFoodComponents.COOKED_HOGCHOP));
    public static final Item HOGLIN_SKIN = register("hoglin_skin", Item::new, new Settings().fireproof());
    public static final Item HOGLIN_BUNDLE = register("hoglin_bundle", BundleItem::new, new Settings().fireproof().component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT).maxCount(1));
    public static final Item RAW_STRIDER_MEAT = register("raw_strider_meat", Item::new, new Settings().food(NetherAndEndFoodComponents.RAW_STRIDER_MEAT, NetherAndEndConsumableComponents.RAW_STRIDER_MEAT));
    public static final Item SMOKED_STRIDER_MEAT = register("smoked_strider_meat", Item::new, new Settings().food(NetherAndEndFoodComponents.SMOKED_STRIDER_MEAT, NetherAndEndConsumableComponents.SMOKED_STRIDER_MEAT));
    public static final Item COOKED_STRIDER_MEAT = register("cooked_strider_meat", Item::new, new Settings().food(NetherAndEndFoodComponents.COOKED_STRIDER_MEAT));
    public static final Item HARDENED_STRIDER_MEAT = register("hardened_strider_meat", Item::new, new Settings().food(NetherAndEndFoodComponents.HARDENED_STRIDER_MEAT, NetherAndEndConsumableComponents.HARDENED_STRIDER_MEAT).fireproof());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(String id, Function<Settings, Item> factory) {
        return register(id, factory, new Item.Settings());
    }

    public static Item register(String id) {
        return register(id, Item::new, new Item.Settings());
    }

    public static void loadItems() {}
}
