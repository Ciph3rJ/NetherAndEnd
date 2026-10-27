package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.content.NeoForgeBlocks;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Set;

public class NetherAndEndBlockLootSubProvider extends BlockLootSubProvider {
    public NetherAndEndBlockLootSubProvider(Context output) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), output);
    }

    @Override
    protected void generate() {
        dropOther(NeoForgeBlocks.WARPED_BLACK_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.black());
        dropOther(NeoForgeBlocks.WARPED_BLUE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.blue());
        dropOther(NeoForgeBlocks.WARPED_BROWN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.brown());
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
        dropOther(NeoForgeBlocks.WARPED_CYAN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.cyan());
        dropOther(NeoForgeBlocks.WARPED_GRAY_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.gray());
        dropOther(NeoForgeBlocks.WARPED_GREEN_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.green());
        dropOther(NeoForgeBlocks.WARPED_LIGHT_BLUE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lightBlue());
        dropOther(NeoForgeBlocks.WARPED_LIGHT_GRAY_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lightGray());
        dropOther(NeoForgeBlocks.WARPED_LIME_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.lime());
        dropOther(NeoForgeBlocks.WARPED_MAGENTA_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.magenta());
        dropSelf(NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.block().get());
        dropOther(NeoForgeBlocks.WARPED_ORANGE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.orange());
        dropOther(NeoForgeBlocks.WARPED_PINK_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.pink());
        dropOther(NeoForgeBlocks.WARPED_PURPLE_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.purple());
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.block().get());
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.block().get());
        dropOther(NeoForgeBlocks.WARPED_RED_CANDLE_CAKE.block().get(), Items.DYED_CANDLE.red());
        dropSelf(NetherAndEndBlocks.WARPED_WART.block().get());
        dropOther(NeoForgeBlocks.WARPED_WHITE_CANDLE_CAKE.block().get(), Items.DYED_BUNDLE.white());
        dropSelf(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get());
        dropOther(NeoForgeBlocks.WARPED_YELLOW_CANDLE_CAKE.block().get(), Items.DYED_BUNDLE.yellow());
    }
}
