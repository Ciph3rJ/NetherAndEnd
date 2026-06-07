package net.enderboy500.netherandend.block.chorus;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class ChorusPressurePlateBlock extends PressurePlateBlock {
    public ChorusPressurePlateBlock(Properties properties) {
        super(NetherAndEndBlockSetTypes.CHORUS, properties.mapColor(NetherAndEndBlocks.CHORUS_BLOCK.block().get().defaultMapColor())
                .forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }
}
