package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void inventoryTick(ItemStack stack, ServerLevel world, Entity entity, EquipmentSlot slot, CallbackInfo ci) {
        /*if (stack.is(Items.ELYTRA)) {
            if (world.getGameRules().get(NetherAndEnd.DISABLE_ELYTRA)) {
                stack.set(DataComponents.MAX_DAMAGE, 1);
            } else {
                stack.set(DataComponents.MAX_DAMAGE, 432);
            }
        }*/
    }
}
