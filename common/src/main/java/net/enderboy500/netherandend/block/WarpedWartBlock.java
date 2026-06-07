package net.enderboy500.netherandend.block;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WarpedWartBlock extends NetherWartBlock {
    public WarpedWartBlock(Properties properties) {
        super(properties);
    }

    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(NetherAndEndBlocks.WARPED_WART.blockItem().get());
    }
}
