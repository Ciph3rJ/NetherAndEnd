package net.enderboy500.netherandend;

import net.enderboy500.netherandend.compat.NEFDRFCompat;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.options.NetherAndEndOptions;
import net.enderboy500.netherandend.resource.NetherAndEndResourceConditions;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.util.dispenser.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.util.dispenser.WitheredBoneMealDispenseBehavior;
import net.enderboy500.netherandend.world.FabricBiomeModifications;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;

public class NetherAndEndFabric implements ModInitializer {
    public static final GameRule<Boolean> DISABLE_ELYTRA = GameRules.registerBoolean("disable_elytras", GameRuleCategory.PLAYER, false);

    public static final Identifier EAT_WARPED_CAKE_SLICE = makeCustomStat("eat_warped_cake_slice", StatFormatter.DEFAULT);

    public static final SimpleParticleType PERDANUS = ParticleTypes.register("perdurans", false);
    public static final SimpleParticleType STERBEN = ParticleTypes.register("sterben", false);
    public static final SimpleParticleType INVERTED_EYE = ParticleTypes.register("inverted_eye", false);

    @Override
    public void onInitialize() {
        Constants.LOG.info("Initializing Nether & End");

        NetherAndEndCommon.options = new NetherAndEndOptions(Minecraft.getInstance().gameDirectory);
        NetherAndEndCommon.options.load();

        BlockEntityTypes.SHELF.addValidBlock(NetherAndEndBlocks.CHORUS_SHELF.block().get());

        NetherAndEndCommon.init();

        NetherAndEndResourceConditions.load();
        FabricBiomeModifications.loadBiomeModifications();

        FabricBlocks.loadBlocks();
        FabricPotions.loadPotions();
        FabricMobEffects.loadMobEffects();
        FabricCreativeModeTab.loadCreativeModeTab();
        FabricCreativeModeTabModifier.loadCreativeModeTabModifier();

        if (Services.PLATFORM.isModLoaded("farmersdelight")) NEFDRFCompat.loadNEFDRFCompat();

        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("glowing_ores"), container,
                Component.translatable("resourcePack.netherandend.glowing_ores.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("ore_borders"), container,
                Component.translatable("resourcePack.netherandend.ore_borders.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("glowing_ore_borders"), container,
                Component.translatable("resourcePack.netherandend.glowing_ore_borders.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("alternate_cracked_bedrock"), container,
                Component.translatable("resourcePack.netherandend.alternate_cracked_bedrock.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("bare_bones"), container,
                Component.translatable("resourcePack.netherandend.bare_bones.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("bare_bones_glowing_ores"), container,
                Component.translatable("resourcePack.netherandend.bare_bones_glowing_ores.name"), PackActivationType.NORMAL));
        FabricLoader.getInstance().getModContainer(Constants.MOD_ID).ifPresent(container -> ResourceLoader.registerBuiltinPack(Constants.id("legacy_chorus_blocks"), container,
                Component.translatable("resourcePack.netherandend.legacy_chorus_blocks.name"), PackActivationType.NORMAL));

        DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE.get());
        DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL.get(), new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL.get()));
        DispenserBlock.registerBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get(), new WitheredBoneMealDispenseBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get()));

        Constants.LOG.info("Finished Initializing Nether & End");
    }

    private static Identifier makeCustomStat(String id, StatFormatter formatter) {
        Identifier location = Constants.id(id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, location);
        Stats.CUSTOM.get(location, formatter);
        return location;
    }
}
