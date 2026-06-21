package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.content.NetherAndEndEffects;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.waypoints.TrackedWaypoint;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin implements TrackedWaypoint.Projector, AutoCloseable {
    @Shadow
    protected abstract void setPostEffect(Identifier id);

    @Shadow
    public abstract void clearPostEffect();

    @Mutable
    @Final
    @Shadow
    private final Minecraft minecraft;

    protected GameRendererMixin(Minecraft client) {
        this.minecraft = client;
    }

    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void nae$renderLevel(DeltaTracker deltaTracker, CallbackInfo ci) {
        if (this.minecraft != null) {
            LocalPlayer localPlayer = this.minecraft.player;
            if (localPlayer != null) {
                if (localPlayer.hasEffect(NetherAndEndEffects.INVERTED_VISION)) {
                    this.setPostEffect(Identifier.withDefaultNamespace("invert"));
                } else {
                    this.clearPostEffect();
                }
            }
        }
    }
}
