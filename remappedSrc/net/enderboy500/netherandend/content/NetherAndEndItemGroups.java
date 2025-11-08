package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.compat.NEFDCompat;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class NetherAndEndItemGroups {
    public static final CreativeModeTab NETHER_AND_END_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "nether_and_end_group"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemgroup.netherandend"))
                    .icon(NetherAndEndBlockItems.END_DIAMOND_ORE::getDefaultInstance)
                    .displayItems((displayContext, entries) -> {
                        entries.accept(NetherAndEndBlockItems.NETHER_COAL_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_IRON_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_COPPER_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_REDSTONE_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_EMERALD_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_LAPIS_ORE);
                        entries.accept(NetherAndEndBlockItems.NETHER_DIAMOND_ORE);
                        entries.accept(NetherAndEndBlockItems.CRACKED_BEDROCK);
                        entries.accept(NetherAndEndBlockItems.CRUMBLING_BASALT);
                        entries.accept(NetherAndEndItems.WARPED_WART);
                        entries.accept(NetherAndEndItems.WARPED_STEW);
                        entries.accept(NetherAndEndBlockItems.WARPED_CAKE);
                        if (FabricLoader.getInstance().isModLoaded("farmersdelight")) entries.accept(NEFDCompat.WARPED_CAKE_SLICE);
                        entries.accept(NetherAndEndItems.RAW_HOGCHOP);
                        entries.accept(NetherAndEndItems.COOKED_HOGCHOP);
                        entries.accept(NetherAndEndItems.HOGLIN_SKIN);
                        entries.accept(NetherAndEndItems.HOGLIN_BUNDLE);
                        entries.accept(NetherAndEndItems.RAW_STRIDER_MEAT);
                        entries.accept(NetherAndEndItems.SMOKED_STRIDER_MEAT);
                        entries.accept(NetherAndEndItems.COOKED_STRIDER_MEAT);
                        entries.accept(NetherAndEndItems.HARDENED_STRIDER_MEAT);

                        entries.accept(NetherAndEndBlockItems.END_COAL_ORE);
                        entries.accept(NetherAndEndBlockItems.END_IRON_ORE);
                        entries.accept(NetherAndEndBlockItems.END_COPPER_ORE);
                        entries.accept(NetherAndEndBlockItems.END_GOLD_ORE);
                        entries.accept(NetherAndEndBlockItems.END_REDSTONE_ORE);
                        entries.accept(NetherAndEndBlockItems.END_EMERALD_ORE);
                        entries.accept(NetherAndEndBlockItems.END_LAPIS_ORE);
                        entries.accept(NetherAndEndBlockItems.END_DIAMOND_ORE);
                        entries.accept(NetherAndEndBlockItems.CHORUS_BLOCK);
                        entries.accept(NetherAndEndBlockItems.CHORUS_PLANKS);
                        entries.accept(NetherAndEndBlockItems.CHORUS_STAIRS);
                        entries.accept(NetherAndEndBlockItems.CHORUS_SLAB);
                        entries.accept(NetherAndEndBlockItems.CHORUS_FENCE);
                        entries.accept(NetherAndEndBlockItems.CHORUS_FENCE_GATE);
                        entries.accept(NetherAndEndBlockItems.CHORUS_DOOR);
                        entries.accept(NetherAndEndBlockItems.CHORUS_TRAPDOOR);
                        entries.accept(NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE);
                        entries.accept(NetherAndEndBlockItems.CHORUS_BUTTON);
                        entries.accept(NetherAndEndBlockItems.CHORUS_SHELF);
                        entries.accept(NetherAndEndItems.ENDER_FRUIT);
                        entries.accept(NetherAndEndItems.CHORUS_SOUP);
                        entries.accept(NetherAndEndItems.CHORUS_PIE);
                        entries.accept(NetherAndEndItems.SHULKER_PEARL);
                        entries.accept(NetherAndEndItems.HARDENED_SHULKER_PEARL);
                        entries.accept(NetherAndEndItems.SHULKER_FALCHION);
                        entries.accept(NetherAndEndBlockItems.ENDER_PEARL_CLUSTER);
                        entries.accept(NetherAndEndItems.DRAGON_CHARGE);
                    }).build());

    public static void loadItemGroups() {}
}
