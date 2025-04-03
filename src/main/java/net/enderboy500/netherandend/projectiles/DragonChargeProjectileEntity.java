package net.enderboy500.netherandend.projectiles;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.List;

public class DragonChargeProjectileEntity extends ThrownItemEntity {
    public DragonChargeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    protected DragonChargeProjectileEntity(World world, LivingEntity owner, ItemStack stack) {
        super(NetherAndEndEntities.DRAGON_CHARGE, owner, world, stack);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return super.createSpawnPacket(entityTrackerEntry);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            List<LivingEntity> livingEntities = this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4, 2, 4));
            AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setParticleType(ParticleTypes.DRAGON_BREATH);
            areaEffectCloud.setRadius(3);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusGrowth((7 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.squaredDistanceTo(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.getWorld().syncWorldEvent(WorldEvents.DRAGON_BREATH_CLOUD_SPAWNS, this.getBlockPos(), this.isSilent() ? -1 : 1);
            this.getWorld().spawnEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient()) {
            List<LivingEntity> livingEntities = this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4, 2, 4));
            AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity) {
                areaEffectCloud.setOwner((LivingEntity) entity);
            }

            areaEffectCloud.setParticleType(ParticleTypes.DRAGON_BREATH);
            areaEffectCloud.setRadius(3);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusGrowth((7 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double d = this.squaredDistanceTo(livingEntity);
                    if (!(d < 16)) continue;
                    areaEffectCloud.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                    break;
                }
            }

            this.getWorld().syncWorldEvent(WorldEvents.DRAGON_BREATH_CLOUD_SPAWNS, this.getBlockPos(), this.isSilent() ? -1 : 1);
            this.getWorld().spawnEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();

        super.onEntityHit(entityHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return NetherAndEndItems.DRAGON_CHARGE;
    }
}


