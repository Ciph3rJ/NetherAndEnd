package net.enderboy500.netherandend.projectiles;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;

public class DragonChargeItem extends Item implements ProjectileItem {
    public DragonChargeItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        Item item = this;

        ItemStack stack = user.getItemInHand(hand);
        if (!world.isClientSide()) {
            world.levelEvent(null, 1018, user.blockPosition(), 0);
            Vec3 vec3d = user.getViewVector(1.0F).normalize().scale(2);
            DragonChargeProjectileEntity dragonChargeProjectileEntity = new DragonChargeProjectileEntity(world, user.getX(),user.getY(),user.getZ(), vec3d);
            dragonChargeProjectileEntity.setPos(dragonChargeProjectileEntity.getX(), user.getEyeY(), dragonChargeProjectileEntity.getZ());
            world.addFreshEntity(dragonChargeProjectileEntity);
            stack.consume(1, user);
            user.getCooldowns().addCooldown(this.getDefaultInstance(), 60);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public DispenseConfig createDispenseConfig() {
        return DispenseConfig.builder()
                .positionFunction((pointer, facing) -> DispenserBlock.getDispensePosition(pointer, 1.0, Vec3.ZERO))
                .uncertainty(6.6666665F)
                .power(1.0F)
                .overrideDispenseEvent(1018)
                .build();
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        RandomSource random = level.getRandom();
        double d = random.triangle(direction.getStepX(), 0.11485000000000001);
        double e = random.triangle(direction.getStepY(), 0.11485000000000001);
        double f = random.triangle(direction.getStepZ(), 0.11485000000000001);
        Vec3 vec3d = new Vec3(d, e, f);
        DragonChargeProjectileEntity dragonChargeEntity = new DragonChargeProjectileEntity(level, pos.x(), pos.y(), pos.z(), vec3d.normalize());
        dragonChargeEntity.setItem(stack);
        return dragonChargeEntity;
    }
}
