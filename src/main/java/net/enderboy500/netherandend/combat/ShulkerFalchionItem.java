package net.enderboy500.netherandend.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ShulkerFalchionItem extends SwordItem {
    public ShulkerFalchionItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,200, 1), attacker);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,80,0));
        return super.postHit(stack, target, attacker);
    }
}
