package net.enderboy500.netherandend.projectile;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class DragonChargeProjectileEntity extends ThrowableItemProjectile {
    public DragonChargeProjectileEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public DragonChargeProjectileEntity(LivingEntity shooter, Level level) {
        super(NetherAndEndEntities.DRAGON_CHARGE.get(), shooter, level, new ItemStack(NetherAndEndItems.DRAGON_CHARGE.get()));
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide()) {
            AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity livingEntity) {
                areaEffectCloud.setOwner(livingEntity);
            }

            areaEffectCloud.setParticle(ParticleTypes.DRAGON_BREATH);
            areaEffectCloud.setRadius(3);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusPerTick((7 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));

            this.level().levelEvent(LevelEvent.PARTICLES_DRAGON_FIREBALL_SPLASH, this.blockPosition(), this.isSilent() ? -1 : 1);
            this.level().addFreshEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (!this.level().isClientSide()) {
            AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();

            if (entity instanceof LivingEntity livingEntity) {
                areaEffectCloud.setOwner(livingEntity);
            }

            areaEffectCloud.setParticle(ParticleTypes.DRAGON_BREATH);
            areaEffectCloud.setRadius(3);
            areaEffectCloud.setDuration(600);
            areaEffectCloud.setRadiusPerTick((7 - areaEffectCloud.getRadius()) / (float) areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));

            this.level().levelEvent(LevelEvent.PARTICLES_DRAGON_FIREBALL_SPLASH, this.blockPosition(), this.isSilent() ? -1 : 1);
            this.level().addFreshEntity(areaEffectCloud);
            this.discard();
        }

        this.discard();
    }

    @Override
    public Item getDefaultItem() {
        return NetherAndEndItems.DRAGON_CHARGE.get();
    }
}
