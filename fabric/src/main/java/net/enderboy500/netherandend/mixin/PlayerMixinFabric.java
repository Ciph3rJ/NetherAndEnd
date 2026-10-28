package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.NetherAndEndCommon;
import net.enderboy500.netherandend.NetherAndEndFabric;
import net.enderboy500.netherandend.content.FabricMobEffects;
import net.enderboy500.netherandend.util.enums.IconDesigns;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixinFabric extends Avatar {
    @Shadow
    protected abstract MutableComponent decorateDisplayNameComponent(MutableComponent nameComponent);

    public PlayerMixinFabric(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @Inject(method = "getDisplayName", at = @At("HEAD"),cancellable = true)
    public void name(CallbackInfoReturnable<Component> cir) {
        if (NetherAndEndFabric.options.getIconDesign().get() != IconDesigns.None) {
            MutableComponent mutableText = PlayerTeam.formatNameForTeam(this.getTeam(), this.getName());
            cir.setReturnValue(this.decorateDisplayNameComponent(mutableText).append(Component.literal(" " + NetherAndEndFabric.options.getIconDesign().get().getCharacter())));
        }
    }

    @Unique
    protected EquipmentSlot sunProtectionSlot() {
        return EquipmentSlot.HEAD;
    }

    @Unique
    private void burnUndead() {
        if (this.isAlive() && this.isSunBurnTick()) {
            EquipmentSlot slot = this.sunProtectionSlot();
            ItemStack sunBlocker = this.getItemBySlot(slot);
            if (!sunBlocker.isEmpty()) {
                if (sunBlocker.isDamageableItem()) {
                    sunBlocker.hurtAndBreak(this.random.nextInt(2), this, slot);
                }
            } else {
                this.igniteForSeconds(8.0F);
            }
        }

    }

    @Unique
    private boolean isSunBurnTick() {
        if (!this.level().isClientSide() && this.level().environmentAttributes().getValue(EnvironmentAttributes.MONSTERS_BURN, this.position())) {
            float br = this.getLightLevelDependentMagicValue();
            BlockPos roundedPos = BlockPos.containing(this.getX(), this.getEyeY(), this.getZ());
            boolean isInNonBurnableBlock = this.isInWaterOrRain() || this.isInPowderSnow || this.wasInPowderSnow;
            if (br > 0.5F && this.random.nextFloat() * 30.0F < (br - 0.4F) * 2.0F && !isInNonBurnableBlock && this.level().canSeeSky(roundedPos)) {
                return true;
            }
        }

        return false;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        if (this.hasEffect(FabricMobEffects.STERBEN)) this.burnUndead();
    }
}
