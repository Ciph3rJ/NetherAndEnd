package net.enderboy500.netherandend.block;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.List;
import java.util.Map;

public class WarpedCandleCakeBlock extends AbstractCandleBlock {
    public static final MapCodec<WarpedCandleCakeBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("candle").forGetter((block) -> block.candle), propertiesCodec()).apply(instance, WarpedCandleCakeBlock::new));
    public static final BooleanProperty LIT;
    private static final VoxelShape SHAPE;
    private static final Map<CandleBlock, WarpedCandleCakeBlock> CANDLES_TO_CANDLE_CAKES;
    private static final Iterable<Vec3> PARTICLE_OFFSETS;
    private final CandleBlock candle;

    public MapCodec<WarpedCandleCakeBlock> codec() {
        return CODEC;
    }

    public WarpedCandleCakeBlock(Block candle, BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(LIT, false));
        if (candle instanceof CandleBlock candleBlock) {
            CANDLES_TO_CANDLE_CAKES.put(candleBlock, this);
            this.candle = candleBlock;
        } else {
            String var10002 = String.valueOf(CandleBlock.class);
            throw new IllegalArgumentException("Expected block to be of " + var10002 + " was " + String.valueOf(candle.getClass()));
        }
    }

    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE) && isLit(state)) {
            if (isHittingCandle(hit) && stack.isEmpty() && (Boolean)state.getValue(LIT)) {
                extinguish(player, state, world, pos);
                return InteractionResult.SUCCESS;
            } else {
                return super.useItemOn(stack, state, world, pos, player, hand, hit);
            }
        } else if (stack.is(Items.FLINT_AND_STEEL) || stack.is(Items.FIRE_CHARGE) && !isHittingCandle(hit)) {
            setLit(world, state, pos, true);
            return InteractionResult.SUCCESS;
        } else if (!isLit(state)){
            InteractionResult actionResult = WarpedCakeBlock.tryEat(world, pos, NetherAndEndBlocks.WARPED_CAKE.defaultBlockState(), player);
            if (actionResult.consumesAction()) {
                dropResources(state, world, pos);
            }
            return actionResult;
        }
        return super.useItemOn(stack,state,world,pos,player,hand,hit);
    }

    public static boolean isHittingCandle(BlockHitResult hitResult) {
        return hitResult.getLocation().y - (double)hitResult.getBlockPos().getY() > (double)0.5F;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }

    protected ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(NetherAndEndBlocks.WARPED_CAKE);
    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    protected int getComparatorOutput(BlockState state, Level world, BlockPos pos) {
        return WarpedCakeBlock.DEFAULT_COMPARATOR_OUTPUT;
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    public static BlockState getCandleCakeFromCandle(CandleBlock candle) {
        return (CANDLES_TO_CANDLE_CAKES.get(candle)).defaultBlockState();
    }

    public static boolean canBeLit(BlockState state) {
        return state.is(BlockTags.CANDLE_CAKES, (statex) -> statex.hasProperty(LIT) && !(Boolean)state.getValue(LIT));
    }

    static {
        LIT = AbstractCandleBlock.LIT;
        SHAPE = Shapes.or(Block.column((double)2.0F, (double)8.0F, (double)14.0F), Block.column((double)14.0F, (double)0.0F, (double)8.0F));
        CANDLES_TO_CANDLE_CAKES = Maps.newHashMap();
        PARTICLE_OFFSETS = List.of((new Vec3((double)8.0F, (double)16.0F, (double)8.0F)).scale((double)0.0625F));
    }
}