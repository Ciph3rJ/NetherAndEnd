package net.enderboy500.netherandend.datagen.providers;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndBlockLootTableProvider extends FabricBlockLootTableProvider {
    public NetherAndEndBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(NetherAndEndBlocks.NETHER_COAL_ORE, Items.COAL);
        addDrop(NetherAndEndBlocks.NETHER_IRON_ORE, Items.IRON_NUGGET);
        copperOreDrop(NetherAndEndBlocks.NETHER_COPPER_ORE);
        redstoneOreDrop(NetherAndEndBlocks.NETHER_REDSTONE_ORE);
        addDrop(NetherAndEndBlocks.NETHER_EMERALD_ORE, Items.EMERALD);
        lapisOreDrop(NetherAndEndBlocks.NETHER_LAPIS_ORE);
        addDrop(NetherAndEndBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND);

        addDrop(NetherAndEndBlocks.END_COAL_ORE, Items.COAL);
        addDrop(NetherAndEndBlocks.END_IRON_ORE, Items.IRON_INGOT);
        copperOreDrop(NetherAndEndBlocks.END_COPPER_ORE);
        addDrop(NetherAndEndBlocks.END_GOLD_ORE, Items.GOLD_INGOT);
        redstoneOreDrop(NetherAndEndBlocks.END_REDSTONE_ORE);
        addDrop(NetherAndEndBlocks.END_EMERALD_ORE, Items.EMERALD);
        lapisOreDrop(NetherAndEndBlocks.END_LAPIS_ORE);
        addDrop(NetherAndEndBlocks.END_DIAMOND_ORE, Items.DIAMOND);
        enderPearlClusterDrop(NetherAndEndBlocks.ENDER_PEARL_CLUSTER);
    }

    public LootTable.Builder oreDrop(Block withSilkTouch, Item withoutSilkTouch) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                withSilkTouch,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        withSilkTouch, ItemEntry.builder(withoutSilkTouch).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder copperOreDrop(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(Items.RAW_COPPER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder lapisOreDrop(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(Items.LAPIS_LAZULI)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 9.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder redstoneOreDrop(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(Items.REDSTONE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder enderPearlClusterDrop(Block drop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(Items.ENDER_PEARL)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 7)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
