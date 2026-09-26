package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.content.FabricBlocks;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockLootTableProvider extends FabricBlockLootSubProvider {
    public NetherAndEndBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropOther(FabricBlocks.WARPED_BLACK_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.black());
        dropOther(FabricBlocks.WARPED_BLUE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.blue());
        dropOther(FabricBlocks.WARPED_BROWN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.brown());
        dropSelf(NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.block().get());
        dropSelf(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_BLOCK.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_BUTTON.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_DOOR.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_FENCE.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_FENCE_GATE.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_PLANKS.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_SHELF.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_STAIRS.block().get());
        dropSelf(NetherAndEndBlocks.CHORUS_TRAPDOOR.block().get());
        dropSelf(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.block().get());
        dropSelf(NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS.block().get());
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.block().get());
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.block().get());
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.block().get());
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().get());
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get());
        dropOther(FabricBlocks.WARPED_CYAN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.cyan());
        dropOther(FabricBlocks.WARPED_GRAY_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.gray());
        dropOther(FabricBlocks.WARPED_GREEN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.green());
        dropOther(FabricBlocks.WARPED_LIGHT_BLUE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lightBlue());
        dropOther(FabricBlocks.WARPED_LIGHT_GRAY_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lightGray());
        dropOther(FabricBlocks.WARPED_LIME_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lime());
        dropOther(FabricBlocks.WARPED_MAGENTA_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.magenta());
        dropSelf(NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.block().get());
        dropOther(FabricBlocks.WARPED_ORANGE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.orange());
        dropOther(FabricBlocks.WARPED_PINK_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.pink());
        dropOther(FabricBlocks.WARPED_PURPLE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.purple());
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.block().get());
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.block().get());
        dropOther(FabricBlocks.WARPED_RED_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.red());
        dropSelf(NetherAndEndBlocks.WARPED_WART.block().get());
        dropOther(FabricBlocks.WARPED_WHITE_CANDLE_CAKE.block().get(), Items.DYED_BUNDLE.white());
        dropSelf(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get());
        dropOther(FabricBlocks.WARPED_YELLOW_CANDLE_CAKE.block().get(), Items.DYED_BUNDLE.yellow());
    }
}
