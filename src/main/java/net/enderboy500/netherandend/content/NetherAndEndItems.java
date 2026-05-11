package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.item.NetherAndEndToolMaterials;
import net.enderboy500.netherandend.item.WitheredBoneMealItem;
import net.enderboy500.netherandend.projectiles.DragonChargeItem;
import net.enderboy500.netherandend.item.ShulkerFalchionItem;
import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class NetherAndEndItems {
    public static final Item SHULKER_PEARL = register("shulker_pearl", Item::new, new Properties().food(NetherAndEndFoodComponents.SHULKER_PEARL, NetherAndEndConsumableComponents.SHULKER_PEARL).stacksTo(16));
    public static final Item HARDENED_SHULKER_PEARL = register("hardened_shulker_pearl", Item::new, new Properties().food(NetherAndEndFoodComponents.HARDENED_SHULKER_PEARL, NetherAndEndConsumableComponents.HARDENED_SHULKER_PEARL).stacksTo(16));
    public static final Item CHORUS_PIE = register("chorus_pie", Item::new, new Properties().food(NetherAndEndFoodComponents.CHORUS_PIE));
    public static final Item CHORUS_SOUP = register("chorus_soup", Item::new, new Properties().food(NetherAndEndFoodComponents.CHORUS_SOUP).stacksTo(1).usingConvertsTo(Items.BOWL));
    public static final Item ENDER_FRUIT = register("ender_fruit", Item::new, new Properties().food(NetherAndEndFoodComponents.ENDER_FRUIT));
    public static final Item DRAGON_CHARGE = register("dragon_charge", DragonChargeItem::new, new Properties().useCooldown(3).rarity(Rarity.UNCOMMON));
    public static final Item SHULKER_FALCHION = register("shulker_falchion", ShulkerFalchionItem::new, new Properties().sword(NetherAndEndToolMaterials.SHULKER_FALCHION, 3.0F, -2.4F).rarity(Rarity.UNCOMMON));

    public static final Item WARPED_WART = register("warped_wart", createBlockItemWithCustomItemName(NetherAndEndBlocks.WARPED_WART), new Properties());
    public static final Item WARPED_STEW = register("warped_stew", Item::new, new Properties().food(NetherAndEndFoodComponents.WARPED_STEW).stacksTo(1).usingConvertsTo(Items.BOWL));
    public static final Item CRIMSON_PIE = register("crimson_pie", Item::new, new Properties().food(NetherAndEndFoodComponents.CRIMSON_PIE));
    public static final Item RAW_HOGCHOP = register("raw_hogchop", Item::new, new Properties().food(NetherAndEndFoodComponents.RAW_HOGCHOP, NetherAndEndConsumableComponents.RAW_HOGCHOP));
    public static final Item COOKED_HOGCHOP = register("cooked_hogchop", Item::new, new Properties().food(NetherAndEndFoodComponents.COOKED_HOGCHOP));
    public static final Item HOGLIN_SKIN = register("hoglin_skin", Item::new, new Properties().fireResistant());
    public static final Item HOGLIN_BUNDLE = register("hoglin_bundle", BundleItem::new, new Properties().fireResistant().stacksTo(1).component(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY));
    public static final Item RAW_STRIDER_MEAT = register("raw_strider_meat", Item::new, new Properties().food(NetherAndEndFoodComponents.RAW_STRIDER_MEAT, NetherAndEndConsumableComponents.RAW_STRIDER_MEAT));
    public static final Item SMOKED_STRIDER_MEAT = register("smoked_strider_meat", Item::new, new Properties().food(NetherAndEndFoodComponents.SMOKED_STRIDER_MEAT, NetherAndEndConsumableComponents.SMOKED_STRIDER_MEAT));
    public static final Item COOKED_STRIDER_MEAT = register("cooked_strider_meat", Item::new, new Properties().food(NetherAndEndFoodComponents.COOKED_STRIDER_MEAT));
    public static final Item HARDENED_STRIDER_MEAT = register("hardened_strider_meat", Item::new, new Properties().food(NetherAndEndFoodComponents.HARDENED_STRIDER_MEAT, NetherAndEndConsumableComponents.HARDENED_STRIDER_MEAT).fireResistant());

    public static final Item WITHERED_BONE = register("withered_bone");
    public static final Item WITHERED_BONE_MEAL = register("withered_bone_meal", WitheredBoneMealItem::new, new Properties());

    private static Function<Properties, Item> createBlockItemWithCustomItemName(final Block block) {
        return (p) -> new BlockItem(block, p.useItemDescriptionPrefix());
    }

    public static Item register(String name, Function<Properties, Item> itemFactory, Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static Item register(String id, Function<Properties, Item> factory) {
        return register(id, factory, new Properties());
    }

    public static Item register(String id) {
        return register(id, Item::new, new Properties());
    }

    public static void loadItems() {}
}
