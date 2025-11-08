package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.effect.InstantCuringEffect;
import net.enderboy500.netherandend.effect.InstantWarpingEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NetherAndEndEffects {
    public static final Holder<MobEffect> INSTANT_WARPING = register("instant_warping",
            new InstantWarpingEffect(MobEffectCategory.NEUTRAL, 9520781));
    public static final Holder<MobEffect> INSTANT_CURING = register("instant_curing",
            new InstantCuringEffect(MobEffectCategory.NEUTRAL, 3532652));

    private static Holder<MobEffect> register(String id, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, id), effect);
    }

    public static void loadEffects() {}
}
