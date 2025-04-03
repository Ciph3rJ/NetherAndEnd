package net.enderboy500.netherandend.util.type;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.WoodType;

import java.util.Map;

public class NetherAndEndWoodTypes {
    private static final Map<String, WoodType> VALUES = new Object2ObjectArrayMap();
    public static final WoodType CHORUS = register(new WoodType("chorus", NetherAndEndBlockSetTypes.CHORUS));

    private static WoodType register(WoodType type) {
        VALUES.put(type.name(), type);
        return type;
    }
}
