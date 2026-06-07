package net.enderboy500.netherandend.block.chorus;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class ChorusDoorBlock extends DoorBlock {
    public ChorusDoorBlock(Properties properties) {
        super(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(NetherAndEndBlocks.CHORUS_BLOCK.block().get().defaultMapColor()).instrument(NoteBlockInstrument.BASS)
                .strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }
}
