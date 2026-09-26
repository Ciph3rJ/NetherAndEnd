package net.enderboy500.netherandend.block.chorus;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ChorusTrapDoorBlock extends TrapDoorBlock {
    public ChorusTrapDoorBlock(Properties properties) {
        super(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(NetherAndEndBlocks.CHORUS_PLANKS.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS)
                .strength(3.0F).noOcclusion().isValidSpawn(NetherAndEndBlocks::never));
    }
}
