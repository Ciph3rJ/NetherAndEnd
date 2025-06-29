package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.block.CrumblingBasaltBlock;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.enderboy500.netherandend.util.type.NetherAndEndWoodTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.level.block.Blocks.*;

public class NetherAndEndBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NetherAndEnd.MOD_ID);

    public static final DeferredBlock<Block> CHORUS_BLOCK = BLOCKS.register("chorus_block",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).mapColor(MapColor.COLOR_PURPLE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> CHORUS_PLANKS = BLOCKS.register("chorus_planks",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS).mapColor(MapColor.COLOR_PURPLE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<StairBlock> CHORUS_STAIRS = BLOCKS.registerBlock("chorus_stairs",
            (properties) -> new StairBlock(CHORUS_BLOCK.get().defaultBlockState(), properties.mapColor(MapColor.COLOR_PURPLE).strength(2, 3)));
    public static final DeferredBlock<SlabBlock> CHORUS_SLAB = BLOCKS.registerBlock("chorus_slab",
            (properties) -> new SlabBlock(properties.strength(2, 3).mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> CHORUS_FENCE = BLOCKS.registerBlock("chorus_fence",
            (properties) -> new FenceBlock(properties.strength(2, 3).mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceGateBlock> CHORUS_FENCE_GATE = BLOCKS.registerBlock("chorus_fence_gate",
            (properties) -> new FenceGateBlock(NetherAndEndWoodTypes.CHORUS, properties.strength(2, 3).mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));
    public static final DeferredBlock<ButtonBlock> CHORUS_BUTTON = BLOCKS.registerBlock("chorus_button",
            (properties) -> new ButtonBlock(NetherAndEndBlockSetTypes.CHORUS, 20, properties.strength(2)));
    public static final DeferredBlock<PressurePlateBlock> CHORUS_PRESSURE_PLATE = BLOCKS.registerBlock("chorus_pressure_plate",
            (properties) -> new PressurePlateBlock(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(MapColor.COLOR_PURPLE).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission()
                    .strength(0.5f).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<DoorBlock> CHORUS_DOOR = BLOCKS.registerBlock("chorus_door",
            (properties) -> new DoorBlock(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(MapColor.COLOR_PURPLE).noOcclusion().pushReaction(PushReaction.DESTROY).strength(3)
                    .instrument(NoteBlockInstrument.BASS).ignitedByLava()));
    public static final DeferredBlock<TrapDoorBlock> CHORUS_TRAPDOOR = BLOCKS.registerBlock("chorus_trapdoor",
            (properties) -> new TrapDoorBlock(NetherAndEndBlockSetTypes.CHORUS, properties.strength(3).noOcclusion().isValidSpawn(Blocks::never).mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BASS)));

    public static final DeferredBlock<Block> NETHER_COAL_ORE = BLOCKS.register("nether_coal_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_IRON_ORE = BLOCKS.register("nether_iron_ore",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_COPPER_ORE = BLOCKS.register("nether_copper_ore",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_REDSTONE_ORE = BLOCKS.register("nether_redstone_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_EMERALD_ORE = BLOCKS.register("nether_emerald_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_LAPIS_ORE = BLOCKS.register("nether_lapis_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> NETHER_DIAMOND_ORE = BLOCKS.register("nether_diamond_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(NETHER_GOLD_ORE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));

    public static final DeferredBlock<Block> END_COAL_ORE = BLOCKS.register("end_coal_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_IRON_ORE = BLOCKS.register("end_iron_ore",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(END_STONE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_GOLD_ORE = BLOCKS.register("end_gold_ore",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(END_STONE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_COPPER_ORE = BLOCKS.register("end_copper_ore",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(END_STONE)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_REDSTONE_ORE = BLOCKS.register("end_redstone_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_EMERALD_ORE = BLOCKS.register("end_emerald_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_LAPIS_ORE = BLOCKS.register("end_lapis_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> END_DIAMOND_ORE = BLOCKS.register("end_diamond_ore",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> ENDER_PEARL_CLUSTER = BLOCKS.register("ender_pearl_cluster",
            resourceLocation -> new DropExperienceBlock(UniformInt.of(3, 5),
                    BlockBehaviour.Properties.ofFullCopy(END_STONE)
                            .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));

    public static final DeferredBlock<Block> CRACKED_BEDROCK = BLOCKS.register("cracked_bedrock",
            resourceLocation -> new Block(BlockBehaviour.Properties.ofFullCopy(BEDROCK).strength(75, -1)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));
    public static final DeferredBlock<Block> CRUMBLING_BASALT = BLOCKS.register("crumbling_basalt",
            resourceLocation -> new CrumblingBasaltBlock(BlockBehaviour.Properties.ofFullCopy(BASALT).instabreak().explosionResistance(2.1f)
                    .setId(ResourceKey.create(Registries.BLOCK, resourceLocation))));

    public static void loadBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
