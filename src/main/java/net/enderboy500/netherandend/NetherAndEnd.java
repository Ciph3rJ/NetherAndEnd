package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.util.NetherAndEndUtils;
import net.enderboy500.netherandend.world.NetherAndEndBiomeModifications;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAndEnd implements ModInitializer {
	public static final String MOD_ID = "netherandend";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> DISABLE_ELYTRA = GameRuleRegistry.register("disableElytra",
			GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Nether & End");

		NetherAndEndItems.loadItems();
		NetherAndEndItemGroups.loadItemGroups();
		NetherAndEndPotions.loadPotions();

		NetherAndEndBlocks.loadBlocks();

		NetherAndEndEffects.loadEffects();
		NetherAndEndEntities.loadEntities();

		NetherAndEndUtils.loadUtils();

		NetherAndEndBiomeModifications.loadBiomeModifications();

		DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE);

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, NetherAndEndItems.HARDENED_SHULKER_PEARL, NetherAndEndPotions.AVERSION_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, Items.NETHER_WART, NetherAndEndPotions.MALNOURISHMENT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.MALNOURISHMENT_POTION, Items.REDSTONE, NetherAndEndPotions.LONG_MALNOURISHMENT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.MALNOURISHMENT_POTION, Items.GLOWSTONE_DUST, NetherAndEndPotions.STRONG_MALNOURISHMENT_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, NetherAndEndItems.WARPED_WART, NetherAndEndPotions.SICKNESS_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Items.REDSTONE, NetherAndEndPotions.LONG_SICKNESS_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Items.GLOWSTONE_DUST, NetherAndEndPotions.STRONG_SICKNESS_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, NetherAndEndItems.SHULKER_PEARL, NetherAndEndPotions.BUOYANT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.BUOYANT_POTION, Items.REDSTONE, NetherAndEndPotions.LONG_BUOYANT_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.BUOYANT_POTION, Items.GLOWSTONE_DUST, NetherAndEndPotions.STRONG_BUOYANT_POTION);

			builder.registerPotionRecipe(NetherAndEndPotions.SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NetherAndEndPotions.INSTANT_CURING_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.LONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NetherAndEndPotions.INSTANT_CURING_POTION);
			builder.registerPotionRecipe(NetherAndEndPotions.STRONG_SICKNESS_POTION, Items.FERMENTED_SPIDER_EYE, NetherAndEndPotions.INSTANT_CURING_POTION);

			builder.registerPotionRecipe(Potions.AWKWARD, NetherAndEndItems.ENDER_FRUIT, NetherAndEndPotions.INSTANT_WARPING_POTION);
		});

		LOGGER.info("Initializing Nether & End");
	}
}