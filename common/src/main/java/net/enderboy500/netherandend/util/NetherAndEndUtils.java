package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.SpriteIconButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.input.InputWithModifiers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class NetherAndEndUtils {
    public static void loadUtils() {
        NetherAndEndFoodComponents.loadFoodComponents();
        NetherAndEndConsumableComponents.loadConsumableComponents();

        NetherAndEndBlockSetTypes.loadBlockSetTypes();
        NetherAndEndWoodTypes.loadWoodTypes();

        NetherAndEndTags.loadTags();
    }

    public static SpriteIconButton makeButton(String translationKey, String narrationTranslationKey, Identifier iconPath, int width, Button.OnPress onPress, boolean iconOnly) {
        SpriteIconButton button = SpriteIconButton.builder(Component.translatable(translationKey), onPress, iconOnly).width(width).sprite(iconPath, 15, 15).narration((var0) -> Component.translatable(narrationTranslationKey)).build();
        button.setTooltip(Tooltip.create(Component.translatable(translationKey)));
        return button;
    }
}