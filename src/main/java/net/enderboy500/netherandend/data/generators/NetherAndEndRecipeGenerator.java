package net.enderboy500.netherandend.data.generators;

import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataOutput;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndRecipeGenerator extends RecipeGenerator {
    public NetherAndEndRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    @Override
    public void generate() {
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_BLOCK)
                .input('#', Items.CHORUS_FRUIT)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_BLOCK), conditionsFromItem(Items.CHORUS_FRUIT))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_PLANKS, 4)
                .input(NetherAndEndBlocks.CHORUS_BLOCK)
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_PLANKS), conditionsFromItem(NetherAndEndBlocks.CHORUS_BLOCK))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_STAIRS, 4)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_STAIRS), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_SLAB, 6)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_SLAB), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_FENCE, 3)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .input('/', Items.STICK)
                .pattern("#/#")
                .pattern("#/#")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_FENCE), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_FENCE_GATE, 1)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .input('/', Items.STICK)
                .pattern("/#/")
                .pattern("/#/")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_FENCE_GATE), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_BUTTON)
                .input(NetherAndEndBlocks.CHORUS_PLANKS)
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_BUTTON), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_PRESSURE_PLATE)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_DOOR, 3)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_DOOR), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_TRAPDOOR, 2)
                .input('#', NetherAndEndBlocks.CHORUS_PLANKS)
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(NetherAndEndBlocks.CHORUS_TRAPDOOR), conditionsFromItem(NetherAndEndBlocks.CHORUS_PLANKS))
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
        this.createShaped(RecipeCategory.FOOD, NetherAndEndBlockItems.WARPED_CAKE)
                .input('L', Items.LAVA_BUCKET)
                .input('W', NetherAndEndItems.WARPED_WART)
                .input('F', Items.WARPED_FUNGUS)
                .input('E', ItemTags.EGGS)
                .pattern("LLL")
                .pattern("WEW")
                .pattern("FFF")
                .criterion(hasItem(NetherAndEndBlockItems.WARPED_CAKE), conditionsFromItem(Items.WARPED_FUNGUS))
                .offerTo(exporter);
        this.createShapeless(RecipeCategory.MISC, NetherAndEndItems.HOGLIN_BUNDLE)
                .input(Items.STRING)
                .input(NetherAndEndItems.HOGLIN_SKIN)
                .criterion(hasItem(NetherAndEndItems.HOGLIN_BUNDLE), conditionsFromItem(NetherAndEndItems.HOGLIN_SKIN))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.NETHER_BRICK_FENCE_GATE).input('#', Items.NETHER_BRICKS)
                .input('/', Items.NETHER_BRICK).pattern("/#/").pattern("/#/")
                .criterion(hasItem(NetherAndEndBlockItems.NETHER_BRICK_FENCE_GATE), conditionsFromItem(Items.NETHER_BRICKS)).offerTo(exporter);
        offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS, Items.RED_NETHER_BRICK_SLAB);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE, 3).input('#', Items.RED_NETHER_BRICKS)
                .input('/', Items.NETHER_BRICK).pattern("#/#").pattern("#/#")
                .criterion(hasItem(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE), conditionsFromItem(Items.RED_NETHER_BRICKS)).offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE_GATE).input('#', Items.RED_NETHER_BRICKS)
                .input('/', Items.NETHER_BRICK).pattern("/#/").pattern("/#/")
                .criterion(hasItem(NetherAndEndBlockItems.RED_NETHER_BRICK_FENCE), conditionsFromItem(Items.RED_NETHER_BRICKS)).offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS).input('#', Items.NETHER_BRICK).input('W', NetherAndEndItems.WARPED_WART)
                .pattern("#W").pattern("W#").criterion(hasItem(NetherAndEndBlockItems.CYAN_NETHER_BRICKS), conditionsFromItem(NetherAndEndItems.WARPED_WART))
                .offerTo(exporter);
        offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS, 4).input('#', NetherAndEndBlockItems.CYAN_NETHER_BRICKS)
                .pattern("#  ").pattern("## ").pattern("###")
                .criterion(hasItem(NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS), conditionsFromItem(NetherAndEndBlockItems.CYAN_NETHER_BRICKS)).offerTo(exporter);
        offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE, 3).input('#', NetherAndEndBlockItems.CYAN_NETHER_BRICKS)
                .input('/', Items.NETHER_BRICK).pattern("#/#").pattern("#/#")
                .criterion(hasItem(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE), conditionsFromItem(NetherAndEndBlockItems.CYAN_NETHER_BRICKS)).offerTo(exporter);
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE_GATE).input('#', NetherAndEndBlockItems.CYAN_NETHER_BRICKS)
                .input('/', Items.NETHER_BRICK).pattern("/#/").pattern("/#/")
                .criterion(hasItem(NetherAndEndBlockItems.CYAN_NETHER_BRICK_FENCE), conditionsFromItem(NetherAndEndBlockItems.CYAN_NETHER_BRICKS)).offerTo(exporter);

        offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS, Items.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB, NetherAndEndBlockItems.CYAN_NETHER_BRICKS, 2);
        offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
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
