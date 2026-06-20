package net.enderboy500.netherandend.item;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.NetherAndEndItems;
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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ShulkerFalchionItem extends Item {
    public ShulkerFalchionItem(Properties properties) {
        super(properties.sword(NetherAndEndToolMaterials.SHULKER_FALCHION, 3.0F, -2.4F).rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (player.getInventory().contains(NetherAndEndItems.SHULKER_PEARL.get().getDefaultInstance())) {
            if (player.getLastHurtMob() != null) {
                level.addFreshEntity(new ShulkerBullet(level, player, player.getLastHurtMob(), player.getNearestViewDirection().getAxis()));
                player.getCooldowns().addCooldown(this.getDefaultInstance(), 10);
                for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
                    if (player.getInventory().getItem(slot).is(NetherAndEndItems.SHULKER_PEARL.get())) {
                        player.getInventory().getItem(slot).shrink(1);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.netherandend.explanation.shulker_falchion").withStyle(ChatFormatting.GRAY));
        } else {
            builder.accept(Component.translatable("tooltip.netherandend.explanation.instructions"));
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
