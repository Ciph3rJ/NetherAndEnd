package net.enderboy500.netherandend.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class InstantWarpingEffect extends InstantenousMobEffect {
    public InstantWarpingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        Level world = entity.level();
        if (!world.isClientSide()) {
            for (int i = 0; i < 16; i++) {
                double d = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                double e = Mth.clamp(
                        entity.getY() + (double)(entity.getRandom().nextInt(16) - 8),
                        world.getMinY(),
                        world.getMinY() + ((ServerLevel)world).getLogicalHeight() - 1
                );
                double f = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
                if (entity.isPassenger()) {
                    entity.stopRiding();
                }

                Vec3 vec3d = entity.position();
                if (entity.randomTeleport(d, e, f, true)) {
                    world.gameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Context.of(entity));
                    SoundSource soundCategory;
                    SoundEvent soundEvent;
                    soundEvent = SoundEvents.ENDERMAN_TELEPORT;
                    soundCategory = SoundSource.PLAYERS;

                    world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                    entity.resetFallDistance();
                    break;
                }
            }

            if (entity instanceof Player playerEntity) {
                playerEntity.resetCurrentImpulseContext();
            }
        }
        return super.applyEffectTick(serverLevel, entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
