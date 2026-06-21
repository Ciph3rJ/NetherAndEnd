package net.enderboy500.netherandend;

import net.enderboy500.netherandend.compat.NEFDRFCompat;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.util.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.world.FabricBiomeModifications;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;

public class NetherAndEndFabric implements ModInitializer {
    public static final GameRule<Boolean> DISABLE_ELYTRA = GameRules.registerBoolean("disable_elytras", GameRuleCategory.PLAYER, false);

    @Override
    public void onInitialize() {
        Constants.LOG.info("Initializing Nether & End");

        NetherAndEndCommon.init();
        BlockEntityTypes.SHELF.addValidBlock(NetherAndEndBlocks.CHORUS_SHELF.block().get());

        FabricBlocks.loadBlocks();
        FabricPotions.loadPotions();
        FabricMobEffects.loadMobEffects();
        FabricCreativeModeTab.loadCreativeModeTab();
        FabricCreativeModeTabModifier.loadCreativeModeTabModifier();

        FabricBiomeModifications.loadBiomeModifications();

        if (Services.PLATFORM.isModLoaded("farmersdelight")) NEFDRFCompat.loadNEFDRFCompat();

        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("glowing_ores"), container,
                Component.translatable("resourcePack.netherandend.glowing_ores.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("ore_borders"), container,
                Component.translatable("resourcePack.netherandend.ore_borders.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("glowing_ore_borders"), container,
                Component.translatable("resourcePack.netherandend.glowing_ore_borders.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("alternate_cracked_bedrock"), container,
                Component.translatable("resourcePack.netherandend.alternate_cracked_bedrock.name"), PackActivationType.NORMAL));

        DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE.get());
        DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL.get(), new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL.get()));

        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.HARDENED_SHULKER_PEARL.get()), FabricPotions.AVERSION_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.NETHER_WART), FabricPotions.MALNOURISHMENT_POTION);
            builder.registerPotionRecipe(FabricPotions.MALNOURISHMENT_POTION, Ingredient.of(Items.REDSTONE), FabricPotions.LONG_MALNOURISHMENT_POTION);
            builder.registerPotionRecipe(FabricPotions.MALNOURISHMENT_POTION, Ingredient.of(Items.GLOWSTONE_DUST), FabricPotions.STRONG_MALNOURISHMENT_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndBlocks.WARPED_WART.blockItem().get()), FabricPotions.SICKNESS_POTION);
            builder.registerPotionRecipe(FabricPotions.SICKNESS_POTION, Ingredient.of(Items.REDSTONE), FabricPotions.LONG_SICKNESS_POTION);
            builder.registerPotionRecipe(FabricPotions.SICKNESS_POTION, Ingredient.of(Items.GLOWSTONE_DUST), FabricPotions.STRONG_SICKNESS_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.SHULKER_PEARL.get()), FabricPotions.BUOYANT_POTION);
            builder.registerPotionRecipe(FabricPotions.BUOYANT_POTION, Ingredient.of(Items.REDSTONE), FabricPotions.LONG_BUOYANT_POTION);
            builder.registerPotionRecipe(FabricPotions.BUOYANT_POTION, Ingredient.of(Items.GLOWSTONE_DUST), FabricPotions.STRONG_BUOYANT_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.WITHER_ROSE), FabricPotions.DECAY_POTION);
            builder.registerPotionRecipe(FabricPotions.DECAY_POTION, Ingredient.of(Items.REDSTONE), FabricPotions.LONG_DECAY_POTION);
            builder.registerPotionRecipe(FabricPotions.DECAY_POTION, Ingredient.of(Items.GLOWSTONE_DUST), FabricPotions.STRONG_DECAY_POTION);

            builder.registerPotionRecipe(FabricPotions.SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), FabricPotions.INSTANT_CURING_POTION);
            builder.registerPotionRecipe(FabricPotions.LONG_SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), FabricPotions.INSTANT_CURING_POTION);
            builder.registerPotionRecipe(FabricPotions.STRONG_SICKNESS_POTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), FabricPotions.INSTANT_CURING_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(NetherAndEndItems.ENDER_FRUIT.get()), FabricPotions.INSTANT_WARPING_POTION);

            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.ENDER_EYE), FabricPotions.ENDERSIGHT_POTION);
        });

        Constants.LOG.info("Finished Initializing Nether & End");
    }
}
