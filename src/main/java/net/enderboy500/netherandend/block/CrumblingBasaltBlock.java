package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrumblingBasaltBlock extends CrumblingBlock {
    public static final MapCodec<CrumblingBasaltBlock> CODEC = simpleCodec(CrumblingBasaltBlock::new);

    public CrumblingBasaltBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (!livingEntity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                livingEntity.hurt(level.damageSources().hotFloor(), 1);
            }
        }
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
