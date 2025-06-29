package net.enderboy500.netherandend.block;

import net.minecraft.world.level.block.FallingBlock;

public abstract class CrumblingBlock extends FallingBlock {
    public CrumblingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected int getDelayAfterPlace() {
        return 100;
    }
}
