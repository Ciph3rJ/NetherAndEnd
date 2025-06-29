package net.enderboy500.netherandend.util.property;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.bus.api.IEventBus;

public class NetherAndEndConsumeEffectProperties {
    public static final Consumable SHULKER_PEARL = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 3)).build();
    public static final Consumable HARDENED_SHULKER_PEARL = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), 6)).build();

    public static final Consumable RAW_HOGCHOP = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 1), 100)).build();
    public static final Consumable RAW_STRIDER_MEAT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 180, 0), 100)).onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 180, 0), 100)).build();
    public static final Consumable SMOKED_STRIDER_MEAT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 180, 0), 100)).build();
    public static final Consumable HARDENED_STRIDER_MEAT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 180, 0), 100)).build();

    public static void loadConsumeEffectProperties(IEventBus eventBus) {}
}
