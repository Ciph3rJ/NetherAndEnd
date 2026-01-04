package net.enderboy500.netherandend.data.generators;

import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndRecipeGenerator extends RecipeProvider {
    protected NetherAndEndRecipeGenerator(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    @Override
    public void buildRecipes() {
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_RED_NETHER_BRICKS, Items.RED_NETHER_BRICKS);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_STAIRS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_SLAB, NetherAndEndBlockItems.CYAN_NETHER_BRICKS, 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CYAN_NETHER_BRICK_WALL, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHISELED_CYAN_NETHER_BRICKS, NetherAndEndBlockItems.CYAN_NETHER_BRICKS);
    }

    public static class Provider extends Runner {
        public Provider(PackOutput dataOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(dataOutput, completableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new NetherAndEndRecipeGenerator(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
