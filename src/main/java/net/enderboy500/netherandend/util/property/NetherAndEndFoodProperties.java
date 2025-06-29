package net.enderboy500.netherandend.util.property;

import net.minecraft.world.food.FoodProperties;
import net.neoforged.bus.api.IEventBus;

public class NetherAndEndFoodProperties {
    public static final FoodProperties SHULKER_PEARL = new FoodProperties.Builder().nutrition(5).saturationModifier(1.5f).build();
    public static final FoodProperties HARDENED_SHULKER_PEARL = new FoodProperties.Builder().nutrition(2).saturationModifier(1).build();
    public static final FoodProperties CHORUS_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(1).build();
    public static final FoodProperties CHORUS_SOUP = new FoodProperties.Builder().nutrition(12).saturationModifier(0.6f).build();
    public static final FoodProperties ENDER_FRUIT = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).build();
    public static final FoodProperties WARPED_STEW = new FoodProperties.Builder().nutrition(12).saturationModifier(0.6f).build();

    public static final FoodProperties RAW_HOGCHOP = new FoodProperties.Builder().nutrition(8).saturationModifier(1.1f).build();
    public static final FoodProperties COOKED_HOGCHOP = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodProperties RAW_STRIDER_MEAT = new FoodProperties.Builder().nutrition(6).saturationModifier(1.4f).build();
    public static final FoodProperties SMOKED_STRIDER_MEAT = new FoodProperties.Builder().nutrition(4).saturationModifier(1).build();
    public static final FoodProperties COOKED_STRIDER_MEAT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).build();
    public static final FoodProperties HARDENED_STRIDER_MEAT = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f).build();

    public static void loadFoodProperties(IEventBus eventBus) {}
}
