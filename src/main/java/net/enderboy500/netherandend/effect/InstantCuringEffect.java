package net.enderboy500.netherandend.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class InstantCuringEffect extends InstantenousMobEffect {
    public InstantCuringEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        removeHarmfulEffects(entity);
        super.onEffectStarted(entity, amplifier);
    }

    public void removeHarmfulEffects(LivingEntity entity){
        entity.removeEffect(MobEffects.NAUSEA);
        entity.removeEffect(MobEffects.POISON);
        entity.removeEffect(MobEffects.HUNGER);
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
