package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NetherAndEndItemGroups {
    public static final ItemGroup NETHER_AND_END_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NetherAndEnd.MOD_ID, "nether_and_end_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.netherandend"))
                    .icon(NetherAndEndBlockItems.END_DIAMOND_ORE::getDefaultStack)
                    .entries((displayContext, entries) -> {
                        entries.add(NetherAndEndBlockItems.NETHER_COAL_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_IRON_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_COPPER_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_REDSTONE_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_EMERALD_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_LAPIS_ORE);
                        entries.add(NetherAndEndBlockItems.NETHER_DIAMOND_ORE);
                        entries.add(NetherAndEndBlockItems.CRACKED_BEDROCK);
                        entries.add(NetherAndEndBlockItems.CRUMBLING_BASALT);
                        entries.add(NetherAndEndItems.WARPED_WART);
                        entries.add(NetherAndEndItems.WARPED_STEW);
                        entries.add(NetherAndEndItems.RAW_HOGCHOP);
                        entries.add(NetherAndEndItems.COOKED_HOGCHOP);
                        entries.add(NetherAndEndItems.HOGLIN_SKIN);
                        entries.add(NetherAndEndItems.RAW_STRIDER_MEAT);
                        entries.add(NetherAndEndItems.SMOKED_STRIDER_MEAT);
                        entries.add(NetherAndEndItems.COOKED_STRIDER_MEAT);
                        entries.add(NetherAndEndItems.HARDENED_STRIDER_MEAT);

                        entries.add(NetherAndEndBlockItems.END_COAL_ORE);
                        entries.add(NetherAndEndBlockItems.END_IRON_ORE);
                        entries.add(NetherAndEndBlockItems.END_COPPER_ORE);
                        entries.add(NetherAndEndBlockItems.END_GOLD_ORE);
                        entries.add(NetherAndEndBlockItems.END_REDSTONE_ORE);
                        entries.add(NetherAndEndBlockItems.END_EMERALD_ORE);
                        entries.add(NetherAndEndBlockItems.END_LAPIS_ORE);
                        entries.add(NetherAndEndBlockItems.END_DIAMOND_ORE);
                        entries.add(NetherAndEndBlockItems.CHORUS_BLOCK);
                        entries.add(NetherAndEndBlockItems.CHORUS_PLANKS);
                        entries.add(NetherAndEndBlockItems.CHORUS_STAIRS);
                        entries.add(NetherAndEndBlockItems.CHORUS_SLAB);
                        entries.add(NetherAndEndBlockItems.CHORUS_FENCE);
                        entries.add(NetherAndEndBlockItems.CHORUS_FENCE_GATE);
                        entries.add(NetherAndEndBlockItems.CHORUS_DOOR);
                        entries.add(NetherAndEndBlockItems.CHORUS_TRAPDOOR);
                        entries.add(NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE);
                        entries.add(NetherAndEndBlockItems.CHORUS_BUTTON);
                        entries.add(NetherAndEndItems.ENDER_FRUIT);
                        entries.add(NetherAndEndItems.CHORUS_SOUP);
                        entries.add(NetherAndEndItems.CHORUS_PIE);
                        entries.add(NetherAndEndItems.SHULKER_PEARL);
                        entries.add(NetherAndEndItems.HARDENED_SHULKER_PEARL);
                        entries.add(NetherAndEndItems.SHULKER_FALCHION);
                        entries.add(NetherAndEndBlockItems.ENDER_PEARL_CLUSTER);
                        entries.add(NetherAndEndItems.DRAGON_CHARGE);
                    }).build());

    public static void loadItemGroups() {}
}
