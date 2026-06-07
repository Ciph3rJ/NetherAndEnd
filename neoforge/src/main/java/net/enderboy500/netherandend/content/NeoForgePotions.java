package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgePotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Constants.MOD_ID);

    public static final Holder<Potion> AVERSION_POTION = POTIONS.register("aversion_potion",
            () -> new Potion("aversion", new MobEffectInstance(MobEffects.RESISTANCE, 1000,0)));
    public static final Holder<Potion> LONG_AVERSION_POTION = POTIONS.register("long_aversion_potion",
            () -> new Potion("long_aversion", new MobEffectInstance(MobEffects.RESISTANCE, 2000,0)));

    public static final Holder<Potion> MALNOURISHMENT_POTION = POTIONS.register("malnourishment_potion",
            () -> new Potion("malnourishment", new MobEffectInstance(MobEffects.HUNGER, 3600, 0)));
    public static final Holder<Potion> LONG_MALNOURISHMENT_POTION = POTIONS.register("long_malnourishment_potion",
            () -> new Potion("long_malnourishment", new MobEffectInstance(MobEffects.HUNGER, 9600, 0)));
    public static final Holder<Potion> STRONG_MALNOURISHMENT_POTION = POTIONS.register("strong_malnourishment_potion",
            () -> new Potion("strong_malnourishment", new MobEffectInstance(MobEffects.HUNGER, 1800, 1)));

    public static final Holder<Potion> SICKNESS_POTION = POTIONS.register("sickness_potion",
            () -> new Potion("sickness", new MobEffectInstance(MobEffects.NAUSEA, 3600, 0)));
    public static final Holder<Potion> LONG_SICKNESS_POTION = POTIONS.register("long_sickness_potion",
            () -> new Potion("long_sickness", new MobEffectInstance(MobEffects.NAUSEA, 9600, 0)));
    public static final Holder<Potion> STRONG_SICKNESS_POTION = POTIONS.register("strong_sickness_potion",
            () -> new Potion("strong_sickness", new MobEffectInstance(MobEffects.NAUSEA, 1800, 1)));

    public static final Holder<Potion> BUOYANT_POTION = POTIONS.register("buoyant_potion",
            () -> new Potion("buoyant", new MobEffectInstance(MobEffects.LEVITATION, 3600,0)));
    public static final Holder<Potion> LONG_BUOYANT_POTION = POTIONS.register("long_buoyant_potion",
            () -> new Potion("long_buoyant", new MobEffectInstance(MobEffects.LEVITATION, 9600, 0)));
    public static final Holder<Potion> STRONG_BUOYANT_POTION = POTIONS.register("strong_buoyant_potion",
            () -> new Potion("strong_buoyant", new MobEffectInstance(MobEffects.LEVITATION, 1800,1)));

    public static final Holder<Potion> INSTANT_WARPING_POTION = POTIONS.register("instant_warping_potion",
            () -> new Potion("instant_warping", new MobEffectInstance(NeoForgeMobEffects.INSTANT_WARPING, 100, 0)));

    public static final Holder<Potion> INSTANT_CURING_POTION = POTIONS.register("instant_curing_potion",
            () -> new Potion("instant_curing", new MobEffectInstance(NeoForgeMobEffects.INSTANT_CURING, 100, 0)));

    public static void loadPotions(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
