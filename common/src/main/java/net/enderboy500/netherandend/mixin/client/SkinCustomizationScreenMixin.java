package net.enderboy500.netherandend.mixin.client;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.options.NetherAndEndCustomizationScreen;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.client.gui.screens.options.SkinCustomizationScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(SkinCustomizationScreen.class)
public abstract class SkinCustomizationScreenMixin extends OptionsSubScreen {
    public SkinCustomizationScreenMixin(Screen lastScreen, Options options, Component title) {
        super(lastScreen, options, title);
    }

    @Inject(method = "addOptions", at = @At("TAIL"))
    public void nae$skinOptions(CallbackInfo ci) {
        List<AbstractWidget> widgets = new ArrayList();
        widgets.add(this.addRenderableWidget(NetherAndEndUtils.makeButton("options.netherandend.customize", "options.netherandend.customize.narration",
                Constants.id("icon/nether_and_end_options"), 150, (var) -> Minecraft.getInstance().setScreenAndShow(new NetherAndEndCustomizationScreen(this)), false)));
        list.addSmall(widgets);
    }
}
