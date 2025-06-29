package net.enderboy500.netherandend.util.type;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;

import java.util.Map;
import java.util.stream.Stream;

public class NetherAndEndBlockSetTypes {
    private static final Map<String, BlockSetType> TYPES = new Object2ObjectArrayMap<>();

    public static final BlockSetType CHORUS = register(new BlockSetType("chorus"));

    public static BlockSetType register(BlockSetType value) {
        TYPES.put(value.name(), value);
        return value;
    }

    public static void loadBlockSetTypes(IEventBus eventBus) {}
}
