package net.enderboy500.netherandend.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(
            method = {"dropEquipment"},
            at = @At("TAIL")
    )
    private void netherAndEnd$dropsByUUID(ServerWorld world, DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        Random random = new Random();
        int randomDropCount = random.nextInt(3) + 1;

        if(source.getAttacker() instanceof PlayerEntity && this.getUuidAsString().equals("5afeaa69-d754-48db-a400-d7e430ef77f4")) {
            this.dropStack(world, new ItemStack(Items.ENDER_PEARL, randomDropCount));
        }
    }
}
