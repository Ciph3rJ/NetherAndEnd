package net.enderboy500.netherandend.mixin.accessor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CoralBlock.class)
public interface CoralBlockAccessor {
    @Accessor
    Block getDeadBlock();
}
