package net.enderboy500.netherandend.options;

import net.enderboy500.netherandend.NetherAndEndCommon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

public class NetherAndEndCustomizationScreen extends OptionsSubScreen {
    public NetherAndEndCustomizationScreen(Screen lastScreen) {
        super(lastScreen, Minecraft.getInstance().options, Component.translatable("options.netherandend.customize.title"));
    }

    @Override
    public void onClose() {
        super.onClose();
        NetherAndEndCommon.options.save();
    }

    @Override
    protected void addOptions() {
        this.list.addSmall(NetherAndEndCommon.options.iconDesign);
    }
}
