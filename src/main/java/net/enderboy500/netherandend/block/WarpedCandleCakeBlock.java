package net.enderboy500.netherandend.block;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.List;
import java.util.Map;

public class WarpedCandleCakeBlock extends AbstractCandleBlock {
    public static final MapCodec<WarpedCandleCakeBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Registries.BLOCK.getCodec().fieldOf("candle").forGetter((block) -> block.candle), createSettingsCodec()).apply(instance, WarpedCandleCakeBlock::new));
    public static final BooleanProperty LIT;
    private static final VoxelShape SHAPE;
    private static final Map<CandleBlock, WarpedCandleCakeBlock> CANDLES_TO_CANDLE_CAKES;
    private static final Iterable<Vec3d> PARTICLE_OFFSETS;
    private final CandleBlock candle;

    public MapCodec<WarpedCandleCakeBlock> getCodec() {
        return CODEC;
    }

    public WarpedCandleCakeBlock(Block candle, Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(LIT, false));
        if (candle instanceof CandleBlock candleBlock) {
            CANDLES_TO_CANDLE_CAKES.put(candleBlock, this);
            this.candle = candleBlock;
        } else {
            String var10002 = String.valueOf(CandleBlock.class);
            throw new IllegalArgumentException("Expected block to be of " + var10002 + " was " + String.valueOf(candle.getClass()));
        }
    }

    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isOf(Items.FLINT_AND_STEEL) && !stack.isOf(Items.FIRE_CHARGE) && isLitCandle(state)) {
            if (isHittingCandle(hit) && stack.isEmpty() && (Boolean)state.get(LIT)) {
                extinguish(player, state, world, pos);
                return ActionResult.SUCCESS;
            } else {
                return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
            }
        } else if (stack.isOf(Items.FLINT_AND_STEEL) || stack.isOf(Items.FIRE_CHARGE) && !isHittingCandle(hit)) {
            setLit(world, state, pos, true);
            return ActionResult.SUCCESS;
        } else if (!isLitCandle(state)){
            ActionResult actionResult = WarpedCakeBlock.tryEat(world, pos, NetherAndEndBlocks.WARPED_CAKE.getDefaultState(), player);
            if (actionResult.isAccepted()) {
                dropStacks(state, world, pos);
            }
            return actionResult;
        }
        return super.onUseWithItem(stack,state,world,pos,player,hand,hit);
    }

    public static boolean isHittingCandle(BlockHitResult hitResult) {
        return hitResult.getPos().y - (double)hitResult.getBlockPos().getY() > (double)0.5F;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }

    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(NetherAndEndBlocks.WARPED_CAKE);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return WarpedCakeBlock.DEFAULT_COMPARATOR_OUTPUT;
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public static BlockState getCandleCakeFromCandle(CandleBlock candle) {
        return (CANDLES_TO_CANDLE_CAKES.get(candle)).getDefaultState();
    }

    public static boolean canBeLit(BlockState state) {
        return state.isIn(BlockTags.CANDLE_CAKES, (statex) -> statex.contains(LIT) && !(Boolean)state.get(LIT));
    }

    static {
        LIT = AbstractCandleBlock.LIT;
        SHAPE = VoxelShapes.union(Block.createColumnShape((double)2.0F, (double)8.0F, (double)14.0F), Block.createColumnShape((double)14.0F, (double)0.0F, (double)8.0F));
        CANDLES_TO_CANDLE_CAKES = Maps.newHashMap();
        PARTICLE_OFFSETS = List.of((new Vec3d((double)8.0F, (double)16.0F, (double)8.0F)).multiply((double)0.0625F));
    }
}
