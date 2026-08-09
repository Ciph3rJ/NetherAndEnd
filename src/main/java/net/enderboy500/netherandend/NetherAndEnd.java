package net.enderboy500.netherandend;

import net.enderboy500.netherandend.compat.NEFDCompat;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.enderboy500.netherandend.util.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.world.NetherAndEndBiomeModifications;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAndEnd implements ModInitializer {
	public static final String MOD_ID = "netherandend";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRule<Boolean> DISABLE_ELYTRA = GameRules.registerBoolean("disable_elytra", GameRuleCategory.PLAYER, false);

	@Override
	public void onInitialize() {

		// FIXED: Fix Warped Candle Cake Particle Position
		// DONE: New Withered Bone Meal -> Black Dye Recipe
		// FIXED: Fix cake eating when not hungry
		// FIXED: Cyan Nether Brick Fence Gate recipe output count from 3 -> 1
		// FIXED: Withered Bone -> Withered Bone Meal recipe now works
		// FIXED: Hoglin Bundle recipe is now shaped
		// FIXED: Fix Redstone Ores
		// FIXED: Fixed inconsistencies and mistakes in Crimson Pie and Chorus Pie Textures + Crimson Icon Texture
		// FIXED: The French Translation for the "Double Wart" Advancement Description to change "Warped" to the appropriate words "Biscornu" and "Tordu" for Standard and Canadian French respectively
		// FIXED: Chorus Shelf in specific states
		// DONE: Swiss French, Austrian German, and Swiss German
		// FIXED: Warped Wart Translation Failing
		// FIXED: Fixed Inconsistent Crumbling Basalt Texture Between Versions
		// FIXED: Warped Candle Cake not reducing durability for Flint & Steel and not destroying Fire Charge on lighting the candle

		LOGGER.info("Initializing Nether & End");

		NetherAndEndItems.loadItems();
		NetherAndEndCreativeModeTabs.loadItemGroups();
		NetherAndEndCreativeModeTabModifiers.loadCreativeModeTabModifiers();
		NetherAndEndPotions.loadPotions();

		NetherAndEndBlocks.loadBlocks();
		NetherAndEndBlockItems.loadBlockItems();

		BlockEntityType.SHELF.addSupportedBlock(NetherAndEndBlocks.CHORUS_SHELF);

		NetherAndEndEffects.loadEffects();
		NetherAndEndEntities.loadEntities();

		NetherAndEndUtils.loadUtils();

		if (FabricLoader.getInstance().isModLoaded("farmersdelight")) NEFDCompat.loadNEFDCompat();

		NetherAndEndBiomeModifications.loadBiomeModifications();

		FabricLoader.getInstance().getModContainer(NetherAndEnd.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "glowing_ores"), container,
				Component.translatable("resourcePack.netherandend.glowing_ores.name"), PackActivationType.NORMAL));
		FabricLoader.getInstance().getModContainer(NetherAndEnd.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "ore_borders"), container,
				Component.translatable("resourcePack.netherandend.ore_borders.name"), PackActivationType.NORMAL));
		FabricLoader.getInstance().getModContainer(NetherAndEnd.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "glowing_ore_borders"), container,
				Component.translatable("resourcePack.netherandend.glowing_ore_borders.name"), PackActivationType.NORMAL));
		FabricLoader.getInstance().getModContainer(NetherAndEnd.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Identifier.fromNamespaceAndPath(NetherAndEnd.MOD_ID, "alternate_cracked_bedrock"), container,
				Component.translatable("resourcePack.netherandend.alternate_cracked_bedrock.name"), PackActivationType.NORMAL));

		DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE);
		DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL, new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL));

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
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

			builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.ENDER_EYE), NetherAndEndPotions.ENDERSIGHT_POTION);
		});

		LOGGER.info("Finished Initializing Nether & End");
	}
}