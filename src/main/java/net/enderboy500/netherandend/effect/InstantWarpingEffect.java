package net.enderboy500.netherandend.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class InstantWarpingEffect extends InstantStatusEffect {
    public InstantWarpingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient) {
            for (int i = 0; i < 16; i++) {
                double d = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                double e = MathHelper.clamp(
                        entity.getY() + (double)(entity.getRandom().nextInt(16) - 8),
                        (double)world.getBottomY(),
                        (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1)
                );
                double f = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                if (entity.hasVehicle()) {
                    entity.stopRiding();
                }

                Vec3d vec3d = entity.getPos();
                if (entity.teleport(d, e, f, true)) {
                    world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                    SoundCategory soundCategory;
                    SoundEvent soundEvent;
                        soundEvent = SoundEvents.ENTITY_ENDERMAN_TELEPORT;
                        soundCategory = SoundCategory.PLAYERS;

                    world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                    entity.onLanding();
                    break;
                }
            }

            if (entity instanceof PlayerEntity playerEntity) {
                playerEntity.clearCurrentExplosion();
            }
        }
        super.onApplied(entity, amplifier);
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
