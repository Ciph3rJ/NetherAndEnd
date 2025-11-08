package net.enderboy500.netherandend.util;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NetherAndEndTags {
    public static TagKey<Block> CHORUS = TagKey.create(Registries.BLOCK, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("chorus"));
    public static TagKey<Block> NETHER_ORES = TagKey.create(Registries.BLOCK, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("nether_ores"));
    public static TagKey<Block> END_ORES = TagKey.create(Registries.BLOCK, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("end_ores"));

    public static TagKey<Item> HOGCHOP = TagKey.create(Registries.ITEM, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("hogchop"));
    public static TagKey<Item> STRIDER_MEAT = TagKey.create(Registries.ITEM, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("strider_meat"));
    public static TagKey<Item> STRIDER_MEAT_BLASTABLE = TagKey.create(Registries.ITEM, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("strider_meat_blastable"));

    public static TagKey<Item> REPAIRS_SHULKER_FALCHION = TagKey.create(Registries.ITEM, ResourceLocation.parse(NetherAndEnd.MOD_ID).withPath("repairs_shulker_falchion"));

    public static void loadTags() {}
}
