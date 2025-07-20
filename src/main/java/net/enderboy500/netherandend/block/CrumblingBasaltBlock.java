package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrumblingBasaltBlock extends CrumblingBlock{
    public CrumblingBasaltBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends CrumblingBlock> getCodec() {
        return null;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof PlayerEntity player && world.getBlockState(pos.up()).isOf(Blocks.AIR) && player.getEquippedStack(EquipmentSlot.FEET).isEmpty() && !player.isSneaking()) {
            if (!player.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                entity.serverDamage(world.getDamageSources().hotFloor(), 1.0F);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
