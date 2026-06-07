package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.block.WarpedCakeBlock;
import net.enderboy500.netherandend.block.WarpedCandleCakeBlock;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.services.util.BlockWithItemRegistryHandle;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.ToIntFunction;

public class NeoForgeBlocks {
    public static final BlockWithItemRegistryHandle<Block> WARPED_CAKE = Services.REGISTRY.registerBlockWithItem("warped_cake", properties -> new WarpedCakeBlock(properties.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    public static final BlockWithItemRegistryHandle<Block> WARPED_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_WHITE_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("white_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.WHITE_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_LIGHT_GRAY_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("light_gray_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.LIGHT_GRAY_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_GRAY_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("gray_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.GRAY_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_BLACK_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("black_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.BLACK_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_BROWN_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("brown_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.BROWN_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_RED_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("red_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.RED_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_ORANGE_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("orange_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.ORANGE_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_YELLOW_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("yellow_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.YELLOW_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_LIME_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("lime_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.LIME_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_GREEN_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("green_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.GREEN_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_CYAN_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("cyan_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.CYAN_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_LIGHT_BLUE_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("light_blue_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.LIGHT_BLUE_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_BLUE_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("blue_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.BLUE_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_PURPLE_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("purple_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.PURPLE_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_MAGENTA_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("magenta_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.MAGENTA_CANDLE, properties.lightLevel(litBlockEmission(3))));
    public static final BlockWithItemRegistryHandle<Block> WARPED_PINK_CANDLE_CAKE = Services.REGISTRY.registerBlockWithItem("pink_warped_candle_cake", properties -> new WarpedCandleCakeBlock(Blocks.PINK_CANDLE, properties.lightLevel(litBlockEmission(3))));

    private static ToIntFunction<BlockState> litBlockEmission(int lightEmission) {
        return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? lightEmission : 0;
    }

    public static void loadBlocks() {}
}
