package net.enderboy500.netherandend.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ShulkerFalchionItem extends Item {
    public ShulkerFalchionItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (player.getLastAttacker() == null) {
            return super.use(level, player, interactionHand);
        } else {
            level.addFreshEntity(new ShulkerBullet(level, player, player.getLastAttacker(), player.getNearestViewDirection().getAxis()));
            player.getCooldowns().addCooldown(this.getDefaultInstance(), 10);
            return InteractionResult.SUCCESS;
        }
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
