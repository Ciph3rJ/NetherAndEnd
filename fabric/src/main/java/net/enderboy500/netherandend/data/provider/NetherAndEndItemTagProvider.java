package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public NetherAndEndItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(NetherAndEndTags.STRIDER_MEAT)
                .addElement(NetherAndEndItems.RAW_STRIDER_MEAT.id())
                .addElement(NetherAndEndItems.SMOKED_STRIDER_MEAT.id())
                .addElement(NetherAndEndItems.COOKED_STRIDER_MEAT.id())
                .addElement(NetherAndEndItems.HARDENED_STRIDER_MEAT.id())
        ;

        getOrCreateRawBuilder(NetherAndEndTags.STRIDER_MEAT_BLASTABLE)
                .addElement(NetherAndEndItems.RAW_STRIDER_MEAT.id())
                .addElement(NetherAndEndItems.SMOKED_STRIDER_MEAT.id())
                .addElement(NetherAndEndItems.COOKED_STRIDER_MEAT.id())
        ;

        getOrCreateRawBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .addElement(NetherAndEndItems.SHULKER_FALCHION.id())
        ;

        getOrCreateRawBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .addElement(NetherAndEndItems.SHULKER_FALCHION.id())
        ;

        getOrCreateRawBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .addElement(NetherAndEndItems.SHULKER_FALCHION.id())
        ;

        getOrCreateRawBuilder(ItemTags.BUNDLES)
                .addElement(NetherAndEndItems.HOGLIN_BUNDLE.id())
        ;

        getOrCreateRawBuilder(ItemTags.MEAT)
                .addTag(NetherAndEndTags.STRIDER_MEAT.location())
        ;

        getOrCreateRawBuilder(ItemTags.PLANKS)
                .addElement(NetherAndEndBlocks.CHORUS_PLANKS.blockItem().id())
        ;

        getOrCreateRawBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .addElement(Identifier.withDefaultNamespace("stone"))
                .addElement(Identifier.withDefaultNamespace("end_stone"))
        ;
    }
}
