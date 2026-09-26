package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.ChangeDimensionTrigger;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        HolderLookup<Item> itemRegistryEntryLookup = registryLookup.lookupOrThrow(Registries.ITEM);

        AdvancementHolder netherAndEnd = Advancement.Builder.advancement()
                .parent(Constants.id("textures/gui/advancements/backgrounds/nether_and_end.png"))
                .display(
                        NetherAndEndBlocks.NETHER_DIAMOND_ORE.blockItem().get(),
                        Component.translatable("advancement.netherandend.nether_and_end.title"),
                        Component.translatable("advancement.netherandend.nether_and_end.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("entered_nether", ChangeDimensionTrigger.TriggerInstance.changedDimension(Level.OVERWORLD, Level.NETHER))
                .save(consumer, Constants.id("/entered_nether"));

        AdvancementHolder doubleWart = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlocks.WARPED_WART.blockItem().get(), 
                        Component.translatable("advancement.netherandend.double_wart.title"),
                        Component.translatable("advancement.netherandend.double_wart.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_nether_wart", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHER_WART))
                .addCriterion("got_warped_wart", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlocks.WARPED_WART.blockItem().get()))
                .save(consumer, Constants.id("/got_warts"));
        AdvancementHolder whyIsThisSoComplicated = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.RAW_STRIDER_MEAT.get(),
                        Component.translatable("advancement.netherandend.why_is_this_so_complicated.title"),
                        Component.translatable("advancement.netherandend.why_is_this_so_complicated.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_raw_strider_meat", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.RAW_STRIDER_MEAT.get()))
                .save(consumer, Constants.id("/got_raw_strider_meat"));
        AdvancementHolder whyWasThisSoHard = Advancement.Builder.advancement()
                .parent(whyIsThisSoComplicated)
                .display(
                        NetherAndEndItems.HARDENED_STRIDER_MEAT.get(),
                        Component.translatable("advancement.netherandend.why_was_this_so_hard.title"),
                        Component.translatable("advancement.netherandend.why_was_this_so_hard.desc"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_raw_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.RAW_STRIDER_MEAT.get()))
                .addCriterion("got_smoked_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.SMOKED_STRIDER_MEAT.get()))
                .addCriterion("got_cooked_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.COOKED_STRIDER_MEAT.get()))
                .addCriterion("got_hardened_strider_meat", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_STRIDER_MEAT.get()))
                .save(consumer, Constants.id("/got_all_strider_meat"));
        AdvancementHolder wellThatsUnique = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlocks.CRUMBLING_BASALT.blockItem().get(),
                        Component.translatable("advancement.netherandend.well_thats_unique.title"),
                        Component.translatable("advancement.netherandend.well_thats_unique.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_crumbling_basalt", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlocks.CRUMBLING_BASALT.blockItem().get()))
                .save(consumer, Constants.id("/got_crumbling_basalt"));

        AdvancementHolder endCompacting = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlocks.CHORUS_BLOCK.blockItem().get(),
                        Component.translatable("advancement.netherandend.end_compacting.title"),
                        Component.translatable("advancement.netherandend.end_compacting.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_chorus_block", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlocks.CHORUS_BLOCK.blockItem().get()))
                .save(consumer, Constants.id("/got_chorus_block"));
        AdvancementHolder fruitful = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.ENDER_FRUIT.get(),
                        Component.translatable("advancement.netherandend.fruitful.title"),
                        Component.translatable("advancement.netherandend.fruitful.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_ender_fruit", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.ENDER_FRUIT.get()))
                .save(consumer, Constants.id("/got_ender_fruit"));
        AdvancementHolder thePowerIsNowMine = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.DRAGON_CHARGE.get(),
                        Component.translatable("advancement.netherandend.the_power_is_now_mine.title"),
                        Component.translatable("advancement.netherandend.the_power_is_now_mine.desc"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("got_dragon_charge", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.DRAGON_CHARGE.get()))
                .save(consumer, Constants.id("/got_dragon_charge"));
        AdvancementHolder woahImFlying = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndItems.SHULKER_PEARL.get(),
                        Component.translatable("advancement.netherandend.woah_im_flying.title"),
                        Component.translatable("advancement.netherandend.woah_im_flying.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("consumed_shulker_pearl", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.SHULKER_PEARL.get()))
                .save(consumer, Constants.id("/consumed_shulker_pearl"));
        AdvancementHolder thisIsCrunchy = Advancement.Builder.advancement()
                .parent(woahImFlying)
                .display(
                        NetherAndEndItems.HARDENED_SHULKER_PEARL.get(),
                        Component.translatable("advancement.netherandend.this_is_crunchy.title"),
                        Component.translatable("advancement.netherandend.this_is_crunchy.desc"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("consumed_hardened_shulker_pearl", ConsumeItemTrigger.TriggerInstance.usedItem(itemRegistryEntryLookup, NetherAndEndItems.HARDENED_SHULKER_PEARL.get()))
                .save(consumer, Constants.id("/consumed_hardened_shulker_pearl"));
        AdvancementHolder theFinalBlade = Advancement.Builder.advancement()
                .parent(thisIsCrunchy)
                .display(
                        NetherAndEndItems.SHULKER_FALCHION.get(),
                        Component.translatable("advancement.netherandend.the_final_blade.title"),
                        Component.translatable("advancement.netherandend.the_final_blade.desc"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_shulker_falchion", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndItems.SHULKER_FALCHION.get()))
                .save(consumer, Constants.id("/got_shulker_falchion"));
        AdvancementHolder thatsMorePeaceful = Advancement.Builder.advancement()
                .parent(netherAndEnd)
                .display(
                        NetherAndEndBlocks.ENDER_PEARL_CLUSTER.blockItem().get(),
                        Component.translatable("advancement.netherandend.thats_more_peaceful.title"),
                        Component.translatable("advancement.netherandend.thats_more_peaceful.desc"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("got_ender_pearl_cluster", InventoryChangeTrigger.TriggerInstance.hasItems(NetherAndEndBlocks.ENDER_PEARL_CLUSTER.blockItem().get()))
                .save(consumer, Constants.id("/got_ender_pearl_cluster"));
        AdvancementHolder oreCollector = Advancement.Builder.advancement()
                .parent(thatsMorePeaceful)
                .display(
                        NetherAndEndBlocks.END_DIAMOND_ORE.blockItem().get(),
                        Component.translatable("advancement.netherandend.ore_collector.title"),
                        Component.translatable("advancement.netherandend.ore_collector.desc"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_all_ores", InventoryChangeTrigger.TriggerInstance.hasItems(
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

                        NetherAndEndBlocks.NETHER_COAL_ORE.blockItem().get(),
                        NetherAndEndBlocks.NETHER_IRON_ORE.blockItem().get(),
                        NetherAndEndBlocks.NETHER_COPPER_ORE.blockItem().get(),
                        Items.NETHER_GOLD_ORE,
                        NetherAndEndBlocks.NETHER_REDSTONE_ORE.blockItem().get(),
                        NetherAndEndBlocks.NETHER_EMERALD_ORE.blockItem().get(),
                        NetherAndEndBlocks.NETHER_LAPIS_ORE.blockItem().get(),
                        NetherAndEndBlocks.NETHER_DIAMOND_ORE.blockItem().get(),
                        Items.NETHER_QUARTZ_ORE,
                        Items.ANCIENT_DEBRIS,

                        NetherAndEndBlocks.END_COAL_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_IRON_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_COPPER_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_GOLD_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_REDSTONE_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_EMERALD_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_LAPIS_ORE.blockItem().get(),
                        NetherAndEndBlocks.END_DIAMOND_ORE.blockItem().get(),
                        NetherAndEndBlocks.ENDER_PEARL_CLUSTER.blockItem().get()
                ))
                .save(consumer, Constants.id("/got_all_ores"));
    }
}
