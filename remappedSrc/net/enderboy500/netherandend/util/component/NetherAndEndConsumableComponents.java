package net.enderboy500.netherandend.util.component;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class NetherAndEndConsumableComponents {
    public static final Consumable SHULKER_PEARL = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 3)).build();
    public static final Consumable HARDENED_SHULKER_PEARL = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 100, 0), 6)).build();
    public static final Consumable RAW_HOGCHOP = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 300, 1), 100)).build();
    public static final Consumable RAW_STRIDER_MEAT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 180, 0), 100))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 180, 0), 100))
            .build();
    public static final Consumable SMOKED_STRIDER_MEAT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 180, 0), 100))
            .build();
    public static final Consumable HARDENED_STRIDER_MEAT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 180, 0), 100))
            .build();

    public static final Consumable WARPED_CAKE_SLICE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 100)).build();

    public static void loadConsumableComponents() {}
}
