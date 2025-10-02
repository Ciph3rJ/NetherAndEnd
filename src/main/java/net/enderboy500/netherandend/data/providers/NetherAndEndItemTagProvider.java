package net.enderboy500.netherandend.data.providers;

import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.util.NetherAndEndTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NetherAndEndItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(NetherAndEndTags.HOGCHOP)
                .add(NetherAndEndItems.RAW_HOGCHOP)
                .add(NetherAndEndItems.COOKED_HOGCHOP);
        valueLookupBuilder(NetherAndEndTags.STRIDER_MEAT)
                .add(NetherAndEndItems.RAW_STRIDER_MEAT)
                .add(NetherAndEndItems.COOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.SMOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.HARDENED_STRIDER_MEAT);
        valueLookupBuilder(NetherAndEndTags.STRIDER_MEAT_BLASTABLE)
                .add(NetherAndEndItems.RAW_STRIDER_MEAT)
                .add(NetherAndEndItems.COOKED_STRIDER_MEAT)
                .add(NetherAndEndItems.SMOKED_STRIDER_MEAT);

        valueLookupBuilder(ItemTags.MEAT)
                .addTag(NetherAndEndTags.HOGCHOP)
                .addTag(NetherAndEndTags.STRIDER_MEAT);

        valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        valueLookupBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);
        valueLookupBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(NetherAndEndItems.SHULKER_FALCHION);

        valueLookupBuilder(ItemTags.BUNDLES)
                .add(NetherAndEndItems.HOGLIN_BUNDLE)
        ;
    }
}
