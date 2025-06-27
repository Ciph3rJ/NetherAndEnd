package net.enderboy500.netherandend.util.component;

import net.minecraft.component.type.FoodComponent;

public class NetherAndEndFoodComponents {
    public static final FoodComponent SHULKER_PEARL = new FoodComponent.Builder().nutrition(5)
            .saturationModifier(1.5f)
            .build();
    public static final FoodComponent HARDENED_SHULKER_PEARL = new FoodComponent.Builder().nutrition(2)
            .saturationModifier(1)
            .build();
    public static final FoodComponent CHORUS_PIE = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(1)
            .build();
    public static final FoodComponent CHORUS_SOUP = new FoodComponent.Builder().nutrition(12)
            .saturationModifier(0.6f)
            .build();
    public static final FoodComponent ENDER_FRUIT = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(0.5f)
            .build();
    public static final FoodComponent WARPED_STEW = new FoodComponent.Builder().nutrition(12)
            .saturationModifier(0.6f)
            .build();
    public static final FoodComponent RAW_HOGCHOP = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(1.1f)
            .build();
    public static final FoodComponent COOKED_HOGCHOP = new FoodComponent.Builder().nutrition(4)
            .saturationModifier(0.5f)
            .build();
    public static final FoodComponent RAW_STRIDER_MEAT = new FoodComponent.Builder().nutrition(6)
            .saturationModifier(1.4f)
            .build();
    public static final FoodComponent COOKED_STRIDER_MEAT = new FoodComponent.Builder().nutrition(3)
            .saturationModifier(0.5f)
            .build();
    public static final FoodComponent SMOKED_STRIDER_MEAT = new FoodComponent.Builder().nutrition(4)
            .saturationModifier(1f)
            .build();
    public static final FoodComponent HARDENED_STRIDER_MEAT = new FoodComponent.Builder().nutrition(1)
            .saturationModifier(0.3f)
            .build();

    public static void loadFoodComponents() {}
}
