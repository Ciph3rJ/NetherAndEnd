package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.block.BrickFenceGateBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FenceBlock.class)
public abstract class FenceBlockMixin extends CrossCollisionBlock {
    public FenceBlockMixin(float radius1, float radius2, float boundingHeight1, float boundingHeight2, float collisionHeight, Properties properties) {
        super(radius1, radius2, boundingHeight1, boundingHeight2, collisionHeight, properties);
    }

    @Inject(method = "connectsTo", at = @At("HEAD"), cancellable = true)
    public void connectsTo(BlockState state, boolean neighborIsFullSquare, Direction dir, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof BrickFenceGateBlock && BrickFenceGateBlock.connectsToDirection(state, dir))
            cir.setReturnValue(true);
    }
}
