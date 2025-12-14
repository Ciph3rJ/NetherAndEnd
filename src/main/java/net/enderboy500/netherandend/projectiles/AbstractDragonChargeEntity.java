package net.enderboy500.netherandend.projectiles;

import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractDragonChargeEntity extends net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile implements ItemSupplier {
    private static final float MAX_RENDER_DISTANCE_WHEN_NEWLY_SPAWNED = 12.25F;
    private static final EntityDataAccessor<ItemStack> ITEM = SynchedEntityData.defineId(AbstractDragonChargeEntity.class, EntityDataSerializers.ITEM_STACK);

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, Level world) {
        super(entityType, world);
    }

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, double d, double e, double f, Vec3 vec3d, Level world) {
        super(entityType, d, e, f, vec3d, world);
    }

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, LivingEntity
            livingEntity, Vec3 vec3d, Level world) {
        super(entityType, livingEntity, vec3d, world);
    }

    public void setItem(ItemStack stack) {
        if (stack.isEmpty()) {
            this.getEntityData().set(ITEM, this.getItem());
        } else {
            this.getEntityData().set(ITEM, stack.copyWithCount(1));
        }
    }

    @Override
    protected void playEntityOnFireExtinguishedSound() {}

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(ITEM, this.getItem());
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput view) {
        super.addAdditionalSaveData(view);
        view.store("Item", ItemStack.CODEC, this.getItem());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput view) {
        super.readAdditionalSaveData(view);
        this.setItem(view.read("Item", ItemStack.CODEC).orElse(this.getItem()));
    }

    public ItemStack getItem() {
        return new ItemStack(NetherAndEndItems.DRAGON_CHARGE);
    }

    @Override
    public SlotAccess getSlot(int mappedIndex) {
        return mappedIndex == 0 ? SlotAccess.of(this::getItem, this::setItem) : super.getSlot(mappedIndex);
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return this.tickCount < 2 && distance < 12.25 ? false : super.shouldRenderAtSqrDistance(distance);
    }
}
