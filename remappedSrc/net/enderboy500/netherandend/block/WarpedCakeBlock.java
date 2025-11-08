package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WarpedCakeBlock extends Block {
    public static final MapCodec<WarpedCakeBlock> CODEC = simpleCodec(WarpedCakeBlock::new);
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES;
    public static final int DEFAULT_COMPARATOR_OUTPUT;
    private static final VoxelShape[] SHAPES_BY_BITES;

    public MapCodec<WarpedCakeBlock> codec() {
        return CODEC;
    }

    public WarpedCakeBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any()).setValue(BITES, 0));
    }

    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES_BY_BITES[(Integer) state.getValue(BITES)];
    }

    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.is(ItemTags.CANDLES) && (Integer) state.getValue(BITES) == 0) {
            Block var10 = Block.byItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock) var10;
                stack.consume(1, player);
                world.playSound((Entity) null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlockAndUpdate(pos, WarpedCandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide()) {
            if (tryEat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    protected static InteractionResult tryEat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
        player.awardStat(Stats.EAT_CAKE_SLICE);
        player.getFoodData().eat(2, 0.1F);
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
        int i = state.getValue(BITES);
        world.gameEvent(player, GameEvent.EAT, pos);
        if (i < 6) {
            world.setBlock(pos, state.setValue(BITES, i + 1), 3);
        } else {
            world.removeBlock(pos, false);
            world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return InteractionResult.SUCCESS;
    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    protected int getComparatorOutput(BlockState state, Level world, BlockPos pos) {
        return getComparatorOutput((Integer) state.getValue(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (7 - bites) * 2;
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    static {
        BITES = BlockStateProperties.BITES;
        DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);
        SHAPES_BY_BITES = Block.boxes(6, (bites) -> Block.box((double) (1 + bites * 2), (double) 0.0F, (double) 1.0F, (double) 15.0F, (double) 8.0F, (double) 15.0F));
    }
}