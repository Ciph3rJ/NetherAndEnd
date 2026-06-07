package net.enderboy500.netherandend.block.chorus;

import net.enderboy500.netherandend.util.type.NetherAndEndBlockSetTypes;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;

public class ChorusButtonBlock extends ButtonBlock {
    public ChorusButtonBlock(Properties properties) {
        super(NetherAndEndBlockSetTypes.CHORUS, 20, properties.noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }
}
