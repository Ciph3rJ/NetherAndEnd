package net.enderboy500.netherandend.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    protected abstract MutableText addTellClickEvent(MutableText component);

    @Inject(method = "getDisplayName", at = @At("HEAD"),cancellable = true)
    public void name(CallbackInfoReturnable<Text> cir) {
        Calendar calendar = Calendar.getInstance();
        if ((calendar.get(Calendar.MONTH) == Calendar.NOVEMBER && calendar.get(Calendar.DATE) >= 19) || (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DATE) <= 19)) {
            MutableText mutableText = Team.decorateName(this.getScoreboardTeam(), this.getName());
            cir.setReturnValue(this.addTellClickEvent(mutableText).append(Text.literal(" " + String.valueOf('\uE001'))));
        }
    }
}
