package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.services.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgeCreativeModeTab {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final Supplier<CreativeModeTab> NETHER_AND_END = CREATIVE_MODE_TABS.register("nether_and_end_group", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemgroup.netherandend"))
            .icon(NetherAndEndBlocks.END_DIAMOND_ORE.blockItem().get()::getDefaultInstance)
            .displayItems(((itemDisplayParameters, entries) -> {
                entries.accept(NetherAndEndBlocks.NETHER_COAL_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_IRON_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_COPPER_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_REDSTONE_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_EMERALD_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_LAPIS_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.NETHER_DIAMOND_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICKS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CRACKED_CYAN_NETHER_BRICKS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CRACKED_BEDROCK.blockItem().get());
                entries.accept(NetherAndEndBlocks.CRUMBLING_BASALT.blockItem().get());
                entries.accept(NetherAndEndBlocks.WARPED_WART.blockItem().get());
                entries.accept(NetherAndEndItems.WARPED_STEW.get());
                entries.accept(NeoForgeBlocks.WARPED_CAKE.blockItem().get());
                entries.accept(NetherAndEndItems.CRIMSON_PIE.get());
                entries.accept(NetherAndEndItems.HOGLIN_SKIN.get());
                entries.accept(NetherAndEndItems.HOGLIN_BUNDLE.get());
                entries.accept(NetherAndEndItems.RAW_STRIDER_MEAT.get());
                entries.accept(NetherAndEndItems.SMOKED_STRIDER_MEAT.get());
                entries.accept(NetherAndEndItems.COOKED_STRIDER_MEAT.get());
                entries.accept(NetherAndEndItems.HARDENED_STRIDER_MEAT.get());
                entries.accept(NetherAndEndItems.WITHERED_BONE.get());
                entries.accept(NetherAndEndItems.WITHERED_BONE_MEAL.get());
                entries.accept(NetherAndEndBlocks.WITHERED_BONE_BLOCK.blockItem().get());

                entries.accept(NetherAndEndBlocks.END_COAL_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_IRON_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_COPPER_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_GOLD_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_REDSTONE_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_EMERALD_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_LAPIS_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.END_DIAMOND_ORE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_BLOCK.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_PLANKS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_STAIRS.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_SLAB.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_FENCE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_FENCE_GATE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_DOOR.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_TRAPDOOR.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_BUTTON.blockItem().get());
                entries.accept(NetherAndEndBlocks.CHORUS_SHELF.blockItem().get());
                entries.accept(NetherAndEndItems.ENDER_FRUIT.get());
                entries.accept(NetherAndEndItems.CHORUS_SOUP.get());
                entries.accept(NetherAndEndItems.CHORUS_PIE.get());
                entries.accept(NetherAndEndItems.SHULKER_PEARL.get());
                entries.accept(NetherAndEndItems.HARDENED_SHULKER_PEARL.get());
                entries.accept(NetherAndEndItems.SHULKER_FALCHION.get());
                entries.accept(NetherAndEndBlocks.ENDER_PEARL_CLUSTER.blockItem().get());
                entries.accept(NetherAndEndItems.DRAGON_CHARGE.get());
            }))
            .build());

    public static void loadCreativeModeTab(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
