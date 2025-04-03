package net.enderboy500.netherandend.util.type;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;

import java.util.Map;

public class NetherAndEndBlockSetTypes {
    private static final Map<String, BlockSetType> VALUES = new Object2ObjectArrayMap();
    public static final BlockSetType CHORUS = register(new BlockSetType("chorus"));

    private static BlockSetType register(BlockSetType blockSetType) {
        VALUES.put(blockSetType.name(), blockSetType);
        return blockSetType;
    }
}
