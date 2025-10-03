package net.enderboy500.netherandend.combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ShulkerFalchionItem extends Item {
    public ShulkerFalchionItem(Settings settings) {
        super(settings);
    }

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        if (target instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 1));
            if (living.getAttacker() != null) living.getAttacker().addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0));
        }
        return super.getBonusAttackDamage(target, baseAttackDamage, damageSource);
    }
}
