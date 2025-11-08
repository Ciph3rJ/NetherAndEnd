package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.block.CrumblingBasaltBlock;
import net.enderboy500.netherandend.block.WarpedCakeBlock;
import net.enderboy500.netherandend.block.WarpedCandleCakeBlock;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

import static net.minecraft.block.Blocks.*;

public class NetherAndEndBlocks {
    public static final Block CHORUS_BLOCK = register("chorus_block", Block::new, Settings.copy(CRIMSON_PLANKS).mapColor(MapColor.DARK_DULL_PINK));
    public static final Block CHORUS_PLANKS = register("chorus_planks", Block::new, Settings.copy(OAK_PLANKS).mapColor(MapColor.DARK_DULL_PINK));
    public static final Block CHORUS_STAIRS = registerStairsBlock("chorus_stairs", CHORUS_PLANKS);
    public static final Block CHORUS_SLAB = register("chorus_slab", SlabBlock::new, Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CHORUS_FENCE = register("chorus_fence", FenceBlock::new, Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CHORUS_FENCE_GATE = register("chorus_fence_gate", (settings) -> {
        return new FenceGateBlock(NetherAndEndWoodTypes.CHORUS, settings);
    }, Settings.create().mapColor(CRIMSON_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    public static final Block CHORUS_BUTTON = register("chorus_button", (settings) -> {
        return new ButtonBlock(NetherAndEndBlockSetTypes.CHORUS, 20, settings);
    }, createButtonSettings());
    public static final Block CHORUS_PRESSURE_PLATE = register("chorus_pressure_plate", (settings) -> {
        return new PressurePlateBlock(NetherAndEndBlockSetTypes.CHORUS, settings);
    }, Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASEDRUM).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block CHORUS_DOOR = register("chorus_door", (settings) -> {
        return new DoorBlock(NetherAndEndBlockSetTypes.CHORUS, settings);
    }, Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block CHORUS_TRAPDOOR = register("chorus_trapdoor", (settings) -> {
        return new TrapdoorBlock(NetherAndEndBlockSetTypes.CHORUS, settings);
    }, Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never));

    public static final Block WARPED_CAKE = register("warped_cake", WarpedCakeBlock::new, Settings.copy(CAKE));
    public static final Block WARPED_CANDLE_CAKE = register("warped_candle_cake", settings -> new WarpedCandleCakeBlock(CANDLE, settings), Settings.copyShallow(WARPED_CAKE).luminance(Blocks.createLightLevelFromLitBlockState(3)));
    public static final Block WARPED_WHITE_CANDLE_CAKE = register("white_warped_candle_cake", settings -> new WarpedCandleCakeBlock(WHITE_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIGHT_GRAY_CANDLE_CAKE = register("light_gray_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIGHT_GRAY_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_GRAY_CANDLE_CAKE = register("gray_warped_candle_cake", settings -> new WarpedCandleCakeBlock(GRAY_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BLACK_CANDLE_CAKE = register("black_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BLACK_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BROWN_CANDLE_CAKE = register("brown_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BROWN_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_RED_CANDLE_CAKE = register("red_warped_candle_cake", settings -> new WarpedCandleCakeBlock(RED_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_ORANGE_CANDLE_CAKE = register("orange_warped_candle_cake", settings -> new WarpedCandleCakeBlock(ORANGE_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_YELLOW_CANDLE_CAKE = register("yellow_warped_candle_cake", settings -> new WarpedCandleCakeBlock(YELLOW_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIME_CANDLE_CAKE = register("lime_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIME_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_GREEN_CANDLE_CAKE = register("green_warped_candle_cake", settings -> new WarpedCandleCakeBlock(GREEN_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_CYAN_CANDLE_CAKE = register("cyan_warped_candle_cake", settings -> new WarpedCandleCakeBlock(CYAN_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_LIGHT_BLUE_CANDLE_CAKE = register("light_blue_warped_candle_cake", settings -> new WarpedCandleCakeBlock(LIGHT_BLUE_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_BLUE_CANDLE_CAKE = register("blue_warped_candle_cake", settings -> new WarpedCandleCakeBlock(BLUE_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_PURPLE_CANDLE_CAKE = register("purple_warped_candle_cake", settings -> new WarpedCandleCakeBlock(PURPLE_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_MAGENTA_CANDLE_CAKE = register("magenta_warped_candle_cake", settings -> new WarpedCandleCakeBlock(MAGENTA_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));
    public static final Block WARPED_PINK_CANDLE_CAKE = register("pink_warped_candle_cake", settings -> new WarpedCandleCakeBlock(PINK_CANDLE, settings), Settings.copy(WARPED_CANDLE_CAKE));

    public static final Block NETHER_COAL_ORE = register("nether_coal_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_IRON_ORE = register("nether_iron_ore",
            Block::new, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_COPPER_ORE = register("nether_copper_ore",
            Block::new, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_REDSTONE_ORE = register("nether_redstone_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_EMERALD_ORE = register("nether_emerald_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_LAPIS_ORE = register("nether_lapis_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(NETHER_GOLD_ORE));

    public static final Block NETHER_DIAMOND_ORE = register("nether_diamond_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(NETHER_GOLD_ORE));

    public static final Block END_COAL_ORE = register("end_coal_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(END_STONE));

    public static final Block END_IRON_ORE = register("end_iron_ore",
            Block::new, Settings.copy(END_STONE));

    public static final Block END_GOLD_ORE = register("end_gold_ore",
            Block::new, Settings.copy(END_STONE));

    public static final Block END_COPPER_ORE = register("end_copper_ore",
            Block::new, Settings.copy(END_STONE));

    public static final Block END_REDSTONE_ORE = register("end_redstone_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(END_STONE));

    public static final Block END_EMERALD_ORE = register("end_emerald_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(END_STONE));

    public static final Block END_LAPIS_ORE = register("end_lapis_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(END_STONE));

    public static final Block END_DIAMOND_ORE = register("end_diamond_ore",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings);
            }, Settings.copy(END_STONE));

    public static final Block ENDER_PEARL_CLUSTER = register("ender_pearl_cluster",
            settings -> {
                return new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), settings);
            }, Settings.copy(END_STONE));

    public static final Block CRACKED_BEDROCK = register("cracked_bedrock", Block::new, Settings.copy(BEDROCK)
            .strength(75, -1));
    public static final Block CRUMBLING_BASALT = register("crumbling_basalt", CrumblingBasaltBlock::new, Settings.copy(BASALT)
            .breakInstantly().resistance(2.1f));

    public static <B extends Block> B register(String name, Function<Settings, B> factory, Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NetherAndEnd.MOD_ID, name));
        B block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block registerStairsBlock(String id, Block base) {
        return register(id, (settings) -> {
            return new StairsBlock(base.getDefaultState(), settings);
        }, Settings.copy(base));
    }

    public static void loadBlocks() {}
}
