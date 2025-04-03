package net.enderboy500.netherandend.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.*;
import net.minecraft.server.world.ServerWorld;

public class InstantCuringEffect extends InstantStatusEffect {
    public InstantCuringEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        removeHarmfulEffects(entity);
        super.onApplied(entity, amplifier);
    }

    public void removeHarmfulEffects(LivingEntity entity){
        entity.removeStatusEffect(StatusEffects.NAUSEA);
        entity.removeStatusEffect(StatusEffects.POISON);
        entity.removeStatusEffect(StatusEffects.HUNGER);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
