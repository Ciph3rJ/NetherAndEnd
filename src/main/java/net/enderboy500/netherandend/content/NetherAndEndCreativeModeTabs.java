package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NetherAndEndCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NetherAndEnd.MOD_ID);

    public static final Supplier<CreativeModeTab> NETHER_AND_END = CREATIVE_MODE_TABS.register("nether_and_end",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(NetherAndEndBlockItems.NETHER_DIAMOND_ORE.get()))
                    .title(Component.translatable("creativetab.netherandend"))
                    .displayItems(((parameters, output) -> {
                        output.accept(NetherAndEndBlockItems.NETHER_COAL_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_IRON_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_COPPER_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_REDSTONE_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_EMERALD_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_LAPIS_ORE);
                        output.accept(NetherAndEndBlockItems.NETHER_DIAMOND_ORE);
                        output.accept(NetherAndEndBlockItems.CRACKED_BEDROCK);
                        output.accept(NetherAndEndBlockItems.CRUMBLING_BASALT);

                        output.accept(NetherAndEndItems.WARPED_WART);
                        output.accept(NetherAndEndItems.WARPED_STEW);
                        output.accept(NetherAndEndItems.RAW_HOGCHOP);
                        output.accept(NetherAndEndItems.COOKED_HOGCHOP);
                        output.accept(NetherAndEndItems.HOGLIN_SKIN);
                        output.accept(NetherAndEndItems.RAW_STRIDER_MEAT);
                        output.accept(NetherAndEndItems.SMOKED_STRIDER_MEAT);
                        output.accept(NetherAndEndItems.COOKED_STRIDER_MEAT);
                        output.accept(NetherAndEndItems.HARDENED_STRIDER_MEAT);
                        
                        output.accept(NetherAndEndBlockItems.END_COAL_ORE);
                        output.accept(NetherAndEndBlockItems.END_IRON_ORE);
                        output.accept(NetherAndEndBlockItems.END_COPPER_ORE);
                        output.accept(NetherAndEndBlockItems.END_GOLD_ORE);
                        output.accept(NetherAndEndBlockItems.END_REDSTONE_ORE);
                        output.accept(NetherAndEndBlockItems.END_EMERALD_ORE);
                        output.accept(NetherAndEndBlockItems.END_LAPIS_ORE);
                        output.accept(NetherAndEndBlockItems.END_DIAMOND_ORE);

                        output.accept(NetherAndEndBlockItems.CHORUS_BLOCK);
                        output.accept(NetherAndEndBlockItems.CHORUS_PLANKS);
                        output.accept(NetherAndEndBlockItems.CHORUS_STAIRS);
                        output.accept(NetherAndEndBlockItems.CHORUS_SLAB);
                        output.accept(NetherAndEndBlockItems.CHORUS_FENCE);
                        output.accept(NetherAndEndBlockItems.CHORUS_FENCE_GATE);
                        output.accept(NetherAndEndBlockItems.CHORUS_DOOR);
                        output.accept(NetherAndEndBlockItems.CHORUS_TRAPDOOR);
                        output.accept(NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE);
                        output.accept(NetherAndEndBlockItems.CHORUS_BUTTON);

                        output.accept(NetherAndEndItems.ENDER_FRUIT);
                        output.accept(NetherAndEndItems.CHORUS_SOUP);
                        output.accept(NetherAndEndItems.CHORUS_PIE);
                        output.accept(NetherAndEndItems.SHULKER_PEARL);
                        output.accept(NetherAndEndItems.HARDENED_SHULKER_PEARL);
                        output.accept(NetherAndEndItems.SHULKER_FALCHION);
                        output.accept(NetherAndEndBlockItems.ENDER_PEARL_CLUSTER);
                        output.accept(NetherAndEndItems.DRAGON_CHARGE);
                    }))
                    .build());

    public static void loadCreativeModeTabs(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
