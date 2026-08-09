package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.block.*;
import net.enderboy500.netherandend.block.chorus.ChorusButtonBlock;
import net.enderboy500.netherandend.block.chorus.ChorusDoorBlock;
import net.enderboy500.netherandend.block.chorus.ChorusPressurePlateBlock;
import net.enderboy500.netherandend.block.chorus.ChorusTrapDoorBlock;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.services.util.BlockWithItemRegistryHandle;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.ToIntFunction;

public class NetherAndEndBlocks {
    public static final BlockWithItemRegistryHandle<Block> CHORUS_BLOCK = Services.REGISTRY.registerBlockWithItem("chorus_block", properties -> new Block(properties.instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD).mapColor(MapColor.WARPED_HYPHAE)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_PLANKS = Services.REGISTRY.registerBlockWithItem("chorus_planks", properties -> new Block(properties.instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.WARPED_HYPHAE)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_STAIRS = Services.REGISTRY.registerBlockWithItem("chorus_stairs",
            properties -> new NetherAndEndStairBlock(CHORUS_PLANKS.block().get().defaultBlockState(), properties.instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.WARPED_HYPHAE)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_SLAB = Services.REGISTRY.registerBlockWithItem("chorus_slab", properties -> new SlabBlock(properties.mapColor(CHORUS_PLANKS.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_FENCE = Services.REGISTRY.registerBlockWithItem("chorus_fence", properties -> new FenceBlock(properties.mapColor(CHORUS_PLANKS.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_FENCE_GATE = Services.REGISTRY.registerBlockWithItem("chorus_fence_gate", properties -> new FenceGateBlock(NetherAndEndWoodTypes.CHORUS, properties.mapColor(Blocks.CRIMSON_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F)));
    public static final BlockWithItemRegistryHandle<Block> CHORUS_BUTTON = Services.REGISTRY.registerBlockWithItem("chorus_button", ChorusButtonBlock::new);
    public static final BlockWithItemRegistryHandle<Block> CHORUS_PRESSURE_PLATE = Services.REGISTRY.registerBlockWithItem("chorus_pressure_plate", ChorusPressurePlateBlock::new);
    public static final BlockWithItemRegistryHandle<Block> CHORUS_DOOR = Services.REGISTRY.registerBlockWithItem("chorus_door", ChorusDoorBlock::new);
    public static final BlockWithItemRegistryHandle<Block> CHORUS_TRAPDOOR = Services.REGISTRY.registerBlockWithItem("chorus_trapdoor", ChorusTrapDoorBlock::new);
    public static final BlockWithItemRegistryHandle<Block> CHORUS_SHELF = Services.REGISTRY.registerBlockWithItem("chorus_shelf", properties -> new ShelfBlock(
            properties.mapColor(CHORUS_PLANKS.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(NetherAndEndBlocks::never)));
    public static final BlockWithItemRegistryHandle<Block> NETHER_BRICK_FENCE_GATE = Services.REGISTRY.registerBlockWithItem("nether_brick_fence_gate", properties -> new BrickFenceGateBlock(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CRACKED_RED_NETHER_BRICKS = Services.REGISTRY.registerBlockWithItem("cracked_red_nether_bricks", properties -> new Block(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> RED_NETHER_BRICK_FENCE = Services.REGISTRY.registerBlockWithItem("red_nether_brick_fence", properties -> new FenceBlock(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> RED_NETHER_BRICK_FENCE_GATE = Services.REGISTRY.registerBlockWithItem("red_nether_brick_fence_gate", properties -> new BrickFenceGateBlock(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CHISELED_RED_NETHER_BRICKS = Services.REGISTRY.registerBlockWithItem("chiseled_red_nether_bricks", properties -> new Block(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICKS = Services.REGISTRY.registerBlockWithItem("cyan_nether_bricks", properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CRACKED_CYAN_NETHER_BRICKS = Services.REGISTRY.registerBlockWithItem("cracked_cyan_nether_bricks", properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICK_STAIRS = Services.REGISTRY.registerBlockWithItem("cyan_nether_brick_stairs",
            properties -> new NetherAndEndStairBlock(CYAN_NETHER_BRICKS.block().get().defaultBlockState(), properties.mapColor(MapColor.TERRACOTTA_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICK_SLAB = Services.REGISTRY.registerBlockWithItem("cyan_nether_brick_slab", properties -> new SlabBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICK_WALL = Services.REGISTRY.registerBlockWithItem("cyan_nether_brick_wall", properties -> new WallBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICK_FENCE = Services.REGISTRY.registerBlockWithItem("cyan_nether_brick_fence", properties -> new FenceBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CYAN_NETHER_BRICK_FENCE_GATE = Services.REGISTRY.registerBlockWithItem("cyan_nether_brick_fence_gate", properties -> new BrickFenceGateBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> CHISELED_CYAN_NETHER_BRICKS = Services.REGISTRY.registerBlockWithItem("chiseled_cyan_nether_bricks", properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final BlockWithItemRegistryHandle<Block> WARPED_WART = Services.REGISTRY.registerBlockWithItem("warped_wart", properties -> new WarpedWartBlock(properties.mapColor(MapColor.TERRACOTTA_GREEN).noCollision().randomTicks().sound(SoundType.NETHER_WART).pushReaction(PushReaction.DESTROY)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_COAL_ORE = Services.REGISTRY.registerBlockWithItem("nether_coal_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_IRON_ORE = Services.REGISTRY.registerBlockWithItem("nether_iron_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_COPPER_ORE = Services.REGISTRY.registerBlockWithItem("nether_copper_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_REDSTONE_ORE = Services.REGISTRY.registerBlockWithItem("nether_redstone_ore",
            properties -> new RedStoneOreBlock(properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_EMERALD_ORE = Services.REGISTRY.registerBlockWithItem("nether_emerald_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_LAPIS_ORE = Services.REGISTRY.registerBlockWithItem("nether_lapis_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> NETHER_DIAMOND_ORE = Services.REGISTRY.registerBlockWithItem("nether_diamond_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE)));

    public static final BlockWithItemRegistryHandle<Block> END_COAL_ORE = Services.REGISTRY.registerBlockWithItem("end_coal_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_IRON_ORE = Services.REGISTRY.registerBlockWithItem("end_iron_ore",
            properties -> new Block(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_GOLD_ORE = Services.REGISTRY.registerBlockWithItem("end_gold_ore",
            properties -> new Block(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_COPPER_ORE = Services.REGISTRY.registerBlockWithItem("end_copper_ore",
            properties -> new Block(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_REDSTONE_ORE = Services.REGISTRY.registerBlockWithItem("end_redstone_ore",
            properties -> new RedStoneOreBlock(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_EMERALD_ORE = Services.REGISTRY.registerBlockWithItem("end_emerald_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_LAPIS_ORE = Services.REGISTRY.registerBlockWithItem("end_lapis_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> END_DIAMOND_ORE = Services.REGISTRY.registerBlockWithItem("end_diamond_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> ENDER_PEARL_CLUSTER = Services.REGISTRY.registerBlockWithItem("ender_pearl_cluster",
            properties -> new DropExperienceBlock(UniformInt.of(0, 2), properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));

    public static final BlockWithItemRegistryHandle<Block> CRACKED_BEDROCK = Services.REGISTRY.registerBlockWithItem("cracked_bedrock", properties -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(75, 3600000.0F).noLootTable()/*.isValidSpawn(Blocks::never)*/));
    public static final BlockWithItemRegistryHandle<Block> CRUMBLING_BASALT = Services.REGISTRY.registerBlockWithItem("crumbling_basalt", properties -> new CrumblingBasaltBlock(properties.mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().instabreak().explosionResistance(2.1f).sound(SoundType.BASALT)));
    public static final BlockWithItemRegistryHandle<Block> WITHERED_BONE_BLOCK = Services.REGISTRY.registerBlockWithItem("withered_bone_block",
            properties -> new RotatedPillarBlock(properties.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.XYLOPHONE).requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.BONE_BLOCK)));

    public static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    public static void loadBlocks() {}
}
