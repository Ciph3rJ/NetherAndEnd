package net.enderboy500.netherandend.item;

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
        }
        return super.getBonusAttackDamage(target, baseAttackDamage, damageSource);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 80, 0));
        user.getItemCooldownManager().set(this.getDefaultStack(), 100);
        return super.use(world, user, hand);
    }
}
