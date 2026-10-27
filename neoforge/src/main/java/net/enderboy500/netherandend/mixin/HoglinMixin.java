package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.content.NeoForgeMobEffects;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Hoglin.class)
public abstract class HoglinMixin extends Animal {
    public HoglinMixin(EntityType<? extends HoglinMixin> type, Level level) {
        super(type, level);
    }

    @Inject(method = "isConverting", at = @At("HEAD"), cancellable = true)
    public void nae$isConverting(CallbackInfoReturnable<Boolean> cir) {
        if (this.hasEffect(NeoForgeMobEffects.STERBEN)) cir.setReturnValue(true);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    public void nae$mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.getMainHandItem().is(Items.NETHER_WART)) {
            player.getMainHandItem().consumeAndReturn(1, player);
            this.addEffect(new MobEffectInstance(NeoForgeMobEffects.PERDURANS, 12000));
            cir.setReturnValue(InteractionResult.SUCCESS);
        }else if (player.getMainHandItem().is(NetherAndEndItems.CRIMSON_STEW.get())) {
            player.getMainHandItem().consumeAndReturn(1, player);
            this.addEffect(new MobEffectInstance(NeoForgeMobEffects.PERDURANS, 2147483647));
            cir.setReturnValue(InteractionResult.SUCCESS);
        } else if (player.getMainHandItem().is(NetherAndEndItems.WARPED_STEW.get())) {
            player.getMainHandItem().consumeAndReturn(1, player);
            this.addEffect(new MobEffectInstance(NeoForgeMobEffects.STERBEN, 200));
            cir.setReturnValue(InteractionResult.SUCCESS);
        }  else if (player.getMainHandItem().is(NetherAndEndBlocks.WARPED_WART.blockItem().get())) {
            player.getMainHandItem().consumeAndReturn(1, player);
            this.addEffect(new MobEffectInstance(NeoForgeMobEffects.STERBEN, 2 * 60 * 20));
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Inject(method = "isImmuneToZombification", at = @At("HEAD"), cancellable = true)
    public void nae$isImmuneToZombification(CallbackInfoReturnable<Boolean> cir) {
        if (this.hasEffect(NeoForgeMobEffects.PERDURANS)) cir.setReturnValue(true);
    }
}
