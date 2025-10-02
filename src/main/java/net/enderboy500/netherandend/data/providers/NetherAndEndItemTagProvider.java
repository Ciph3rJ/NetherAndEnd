package net.enderboy500.netherandend.data.providers;

import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NetherAndEndItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(NetherAndEndTags.HOGCHOP)
                .add(NetherAndEndItems.RAW_HOGCHOP)
                .add(NetherAndEndItems.COOKED_HOGCHOP);
        getOrCreateTagBuilder(NetherAndEndTags.STRIDER_MEAT)
                .add(NetherAndEndItems.RAW_STRIDER_MEAT)
                .add(NetherAndEndItems.COOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.SMOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.HARDENED_STRIDER_MEAT);
        getOrCreateTagBuilder(NetherAndEndTags.STRIDER_MEAT_BLASTABLE)
                .add(NetherAndEndItems.RAW_STRIDER_MEAT)
                .add(NetherAndEndItems.COOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.SMOKED_STRIDER_MEAT);

        getOrCreateTagBuilder(ItemTags.MEAT)
                .addTag(NetherAndEndTags.HOGCHOP)
                .addTag(NetherAndEndTags.STRIDER_MEAT);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);

        getOrCreateTagBuilder(ItemTags.BUNDLES)
                .add(NetherAndEndItems.HOGLIN_BUNDLE)
        ;
    }
}
