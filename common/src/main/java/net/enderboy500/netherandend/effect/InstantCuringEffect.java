package net.enderboy500.netherandend.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;

import java.util.Collection;
import java.util.List;

public class InstantCuringEffect extends InstantaneousMobEffect {
    public InstantCuringEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantaneous() {
        return false;
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        removeHarmfulEffects(entity);
        super.onEffectStarted(entity, amplifier);
    }

    public void removeHarmfulEffects(LivingEntity entity) {
        List<MobEffectInstance> effects = entity.getActiveEffects().stream().toList();
        for (MobEffectInstance effectInstance : effects) {
            if (effectInstance.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                entity.removeEffect(effectInstance.getEffect());
            }
        }
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        return super.applyEffectTick(world, entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}