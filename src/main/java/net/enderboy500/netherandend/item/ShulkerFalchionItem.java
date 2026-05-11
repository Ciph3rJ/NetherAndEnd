package net.enderboy500.netherandend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ShulkerFalchionItem extends Item {
    public ShulkerFalchionItem(Properties settings) {
        super(settings);
    }

    @Override
    public float getAttackDamageBonus(Entity target, float baseAttackDamage, DamageSource damageSource) {
        if (target instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 1));
            if (living.getLastHurtByMob() != null) {
                living.getLastHurtByMob().addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 200, 0));
            }
        }
        return super.getAttackDamageBonus(target, baseAttackDamage, damageSource);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.netherandend.explanation.shulker_falchion").withStyle(ChatFormatting.GRAY));
        } else {
            consumer.accept(Component.translatable("tooltip.netherandend.explanation.instructions"));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
    }
}
