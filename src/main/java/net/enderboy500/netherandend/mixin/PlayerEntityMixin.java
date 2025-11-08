package net.enderboy500.netherandend.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    protected abstract MutableComponent addTellClickEvent(MutableComponent component);

    @Inject(method = "getDisplayName", at = @At("HEAD"),cancellable = true)
    public void name(CallbackInfoReturnable<Component> cir) {
        Calendar calendar = Calendar.getInstance();
        if ((calendar.get(Calendar.MONTH) == Calendar.NOVEMBER && calendar.get(Calendar.DATE) >= 19) || (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DATE) <= 19)) {
            MutableComponent mutableText = PlayerTeam.formatNameForTeam(this.getTeam(), this.getName());
            cir.setReturnValue(this.addTellClickEvent(mutableText).append(Component.literal(" " + '\uE001')));
        }
    }
}
