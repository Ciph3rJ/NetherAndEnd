package net.enderboy500.netherandend.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.FireChargeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FireChargeItem.class)
public abstract class FireChargeItemMixin extends Item {
    @Shadow
    public abstract ActionResult useOnBlock(ItemUsageContext context);

    public FireChargeItemMixin(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            world.syncWorldEvent(null, 1018, user.getBlockPos(), 0);
            Vec3d vec3d = user.getRotationVec(1.0F).normalize().multiply(2);
            SmallFireballEntity smallFireballEntity = new SmallFireballEntity(world, user.getX(), user.getY(), user.getZ(), vec3d);
            smallFireballEntity.setPosition(smallFireballEntity.getX(), user.getEyeY(), smallFireballEntity.getZ());
            world.spawnEntity(smallFireballEntity);
            stack.decrementUnlessCreative(1, user);
            user.getItemCooldownManager().set(this.getDefaultStack(), 40);
        }
        return ActionResult.SUCCESS;
    }
}
