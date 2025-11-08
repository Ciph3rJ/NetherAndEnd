package net.enderboy500.netherandend.compat;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import java.util.function.Function;

public class NEFDCompat {
    public static final Item WARPED_CAKE_SLICE = register("warped_cake_slice", Item::new, new Item.Properties().food(NetherAndEndFoodComponents.WARPED_CAKE_SLICE, NetherAndEndConsumableComponents.WARPED_CAKE_SLICE));

    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, name));
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static Item register(String id, Function<Item.Properties, Item> factory) {
        return register(id, factory, new Item.Properties());
    }

    public static void loadNEFDCompat() {}
}