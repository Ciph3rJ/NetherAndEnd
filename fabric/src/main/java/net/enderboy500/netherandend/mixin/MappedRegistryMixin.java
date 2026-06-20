package net.enderboy500.netherandend.mixin;

import net.enderboy500.netherandend.Constants;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MappedRegistry.class, priority=10)
public abstract class MappedRegistryMixin<T> implements WritableRegistry<T> {
    @Shadow
    private boolean frozen;

    @Inject(method = "freeze", at = @At("HEAD"))
    public void freeze(CallbackInfoReturnable<Registry<T>> cir) {
        if (this.frozen) return;

        try {
            this.addAlias(Constants.id("raw_hogchop"), Identifier.withDefaultNamespace("porkchop"));
        } catch (Throwable e) {
            Constants.LOG.error("Failed to set alias 'netherandend:raw_hogchop' -> 'minecraft:porkchop'");
        }

        try {
            this.addAlias(Constants.id("cooked_hogchop"), Identifier.withDefaultNamespace("cooked_porkchop"));
        } catch (Throwable e) {
            Constants.LOG.error("Failed to set alias 'netherandend:cooked_hogchop' -> 'minecraft:cooked_porkchop'");
        }

        try {
            this.addAlias(Constants.id("hardened_strider_meat"), Constants.id("burnt_strider_meat"));
        } catch (Throwable e) {
            Constants.LOG.error("Failed to set alias 'netherandend:hardened_strider_meat' -> 'minecraft:burnt_strider_meat'");
        }
    }
}
