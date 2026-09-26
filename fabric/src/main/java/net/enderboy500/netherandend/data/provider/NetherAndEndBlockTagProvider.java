package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.content.FabricBlocks;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public NetherAndEndBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(NetherAndEndTags.CHORUS)
                .addElement(NetherAndEndBlocks.CHORUS_BLOCK.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_PLANKS.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_STAIRS.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_SLAB.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_FENCE.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_FENCE_GATE.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_DOOR.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_TRAPDOOR.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_BUTTON.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_SHELF.block().id())
        ;

        getOrCreateRawBuilder(NetherAndEndTags.NETHER_ORES)
                .addElement(NetherAndEndBlocks.NETHER_COAL_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_IRON_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_COPPER_ORE.block().id())
                .addElement(Identifier.withDefaultNamespace("nether_gold_ore"))
                .addElement(NetherAndEndBlocks.NETHER_REDSTONE_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_EMERALD_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_LAPIS_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_DIAMOND_ORE.block().id())
                .addElement(Identifier.withDefaultNamespace("nether_quartz_ore"))
                .addElement(Identifier.withDefaultNamespace("ancient_debris"))
        ;

        getOrCreateRawBuilder(NetherAndEndTags.END_ORES)
                .addElement(NetherAndEndBlocks.END_COAL_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_IRON_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_COPPER_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_GOLD_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_REDSTONE_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_EMERALD_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_LAPIS_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_DIAMOND_ORE.block().id())
                .addElement(NetherAndEndBlocks.ENDER_PEARL_CLUSTER.block().id())
        ;

        getOrCreateRawBuilder(ConventionalBlockTags.ORES)
                .addTag(NetherAndEndTags.NETHER_ORES.location())
                .addTag(NetherAndEndTags.END_ORES.location())
        ;
        
        getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_AXE)
                .addTag(NetherAndEndTags.CHORUS.location())
        ;
        
        getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addElement(NetherAndEndBlocks.CRACKED_BEDROCK.block().id())
                .addElement(NetherAndEndBlocks.CRUMBLING_BASALT.block().id())
                
                .addElement(NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.block().id())
                .addElement(NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS.block().id())
                .addElement(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.block().id())
                .addElement(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.block().id())
                .addElement(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().id())
                .addElement(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.block().id())
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.block().id())
                .addElement(NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.block().id())
                .addElement(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().id())
                
                .addTag(NetherAndEndTags.NETHER_ORES.location())
                .addTag(NetherAndEndTags.END_ORES.location())
        ;

        getOrCreateRawBuilder(BlockTags.NEEDS_STONE_TOOL)
                .addElement(NetherAndEndBlocks.NETHER_IRON_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_COPPER_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_LAPIS_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_IRON_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_COPPER_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_LAPIS_ORE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.NEEDS_IRON_TOOL)
                .addElement(NetherAndEndBlocks.NETHER_REDSTONE_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_EMERALD_ORE.block().id())
                .addElement(NetherAndEndBlocks.NETHER_DIAMOND_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_GOLD_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_REDSTONE_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_EMERALD_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_DIAMOND_ORE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.PLANKS)
                .addElement(NetherAndEndBlocks.CHORUS_PLANKS.block().id())
        ;
        
        getOrCreateRawBuilder(BlockTags.BUTTONS)
                .addElement(NetherAndEndBlocks.CHORUS_BUTTON.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.PRESSURE_PLATES)
                .addElement(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.DOORS)
                .addElement(NetherAndEndBlocks.CHORUS_DOOR.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.FENCES)
                .addElement(NetherAndEndBlocks.CHORUS_FENCE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.FENCE_GATES)
                .addElement(NetherAndEndBlocks.CHORUS_FENCE_GATE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.SLABS)
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().id())
                .addElement(NetherAndEndBlocks.CHORUS_SLAB.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.TRAPDOORS)
                .addElement(NetherAndEndBlocks.CHORUS_TRAPDOOR.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.TRAPDOORS)
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_BUTTONS)
                .addElement(NetherAndEndBlocks.CHORUS_BUTTON.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_DOORS)
                .addElement(NetherAndEndBlocks.CHORUS_DOOR.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_FENCES)
                .addElement(NetherAndEndBlocks.CHORUS_FENCE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .addElement(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_SHELVES)
                .addElement(NetherAndEndBlocks.CHORUS_SHELF.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_SLABS)
                .addElement(NetherAndEndBlocks.CHORUS_SLAB.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_STAIRS)
                .addElement(NetherAndEndBlocks.CHORUS_STAIRS.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WOODEN_TRAPDOORS)
                .addElement(NetherAndEndBlocks.CHORUS_TRAPDOOR.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.CANDLE_CAKES)
                .addElement(FabricBlocks.WARPED_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_WHITE_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_LIGHT_GRAY_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_GRAY_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_BLACK_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_BROWN_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_RED_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_ORANGE_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_YELLOW_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_LIME_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_GREEN_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_CYAN_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_LIGHT_BLUE_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_BLUE_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_PURPLE_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_MAGENTA_CANDLE_CAKE.block().id())
                .addElement(FabricBlocks.WARPED_PINK_CANDLE_CAKE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.COPPER_ORES)
                .addElement(NetherAndEndBlocks.NETHER_COPPER_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_COPPER_ORE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.IRON_ORES)
                .addElement(NetherAndEndBlocks.NETHER_IRON_ORE.block().id())
                .addElement(NetherAndEndBlocks.END_IRON_ORE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.GOLD_ORES)
                .addElement(NetherAndEndBlocks.END_GOLD_ORE.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.WALLS)
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().id())
        ;

        getOrCreateRawBuilder(BlockTags.FENCES)
                .addElement(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.block().id())
        ;
    }
}
