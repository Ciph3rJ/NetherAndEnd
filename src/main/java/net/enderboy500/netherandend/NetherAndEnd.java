package net.enderboy500.netherandend;

import net.enderboy500.netherandend.compat.NEFDCompat;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.item.WitheredBoneMealItem;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.enderboy500.netherandend.util.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.world.NetherAndEndBiomeModifications;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAndEnd implements ModInitializer {
	public static final String MOD_ID = "netherandend";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Nether & End");

		NetherAndEndItems.loadItems();
		NetherAndEndCreativeModeTabs.loadItemGroups();
		NetherAndEndCreativeModeTabModifiers.loadCreativeModeTabModifiers();
		NetherAndEndPotions.loadPotions();

		NetherAndEndBlocks.loadBlocks();
		NetherAndEndBlockItems.loadBlockItems();

		BlockEntityType.SHELF.addValidBlock(NetherAndEndBlocks.CHORUS_SHELF);

		NetherAndEndEffects.loadEffects();
		NetherAndEndEntities.loadEntities();

		NetherAndEndUtils.loadUtils();

		if (FabricLoader.getInstance().isModLoaded("farmersdelight")) NEFDCompat.loadNEFDCompat();

		NetherAndEndBiomeModifications.loadBiomeModifications();

		DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE);
		DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL, new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL));

		DispenserBlock.registerBehavior(NetherAndEndItems.WITHERED_BONE_MEAL, (blockSource, itemStack) -> {
			Level level = blockSource.level();
			BlockPos pos = blockSource.pos();
			BlockState state = level.getBlockState(pos);

			WitheredBoneMealItem.checkAndWither(itemStack, level, pos, state);
			return itemStack;
		});

		FabricPotionBrewingBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.HARDENED_SHULKER_PEARL), NetherAndEndPotions.AVERSION_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.NETHER_WART), NetherAndEndPotions.MALNOURISHMENT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.MALNOURISHMENT_POTION, Ingredient.of(Items.REDSTONE), NetherAndEndPotions.LONG_MALNOURISHMENT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.MALNOURISHMENT_POTION, Ingredient.of(Items.GLOWSTONE_DUST), NetherAndEndPotions.STRONG_MALNOURISHMENT_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.WARPED_WART), NetherAndEndPotions.SICKNESS_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Ingredient.of(Items.REDSTONE), NetherAndEndPotions.LONG_SICKNESS_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Ingredient.of(Items.GLOWSTONE_DUST), NetherAndEndPotions.STRONG_SICKNESS_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.SHULKER_PEARL), NetherAndEndPotions.BUOYANT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.BUOYANT_POTION, Ingredient.of(Items.REDSTONE), NetherAndEndPotions.LONG_BUOYANT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.BUOYANT_POTION, Ingredient.of(Items.GLOWSTONE_DUST), NetherAndEndPotions.STRONG_BUOYANT_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.WITHER_ROSE), NetherAndEndPotions.DECAY_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.DECAY_POTION, Ingredient.of(Items.REDSTONE), NetherAndEndPotions.LONG_DECAY_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.DECAY_POTION, Ingredient.of(Items.GLOWSTONE_DUST), NetherAndEndPotions.STRONG_DECAY_POTION);

			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), NetherAndEndPotions.INSTANT_CURING_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.LONG_SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), NetherAndEndPotions.INSTANT_CURING_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.STRONG_SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), NetherAndEndPotions.INSTANT_CURING_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.ENDER_FRUIT), NetherAndEndPotions.INSTANT_WARPING_POTION);
		});

		/*
		* Bug Fixes:
		* Fixed all translations for: advancement.netherandend.why_was_this_so_hard.title
		* Adding the nether bricks to the mod's item group
		* Fixed all advancements
		* Fixed chilean, uruguayan, and mexican translations for potions
		* Fixed chilean, ecuadorian, mexican, uruguayan, and venezuelan translations for Chorus Pie
		* Fixed all french translations for Warped Stew, Warped Cake, and Slice of Warped Cake
		* Fixed all spanish translations for Warped Stew, Warped Cake, Slice of Warped Cake, and Chorus Soup
		* Removed the black pixel in hoglin skin
		* Fixed Instant Curing and Instant Warping
		* */

		LOGGER.info("Finished Initializing Nether & End");
	}
}