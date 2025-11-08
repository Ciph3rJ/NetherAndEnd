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
        dropOther(NetherAndEndBlocks.NETHER_COAL_ORE, Items.COAL);
        dropOther(NetherAndEndBlocks.NETHER_IRON_ORE, Items.IRON_NUGGET);
        copperOreDrop(NetherAndEndBlocks.NETHER_COPPER_ORE);
        redstoneOreDrop(NetherAndEndBlocks.NETHER_REDSTONE_ORE);
        dropOther(NetherAndEndBlocks.NETHER_EMERALD_ORE, Items.EMERALD);
        lapisOreDrop(NetherAndEndBlocks.NETHER_LAPIS_ORE);
        dropOther(NetherAndEndBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND);

        dropOther(NetherAndEndBlocks.END_COAL_ORE, Items.COAL);
        dropOther(NetherAndEndBlocks.END_IRON_ORE, Items.RAW_IRON);
        copperOreDrop(NetherAndEndBlocks.END_COPPER_ORE);
        dropOther(NetherAndEndBlocks.END_GOLD_ORE, Items.RAW_GOLD);
        redstoneOreDrop(NetherAndEndBlocks.END_REDSTONE_ORE);
        dropOther(NetherAndEndBlocks.END_EMERALD_ORE, Items.EMERALD);
        lapisOreDrop(NetherAndEndBlocks.END_LAPIS_ORE);
        dropOther(NetherAndEndBlocks.END_DIAMOND_ORE, Items.DIAMOND);
        enderPearlClusterDrop(NetherAndEndBlocks.ENDER_PEARL_CLUSTER);
    }

    public LootTable.Builder copperOreDrop(Block drop) {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                drop,
                this.applyExplosionDecay(
                        drop,
                        LootItem.lootTableItem(Items.RAW_COPPER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder lapisOreDrop(Block drop) {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                drop,
                this.applyExplosionDecay(
                        drop,
                        LootItem.lootTableItem(Items.LAPIS_LAZULI)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder redstoneOreDrop(Block drop) {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                drop,
                this.applyExplosionDecay(
                        drop,
                        LootItem.lootTableItem(Items.REDSTONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 5.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder enderPearlClusterDrop(Block drop) {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                drop,
                this.applyExplosionDecay(
                        drop,
                        LootItem.lootTableItem(Items.ENDER_PEARL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7)))
                                .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
