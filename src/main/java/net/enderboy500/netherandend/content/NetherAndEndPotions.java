package net.enderboy500.netherandend.content;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class NetherAndEndPotions {
    public static final RegistryEntry<Potion> AVERSION_POTION = register("aversion_potion",
            new Potion("aversion", new StatusEffectInstance(StatusEffects.RESISTANCE, 1000,0)));
    public static final RegistryEntry<Potion> LONG_AVERSION_POTION = register("long_aversion_potion",
            new Potion("long_aversion", new StatusEffectInstance(StatusEffects.RESISTANCE, 2000,0)));

    public static final RegistryEntry<Potion> MALNOURISHMENT_POTION = register("malnourishment_potion",
            new Potion("malnourishment", new StatusEffectInstance(StatusEffects.HUNGER, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_MALNOURISHMENT_POTION = register("long_malnourishment_potion",
            new Potion("long_malnourishment", new StatusEffectInstance(StatusEffects.HUNGER, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_MALNOURISHMENT_POTION = register("strong_malnourishment_potion",
            new Potion("strong_malnourishment", new StatusEffectInstance(StatusEffects.HUNGER, 1800, 1)));

    public static final RegistryEntry<Potion> SICKNESS_POTION = register("sickness_potion",
            new Potion("sickness", new StatusEffectInstance(StatusEffects.NAUSEA, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_SICKNESS_POTION = register("long_sickness_potion",
            new Potion("long_sickness", new StatusEffectInstance(StatusEffects.NAUSEA, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_SICKNESS_POTION = register("strong_sickness_potion",
            new Potion("strong_sickness", new StatusEffectInstance(StatusEffects.NAUSEA, 1800, 1)));

    public static final RegistryEntry<Potion> BUOYANT_POTION = register("buoyant_potion",
            new Potion("buoyant", new StatusEffectInstance(StatusEffects.LEVITATION, 3600,0)));
    public static final RegistryEntry<Potion> LONG_BUOYANT_POTION = register("long_buoyant_potion",
            new Potion("long_buoyant", new StatusEffectInstance(StatusEffects.LEVITATION, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_BUOYANT_POTION = register("strong_buoyant_potion",
            new Potion("strong_buoyant", new StatusEffectInstance(StatusEffects.LEVITATION, 1800,1)));

    public static final RegistryEntry<Potion> INSTANT_WARPING_POTION = register("instant_warping_potion",
            new Potion("instant_warping", new StatusEffectInstance(NetherAndEndEffects.INSTANT_WARPING, 100, 0)));

    public static final RegistryEntry<Potion> INSTANT_CURING_POTION = register("instant_curing_potion",
            new Potion("instant_curing", new StatusEffectInstance(NetherAndEndEffects.INSTANT_CURING, 100, 0)));

    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.ofVanilla(name), potion);
    }

    public static void loadPotions() {}
}
