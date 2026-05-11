package net.enderboy500.netherandend.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ShulkerPearlDispenseBehavior extends DefaultDispenseItemBehavior {
    public ShulkerPearlDispenseBehavior(Item item) {}

    public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        ServerLevel serverLevel = blockSource.level();
        Direction direction = (Direction)blockSource.state().getValue(DispenserBlock.FACING);
        AABB box = new AABB(blockSource.pos()).inflate(8);
        List<LivingEntity> livingEntitys = serverLevel.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, null, box);
        if (!livingEntitys.isEmpty()) {
            ShulkerBullet shulkerBullet = new ShulkerBullet(serverLevel, serverLevel.getRandomPlayer(), livingEntitys.getFirst(), direction.getAxis());
            BlockPos vec3 = blockSource.pos().relative(direction);
            shulkerBullet.snapTo(vec3.getX(), vec3.getY(), vec3.getZ(), direction.toYRot(), direction.toYRot());
            serverLevel.addFreshEntity(shulkerBullet);
            itemStack.shrink(1);
        }
        return itemStack;
    }

    protected void playSound(BlockSource blockSource) {
        //blockSource.level().levelEvent(this.dispenseConfig.overrideDispenseEvent().orElse(1002), blockSource.pos(), 0);
    }
}
