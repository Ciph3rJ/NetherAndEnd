package net.enderboy500.netherandend.item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

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
}
