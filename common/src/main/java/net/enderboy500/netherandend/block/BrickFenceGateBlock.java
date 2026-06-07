package net.enderboy500.netherandend.block;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiConsumer;

public class BrickFenceGateBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<BrickFenceGateBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(propertiesCodec()).apply(instance, BrickFenceGateBlock::new));
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty IN_WALL = BlockStateProperties.IN_WALL;
    private static final Map<Direction.Axis, VoxelShape> REGULAR_OUTLINE_SHAPES = Shapes.rotateHorizontalAxis(Block.cube(16, 16, 4));
    private static final Map<Direction.Axis, VoxelShape> IN_WALL_OUTLINE_SHAPES = Maps.newEnumMap(Util.mapValues(REGULAR_OUTLINE_SHAPES, (shape) -> Shapes.join(shape, Block.column(16, 13, 16), BooleanOp.ONLY_FIRST)));
    private static final Map<Direction.Axis, VoxelShape> CLOSED_COLLISION_SHAPES = Shapes.rotateHorizontalAxis(Block.column(16, 4, 0, 24));
    private static final Map<Direction.Axis, VoxelShape> CLOSED_SIDES_SHAPES = Shapes.rotateHorizontalAxis(Block.column(16, 4, 5, 24));
    private static final Map<Direction.Axis, VoxelShape> REGULAR_CULLING_SHAPES = Shapes.rotateHorizontalAxis(Shapes.or(Block.box(0, 5, 7, 2, 16, 9), Block.box(14, 5, 7, 16, 16, 9)));
    private static final Map<Direction.Axis, VoxelShape> IN_WALL_CULLING_SHAPES = Maps.newEnumMap(Util.mapValues(REGULAR_CULLING_SHAPES, (shape) -> shape.move(0, -0.1875, 0).optimize()));

    public BrickFenceGateBlock(Properties properties) {
        super(properties.sound(SoundType.NETHER_BRICKS));
        this.registerDefaultState((((this.stateDefinition.any()).setValue(OPEN, false)).setValue(POWERED, false)).setValue(IN_WALL, false));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction.Axis axis = (state.getValue(FACING)).getAxis();
        return (state.getValue(IN_WALL) ? IN_WALL_OUTLINE_SHAPES : REGULAR_OUTLINE_SHAPES).get(axis);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        Direction.Axis axis = direction.getAxis();
        if ((state.getValue(FACING)).getClockWise().getAxis() != axis) {
            return super.updateShape(state, levelReader, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
        } else {
            boolean bl = this.isWall(neighborState) || this.isWall(levelReader.getBlockState(pos.relative(direction.getOpposite())));
            return state.setValue(IN_WALL, bl);
        }
    }

    @Override
    protected VoxelShape getBlockSupportShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        Direction.Axis axis = (state.getValue(FACING)).getAxis();
        return state.getValue(OPEN) ? Shapes.empty() : CLOSED_SIDES_SHAPES.get(axis);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction.Axis axis = (state.getValue(FACING)).getAxis();
        return state.getValue(OPEN) ? Shapes.empty() : CLOSED_COLLISION_SHAPES.get(axis);
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        Direction.Axis axis = (state.getValue(FACING)).getAxis();
        return (state.getValue(IN_WALL) ? IN_WALL_CULLING_SHAPES : REGULAR_CULLING_SHAPES).get(axis);
    }

    protected boolean canPathfindThrough(BlockState state, PathComputationType type) {
        switch (type) {
            case LAND -> {
                return state.getValue(OPEN);
            }
            case WATER -> {
                return false;
            }
            case AIR -> {
                return state.getValue(OPEN);
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        boolean bl = level.hasNeighborSignal(blockPos);
        Direction direction = ctx.getHorizontalDirection();
        Direction.Axis axis = direction.getAxis();
        boolean bl2 = axis == Direction.Axis.Z && (this.isWall(level.getBlockState(blockPos.west())) || this.isWall(level.getBlockState(blockPos.east()))) || axis == Direction.Axis.X && (this.isWall(level.getBlockState(blockPos.north())) || this.isWall(level.getBlockState(blockPos.south())));
        return (((this.defaultBlockState().setValue(FACING, direction)).setValue(OPEN, bl)).setValue(POWERED, bl)).setValue(IN_WALL, bl2);
    }

    private boolean isWall(BlockState state) {
        return state.is(BlockTags.WALLS);
    }

    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (state.getValue(OPEN)) {
            state = state.setValue(OPEN, false);
            world.setBlock(pos, state, 10);
        } else {
            Direction direction = player.getDirection();
            if (state.getValue(FACING) == direction.getOpposite()) state = state.setValue(FACING, direction);


            state = state.setValue(OPEN, true);
            world.setBlock(pos, state, 10);
        }

        boolean bl = state.getValue(OPEN);
        world.playSound(player, pos, bl ? SoundEvents.NETHER_BRICKS_STEP : SoundEvents.NETHER_BRICKS_STEP, SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
        world.gameEvent(player, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onExplosionHit(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (explosion.canTriggerBlocks() && !(Boolean)state.getValue(POWERED)) {
            boolean bl = state.getValue(OPEN);
            level.setBlockAndUpdate(pos, state.setValue(OPEN, !bl));
            level.playSound(null, pos, bl ? SoundEvents.NETHER_BRICKS_STEP :SoundEvents.NETHER_BRICKS_STEP, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
            level.gameEvent(bl ? GameEvent.BLOCK_CLOSE : GameEvent.BLOCK_OPEN, pos, GameEvent.Context.of(state));
        }

        super.onExplosionHit(state, level, pos, explosion, biConsumer);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, POWERED, IN_WALL);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean notify) {
        if (!level.isClientSide()) {
            boolean bl = level.hasNeighborSignal(pos);
            if (state.getValue(POWERED) != bl) {
                level.setBlock(pos, (state.setValue(POWERED, bl)).setValue(OPEN, bl), 2);
                if (state.getValue(OPEN) != bl) {
                    level.playSound(null, pos, bl ? SoundEvents.NETHER_BRICKS_STEP : SoundEvents.NETHER_BRICKS_STEP, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
                    level.gameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                }
            }

        }
    }

    public static boolean connectsToDirection(BlockState state, Direction side) {
        return state.getValue(FACING).getAxis() == side.getClockWise().getAxis();
    }
}
