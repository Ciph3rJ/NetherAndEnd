package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.util.icon.Icon;
import net.enderboy500.netherandend.util.icon.IconUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends Entity {
    @Shadow protected abstract MutableComponent decorateDisplayNameComponent(MutableComponent mutableComponent);

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "getDisplayName", at = @At("HEAD"),cancellable = true)
    public void name(CallbackInfoReturnable<Component> cir) {
        if (IconUtil.checkEverything(Icon.WARPED)) {
            MutableComponent mutableText = PlayerTeam.formatNameForTeam(this.getTeam(), this.getName());
            cir.setReturnValue(this.decorateDisplayNameComponent(mutableText).append(Component.literal(" " + '\uE001')));
        } else if (IconUtil.checkEverything(Icon.CRIMSON)) {
            MutableComponent mutableText = PlayerTeam.formatNameForTeam(this.getTeam(), this.getName());
            cir.setReturnValue(this.decorateDisplayNameComponent(mutableText).append(Component.literal(" " + '\uE002')));
        }
    }
}
