package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.effect.InstantCuringEffect;
import net.enderboy500.netherandend.effect.InstantWarpingEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class NetherAndEndEffects {
    public static final RegistryEntry<StatusEffect> INSTANT_WARPING = register("instant_warping",
            new InstantWarpingEffect(StatusEffectCategory.NEUTRAL, 9520781));
    public static final RegistryEntry<StatusEffect> INSTANT_CURING = register("instant_curing",
            new InstantCuringEffect(StatusEffectCategory.NEUTRAL, 3532652));

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(NetherAndEnd.MOD_ID, id), effect);
    }

    public static void loadEffects() {}
}
