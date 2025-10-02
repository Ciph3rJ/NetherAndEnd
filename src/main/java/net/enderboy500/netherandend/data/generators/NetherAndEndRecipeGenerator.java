package net.enderboy500.netherandend.data.generators;

import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataOutput;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndRecipeGenerator extends RecipeGenerator {
    public NetherAndEndRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    @Override
    public void generate() {
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_BLOCK)
                .input('#', Items.CHORUS_FRUIT)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_BLOCK), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_PLANKS, 4)
                .input(NetherAndEndBlockItems.CHORUS_BLOCK)
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_PLANKS), conditionsFromItem(NetherAndEndBlockItems.CHORUS_BLOCK))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_STAIRS, 4)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_STAIRS), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_SLAB, 6)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_SLAB), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_FENCE, 3)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .input('/', Items.STICK)
                .pattern("#/#")
                .pattern("#/#")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_FENCE), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_FENCE_GATE, 1)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .input('/', Items.STICK)
                .pattern("/#/")
                .pattern("/#/")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_FENCE_GATE), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_BUTTON)
                .input(NetherAndEndBlockItems.CHORUS_PLANKS)
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_BUTTON), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_DOOR, 3)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_DOOR), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_TRAPDOOR, 2)
                .input('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_TRAPDOOR), conditionsFromItem(NetherAndEndBlockItems.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_SHELF, 6)
                .input('#', NetherAndEndBlockItems.CHORUS_BLOCK)
                .pattern("###")
                .pattern("   ")
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlockItems.CHORUS_SHELF), conditionsFromItem(NetherAndEndBlockItems.CHORUS_BLOCK))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.FOOD, NetherAndEndItems.CHORUS_PIE)
                .input(Items.CHORUS_FRUIT)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(NetherAndEndItems.CHORUS_PIE), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.FOOD, NetherAndEndItems.CHORUS_SOUP)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.CHORUS_FRUIT)
                .input(Items.BOWL)
                .criterion(hasItem(NetherAndEndItems.CHORUS_SOUP), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.FOOD, NetherAndEndItems.ENDER_FRUIT)
                .input('#', Items.CHORUS_FRUIT)
                .input('E', Items.ENDER_PEARL)
                .pattern(" # ")
                .pattern("#E#")
                .pattern(" # ")
                .criterion(hasItem(NetherAndEndItems.ENDER_FRUIT), conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.FOOD, NetherAndEndItems.DRAGON_CHARGE)
                .input(Items.FIRE_CHARGE)
                .input(Items.DRAGON_BREATH)
                .criterion(hasItem(NetherAndEndItems.DRAGON_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.COMBAT, NetherAndEndItems.SHULKER_FALCHION)
                .input('#', NetherAndEndItems.SHULKER_PEARL)
                .input('E', NetherAndEndItems.HARDENED_SHULKER_PEARL)
                .input('S', Items.SHULKER_SHELL)
                .input('N', Items.ENDER_PEARL)
                .input('/', Items.STICK)
                .pattern(" #E")
                .pattern("SN#")
                .pattern("/S ")
                .criterion(hasItem(NetherAndEndItems.SHULKER_FALCHION), conditionsFromItem(NetherAndEndItems.SHULKER_PEARL))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.MISC, NetherAndEndItems.WARPED_WART, 9)
                .input(Blocks.WARPED_WART_BLOCK)
                .criterion(hasItem(NetherAndEndItems.WARPED_WART), conditionsFromItem(Blocks.WARPED_WART_BLOCK))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.MISC, NetherAndEndItems.WARPED_STEW)
                .input(Items.WARPED_FUNGUS)
                .input(NetherAndEndItems.WARPED_WART)
                .input(Items.BOWL)
                .criterion(hasItem(NetherAndEndItems.WARPED_STEW), conditionsFromItem(Blocks.WARPED_FUNGUS))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.MISC, NetherAndEndItems.HOGLIN_BUNDLE).input(NetherAndEndItems.HOGLIN_SKIN)
                .input(Items.STRING).criterion(hasItem(NetherAndEndItems.HOGLIN_BUNDLE), conditionsFromItem(NetherAndEndItems.HOGLIN_SKIN))
                .offerTo(exporter);
    }

    public static class Provider extends RecipeProvider {
        public Provider(DataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(dataOutput, completableFuture);
        }

        @Override
        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
            return new NetherAndEndRecipeGenerator(registries, exporter);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
