package net.enderboy500.netherandend.util.type;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;

import java.util.Map;

public class NetherAndEndWoodTypes {
    private static final Map<String, WoodType> TYPES = new Object2ObjectArrayMap<>();

    public static final WoodType CHORUS = register(new WoodType("chorus", NetherAndEndBlockSetTypes.CHORUS));

    public static WoodType register(WoodType woodType) {
        TYPES.put(woodType.name(), woodType);
        return woodType;
    }

    public static void loadWoodTypes(IEventBus eventBus) {}
}
