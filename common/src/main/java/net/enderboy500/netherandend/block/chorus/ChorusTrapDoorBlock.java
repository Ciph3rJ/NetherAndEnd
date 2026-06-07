package net.enderboy500.netherandend.block.chorus;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class ChorusTrapDoorBlock extends TrapDoorBlock {
    public ChorusTrapDoorBlock(Properties properties) {
        super(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(NetherAndEndBlocks.CHORUS_PLANKS.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS)
                .strength(3.0F).noOcclusion().isValidSpawn(NetherAndEndBlocks::never));
    }
}
