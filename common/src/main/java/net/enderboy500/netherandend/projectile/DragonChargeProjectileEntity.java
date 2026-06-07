package net.enderboy500.netherandend.projectile;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.projectile.AbstractDragonChargeEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.PowerParticleOption;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class DragonChargeProjectileEntity extends AbstractDragonChargeEntity {
    public DragonChargeProjectileEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, Level world) {
        super(entityType, world);
    }
    protected DragonChargeProjectileEntity(Level world, LivingEntity owner, Vec3 velocity) {
        super(NetherAndEndEntities.DRAGON_CHARGE.get(), owner, velocity, world);
    }

    protected DragonChargeProjectileEntity(Level world, double x, double y, double z, Vec3 velocity) {
        super(NetherAndEndEntities.DRAGON_CHARGE.get(), x, y, z, velocity, world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entityTrackerEntry) {
        return super.getAddEntityPacket(entityTrackerEntry);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        if (!this.level().isClientSide()) {
            List<LivingEntity> livingEntities = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4, 2, 4));
            AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setCustomParticle(PowerParticleOption.create(ParticleTypes.DRAGON_BREATH, 1));
            areaEffectCloud.setRadius(1);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusPerTick((4 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.distanceToSqr(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.level().levelEvent(LevelEvent.PARTICLES_DRAGON_FIREBALL_SPLASH, this.blockPosition(), this.isSilent() ? -1 : 1);
            this.level().addFreshEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();
        super.onHitBlock(blockHitResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level().isClientSide()) {
            List<LivingEntity> livingEntities = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4, 2, 4));
            AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setCustomParticle(PowerParticleOption.create(ParticleTypes.DRAGON_BREATH, 1));
            areaEffectCloud.setRadius(1);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusPerTick((4 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.distanceToSqr(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.level().levelEvent(LevelEvent.PARTICLES_DRAGON_FIREBALL_SPLASH, this.blockPosition(), this.isSilent() ? -1 : 1);
            this.level().addFreshEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();

        super.onHitEntity(entityHitResult);
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

}