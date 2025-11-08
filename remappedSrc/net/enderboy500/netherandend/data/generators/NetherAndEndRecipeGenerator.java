package net.enderboy500.netherandend.data.generators;

import net.enderboy500.netherandend.content.NetherAndEndBlockItems;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import java.util.concurrent.CompletableFuture;

public class NetherAndEndRecipeGenerator extends RecipeProvider {
    public NetherAndEndRecipeGenerator(HolderLookup.Provider registries, RecipeOutput exporter) {
        super(registries, exporter);
    }

    @Override
    public void buildRecipes() {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_BLOCK)
                .define('#', Items.CHORUS_FRUIT)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_BLOCK), has(Items.CHORUS_FRUIT))
                .save(output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_PLANKS, 4)
                .requires(NetherAndEndBlockItems.CHORUS_BLOCK)
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_PLANKS), has(NetherAndEndBlockItems.CHORUS_BLOCK))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_STAIRS, 4)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_STAIRS), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_SLAB, 6)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("###")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_SLAB), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_FENCE, 3)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .define('/', Items.STICK)
                .pattern("#/#")
                .pattern("#/#")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_FENCE), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_FENCE_GATE, 1)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .define('/', Items.STICK)
                .pattern("/#/")
                .pattern("/#/")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_FENCE_GATE), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_BUTTON)
                .requires(NetherAndEndBlockItems.CHORUS_PLANKS)
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_BUTTON), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("##")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_PRESSURE_PLATE), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_DOOR, 3)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_DOOR), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_TRAPDOOR, 2)
                .define('#', NetherAndEndBlockItems.CHORUS_PLANKS)
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_TRAPDOOR), has(NetherAndEndBlockItems.CHORUS_PLANKS))
                .save(output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlockItems.CHORUS_SHELF, 6)
                .define('#', NetherAndEndBlockItems.CHORUS_BLOCK)
                .pattern("###")
                .pattern("   ")
                .pattern("###")
                .unlockedBy(getHasName(NetherAndEndBlockItems.CHORUS_SHELF), has(NetherAndEndBlockItems.CHORUS_BLOCK))
                .save(output);

        this.shapeless(RecipeCategory.FOOD, NetherAndEndItems.CHORUS_PIE)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.SUGAR)
                .requires(Items.EGG)
                .unlockedBy(getHasName(NetherAndEndItems.CHORUS_PIE), has(Items.CHORUS_FRUIT))
                .save(output);
        this.shapeless(RecipeCategory.FOOD, NetherAndEndItems.CHORUS_SOUP)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(NetherAndEndItems.CHORUS_SOUP), has(Items.CHORUS_FRUIT))
                .save(output);
        this.shaped(RecipeCategory.FOOD, NetherAndEndItems.ENDER_FRUIT)
                .define('#', Items.CHORUS_FRUIT)
                .define('E', Items.ENDER_PEARL)
                .pattern(" # ")
                .pattern("#E#")
                .pattern(" # ")
                .unlockedBy(getHasName(NetherAndEndItems.ENDER_FRUIT), has(Items.ENDER_PEARL))
                .save(output);
        this.shapeless(RecipeCategory.FOOD, NetherAndEndItems.DRAGON_CHARGE)
                .requires(Items.FIRE_CHARGE)
                .requires(Items.DRAGON_BREATH)
                .unlockedBy(getHasName(NetherAndEndItems.DRAGON_CHARGE), has(Items.FIRE_CHARGE))
                .save(output);
        this.shaped(RecipeCategory.COMBAT, NetherAndEndItems.SHULKER_FALCHION)
                .define('#', NetherAndEndItems.SHULKER_PEARL)
                .define('E', NetherAndEndItems.HARDENED_SHULKER_PEARL)
                .define('S', Items.SHULKER_SHELL)
                .define('N', Items.ENDER_PEARL)
                .define('/', Items.STICK)
                .pattern(" #E")
                .pattern("SN#")
                .pattern("/S ")
                .unlockedBy(getHasName(NetherAndEndItems.SHULKER_FALCHION), has(NetherAndEndItems.SHULKER_PEARL))
                .save(output);

        this.shapeless(RecipeCategory.MISC, NetherAndEndItems.WARPED_WART, 9)
                .requires(Blocks.WARPED_WART_BLOCK)
                .unlockedBy(getHasName(NetherAndEndItems.WARPED_WART), has(Blocks.WARPED_WART_BLOCK))
                .save(output);
        this.shapeless(RecipeCategory.MISC, NetherAndEndItems.WARPED_STEW)
                .requires(Items.WARPED_FUNGUS)
                .requires(NetherAndEndItems.WARPED_WART)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(NetherAndEndItems.WARPED_STEW), has(Blocks.WARPED_FUNGUS))
                .save(output);
        this.shaped(RecipeCategory.FOOD, NetherAndEndBlockItems.WARPED_CAKE)
                .define('L', Items.LAVA_BUCKET)
                .define('W', NetherAndEndItems.WARPED_WART)
                .define('F', Items.WARPED_FUNGUS)
                .define('E', ItemTags.EGGS)
                .pattern("LLL")
                .pattern("WEW")
                .pattern("FFF")
                .unlockedBy(getHasName(NetherAndEndBlockItems.WARPED_CAKE), has(Items.WARPED_FUNGUS))
                .save(output);
        this.shapeless(RecipeCategory.MISC, NetherAndEndItems.HOGLIN_BUNDLE).requires(NetherAndEndItems.HOGLIN_SKIN)
                .requires(Items.STRING).unlockedBy(getHasName(NetherAndEndItems.HOGLIN_BUNDLE), has(NetherAndEndItems.HOGLIN_SKIN))
                .save(output);
    }

    public static class Provider extends Runner {
        public Provider(PackOutput dataOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(dataOutput, completableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
            return new NetherAndEndRecipeGenerator(registries, exporter);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
