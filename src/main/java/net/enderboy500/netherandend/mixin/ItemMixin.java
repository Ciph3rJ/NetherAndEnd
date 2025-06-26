package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, EquipmentSlot slot, CallbackInfo ci) {
        if (stack.isOf(Items.ELYTRA)) {
            if (world.getGameRules().getBoolean(NetherAndEnd.DISABLE_ELYTRA)) {
                stack.set(DataComponentTypes.MAX_DAMAGE, 1);
            } else {
                stack.set(DataComponentTypes.MAX_DAMAGE, 432);
            }

        }

    }

}
