package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.block.CrumblingBasaltBlock;
import net.enderboy500.netherandend.block.WarpedCakeBlock;
import net.enderboy500.netherandend.block.WarpedCandleCakeBlock;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.minecraft.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.*;

public class NetherAndEndBlocks {
    public static final Block CHORUS_BLOCK = register("chorus_block", Block::new, Properties.ofFullCopy(CRIMSON_PLANKS).mapColor(MapColor.WARPED_HYPHAE));
    public static final Block CHORUS_PLANKS = register("chorus_planks", Block::new, Properties.ofFullCopy(OAK_PLANKS).mapColor(MapColor.WARPED_HYPHAE));
    public static final Block CHORUS_STAIRS = registerStairsBlock("chorus_stairs", CHORUS_PLANKS);
    public static final Block CHORUS_SLAB = register("chorus_slab", SlabBlock::new, Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Block CHORUS_FENCE = register("chorus_fence", FenceBlock::new, Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Block CHORUS_FENCE_GATE = register("chorus_fence_gate", settings -> new FenceGateBlock(NetherAndEndWoodTypes.CHORUS, settings),
            Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    public static final Block CHORUS_BUTTON = register("chorus_button", settings ->
         new ButtonBlock(NetherAndEndBlockSetTypes.CHORUS, 20, settings), buttonProperties());
    public static final Block CHORUS_PRESSURE_PLATE = register("chorus_pressure_plate", settings -> new PressurePlateBlock(NetherAndEndBlockSetTypes.CHORUS, settings),
        Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY));
    public static final Block CHORUS_DOOR = register("chorus_door", settings -> new DoorBlock(NetherAndEndBlockSetTypes.CHORUS, settings),
        Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    public static final Block CHORUS_TRAPDOOR = register("chorus_trapdoor", settings -> new TrapDoorBlock(NetherAndEndBlockSetTypes.CHORUS, settings),
        Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never));
    public static final Block CHORUS_SHELF = register("chorus_shelf", ShelfBlock::new,
            Properties.of().mapColor(CHORUS_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never));

    public static final Block WARPED_CAKE = register("warped_cake", WarpedCakeBlock::new, BlockBehaviour.Properties.ofFullCopy(CAKE));
    public static final Block WARPED_CANDLE_CAKE = register("warped_candle_cake", settings -> new WarpedCandleCakeBlock(CANDLE, settings), BlockBehaviour.Properties.ofLegacyCopy(WARPED_CAKE).lightLevel(Blocks.litBlockEmission(3)));
    public static final Block WARPED_WHITE_CANDLE_CAKE = register("white_warped_candle_cake", settings -> new WarpedCandleCakeBlock(WHITE_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIGHT_GRAY_CANDLE_CAKE = register("light_gray_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIGHT_GRAY_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_GRAY_CANDLE_CAKE = register("gray_warped_candle_cake", settings -> new WarpedCandleCakeBlock(GRAY_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BLACK_CANDLE_CAKE = register("black_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BLACK_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BROWN_CANDLE_CAKE = register("brown_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BROWN_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_RED_CANDLE_CAKE = register("red_warped_candle_cake", settings -> new WarpedCandleCakeBlock(RED_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_ORANGE_CANDLE_CAKE = register("orange_warped_candle_cake", settings -> new WarpedCandleCakeBlock(ORANGE_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_YELLOW_CANDLE_CAKE = register("yellow_warped_candle_cake", settings -> new WarpedCandleCakeBlock(YELLOW_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIME_CANDLE_CAKE = register("lime_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIME_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_GREEN_CANDLE_CAKE = register("green_warped_candle_cake", settings -> new WarpedCandleCakeBlock(GREEN_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_CYAN_CANDLE_CAKE = register("cyan_warped_candle_cake", settings -> new WarpedCandleCakeBlock(CYAN_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIGHT_BLUE_CANDLE_CAKE = register("light_blue_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIGHT_BLUE_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BLUE_CANDLE_CAKE = register("blue_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BLUE_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_PURPLE_CANDLE_CAKE = register("purple_warped_candle_cake", settings -> new WarpedCandleCakeBlock(PURPLE_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_MAGENTA_CANDLE_CAKE = register("magenta_warped_candle_cake", settings -> new WarpedCandleCakeBlock(MAGENTA_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_PINK_CANDLE_CAKE = register("pink_warped_candle_cake", settings -> new WarpedCandleCakeBlock(PINK_CANDLE, settings), BlockBehaviour.Properties.ofFullCopy(WARPED_CANDLE_CAKE));


    public static final Block NETHER_COAL_ORE = register("nether_coal_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_IRON_ORE = register("nether_iron_ore",
            Block::new, Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_COPPER_ORE = register("nether_copper_ore",
            Block::new, Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_REDSTONE_ORE = register("nether_redstone_ore",
            settings -> {
                return new DropExperienceBlock(UniformInt.of(0, 2), settings);
            }, Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_EMERALD_ORE = register("nether_emerald_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_LAPIS_ORE = register("nether_lapis_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block NETHER_DIAMOND_ORE = register("nether_diamond_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(NETHER_GOLD_ORE));

    public static final Block END_COAL_ORE = register("end_coal_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(END_STONE));

    public static final Block END_IRON_ORE = register("end_iron_ore",
            Block::new, Properties.ofFullCopy(END_STONE));

    public static final Block END_GOLD_ORE = register("end_gold_ore",
            Block::new, Properties.ofFullCopy(END_STONE));

    public static final Block END_COPPER_ORE = register("end_copper_ore",
            Block::new, Properties.ofFullCopy(END_STONE));

    public static final Block END_REDSTONE_ORE = register("end_redstone_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(END_STONE));

    public static final Block END_EMERALD_ORE = register("end_emerald_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(END_STONE));

    public static final Block END_LAPIS_ORE = register("end_lapis_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(END_STONE));

    public static final Block END_DIAMOND_ORE = register("end_diamond_ore",
            settings -> new DropExperienceBlock(UniformInt.of(0, 2), settings), Properties.ofFullCopy(END_STONE));

    public static final Block ENDER_PEARL_CLUSTER = register("ender_pearl_cluster",
            settings -> new DropExperienceBlock(UniformInt.of(3, 5), settings), Properties.ofFullCopy(END_STONE));

    public static final Block CRACKED_BEDROCK = register("cracked_bedrock", Block::new, Properties.ofFullCopy(BEDROCK)
            .strength(75, -1));
    public static final Block CRUMBLING_BASALT = register("crumbling_basalt", CrumblingBasaltBlock::new, Properties.ofFullCopy(BASALT)
            .instabreak().explosionResistance(2.1f));

    public static <B extends Block> B register(String name, Function<Properties, B> factory, Properties settings) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, name));
        B block = factory.apply(settings.setId(key));

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static Block registerStairsBlock(String id, Block base) {
        return register(id, (settings) -> {
            return new StairBlock(base.defaultBlockState(), settings);
        }, Properties.ofFullCopy(base));
    }

    public static void loadBlocks() {}
}
