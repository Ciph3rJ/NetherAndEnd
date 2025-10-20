package net.enderboy500.netherandend.compat;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class NEFDCompat {
    public static final Item WARPED_CAKE_SLICE = register("warped_cake_slice", Item::new, new Item.Settings().food(NetherAndEndFoodComponents.WARPED_CAKE_SLICE, NetherAndEndConsumableComponents.WARPED_CAKE_SLICE));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static Item register(String id, Function<Item.Settings, Item> factory) {
        return register(id, factory, new Item.Settings());
    }

    public static void loadNEFDCompat() {}
}
