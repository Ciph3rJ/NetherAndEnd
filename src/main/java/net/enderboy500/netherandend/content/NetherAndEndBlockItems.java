package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NetherAndEndBlockItems {
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(NetherAndEnd.MOD_ID);

    public static final DeferredItem<BlockItem> CHORUS_BLOCK = BLOCK_ITEMS.registerSimpleBlockItem("chorus_block", NetherAndEndBlocks.CHORUS_BLOCK, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_PLANKS = BLOCK_ITEMS.registerSimpleBlockItem("chorus_planks", NetherAndEndBlocks.CHORUS_PLANKS, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_STAIRS = BLOCK_ITEMS.registerSimpleBlockItem("chorus_stairs", NetherAndEndBlocks.CHORUS_STAIRS, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_SLAB = BLOCK_ITEMS.registerSimpleBlockItem("chorus_slab", NetherAndEndBlocks.CHORUS_SLAB, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_FENCE = BLOCK_ITEMS.registerSimpleBlockItem("chorus_fence", NetherAndEndBlocks.CHORUS_FENCE, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_FENCE_GATE = BLOCK_ITEMS.registerSimpleBlockItem("chorus_fence_gate", NetherAndEndBlocks.CHORUS_FENCE_GATE, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_BUTTON = BLOCK_ITEMS.registerSimpleBlockItem("chorus_button", NetherAndEndBlocks.CHORUS_BUTTON, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_PRESSURE_PLATE = BLOCK_ITEMS.registerSimpleBlockItem("chorus_pressure_plate", NetherAndEndBlocks.CHORUS_PRESSURE_PLATE, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_DOOR = BLOCK_ITEMS.registerSimpleBlockItem("chorus_door", NetherAndEndBlocks.CHORUS_DOOR, new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_TRAPDOOR = BLOCK_ITEMS.registerSimpleBlockItem("chorus_trapdoor", NetherAndEndBlocks.CHORUS_TRAPDOOR, new Item.Properties());

    public static final DeferredItem<BlockItem> NETHER_COAL_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_coal_ore", NetherAndEndBlocks.NETHER_COAL_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_IRON_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_iron_ore", NetherAndEndBlocks.NETHER_IRON_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_COPPER_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_copper_ore", NetherAndEndBlocks.NETHER_COPPER_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_REDSTONE_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_redstone_ore", NetherAndEndBlocks.NETHER_REDSTONE_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_EMERALD_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_emerald_ore", NetherAndEndBlocks.NETHER_EMERALD_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_LAPIS_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_lapis_ore", NetherAndEndBlocks.NETHER_LAPIS_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> NETHER_DIAMOND_ORE = BLOCK_ITEMS.registerSimpleBlockItem("nether_diamond_ore", NetherAndEndBlocks.NETHER_DIAMOND_ORE, new Item.Properties());

    public static final DeferredItem<BlockItem> END_COAL_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_coal_ore", NetherAndEndBlocks.END_COAL_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_IRON_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_iron_ore", NetherAndEndBlocks.END_IRON_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_GOLD_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_gold_ore", NetherAndEndBlocks.END_GOLD_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_COPPER_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_copper_ore", NetherAndEndBlocks.END_COPPER_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_REDSTONE_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_redstone_ore", NetherAndEndBlocks.END_REDSTONE_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_EMERALD_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_emerald_ore", NetherAndEndBlocks.END_EMERALD_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_LAPIS_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_lapis_ore", NetherAndEndBlocks.END_LAPIS_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> END_DIAMOND_ORE = BLOCK_ITEMS.registerSimpleBlockItem("end_diamond_ore", NetherAndEndBlocks.END_DIAMOND_ORE, new Item.Properties());
    public static final DeferredItem<BlockItem> ENDER_PEARL_CLUSTER = BLOCK_ITEMS.registerSimpleBlockItem("ender_pearl_cluster", NetherAndEndBlocks.ENDER_PEARL_CLUSTER, new Item.Properties());

    public static final DeferredItem<BlockItem> CRACKED_BEDROCK = BLOCK_ITEMS.registerSimpleBlockItem("cracked_bedrock", NetherAndEndBlocks.CRACKED_BEDROCK, new Item.Properties());
    public static final DeferredItem<BlockItem> CRUMBLING_BASALT = BLOCK_ITEMS.registerSimpleBlockItem("crumbling_basalt", NetherAndEndBlocks.CRUMBLING_BASALT, new Item.Properties());

    public static void loadBlockItems(IEventBus eventBus) {
        BLOCK_ITEMS.register(eventBus);
    }
}
