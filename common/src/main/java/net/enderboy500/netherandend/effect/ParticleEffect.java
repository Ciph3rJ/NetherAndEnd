package net.enderboy500.netherandend.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

public class ParticleEffect extends MobEffect {
    ParticleOptions particleOptions;

    public ParticleEffect(MobEffectCategory category, int color, ParticleOptions particleOptions) {
        super(category, color, particleOptions);
        this.particleOptions = particleOptions;
    }

    @Override
    public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
        return particleOptions;
    }
}
