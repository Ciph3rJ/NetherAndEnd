package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.block.BrickFenceGateBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallBlockMixin extends Block {
    public WallBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "connectsTo", at = @At("HEAD"), cancellable = true)
    public void connectsTo(BlockState state, boolean neighborIsFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof BrickFenceGateBlock && BrickFenceGateBlock.connectsToDirection(state, side))
            cir.setReturnValue(true);
    }
}
