package net.enderboy500.netherandend.mixin.accessor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralFanBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CoralFanBlock.class)
public interface CoralFanBlockAccessor {
    @Accessor
    Block getDeadBlock();
}
