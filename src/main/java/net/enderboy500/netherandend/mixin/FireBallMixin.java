package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.projectiles.DragonChargeProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FireChargeItem.class)
public abstract class FireBallMixin extends Item {

    @Shadow public abstract ActionResult useOnBlock(ItemUsageContext context);

    public FireBallMixin(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        Item item = this;

            ItemStack stack = user.getStackInHand(hand);
            if (!world.isClient()) {
                world.syncWorldEvent(null, 1018, user.getBlockPos(), 0);
                Vec3d vec3d = user.getRotationVec(1.0F).normalize().multiply(2);
                SmallFireballEntity smallFireballEntity = new SmallFireballEntity(world, user.getX(),user.getY(),user.getZ(), vec3d);
                smallFireballEntity.setPosition(smallFireballEntity.getX(), user.getEyeY(), smallFireballEntity.getZ());
                world.spawnEntity(smallFireballEntity);
                stack.decrementUnlessCreative(1, user);
                user.getItemCooldownManager().set(this.getDefaultStack(), 40);
            }
            return ActionResult.SUCCESS;

    }
}
