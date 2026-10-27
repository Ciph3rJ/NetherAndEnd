package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.NetherAndEndCommon;
import net.enderboy500.netherandend.NetherAndEndFabric;
import net.enderboy500.netherandend.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FabricMobEffects {
    public static final Holder<MobEffect> INSTANT_WARPING = register("instant_warping", new InstantWarpingEffect(MobEffectCategory.NEUTRAL, 9520781));
    public static final Holder<MobEffect> INSTANT_CURING = register("instant_curing", new InstantCuringEffect(MobEffectCategory.NEUTRAL, 3532652));
    public static final Holder<MobEffect> INVERTED_VISION = register("inverted_vision", new ParticleEffect(MobEffectCategory.HARMFUL, 0x654448, NetherAndEndFabric.INVERTED_EYE));
    public static final Holder<MobEffect> PERDURANS = register("perdurans", new ParticleEffect(MobEffectCategory.NEUTRAL, 0x3c552a, NetherAndEndFabric.PERDANUS));
    public static final Holder<MobEffect> STERBEN = register("sterben", new SterbenEffect(NetherAndEndFabric.STERBEN));

    private static Holder<MobEffect> register(String id, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Constants.id(id), effect);
    }

    public static void loadMobEffects() {}
}
