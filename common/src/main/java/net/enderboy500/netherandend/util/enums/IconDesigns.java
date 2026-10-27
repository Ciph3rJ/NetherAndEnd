package net.enderboy500.netherandend.util.enums;

import com.mojang.serialization.Codec;
import net.enderboy500.netherandend.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.Nullable;

public enum IconDesigns implements StringRepresentable {
    NONE("none", Constants.id("none"), null),
    WARPED("warped", Constants.id("warped"), '\uE001'),
    CRIMSON("crimson", Constants.id("crimson"), '\uE002')
    ;

    public static final Codec<IconDesigns> CODEC = StringRepresentable.fromEnum(IconDesigns::values);
    private String name;
    private Identifier id;
    private Character character;
    private final Component translatable;
    private final Component tooltip;

    IconDesigns(String name, Identifier id, @Nullable Character character) {
        this.name = name;
        this.id = id;
        this.character = character;
        this.translatable = Component.translatable("option." + id.getNamespace() + ".icon_designs." + id.getPath());
        this.tooltip = Component.translatable("option." + id.getNamespace() + ".icon_designs." + id.getPath());
    }

    public Component getTooltip() {
        return tooltip;
    }

    public Component getTranslatable() {
        return translatable;
    }

    public String getName() {
        return name;
    }

    public Identifier getId() {
        return id;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
