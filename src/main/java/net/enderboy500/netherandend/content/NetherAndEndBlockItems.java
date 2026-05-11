package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class NetherAndEndBlockItems {
    public static final BlockItem CHORUS_BLOCK = register("chorus_block", NetherAndEndBlocks.CHORUS_BLOCK);
    public static final BlockItem CHORUS_PLANKS = register("chorus_planks", NetherAndEndBlocks.CHORUS_PLANKS);
    public static final BlockItem CHORUS_STAIRS = register("chorus_stairs", NetherAndEndBlocks.CHORUS_STAIRS);
    public static final BlockItem CHORUS_SLAB = register("chorus_slab", NetherAndEndBlocks.CHORUS_SLAB);
    public static final BlockItem CHORUS_FENCE = register("chorus_fence", NetherAndEndBlocks.CHORUS_FENCE);
    public static final BlockItem CHORUS_FENCE_GATE = register("chorus_fence_gate", NetherAndEndBlocks.CHORUS_FENCE_GATE);
    public static final BlockItem CHORUS_BUTTON = register("chorus_button", NetherAndEndBlocks.CHORUS_BUTTON);
    public static final BlockItem CHORUS_PRESSURE_PLATE = register("chorus_pressure_plate", NetherAndEndBlocks.CHORUS_PRESSURE_PLATE);
    public static final BlockItem CHORUS_DOOR = register("chorus_door", NetherAndEndBlocks.CHORUS_DOOR);
    public static final BlockItem CHORUS_TRAPDOOR = register("chorus_trapdoor", NetherAndEndBlocks.CHORUS_TRAPDOOR);
    public static final BlockItem CHORUS_SHELF = register("chorus_shelf", NetherAndEndBlocks.CHORUS_SHELF);

    public static final BlockItem WARPED_CAKE = register("warped_cake", NetherAndEndBlocks.WARPED_CAKE);

    public static final BlockItem NETHER_BRICK_FENCE_GATE = register("nether_brick_fence_gate", NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE);
    public static final BlockItem CRACKED_RED_NETHER_BRICKS = register("cracked_red_nether_bricks", NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS);
    public static final BlockItem RED_NETHER_BRICK_FENCE = register("red_nether_brick_fence", NetherAndEndBlocks.RED_NETHER_BRICK_FENCE);
    public static final BlockItem RED_NETHER_BRICK_FENCE_GATE = register("red_nether_brick_fence_gate", NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE);
    public static final BlockItem CHISELED_RED_NETHER_BRICKS = register("chiseled_red_nether_bricks", NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS);
    public static final BlockItem CYAN_NETHER_BRICKS = register("cyan_nether_bricks", NetherAndEndBlocks.CYAN_NETHER_BRICKS);
    public static final BlockItem CRACKED_CYAN_NETHER_BRICKS = register("cracked_cyan_nether_bricks", NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS);
    public static final BlockItem CYAN_NETHER_BRICK_STAIRS = register("cyan_nether_brick_stairs", NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS);
    public static final BlockItem CYAN_NETHER_BRICK_SLAB = register("cyan_nether_brick_slab", NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB);
    public static final BlockItem CYAN_NETHER_BRICK_WALL = register("cyan_nether_brick_wall", NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL);
    public static final BlockItem CYAN_NETHER_BRICK_FENCE = register("cyan_nether_brick_fence", NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE);
    public static final BlockItem CYAN_NETHER_BRICK_FENCE_GATE = register("cyan_nether_brick_fence_gate", NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE);
    public static final BlockItem CHISELED_CYAN_NETHER_BRICKS = register("chiseled_cyan_nether_bricks", NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS);

    public static final BlockItem NETHER_COAL_ORE = register("nether_coal_ore", NetherAndEndBlocks.NETHER_COAL_ORE);
    public static final BlockItem NETHER_IRON_ORE = register("nether_iron_ore", NetherAndEndBlocks.NETHER_IRON_ORE);
    public static final BlockItem NETHER_COPPER_ORE = register("nether_copper_ore", NetherAndEndBlocks.NETHER_COPPER_ORE);
    public static final BlockItem NETHER_REDSTONE_ORE = register("nether_redstone_ore", NetherAndEndBlocks.NETHER_REDSTONE_ORE);
    public static final BlockItem NETHER_EMERALD_ORE = register("nether_emerald_ore", NetherAndEndBlocks.NETHER_EMERALD_ORE);
    public static final BlockItem NETHER_LAPIS_ORE = register("nether_lapis_ore", NetherAndEndBlocks.NETHER_LAPIS_ORE);
    public static final BlockItem NETHER_DIAMOND_ORE = register("nether_diamond_ore", NetherAndEndBlocks.NETHER_DIAMOND_ORE);

    public static final BlockItem END_COAL_ORE = register("end_coal_ore", NetherAndEndBlocks.END_COAL_ORE);
    public static final BlockItem END_IRON_ORE = register("end_iron_ore", NetherAndEndBlocks.END_IRON_ORE);
    public static final BlockItem END_GOLD_ORE = register("end_gold_ore", NetherAndEndBlocks.END_GOLD_ORE);
    public static final BlockItem END_COPPER_ORE = register("end_copper_ore", NetherAndEndBlocks.END_COPPER_ORE);
    public static final BlockItem END_REDSTONE_ORE = register("end_redstone_ore", NetherAndEndBlocks.END_REDSTONE_ORE);
    public static final BlockItem END_EMERALD_ORE = register("end_emerald_ore", NetherAndEndBlocks.END_EMERALD_ORE);
    public static final BlockItem END_LAPIS_ORE = register("end_lapis_ore", NetherAndEndBlocks.END_LAPIS_ORE);
    public static final BlockItem END_DIAMOND_ORE = register("end_diamond_ore", NetherAndEndBlocks.END_DIAMOND_ORE);
    public static final BlockItem ENDER_PEARL_CLUSTER = register("ender_pearl_cluster", NetherAndEndBlocks.ENDER_PEARL_CLUSTER);

    public static final BlockItem CRACKED_BEDROCK = register("cracked_bedrock", NetherAndEndBlocks.CRACKED_BEDROCK);
    public static final BlockItem CRUMBLING_BASALT = register("crumbling_basalt", NetherAndEndBlocks.CRUMBLING_BASALT);
    public static final BlockItem WITHERED_BONE_BLOCK = register("withered_bone_block", NetherAndEndBlocks.WIHERED_BONE_BLOCK);

    public static <I extends Item> I registerItem(String id, Function<Item.Properties, I> factory, Item.Properties settings) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, id));
        I item = factory.apply(settings.setId(key));

        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, blockItem);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static BlockItem register(String id, Block block) {
        return registerItem(id, settings -> new BlockItem(block, settings), new Item.Properties().useBlockDescriptionPrefix());
    }

    public static void loadBlockItems() {}
}
