package net.enderboy500.netherandend.data.providers;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockLootTableProvider extends FabricBlockLootTableProvider {
    public NetherAndEndBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE);
        dropSelf(NetherAndEndBlocks.CRACKED_RED_NETHER_BRICKS);
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE);
        dropSelf(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE);
        dropSelf(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS);
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICKS);
        dropSelf(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS);
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS);
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL);
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE);
        dropSelf(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE);
        dropSelf(NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS);
        dropSelf(NetherAndEndBlocks.WIHERED_BONE_BLOCK);
    }
}
