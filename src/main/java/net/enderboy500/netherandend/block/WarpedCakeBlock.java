package net.enderboy500.netherandend.block;

import com.mojang.serialization.MapCodec;
import net.enderboy500.netherandend.compat.NEFDCompat;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.ScheduledTickView;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

public class WarpedCakeBlock extends Block {
    public static final MapCodec<WarpedCakeBlock> CODEC = createCodec(WarpedCakeBlock::new);
    public static final int MAX_BITES = 6;
    public static final IntProperty BITES;
    public static final int DEFAULT_COMPARATOR_OUTPUT;
    private static final VoxelShape[] SHAPES_BY_BITES;

    public MapCodec<WarpedCakeBlock> getCodec() {
        return CODEC;
    }

    public WarpedCakeBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(BITES, 0));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_BITES[(Integer) state.get(BITES)];
    }

    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && (Integer) state.get(BITES) == 0) {
            Block var10 = Block.getBlockFromItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock) var10;
                stack.decrementUnlessCreative(1, player);
                world.playSound((Entity) null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, WarpedCandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    public boolean isDelighted(ItemStack stack) {
        if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
            if (stack.isIn(ModTags.KNIVES)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient && !isDelighted(player.getMainHandStack())) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        } else if (isDelighted(player.getMainHandStack())) {
            onCakeInteraction(player, world, player.getActiveHand(), hit);
            int i = state.get(BITES);
            if (i < 6) {
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
        }

        return tryEat(world, pos, state, player);
    }

    public static ActionResult onCakeInteraction(PlayerEntity player, World level, Hand hand, BlockHitResult hitResult) {
        if (player.isSpectator()) {
            return ActionResult.PASS;
        } else {
            ItemStack toolStack = player.getStackInHand(hand);
            if (!toolStack.isIn(ModTags.KNIVES)) {
                return ActionResult.PASS;
            } else {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = level.getBlockState(pos);
                Block block = state.getBlock();
                if (state.getBlock() instanceof WarpedCakeBlock || state.getBlock() instanceof WarpedCandleCakeBlock) {
                    level.setBlockState(pos, (BlockState)Blocks.CAKE.getDefaultState().with(BITES, 1), 3);
                    Block.dropStacks(state, level, pos);
                    ItemUtils.spawnItemEntity(level, new ItemStack(NEFDCompat.WARPED_CAKE_SLICE), (double)pos.getX(), (double)pos.getY() + 0.2, (double)pos.getZ() + (double)0.5F, -0.05, (double)0.0F, (double)0.0F);
                    level.playSound((Entity)null, pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);
                    return ActionResult.SUCCESS;
                } else if (block == NetherAndEndBlocks.WARPED_CAKE) {
                    int bites = (Integer)state.get(BITES);
                    if (bites < 6) {
                        level.setBlockState(pos, (BlockState)state.with(BITES, bites + 1), 3);
                    } else {
                        level.removeBlock(pos, false);
                    }

                    ItemUtils.spawnItemEntity(level, new ItemStack((ItemConvertible)ModItems.CAKE_SLICE.get()), (double)pos.getX() + (double)bites * 0.1, (double)pos.getY() + 0.2, (double)pos.getZ() + (double)0.5F, -0.05, (double)0.0F, (double)0.0F);
                    level.playSound((Entity)null, pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);
                    return level.isClient ? ActionResult.SUCCESS : ActionResult.CONSUME;
                } else {
                    return ActionResult.PASS;
                }
            }
        }
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.incrementStat(Stats.EAT_CAKE_SLICE);
        player.getHungerManager().add(2, 0.1F);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0));
        int i = state.get(BITES);
        world.emitGameEvent(player, GameEvent.EAT, pos);
        if (i < 6) {
            world.setBlockState(pos, state.with(BITES, i + 1), 3);
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return ActionResult.SUCCESS;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput((Integer) state.get(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (7 - bites) * 2;
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        BITES = Properties.BITES;
        DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);
        SHAPES_BY_BITES = Block.createShapeArray(6, (bites) -> Block.createCuboidShape((double) (1 + bites * 2), (double) 0.0F, (double) 1.0F, (double) 15.0F, (double) 8.0F, (double) 15.0F));
    }
}
