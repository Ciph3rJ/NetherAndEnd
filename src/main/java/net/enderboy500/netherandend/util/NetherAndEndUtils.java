package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.util.property.NetherAndEndConsumeEffectProperties;
import net.enderboy500.netherandend.util.property.NetherAndEndFoodProperties;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.neoforged.bus.api.IEventBus;

public class NetherAndEndUtils {
    public static void loadUtils(IEventBus eventBus) {
        NetherAndEndFoodProperties.loadFoodProperties(eventBus);
        NetherAndEndConsumeEffectProperties.loadConsumeEffectProperties(eventBus);

        NetherAndEndBlockSetTypes.loadBlockSetTypes(eventBus);
        NetherAndEndWoodTypes.loadWoodTypes(eventBus);
    }
}
