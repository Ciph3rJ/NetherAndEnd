package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.util.component.NetherAndEndConsumableComponents;
import net.enderboy500.netherandend.util.component.NetherAndEndFoodComponents;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;

public class NetherAndEndUtils {
    public static void loadUtils() {
        NetherAndEndTags.loadTags();
        NetherAndEndFoodComponents.loadFoodComponents();
        NetherAndEndConsumableComponents.loadConsumableComponents();
        NetherAndEndBlockSetTypes.loadBlockSetTypes();
        NetherAndEndWoodTypes.loadWoodTypes();
    }
}