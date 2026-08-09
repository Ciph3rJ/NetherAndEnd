package net.enderboy500.netherandend.util.dispenser;

import net.enderboy500.netherandend.mixin.accessor.CoralBlockAccessor;
import net.enderboy500.netherandend.mixin.accessor.CoralFanBlockAccessor;
import net.enderboy500.netherandend.mixin.accessor.CoralPlantBlockAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Random;

public class WitheredBoneMealDispenseBehavior extends DefaultDispenseItemBehavior {
    private static final ThreadLocal<RandomSource> random = ThreadLocal.withInitial(RandomSource::create);

    public WitheredBoneMealDispenseBehavior(Item item) {
    }

    @Override
    protected ItemStack execute(BlockSource source, ItemStack dispensed) {
        Level level = source.level();
        BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));
        BlockState state = level.getBlockState(pos);
        if (tryUseOnGround(dispensed, level, pos, state, true)) {
            checkAndWither(dispensed, level, pos, state);
            return dispensed;
        }
        return dispensed;
    }

    public static void addWitheringParticles(LevelAccessor levelAccessor, BlockPos blockPos, int i) {
        BlockState blockState = levelAccessor.getBlockState(blockPos);
        Block var5 = blockState.getBlock();
        if (var5 instanceof BonemealableBlock) {
            BonemealableBlock bonemealableBlock = (BonemealableBlock)var5;
            BlockPos blockPos2 = bonemealableBlock.getParticlePos(blockPos);
            switch (bonemealableBlock.getType()) {
                case NEIGHBOR_SPREADER -> ParticleUtils.spawnParticles(levelAccessor, blockPos2, i * 3, (double)3.0F, (double)1.0F, false, new DustParticleOptions(0,2));
                case GROWER -> ParticleUtils.spawnParticleInBlock(levelAccessor, blockPos2, i, new DustParticleOptions(0,2));
            }
        } else if (blockState.is(Blocks.WATER)) {
            ParticleUtils.spawnParticles(levelAccessor, blockPos, i * 3, (double)3.0F, (double)1.0F, false, ParticleTypes.ASH);
        }
    }

    public static void checkAndWither(ItemStack stack, Level level, BlockPos pos, BlockState state) {
        if (tryUseOnGround(stack, level, pos, state, true)) {
            for (int i = 0; i < 3; i++) {
                Random random = new Random();
                int j = random.nextInt(0, i + 1);
                for (Direction direction : Direction.values()) {
                    BlockPos pos1 = pos.offset(direction.getUnitVec3i().multiply(i)).above();
                    BlockState state1 = level.getBlockState(pos1);
                    for (Direction direction1 : Direction.values()) {
                        BlockPos pos2 = pos1.offset(direction1.getUnitVec3i());
                        BlockState state2 = level.getBlockState(pos2);
                        for (Direction direction2 : Direction.values()) {
                            BlockPos pos3 = pos2.offset(direction2.getUnitVec3i());
                            BlockState state3 = level.getBlockState(pos3);
                            tryUseOnGround(stack, level, pos3, state3, false);
                        }
                        tryUseOnGround(stack, level, pos2, state2, false);
                    }
                    tryUseOnGround(stack, level, pos1, state1, false);
                }
            }
            addWitheringParticles(level, pos, 3);
            stack.shrink(1);
        }
    }

    public static boolean tryUseOnGround(final ItemStack stack, final Level level, final BlockPos pos, final BlockState state, boolean base) {
        final Block block = state.getBlock();


        if (block instanceof WitherRoseBlock)    return false;
        if (block instanceof NetherRootsBlock)   return false;
        if (block instanceof NetherSproutsBlock) return false;

        if (block instanceof NetherrackBlock netherrack)           return handleWithVanillaBehavior(level, stack, pos, netherrack, state, 0.5);
        if (block instanceof NyliumBlock nylium)                   return handleWithVanillaBehavior(level, stack, pos, nylium, state, 0.5);
        if (block instanceof NetherFungusBlock amogus)             return handleWithVanillaBehavior(level, stack, pos, amogus, state);
        if (block instanceof WeepingVinesBlock weepers)            return handleWithVanillaBehavior(level, stack, pos, weepers, state);
        if (block instanceof WeepingVinesPlantBlock weepersPlant)  return handleWithVanillaBehavior(level, stack, pos, weepersPlant, state);
        if (block instanceof TwistingVinesBlock twister)           return handleWithVanillaBehavior(level, stack, pos, twister, state);
        if (block instanceof TwistingVinesPlantBlock twisterPlant) return handleWithVanillaBehavior(level, stack, pos, twisterPlant, state);

        if (block instanceof TallFlowerBlock && base)      return replaceTallBlockWith(level, stack, pos, state, Blocks.WITHER_ROSE);
        else if (block instanceof TallFlowerBlock && !base)      return replaceTallBlockWith(level, stack, pos, state, Blocks.AIR);
        if (block instanceof FlowerBlock && base)          return replaceWith(level, stack, pos, Blocks.WITHER_ROSE);
        else if (block instanceof FlowerBlock && !base)          return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof GrassBlock && base)           return replaceWith(level, stack, pos, Blocks.DIRT, 0.5);
        if (block instanceof MyceliumBlock && base)        return replaceWith(level, stack, pos, Blocks.DIRT, 0.5);
        if (block instanceof RootedDirtBlock && base)      return replaceWith(level, stack, pos, Blocks.DIRT, 0.5);
        if (state.is(Blocks.PODZOL) && base)               return replaceWith(level, stack, pos, Blocks.DIRT, 0.5);
        if (state.is(Blocks.MUDDY_MANGROVE_ROOTS) && base) return replaceWith(level, stack, pos, Blocks.MUD);

        if (block instanceof NetherWartBlock) return handleNetherWart(level, stack, pos, state);

        if (block instanceof CropBlock)           return handleAgedBlock(level, stack, pos, state, CropBlock.AGE);
        if (block instanceof StemBlock)           return handleAgedBlock(level, stack, pos, state, StemBlock.AGE);

        if (block instanceof CoralFanBlock coralFan)     return replaceWith(level, stack, pos, ((CoralFanBlockAccessor) coralFan).getDeadBlock().defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, state.getValue(BlockStateProperties.WATERLOGGED)));
        if (block instanceof CoralPlantBlock coralPlant) return replaceWith(level, stack, pos, ((CoralPlantBlockAccessor) coralPlant).getDeadBlock().defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, state.getValue(BlockStateProperties.WATERLOGGED)));
        if (block instanceof CoralBlock coralBlock)      return replaceWith(level, stack, pos, ((CoralBlockAccessor) coralBlock).getDeadBlock().defaultBlockState());

        if (block instanceof DoublePlantBlock)     return replaceTallBlockWith(level, stack, pos, state, Blocks.AIR);
        if (block instanceof GrowingPlantBlock)    return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof MangroveRootsBlock)   return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof HangingRootsBlock)    return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof SugarCaneBlock)       return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof CactusBlock && base)  return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof BigDripleafBlock)     return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof BigDripleafStemBlock) return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof BambooStalkBlock)     return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof BambooSaplingBlock)   return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof GlowLichenBlock)      return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof VineBlock)            return replaceWith(level, stack, pos, Blocks.AIR);
        if (block instanceof BushBlock)            return replaceWith(level, stack, pos, Blocks.AIR);
        if (state.is(Blocks.SHORT_GRASS))          return replaceWith(level, stack, pos, Blocks.AIR);
        return false;
    }
    private static boolean handleWithVanillaBehavior(final Level level, final ItemStack stack, final BlockPos pos, final BonemealableBlock block, final BlockState state) {
        return handleWithVanillaBehavior(level, stack, pos, block, state, 0);
    }

    private static boolean handleWithVanillaBehavior(final Level level, final ItemStack stack, final BlockPos pos, final BonemealableBlock block, final BlockState state, final double particleYOffset) {
        if (!block.isValidBonemealTarget(level, pos, state)) return false;
        if (level instanceof ServerLevel serverLevel) block.performBonemeal(serverLevel, random.get(), pos, state);

        onSuccess(level, stack, pos, particleYOffset);
        return true;
    }

    private static boolean replaceTallBlockWith(final Level level, final ItemStack stack, final BlockPos pos, final BlockState state, final Block newBlock) {
        return replaceWith(level, stack, state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER) ? pos.below() : pos, newBlock);
    }
    private static boolean replaceWith(final Level level, final ItemStack stack, final BlockPos pos, final Block newBlock) {
        return replaceWith(level, stack, pos, newBlock.defaultBlockState());
    }
    private static boolean replaceWith(final Level level, final ItemStack stack, final BlockPos pos, final Block newBlock, final double particleYOffset) {
        return replaceWith(level, stack, pos, newBlock.defaultBlockState(), particleYOffset);
    }
    private static boolean replaceWith(final Level level, final ItemStack stack, final BlockPos pos, final BlockState newState) {
        return replaceWith(level, stack, pos, newState, 0);
    }

    private static boolean replaceWith(final Level level, final ItemStack stack, final BlockPos pos, final BlockState newState, double particleYOffset) {
        onSuccess(level, stack, pos, particleYOffset);
        setBlock(level, pos, newState);

        return true;
    }

    private static boolean handleNetherWart(final Level level, final ItemStack stack, final BlockPos pos, final BlockState state) {
        int newAge = state.getValue(BlockStateProperties.AGE_3) + 1;
        if (newAge > BlockStateProperties.MAX_AGE_3) return false;

        return replaceWith(level, stack, pos, state.setValue(BlockStateProperties.AGE_3, newAge));
    }

    private static boolean handleAgedBlock(final Level level, final ItemStack stack, final BlockPos pos, final BlockState state, final IntegerProperty ageProperty) {
        int newAge = state.getValue(ageProperty) - 1;
        if (newAge < 0) return replaceWith(level, stack, pos, Blocks.AIR);

        return replaceWith(level, stack, pos, state.setValue(ageProperty, newAge));
    }

    private static void onSuccess(final Level level, final ItemStack stack, final BlockPos pos, final double particleYOffset) {

    }

    private static void setBlock(final Level level, final BlockPos pos, final BlockState newState) {
        if (level.isClientSide()) return;
        level.setBlockAndUpdate(pos, newState);
    }
}
