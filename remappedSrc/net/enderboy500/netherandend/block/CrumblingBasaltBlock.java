package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CrumblingBasaltBlock extends CrumblingBlock{
    public CrumblingBasaltBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends CrumblingBlock> codec() {
        return null;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof Player player && world.getBlockState(pos.above()).is(Blocks.AIR) && player.getItemBySlot(EquipmentSlot.FEET).isEmpty() && !player.isShiftKeyDown()) {
            if (!player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                entity.hurt(world.damageSources().hotFloor(), 1.0F);
            }
        }

        super.stepOn(world, pos, state, entity);
    }
}
