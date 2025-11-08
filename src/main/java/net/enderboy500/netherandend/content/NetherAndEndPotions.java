package net.enderboy500.netherandend.content;


import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class NetherAndEndPotions {
    public static final Holder<Potion> AVERSION_POTION = register("aversion_potion",
            new Potion("aversion", new MobEffectInstance(MobEffects.RESISTANCE, 1000,0)));
    public static final Holder<Potion> LONG_AVERSION_POTION = register("long_aversion_potion",
            new Potion("long_aversion", new MobEffectInstance(MobEffects.RESISTANCE, 2000,0)));

    public static final Holder<Potion> MALNOURISHMENT_POTION = register("malnourishment_potion",
            new Potion("malnourishment", new MobEffectInstance(MobEffects.HUNGER, 3600, 0)));
    public static final Holder<Potion> LONG_MALNOURISHMENT_POTION = register("long_malnourishment_potion",
            new Potion("long_malnourishment", new MobEffectInstance(MobEffects.HUNGER, 9600, 0)));
    public static final Holder<Potion> STRONG_MALNOURISHMENT_POTION = register("strong_malnourishment_potion",
            new Potion("strong_malnourishment", new MobEffectInstance(MobEffects.HUNGER, 1800, 1)));

    public static final Holder<Potion> SICKNESS_POTION = register("sickness_potion",
            new Potion("sickness", new MobEffectInstance(MobEffects.NAUSEA, 3600, 0)));
    public static final Holder<Potion> LONG_SICKNESS_POTION = register("long_sickness_potion",
            new Potion("long_sickness", new MobEffectInstance(MobEffects.NAUSEA, 9600, 0)));
    public static final Holder<Potion> STRONG_SICKNESS_POTION = register("strong_sickness_potion",
            new Potion("strong_sickness", new MobEffectInstance(MobEffects.NAUSEA, 1800, 1)));

    public static final Holder<Potion> BUOYANT_POTION = register("buoyant_potion",
            new Potion("buoyant", new MobEffectInstance(MobEffects.LEVITATION, 3600,0)));
    public static final Holder<Potion> LONG_BUOYANT_POTION = register("long_buoyant_potion",
            new Potion("long_buoyant", new MobEffectInstance(MobEffects.LEVITATION, 9600, 0)));
    public static final Holder<Potion> STRONG_BUOYANT_POTION = register("strong_buoyant_potion",
            new Potion("strong_buoyant", new MobEffectInstance(MobEffects.LEVITATION, 1800,1)));

    public static final Holder<Potion> INSTANT_WARPING_POTION = register("instant_warping_potion",
            new Potion("instant_warping", new MobEffectInstance(NetherAndEndEffects.INSTANT_WARPING, 100, 0)));

    public static final Holder<Potion> INSTANT_CURING_POTION = register("instant_curing_potion",
            new Potion("instant_curing", new MobEffectInstance(NetherAndEndEffects.INSTANT_CURING, 100, 0)));

    private static Holder<Potion> register(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.withDefaultNamespace(name), potion);
    }

    public static void loadPotions() {}
}
