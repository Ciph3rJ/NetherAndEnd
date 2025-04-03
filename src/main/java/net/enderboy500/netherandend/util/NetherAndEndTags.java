package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class NetherAndEndTags {
    public static TagKey<Block> CHORUS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(NetherAndEnd.MOD_ID).withPath("chorus"));
    public static TagKey<Block> NETHER_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(NetherAndEnd.MOD_ID).withPath("nether_ores"));
    public static TagKey<Block> END_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(NetherAndEnd.MOD_ID).withPath("end_ores"));

    public static TagKey<Item> HOGCHOP = TagKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID).withPath("hogchop"));
    public static TagKey<Item> STRIDER_MEAT = TagKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID).withPath("strider_meat"));
    public static TagKey<Item> STRIDER_MEAT_BLASTABLE = TagKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID).withPath("strider_meat_blastable"));

    public static TagKey<Item> REPAIRS_SHULKER_FALCHION = TagKey.of(RegistryKeys.ITEM, Identifier.of(NetherAndEnd.MOD_ID).withPath("repairs_shulker_falchion"));

    public static void loadTags() {}
}
