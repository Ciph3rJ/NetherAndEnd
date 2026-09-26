package net.enderboy500.netherandend.resource;

import net.enderboy500.netherandend.Constants;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;

public class NetherAndEndResourceConditions {
    static final ResourceConditionType<BrewingRecipeResourceCondition> BREWING_RECIPE = ResourceConditionType.create(Constants.id("brewing_recipe"),
            BrewingRecipeResourceCondition.CODEC);

    public static void load() {
        ResourceConditions.register(BREWING_RECIPE);
    }
}
