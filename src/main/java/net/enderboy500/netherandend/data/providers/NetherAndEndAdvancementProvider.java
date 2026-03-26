package net.enderboy500.netherandend.data.providers;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.*;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class NetherAndEndAdvancementProvider extends FabricAdvancementProvider {
    public NetherAndEndAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
        HolderGetter<Item> itemRegistryEntryLookup = provider.lookupOrThrow(Registries.ITEM);

        AdvancementHolder netherAndEnd = Advancement.Builder.advancement()
                .display(
                        NetherAndEndBlockItems.NETHER_DIAMOND_ORE,
                        Component.translatable("advancement.netherandend.nether_and_end.title"),
                        Component.translatable("advancement.netherandend.nether_and_end.desc"),
                        Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "gui/advancements/backgrounds/nether_and_end"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("entered_nether", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.NETHER))
                .save(consumer, NetherAndEnd.MOD_ID + ":entered_nether");

        AdvancementHolder doubleWart = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.WARPED_WART,
                        Component.translatable("advancement.netherandend.double_wart.title"),
                        Component.translatable("advancement.netherandend.double_wart.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_nether_wart", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHER_WART))
                .addCriterion("got_warped_wart", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.WARPED_WART))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_warts");
        AdvancementHolder whyIsThisSoComplicated = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.RAW_STRIDER_MEAT,
                        Component.translatable("advancement.netherandend.why_is_this_so_complicated.title"),
                        Component.translatable("advancement.netherandend.why_is_this_so_complicated.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_raw_strider_meat", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.RAW_STRIDER_MEAT))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_raw_strider_meat");
        AdvancementHolder whyWasThisSoHard = Advancement.Builder.advancement()
                .parent(whyIsThisSoComplicated)
                .display(
                        NetherAndEndItems.HARDENED_STRIDER_MEAT,
                        Component.translatable("advancement.netherandend.why_was_this_so_hard.title"),
                        Component.translatable("advancement.netherandend.why_was_this_so_hard.desc"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_raw_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.RAW_STRIDER_MEAT))
                .addCriterion("got_smoked_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.SMOKED_STRIDER_MEAT))
                .addCriterion("got_cooked_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.COOKED_STRIDER_MEAT))
                .addCriterion("got_hardened_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_STRIDER_MEAT))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_all_strider_meat");
        AdvancementHolder whatsTheDifference = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.RAW_HOGCHOP,
                        Component.translatable("advancement.netherandend.whats_the_difference.title"),
                        Component.translatable("advancement.netherandend.whats_the_difference.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_raw_hogchop", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.RAW_HOGCHOP))
                .addCriterion("got_raw_porkchop", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PORKCHOP))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_chops");
        AdvancementHolder wellThatsUnique = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.CRUMBLING_BASALT,
                        Component.translatable("advancement.netherandend.well_thats_unique.title"),
                        Component.translatable("advancement.netherandend.well_thats_unique.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_crumbling_basalt", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlockItems.CRUMBLING_BASALT))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_crumbling_basalt");

        AdvancementHolder endCompacting = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.CHORUS_BLOCK,
                        Component.translatable("advancement.netherandend.end_compacting.title"),
                        Component.translatable("advancement.netherandend.end_compacting.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_chorus_block", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlockItems.CHORUS_BLOCK))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_chorus_block");
        AdvancementHolder fruitful = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.ENDER_FRUIT,
                        Component.translatable("advancement.netherandend.fruitful.title"),
                        Component.translatable("advancement.netherandend.fruitful.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_ender_fruit", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.ENDER_FRUIT))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_ender_fruit");
        AdvancementHolder thePowerIsNowMine = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.DRAGON_CHARGE,
                        Component.translatable("advancement.netherandend.the_power_is_now_mine.title"),
                        Component.translatable("advancement.netherandend.the_power_is_now_mine.desc"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("got_dragon_charge", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.DRAGON_CHARGE))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_dragon_charge");
        AdvancementHolder woahImFlying = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.SHULKER_PEARL,
                        Component.translatable("advancement.netherandend.woah_im_flying.title"),
                        Component.translatable("advancement.netherandend.woah_im_flying.desc"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("consumed_shulker_pearl", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.SHULKER_PEARL))
                .save(consumer, NetherAndEnd.MOD_ID + ":consumed_shulker_pearl");
        AdvancementHolder thisIsCrunchy = Advancement.Builder.advancement()
                .parent(woahImFlying)
                .display(
                        NetherAndEndItems.HARDENED_SHULKER_PEARL,
                        Component.translatable("advancement.netherandend.this_is_crunchy.title"),
                        Component.translatable("advancement.netherandend.this_is_crunchy.desc"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("consumed_hardened_shulker_pearl", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_SHULKER_PEARL))
                .save(consumer, NetherAndEnd.MOD_ID + ":consumed_hardened_shulker_pearl");
        AdvancementHolder theFinalBlade = Advancement.Builder.advancement()
                .parent(thisIsCrunchy)
                .display(
                        NetherAndEndItems.SHULKER_FALCHION,
                        Component.translatable("advancement.netherandend.the_final_blade.title"),
                        Component.translatable("advancement.netherandend.the_final_blade.desc"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_shulker_falchion", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.SHULKER_FALCHION))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_shulker_falchion");
        AdvancementHolder thatsMorePeaceful = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlockItems.ENDER_PEARL_CLUSTER,
                        Component.translatable("advancement.netherandend.thats_more_peaceful.title"),
                        Component.translatable("advancement.netherandend.thats_more_peaceful.desc"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("got_ender_pearl_cluster", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlockItems.ENDER_PEARL_CLUSTER))
                .save(consumer, NetherAndEnd.MOD_ID + ":got_ender_pearl_cluster");
        AdvancementHolder oreCollector = Advancement.Builder.advancement()
                .parent(thatsMorePeaceful)
                .display(
                        NetherAndEndBlockItems.END_DIAMOND_ORE,
                        Component.translatable("advancement.netherandend.ore_collector.title"),
                        Component.translatable("advancement.netherandend.ore_collector.desc"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_all_ores", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL_ORE,
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
                .save(consumer, NetherAndEnd.MOD_ID + ":got_all_ores");
    }
}
