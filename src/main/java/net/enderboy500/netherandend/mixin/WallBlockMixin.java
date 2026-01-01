package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.block.BrickFenceGateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public class WallBlockMixin extends Block {
    public WallBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "shouldConnectTo", at = @At("HEAD"), cancellable = true)
    public void shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof BrickFenceGateBlock && BrickFenceGateBlock.canWallConnect(state, side)) {
            cir.setReturnValue(true);
        }
    }
}
