package net.enderboy500.netherandend.data.generator;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.FabricBlocks;
import net.enderboy500.netherandend.content.FabricPotions;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.enderboy500.netherandend.resource.BrewingRecipeResourceCondition;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.BrewingRecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class NetherAndEndRecipeGenerator extends FabricRecipeProvider {
    public NetherAndEndRecipeGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            private static ResourceKey<Recipe<?>> recipeKey(String path) {
                return ResourceKey.create(Registries.RECIPE, Constants.id(path));
            }

            @Override
            public void buildRecipes() {
                RecipeOutput brewingOutput = NetherAndEndRecipeGenerator.this.withConditions(output, new BrewingRecipeResourceCondition());


                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.block().get())
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().get()).pattern("#").pattern("#")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHISELED_CYAN_NETHER_BRICKS.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.block().get())
                        .define('#', Items.RED_NETHER_BRICK_SLAB).pattern("#").pattern("#")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHISELED_RED_NETHER_BRICKS.block().get()), has(Items.RED_NETHER_BRICK_SLAB)).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_BLOCK.block().get())
                        .define('#', Items.CHORUS_FRUIT).pattern("##").pattern("##")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_BLOCK.block().get()), has(Items.CHORUS_FRUIT)).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_BUTTON.block().get())
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("#")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_BUTTON.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_DOOR.block().get(), 3)
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("##").pattern("##").pattern("##")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_DOOR.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_FENCE.block().get(), 3)
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).define('/', Items.STICK)
                        .pattern("#/#").pattern("#/#").unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_FENCE.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get()))
                        .save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_FENCE_GATE.block().get())
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).define('/', Items.STICK)
                        .pattern("/#/").pattern("/#/").unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_FENCE_GATE.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get()))
                        .save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.CHORUS_PIE.get()).requires(Items.CHORUS_FRUIT).requires(Items.SUGAR).requires(ItemTags.EGGS)
                        .unlockedBy(getHasName(NetherAndEndItems.CHORUS_PIE.get()), has(Items.CHORUS_FRUIT)).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndBlocks.CHORUS_PLANKS.block().get(), 4).requires(NetherAndEndBlocks.CHORUS_BLOCK.block().get())
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_PLANKS.block().get()), has(NetherAndEndBlocks.CHORUS_BLOCK.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().get())
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("##")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_PRESSURE_PLATE.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_SHELF.block().get(), 6)
                        .define('#', NetherAndEndBlocks.CHORUS_BLOCK.block().get()).pattern("###").pattern("   ").pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_SHELF.block().get()), has(NetherAndEndBlocks.CHORUS_BLOCK.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_SLAB.block().get(), 6)
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_SLAB.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.CHORUS_SOUP.get()).requires(Items.CHORUS_FRUIT, 7).requires(Items.BOWL)
                        .unlockedBy(getHasName(NetherAndEndItems.CHORUS_SOUP.get()), has(Items.CHORUS_FRUIT)).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_STAIRS.block().get(), 4)
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_STAIRS.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CHORUS_TRAPDOOR.block().get(), 2)
                        .define('#', NetherAndEndBlocks.CHORUS_PLANKS.block().get()).pattern("###").pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CHORUS_TRAPDOOR.block().get()), has(NetherAndEndBlocks.CHORUS_PLANKS.block().get())).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.DRAGON_CHARGE.get()).requires(ItemTags.COALS).requires(Items.GUNPOWDER).requires(Items.DRAGON_BREATH)
                        .unlockedBy(getHasName(NetherAndEndItems.DRAGON_CHARGE.get()), has(Items.DRAGON_BREATH)).save(output);

                this.shaped(RecipeCategory.MISC, NetherAndEndItems.ENDER_FRUIT.get()).define('#', Items.CHORUS_FRUIT).define('E', Items.ENDER_PEARL)
                        .pattern(" # ").pattern("#E#").pattern(" # ").unlockedBy(getHasName(NetherAndEndItems.ENDER_FRUIT.get()), has(Items.CHORUS_FRUIT))
                        .save(output);

                this.shaped(RecipeCategory.COMBAT, NetherAndEndItems.SHULKER_FALCHION.get()).define('#', NetherAndEndItems.SHULKER_PEARL.get())
                        .define('/', Items.STICK).define('E', NetherAndEndItems.HARDENED_SHULKER_PEARL.get()).define('N', Items.ENDER_PEARL)
                        .define('S', Items.SHULKER_SHELL).pattern(" #E").pattern("SN#").pattern("/S ")
                        .unlockedBy(getHasName(NetherAndEndItems.SHULKER_FALCHION.get()), has(NetherAndEndItems.SHULKER_PEARL.get())).save(output);


                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.CRIMSON_PIE.get()).requires(Items.CRIMSON_FUNGUS).requires(Items.SUGAR).requires(ItemTags.EGGS)
                        .unlockedBy(getHasName(NetherAndEndItems.CRIMSON_PIE.get()), has(Items.CRIMSON_FUNGUS)).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.CRIMSON_STEW.get()).requires(Items.CRIMSON_FUNGUS).requires(Items.NETHER_WART)
                        .requires(Items.BOWL).unlockedBy(getHasName(NetherAndEndItems.CRIMSON_STEW.get()), has(Items.NETHER_WART)).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.block().get(), 3)
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()).define('/', Items.NETHER_BRICK)
                        .pattern("#/#").pattern("#/#").unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()))
                        .save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.block().get())
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()).define('/', Items.NETHER_BRICK)
                        .pattern("/#/").pattern("/#/").unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICK_FENCE_GATE.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()))
                        .save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().get(), 6)
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()).pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICK_SLAB.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.block().get(), 4)
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICK_STAIRS.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().get(), 6)
                        .define('#', NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()).pattern("###").pattern("###")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICK_WALL.block().get()), has(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get())
                        .define('W', NetherAndEndBlocks.WARPED_WART.block().get()).define('#', Items.NETHER_BRICK).pattern("#W").pattern("W#")
                        .unlockedBy(getHasName(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get()), has(NetherAndEndBlocks.WARPED_WART.block().get())).save(output);

                this.shaped(RecipeCategory.MISC, NetherAndEndItems.HOGLIN_BUNDLE.get()).define('#', Items.STRING).define('S', NetherAndEndItems.HOGLIN_SKIN.get())
                        .pattern("#").pattern("S").unlockedBy(getHasName(NetherAndEndItems.HOGLIN_BUNDLE.get()), has(NetherAndEndItems.HOGLIN_SKIN.get()))
                        .save(output);

                this.shapeless(RecipeCategory.MISC, Items.NETHER_WART, 9).requires(Items.NETHER_WART_BLOCK)
                        .unlockedBy(getHasName(Items.NETHER_WART), has(Items.NETHER_WART_BLOCK)).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.block().get(), 3)
                        .define('#', Items.RED_NETHER_BRICKS).define('/', Items.NETHER_BRICK)
                        .pattern("#/#").pattern("#/#").unlockedBy(getHasName(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE.block().get()), has(Items.RED_NETHER_BRICKS))
                        .save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.block().get())
                        .define('#', Items.RED_NETHER_BRICKS).define('/', Items.NETHER_BRICK)
                        .pattern("/#/").pattern("/#/").unlockedBy(getHasName(NetherAndEndBlocks.RED_NETHER_BRICK_FENCE_GATE.block().get()), has(Items.RED_NETHER_BRICKS))
                        .save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, FabricBlocks.WARPED_CAKE.block().get()).define('E', ItemTags.EGGS).define('F', Items.WARPED_FUNGUS)
                        .define('L', Items.LAVA_BUCKET).define('W', NetherAndEndBlocks.WARPED_WART.block().get()).pattern("LLL").pattern("WEW")
                        .pattern("FFF").unlockedBy(getHasName(FabricBlocks.WARPED_CAKE.block().get()), has(Items.WARPED_FUNGUS)).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.WARPED_STEW.get()).requires(Items.WARPED_FUNGUS).requires(NetherAndEndBlocks.WARPED_WART.block().get())
                        .requires(Items.BOWL).unlockedBy(getHasName(NetherAndEndItems.WARPED_STEW.get()), has(NetherAndEndBlocks.WARPED_WART.block().get())).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndBlocks.WARPED_WART.block().get(), 9).requires(Items.WARPED_WART_BLOCK)
                        .unlockedBy(getHasName(NetherAndEndBlocks.WARPED_WART.block().get()), has(Items.WARPED_WART_BLOCK)).save(output);

                this.shapeless(RecipeCategory.MISC, Items.WARPED_WART_BLOCK).requires(NetherAndEndBlocks.WARPED_WART.block().get(), 9)
                        .unlockedBy(getHasName(Items.WARPED_WART_BLOCK), has(NetherAndEndBlocks.WARPED_WART.block().get())).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get()).requires(NetherAndEndItems.WITHERED_BONE_MEAL.get(), 9)
                        .unlockedBy(getHasName(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get()), has(NetherAndEndItems.WITHERED_BONE_MEAL.get())).save(output);

                this.shapeless(RecipeCategory.MISC, NetherAndEndItems.WITHERED_BONE_MEAL.get(), 9).requires(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get())
                        .unlockedBy(getHasName(NetherAndEndItems.WITHERED_BONE_MEAL.get()), has(NetherAndEndBlocks.WITHERED_BONE_BLOCK.block().get())).save(output);

                this.shaped(RecipeCategory.BUILDING_BLOCKS, NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.block().get()).define('#', Items.NETHER_BRICKS).define('/', Items.NETHER_BRICK)
                        .pattern("/#/").pattern("/#/").unlockedBy(getHasName(NetherAndEndBlocks.NETHER_BRICK_FENCE_GATE.block().get()), has(Items.NETHER_BRICKS))
                        .save(output);

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), FabricPotions.AVERSION_POTION).save(brewingOutput, recipeKey("brewing/potion_aversion"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), FabricPotions.AVERSION_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_aversion"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), FabricPotions.AVERSION_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_aversion"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.AVERSION_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_aversion_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.AVERSION_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_aversion_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, Items.NETHER_WART, FabricPotions.MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/potion_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, Items.NETHER_WART, FabricPotions.MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, Items.NETHER_WART, FabricPotions.MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_malnourishment"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.MALNOURISHMENT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_malnourishment_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.MALNOURISHMENT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_malnourishment_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.MALNOURISHMENT_POTION, Items.REDSTONE, FabricPotions.LONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/potion_long_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.MALNOURISHMENT_POTION, Items.REDSTONE, FabricPotions.LONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.MALNOURISHMENT_POTION, Items.REDSTONE, FabricPotions.LONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_malnourishment"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.LONG_MALNOURISHMENT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_malnourishment_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.LONG_MALNOURISHMENT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_malnourishment_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.MALNOURISHMENT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/potion_strong_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.MALNOURISHMENT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_malnourishment"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.MALNOURISHMENT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_MALNOURISHMENT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_malnourishment"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.STRONG_MALNOURISHMENT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_malnourishment_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.STRONG_MALNOURISHMENT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_malnourishment_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, NetherAndEndBlocks.WARPED_WART.blockItem().get(), FabricPotions.SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/potion_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, NetherAndEndBlocks.WARPED_WART.blockItem().get(), FabricPotions.SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, NetherAndEndBlocks.WARPED_WART.blockItem().get(), FabricPotions.SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_sickness"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.SICKNESS_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_sickness_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.SICKNESS_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_sickness_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.SICKNESS_POTION, Items.REDSTONE, FabricPotions.LONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/potion_long_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.SICKNESS_POTION, Items.REDSTONE, FabricPotions.LONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.SICKNESS_POTION, Items.REDSTONE, FabricPotions.LONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_sickness"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.LONG_SICKNESS_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_sickness_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.LONG_SICKNESS_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_sickness_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.SICKNESS_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/potion_strong_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.SICKNESS_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_sickness"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.SICKNESS_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_SICKNESS_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_sickness"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.STRONG_SICKNESS_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_sickness_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.STRONG_SICKNESS_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_sickness_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, NetherAndEndItems.SHULKER_PEARL.get(), FabricPotions.BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/potion_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, NetherAndEndItems.SHULKER_PEARL.get(), FabricPotions.BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, NetherAndEndItems.SHULKER_PEARL.get(), FabricPotions.BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_buoyant"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.BUOYANT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_buoyant_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.BUOYANT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_buoyant_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.BUOYANT_POTION, Items.REDSTONE, FabricPotions.LONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/potion_long_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.BUOYANT_POTION, Items.REDSTONE, FabricPotions.LONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.BUOYANT_POTION, Items.REDSTONE, FabricPotions.LONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_buoyant"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.LONG_BUOYANT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_buoyant_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.LONG_BUOYANT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_buoyant_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.BUOYANT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/potion_strong_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.BUOYANT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_buoyant"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.BUOYANT_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_BUOYANT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_buoyant"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.STRONG_BUOYANT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_buoyant_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.STRONG_BUOYANT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_buoyant_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, Items.WITHER_ROSE, FabricPotions.DECAY_POTION).save(brewingOutput, recipeKey("brewing/potion_decay"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, Items.WITHER_ROSE, FabricPotions.DECAY_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_decay"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, Items.WITHER_ROSE, FabricPotions.DECAY_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_decay"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.DECAY_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_decay_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.DECAY_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_decay_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.DECAY_POTION, Items.REDSTONE, FabricPotions.LONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/potion_long_decay"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.DECAY_POTION, Items.REDSTONE, FabricPotions.LONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_decay"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.DECAY_POTION, Items.REDSTONE, FabricPotions.LONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_decay"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.LONG_DECAY_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_long_decay_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.LONG_DECAY_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_long_decay_dragon_breath"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.DECAY_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/potion_strong_decay"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.DECAY_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_decay"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.DECAY_POTION, Items.GLOWSTONE_DUST, FabricPotions.STRONG_DECAY_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_decay"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.STRONG_DECAY_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_strong_decay_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.STRONG_DECAY_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_strong_decay_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/potion_instant_curing"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_curing"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_curing"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.LONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/potion_instant_curing_from_long"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.LONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_curing_from_long"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.LONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_curing_from_long"));
                BrewingRecipeBuilder.brewingMix(Items.POTION, FabricPotions.STRONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/potion_instant_curing_from_strong"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, FabricPotions.STRONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_curing_from_strong"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, FabricPotions.STRONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, FabricPotions.INSTANT_CURING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_curing_from_strong"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.INSTANT_CURING_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_curing_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.INSTANT_CURING_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_curing_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, NetherAndEndItems.ENDER_FRUIT.get(), FabricPotions.INSTANT_WARPING_POTION).save(brewingOutput, recipeKey("brewing/potion_instant_warping"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, NetherAndEndItems.ENDER_FRUIT.get(), FabricPotions.INSTANT_WARPING_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_warping"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, NetherAndEndItems.ENDER_FRUIT.get(), FabricPotions.INSTANT_WARPING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_warping"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.INSTANT_WARPING_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_instant_warping_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.INSTANT_WARPING_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_instant_warping_dragon_breath"));

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.AWKWARD, Items.ENDER_EYE, FabricPotions.ENDERSIGHT_POTION).save(brewingOutput, recipeKey("brewing/potion_endersight"));
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.AWKWARD, Items.ENDER_EYE, FabricPotions.ENDERSIGHT_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_endersight"));
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.AWKWARD, Items.ENDER_EYE, FabricPotions.ENDERSIGHT_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_endersight"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, FabricPotions.ENDERSIGHT_POTION, Items.GUNPOWDER, Items.SPLASH_POTION).save(brewingOutput, recipeKey("brewing/splash_potion_endersight_gunpowder"));
                BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, FabricPotions.ENDERSIGHT_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(brewingOutput, recipeKey("brewing/lingering_potion_endersight_dragon_breath"));
            }
        };
    }
}
