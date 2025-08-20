package net.enderboy500.netherandend.projectiles;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class DragonChargeItem extends Item implements ProjectileItem {
    public DragonChargeItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        Item item = this;

        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            world.syncWorldEvent(null, 1018, user.getBlockPos(), 0);
            Vec3d vec3d = user.getRotationVec(1.0F).normalize().multiply(2);
            DragonChargeProjectileEntity dragonChargeProjectileEntity = new DragonChargeProjectileEntity(world, user.getX(),user.getY(),user.getZ(), vec3d);
            dragonChargeProjectileEntity.setPosition(dragonChargeProjectileEntity.getX(), user.getEyeY(), dragonChargeProjectileEntity.getZ());
            world.spawnEntity(dragonChargeProjectileEntity);
            stack.decrementUnlessCreative(1, user);
            user.getItemCooldownManager().set(this.getDefaultStack(), 60);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        Random random = world.getRandom();
        double d = random.nextTriangular((double)direction.getOffsetX(), 0.11485000000000001);
        double e = random.nextTriangular((double)direction.getOffsetY(), 0.11485000000000001);
        double f = random.nextTriangular((double)direction.getOffsetZ(), 0.11485000000000001);
        Vec3d vec3d = new Vec3d(d, e, f);
        DragonChargeProjectileEntity dragonChargeEntity = new DragonChargeProjectileEntity(world, pos.getX(), pos.getY(), pos.getZ(), vec3d.normalize());
        dragonChargeEntity.setItem(stack);
        return dragonChargeEntity;
    }

    @Override
    public ProjectileItem.Settings getProjectileSettings() {
        return ProjectileItem.Settings.builder()
                .positionFunction((pointer, facing) -> DispenserBlock.getOutputLocation(pointer, 1.0, Vec3d.ZERO))
                .uncertainty(6.6666665F)
                .power(1.0F)
                .overrideDispenseEvent(1018)
                .build();
    }
}
