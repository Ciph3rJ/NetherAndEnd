package net.enderboy500.netherandend.projectiles;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.minecraft.client.particle.DragonBreathParticle;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.particle.DragonBreathParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.List;

public class DragonChargeProjectileEntity extends AbstractDragonChargeEntity {
    public DragonChargeProjectileEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, World world) {
        super(entityType, world);
    }
    protected DragonChargeProjectileEntity(World world, LivingEntity owner, Vec3d velocity) {
        super(NetherAndEndEntities.DRAGON_CHARGE, owner, velocity, world);
    }

    protected DragonChargeProjectileEntity(World world, double x, double y, double z, Vec3d velocity) {
        super(NetherAndEndEntities.DRAGON_CHARGE, x, y, z, velocity, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return super.createSpawnPacket(entityTrackerEntry);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getEntityWorld().isClient()) {
            List<LivingEntity> livingEntities = this.getEntityWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4, 2, 4));
            AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(this.getEntityWorld(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setParticleType(DragonBreathParticleEffect.of(ParticleTypes.DRAGON_BREATH, 1));
            areaEffectCloud.setRadius(1);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusGrowth((4 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.squaredDistanceTo(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.getEntityWorld().syncWorldEvent(WorldEvents.DRAGON_BREATH_CLOUD_SPAWNS, this.getBlockPos(), this.isSilent() ? -1 : 1);
            this.getEntityWorld().spawnEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getEntityWorld().isClient()) {
            List<LivingEntity> livingEntities = this.getEntityWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4, 2, 4));
            AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(this.getEntityWorld(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setParticleType(DragonBreathParticleEffect.of(ParticleTypes.DRAGON_BREATH, 1));
            areaEffectCloud.setRadius(1);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusGrowth((4 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.squaredDistanceTo(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.getEntityWorld().syncWorldEvent(WorldEvents.DRAGON_BREATH_CLOUD_SPAWNS, this.getBlockPos(), this.isSilent() ? -1 : 1);
            this.getEntityWorld().spawnEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();

        super.onEntityHit(entityHitResult);
    }

    @Override
    public boolean doesRenderOnFire() {
        return false;
    }

}


