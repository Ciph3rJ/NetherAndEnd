package net.enderboy500.netherandend.mixin;

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

import java.util.Calendar;

@Mixin(Player.class)
public abstract class PlayerMixin extends Entity {
    @Shadow protected abstract MutableComponent decorateDisplayNameComponent(MutableComponent mutableComponent);

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "getDisplayName", at = @At("HEAD"),cancellable = true)
    public void name(CallbackInfoReturnable<Component> cir) {
        Calendar calendar = Calendar.getInstance();
        if (IconUtil.getAvailableIcon() != null) {
            MutableComponent mutableText = PlayerTeam.formatNameForTeam(this.getTeam(), this.getName());
            cir.setReturnValue(this.decorateDisplayNameComponent(mutableText).append(Component.literal(" " + IconUtil.getAvailableIcon().getChar())));
        }
    }
}
