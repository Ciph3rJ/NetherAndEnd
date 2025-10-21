package net.enderboy500.netherandend.util.component;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class NetherAndEndConsumableComponents {
    public static final ConsumableComponent SHULKER_PEARL = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 0), 3)).build();
    public static final ConsumableComponent HARDENED_SHULKER_PEARL = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0), 6)).build();
    public static final ConsumableComponent RAW_HOGCHOP = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1), 100)).build();
    public static final ConsumableComponent RAW_STRIDER_MEAT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 180, 0), 100))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180, 0), 100))
            .build();
    public static final ConsumableComponent SMOKED_STRIDER_MEAT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180, 0), 100))
            .build();
    public static final ConsumableComponent HARDENED_STRIDER_MEAT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 180, 0), 100))
            .build();

    public static final ConsumableComponent WARPED_CAKE_SLICE = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 100)).build();

    public static void loadConsumableComponents() {}
}
