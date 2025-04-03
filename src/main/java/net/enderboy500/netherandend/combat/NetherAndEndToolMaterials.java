package net.enderboy500.netherandend.combat;

import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class NetherAndEndToolMaterials {
    // tagKey = inverseTag
    // i = durability
    // f = miningSpeedMultiplier
    // g = attackDamage
    // j = enchantability
    // tagKey2 = repairIngredient

    public static final ToolMaterial SHULKER_FALCHION = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            966,
            3,
            7,
            1,
            NetherAndEndTags.REPAIRS_SHULKER_FALCHION);
}
