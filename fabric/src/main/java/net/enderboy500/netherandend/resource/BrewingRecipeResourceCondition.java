package net.enderboy500.netherandend.resource;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.resources.RegistryOps;
import org.jspecify.annotations.Nullable;

public class BrewingRecipeResourceCondition implements ResourceCondition {
    public static final BrewingRecipeResourceCondition INSTANCE = new BrewingRecipeResourceCondition();
    public static final MapCodec<BrewingRecipeResourceCondition> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public ResourceConditionType<?> getType() {
        return NetherAndEndResourceConditions.BREWING_RECIPE;
    }

    @Override
    public boolean test(RegistryOps.@Nullable RegistryInfoLookup registryInfo) {
        return true;
    }
}
