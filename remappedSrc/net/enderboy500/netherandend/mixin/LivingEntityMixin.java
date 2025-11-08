package net.enderboy500.netherandend.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(
            method = {"dropEquipment"},
            at = @At("TAIL")
    )
    private void netherAndEnd$dropsByUUID(ServerLevel world, DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        Random random = new Random();
        int randomDropCount = random.nextInt(3) + 1;

        if(source.getEntity() instanceof Player && this.getStringUUID().equals("5afeaa69-d754-48db-a400-d7e430ef77f4")) {
            this.spawnAtLocation(world, new ItemStack(Items.ENDER_PEARL, randomDropCount));
        }
    }
}
