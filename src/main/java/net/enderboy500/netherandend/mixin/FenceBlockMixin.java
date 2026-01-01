package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.block.BrickFenceGateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FenceBlock.class)
public abstract class FenceBlockMixin extends HorizontalConnectingBlock {
    public FenceBlockMixin(float radius1, float radius2, float boundingHeight1, float boundingHeight2, float collisionHeight, Settings settings) {
        super(radius1, radius2, boundingHeight1, boundingHeight2, collisionHeight, settings);
    }

    @Inject(method = "canConnect", at = @At("HEAD"), cancellable = true)
    public void canConnect(BlockState state, boolean neighborIsFullSquare, Direction dir, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof BrickFenceGateBlock && BrickFenceGateBlock.canWallConnect(state, dir)) {
            cir.setReturnValue(true);
        }
    }
}
