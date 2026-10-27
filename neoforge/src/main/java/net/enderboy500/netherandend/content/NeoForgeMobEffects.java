package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.NetherAndEndCommon;
import net.enderboy500.netherandend.NetherAndEndNeoForge;
import net.enderboy500.netherandend.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeMobEffects {
    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Constants.MOD_ID);

    public static final Holder<MobEffect> INSTANT_WARPING = MOB_EFFECTS.register("instant_warping", () -> new InstantWarpingEffect(MobEffectCategory.NEUTRAL, 9520781));
    public static final Holder<MobEffect> INSTANT_CURING = MOB_EFFECTS.register("instant_curing", () -> new InstantCuringEffect(MobEffectCategory.NEUTRAL, 3532652));
    public static final Holder<MobEffect> INVERTED_VISION = MOB_EFFECTS.register("inverted_vision", () -> new ParticleEffect(MobEffectCategory.HARMFUL, 0x654448, NetherAndEndNeoForge.INVERTED_EYE.get()));
    public static final Holder<MobEffect> PERDURANS = MOB_EFFECTS.register("perdurans", () -> new ParticleEffect(MobEffectCategory.NEUTRAL, 0x3c552a, NetherAndEndNeoForge.PERDURANS.get()));
    public static final Holder<MobEffect> STERBEN = MOB_EFFECTS.register("sterben", () -> new SterbenEffect(NetherAndEndNeoForge.STERBEN.get()));

    public static void loadEffects(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
