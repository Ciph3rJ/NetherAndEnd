package net.enderboy500.netherandend.projectiles;

import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryOps;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class AbstractDragonChargeEntity extends ExplosiveProjectileEntity implements FlyingItemEntity {
    private static final float MAX_RENDER_DISTANCE_WHEN_NEWLY_SPAWNED = 12.25F;
    private static final TrackedData<ItemStack> ITEM = DataTracker.registerData(AbstractDragonChargeEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, World world) {
        super(entityType, world);
    }

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, double d, double e, double f, Vec3d vec3d, World world) {
        super(entityType, d, e, f, vec3d, world);
    }

    public AbstractDragonChargeEntity(EntityType<? extends AbstractDragonChargeEntity> entityType, LivingEntity
            livingEntity, Vec3d vec3d, World world) {
        super(entityType, livingEntity, vec3d, world);
    }

    public void setItem(ItemStack stack) {
        if (stack.isEmpty()) {
            this.getDataTracker().set(ITEM, this.getItem());
        } else {
            this.getDataTracker().set(ITEM, stack.copyWithCount(1));
        }
    }

    @Override
    protected void playExtinguishSound() {}

    @Override
    public ItemStack getStack() {
        return this.getDataTracker().get(ITEM);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(ITEM, this.getItem());
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.put("Item", ItemStack.CODEC, this.getStack());
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        this.setItem((ItemStack)view.read("Item", ItemStack.CODEC).orElse(this.getItem()));
    }

    private ItemStack getItem() {
        return new ItemStack(NetherAndEndItems.DRAGON_CHARGE);
    }

    @Override
    public StackReference getStackReference(int mappedIndex) {
        return mappedIndex == 0 ? StackReference.of(this::getStack, this::setItem) : super.getStackReference(mappedIndex);
    }

    @Override
    public boolean shouldRender(double distance) {
        return this.age < 2 && distance < 12.25 ? false : super.shouldRender(distance);
    }
}
