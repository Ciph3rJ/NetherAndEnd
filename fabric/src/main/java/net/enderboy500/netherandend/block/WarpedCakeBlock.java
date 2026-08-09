package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.enderboy500.netherandend.NetherAndEndFabric;
import net.enderboy500.netherandend.compat.NEFDRFCompat;
import net.enderboy500.netherandend.content.FabricBlocks;
import net.enderboy500.netherandend.services.Services;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class WarpedCakeBlock extends Block {
    public static final MapCodec<WarpedCakeBlock> CODEC = simpleCodec(WarpedCakeBlock::new);
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES;
    public static final int FULL_CAKE_SIGNAL;
    private static final VoxelShape[] SHAPES;

    public MapCodec<WarpedCakeBlock> codec() {
        return CODEC;
    }

    public WarpedCakeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(BITES, 0));
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPES[blockState.getValue(BITES)];
    }

    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        Item item = itemStack.getItem();
        if (itemStack.is(ItemTags.CANDLES) && blockState.getValue(BITES) == 0) {
            Block var10 = Block.byItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock)var10;
                itemStack.consume(1, player);
                level.playSound(null, blockPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(blockPos, WarpedCandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                player.awardStat(Stats.ITEM_USED.get(item));
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    public boolean isDelighted(ItemStack stack) {
        if (Services.PLATFORM.isModLoaded("farmersdelight")) {
            return stack.is(ModTags.Items.KNIVES);
        }
        return false;
    }

    public static InteractionResult onCakeInteraction(Player player, Level level, InteractionHand hand, BlockHitResult hitResult) {
        if (player.isSpectator()) {
            return InteractionResult.PASS;
        } else {
            ItemStack toolStack = player.getItemInHand(hand);
            if (!toolStack.is(ModTags.Items.KNIVES)) {
                return InteractionResult.PASS;
            } else {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = level.getBlockState(pos);
                Block block = state.getBlock();
                if (state.getBlock() instanceof WarpedCakeBlock || state.getBlock() instanceof WarpedCandleCakeBlock) {
                    level.setBlock(pos, Blocks.CAKE.getStateDefinition().any().setValue(BITES, 1), 3);
                    Block.dropResources(state, level, pos);
                    ItemUtils.spawnItemEntity(level, new ItemStack(NEFDRFCompat.WARPED_CAKE_SLICE), pos.getX(), (double)pos.getY() + 0.2, (double)pos.getZ() + (double)0.5F, -0.05, 0.0F, 0.0F);
                    level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
                } else if (block == FabricBlocks.WARPED_CAKE.block().get()) {
                    int bites = state.getValue(BITES);
                    if (bites < 6) {
                        level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
                    } else {
                        level.removeBlock(pos, false);
                    }

                    ItemUtils.spawnItemEntity(level, new ItemStack(ModItems.CAKE_SLICE.get()), (double)pos.getX() + (double)bites * 0.1, (double)pos.getY() + 0.2, (double)pos.getZ() + (double)0.5F, -0.05, (double)0.0F, (double)0.0F);
                    level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
                }
                return InteractionResult.SUCCESS;
            }
        }
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.isClientSide() && !isDelighted(player.getMainHandItem())) {
            if (eat(level, blockPos, blockState, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        } else if (isDelighted(player.getMainHandItem())) {
            onCakeInteraction(player, level, player.getUsedItemHand(), blockHitResult);
            int i = blockState.getValue(BITES);
            if (i < 6) {
                level.setBlock(blockPos, blockState.setValue(BITES, i + 1), 3);
            } else {
                level.removeBlock(blockPos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
            }
        }

        return eat(level, blockPos, blockState, player);
    }

    public static InteractionResult eat(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, Player player) {
        if (player.getFoodData().needsFood()) {
            player.awardStat(NetherAndEndFabric.EAT_WARPED_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
            int i = blockState.getValue(BITES);
            levelAccessor.gameEvent(player, GameEvent.EAT, blockPos);
            if (i < 6) {
                levelAccessor.setBlock(blockPos, blockState.setValue(BITES, i + 1), 3);
            } else {
                levelAccessor.removeBlock(blockPos, false);
                levelAccessor.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        return direction == Direction.DOWN && !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    }

    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos, Direction direction) {
        return getOutputSignal(blockState.getValue(BITES));
    }

    public static int getOutputSignal(int i) {
        return (7 - i) * 2;
    }

    protected boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    static {
        BITES = BlockStateProperties.BITES;
        FULL_CAKE_SIGNAL = getOutputSignal(0);
        SHAPES = Block.boxes(6, (i) -> Block.box((double)(1 + i * 2), (double)0.0F, (double)1.0F, (double)15.0F, (double)8.0F, (double)15.0F));
    }
}