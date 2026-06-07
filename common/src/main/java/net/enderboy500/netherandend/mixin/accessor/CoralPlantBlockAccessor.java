package net.enderboy500.netherandend.mixin.accessor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralPlantBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CoralPlantBlock.class)
public interface CoralPlantBlockAccessor {
    @Accessor
    Block getDeadBlock();
}