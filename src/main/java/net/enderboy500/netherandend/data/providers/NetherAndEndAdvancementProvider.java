package net.enderboy500.netherandend.data.providers;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class NetherAndEndAdvancementProvider extends FabricAdvancementProvider {
    public NetherAndEndAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        RegistryEntryLookup<Item> itemRegistryEntryLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

        AdvancementEntry netherAndEnd = Advancement.Builder.create()
                .display(
                        NetherAndEndBlockItems.NETHER_DIAMOND_ORE,
                        Text.translatable("advancement.netherandend.nether_and_end.title"),
                        Text.translatable("advancement.netherandend.nether_and_end.desc"),
                        Identifier.of(NetherAndEnd.MOD_ID, "gui/advancements/backgrounds/nether_and_end"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("entered_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER))
                .build(consumer, NetherAndEnd.MOD_ID + "/entered_nether");

        AdvancementEntry doubleWart = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.WARPED_WART,
                        Text.translatable("advancement.netherandend.double_wart.title"),
                        Text.translatable("advancement.netherandend.double_wart.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_nether_wart", InventoryChangedCriterion.Conditions.items(Items.NETHER_WART))
                .criterion("got_warped_wart", InventoryChangedCriterion.Conditions.items(NetherAndEndItems.WARPED_WART))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_warts");
        AdvancementEntry whyIsThisSoComplicated = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.RAW_STRIDER_MEAT,
                        Text.translatable("advancement.netherandend.why_is_this_so_complicated.title"),
                        Text.translatable("advancement.netherandend.why_is_this_so_complicated.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_raw_strider_meat", InventoryChangedCriterion.Conditions.items(NetherAndEndItems.RAW_STRIDER_MEAT))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_raw_strider_meat");
        AdvancementEntry whyWasThisSoHard = Advancement.Builder.create()
                .parent(whyIsThisSoComplicated)
                .display(
                        NetherAndEndItems.HARDENED_STRIDER_MEAT,
                        Text.translatable("advancement.netherandend.why_was_this_so_hard.title"),
                        Text.translatable("advancement.netherandend.why_was_this_so_hard.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("got_raw_strider_meat", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.RAW_STRIDER_MEAT))
                .criterion("got_smoked_strider_meat", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.SMOKED_STRIDER_MEAT))
                .criterion("got_cooked_strider_meat", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.COOKED_STRIDER_MEAT))
                .criterion("got_hardened_strider_meat", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_STRIDER_MEAT))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_all_strider_meat");
        AdvancementEntry whatsTheDifference = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.RAW_HOGCHOP,
                        Text.translatable("advancement.netherandend.whats_the_difference.title"),
                        Text.translatable("advancement.netherandend.whats_the_difference.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_raw_hogchop", InventoryChangedCriterion.Conditions.items(NetherAndEndItems.RAW_HOGCHOP))
                .criterion("got_raw_porkchop", InventoryChangedCriterion.Conditions.items(Items.PORKCHOP))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_chops");
        AdvancementEntry wellThatsUnique = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.CRUMBLING_BASALT,
                        Text.translatable("advancement.netherandend.well_thats_unique.title"),
                        Text.translatable("advancement.netherandend.well_thats_unique.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_crumbling_basalt", InventoryChangedCriterion.Conditions.items(NetherAndEndBlockItems.CRUMBLING_BASALT))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_crumbling_basalt");

        AdvancementEntry endCompacting = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.CHORUS_BLOCK,
                        Text.translatable("advancement.netherandend.end_compacting.title"),
                        Text.translatable("advancement.netherandend.end_compacting.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_chorus_block", InventoryChangedCriterion.Conditions.items(NetherAndEndBlockItems.CHORUS_BLOCK))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_chorus_block");
        AdvancementEntry fruitful = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.ENDER_FRUIT,
                        Text.translatable("advancement.netherandend.fruitful.title"),
                        Text.translatable("advancement.netherandend.fruitful.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_ender_fruit", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.ENDER_FRUIT))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_ender_fruit");
        AdvancementEntry thePowerIsNowMine = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.DRAGON_CHARGE,
                        Text.translatable("advancement.netherandend.the_power_is_now_mine.title"),
                        Text.translatable("advancement.netherandend.the_power_is_now_mine.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_dragon_charge", InventoryChangedCriterion.Conditions.items(NetherAndEndItems.DRAGON_CHARGE))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_dragon_charge");
        AdvancementEntry woahImFlying = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.SHULKER_PEARL,
                        Text.translatable("advancement.netherandend.woah_im_flying.title"),
                        Text.translatable("advancement.netherandend.woah_im_flying.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("consumed_shulker_pearl", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.SHULKER_PEARL))
                .build(consumer, NetherAndEnd.MOD_ID + "/consumed_shulker_pearl");
        AdvancementEntry thisIsCrunchy = Advancement.Builder.create()
                .parent(woahImFlying)
                .display(
                        NetherAndEndItems.HARDENED_SHULKER_PEARL,
                        Text.translatable("advancement.netherandend.this_is_crunchy.title"),
                        Text.translatable("advancement.netherandend.this_is_crunchy.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("consumed_hardened_shulker_pearl", ConsumeItemCriterion.Conditions.item(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_SHULKER_PEARL))
                .build(consumer, NetherAndEnd.MOD_ID + "/consumed_hardened_shulker_pearl");
        AdvancementEntry theFinalBlade = Advancement.Builder.create()
                .parent(thisIsCrunchy)
                .display(
                        NetherAndEndItems.SHULKER_FALCHION,
                        Text.translatable("advancement.netherandend.the_final_blade.title"),
                        Text.translatable("advancement.netherandend.the_final_blade.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("got_shulker_falchion", InventoryChangedCriterion.Conditions.items(NetherAndEndItems.SHULKER_FALCHION))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_shulker_falchion");
        AdvancementEntry thatsMorePeaceful = Advancement.Builder.create()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.ENDER_PEARL_CLUSTER,
                        Text.translatable("advancement.netherandend.thats_more_peaceful.title"),
                        Text.translatable("advancement.netherandend.thats_more_peaceful.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_ender_pearl_cluster", InventoryChangedCriterion.Conditions.items(NetherAndEndBlockItems.ENDER_PEARL_CLUSTER))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_ender_pearl_cluster");
        AdvancementEntry oreCollector = Advancement.Builder.create()
                .parent(thatsMorePeaceful)
                .display(
                        NetherAndEndBlockItems.END_DIAMOND_ORE,
                        Text.translatable("advancement.netherandend.ore_collector.title"),
                        Text.translatable("advancement.netherandend.ore_collector.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("got_all_ores", InventoryChangedCriterion.Conditions.items(Items.COAL_ORE,
                        Items.IRON_ORE,
                        Items.COPPER_ORE,
                        Items.GOLD_ORE,
                        Items.REDSTONE_ORE,
                        Items.EMERALD_ORE,
                        Items.LAPIS_ORE,
                        Items.DIAMOND_ORE,

                        Items.DEEPSLATE_COAL_ORE,
                        Items.DEEPSLATE_IRON_ORE,
                        Items.DEEPSLATE_COPPER_ORE,
                        Items.DEEPSLATE_GOLD_ORE,
                        Items.DEEPSLATE_REDSTONE_ORE,
                        Items.DEEPSLATE_EMERALD_ORE,
                        Items.DEEPSLATE_LAPIS_ORE,
                        Items.DEEPSLATE_DIAMOND_ORE,

                        NetherAndEndBlockItems.NETHER_COAL_ORE,
                        NetherAndEndBlockItems.NETHER_IRON_ORE,
                        NetherAndEndBlockItems.NETHER_COPPER_ORE,
                        Items.NETHER_GOLD_ORE,
                        NetherAndEndBlockItems.NETHER_REDSTONE_ORE,
                        NetherAndEndBlockItems.NETHER_EMERALD_ORE,
                        NetherAndEndBlockItems.NETHER_LAPIS_ORE,
                        NetherAndEndBlockItems.NETHER_DIAMOND_ORE,
                        Items.NETHER_QUARTZ_ORE,
                        Items.ANCIENT_DEBRIS,

                        NetherAndEndBlockItems.END_COAL_ORE,
                        NetherAndEndBlockItems.END_IRON_ORE,
                        NetherAndEndBlockItems.END_COPPER_ORE,
                        NetherAndEndBlockItems.END_GOLD_ORE,
                        NetherAndEndBlockItems.END_REDSTONE_ORE,
                        NetherAndEndBlockItems.END_EMERALD_ORE,
                        NetherAndEndBlockItems.END_LAPIS_ORE,
                        NetherAndEndBlockItems.END_DIAMOND_ORE,
                        NetherAndEndBlockItems.ENDER_PEARL_CLUSTER))
                .build(consumer, NetherAndEnd.MOD_ID + "/got_all_ores");
    }
}
