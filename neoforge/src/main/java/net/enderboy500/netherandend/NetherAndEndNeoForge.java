package net.enderboy500.netherandend;

import net.enderboy500.netherandend.config.NetherAndEndConfig;
import net.enderboy500.netherandend.content.*;
import net.enderboy500.netherandend.services.NeoForgeRegistryHelperService;
import net.enderboy500.netherandend.util.NeoForgeEvents;
import net.enderboy500.netherandend.util.dispenser.ShulkerPearlDispenseBehavior;
import net.enderboy500.netherandend.util.dispenser.WitheredBoneMealDispenseBehavior;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLConfig;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public class NetherAndEndNeoForge {
    public static ModContainer container;

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Constants.MOD_ID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PERDURANS = PARTICLE_TYPES.register("perdurans", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STERBEN = PARTICLE_TYPES.register("sterben", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> INVERTED_EYE = PARTICLE_TYPES.register("inverted_eye", () -> new SimpleParticleType(false));

    public NetherAndEndNeoForge(IEventBus eventBus, ModContainer container) {
        Constants.LOG.info("Initializing Nether & End");

        this.container = container;

        NetherAndEndCommon.init();

        NetherAndEndNeoForge.PARTICLE_TYPES.register(eventBus);

        NeoForgeRegistryHelperService.register(eventBus);

        NeoForgeBlocks.loadBlocks();
        NeoForgePotions.loadPotions(eventBus);
        NeoForgeMobEffects.loadEffects(eventBus);
        NeoForgeCreativeModeTab.loadCreativeModeTab(eventBus);

        eventBus.addListener(this::commonSetup);

        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyBuildingBlocksCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyNaturalBlockCreativeModeTab);
        eventBus.addListener(NeoForgeCreativeModeTabModifier::modifyIngredientsCreativeModeTab);
        eventBus.addListener(NeoForgeEvents::addBuiltInPacks);
        eventBus.addListener(NeoForgeEvents::onBlockEntityTypeAddBlocks);
        eventBus.addListener(this::registerParticles);

        container.registerConfig(ModConfig.Type.CLIENT, NetherAndEndConfig.SPEC);
        FMLConfig.updateConfig(FMLConfig.ConfigValue.DISABLE_CONFIG_WATCHER, true);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        Constants.LOG.info("Finished Initializing Nether & End");
    }

    @SubscribeEvent
    public void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(NetherAndEndNeoForge.INVERTED_EYE.get(), SpellParticle.Provider::new);
        event.registerSpriteSet(NetherAndEndNeoForge.PERDURANS.get(), SpellParticle.Provider::new);
        event.registerSpriteSet(NetherAndEndNeoForge.STERBEN.get(), SpellParticle.Provider::new);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerProjectileBehavior(NetherAndEndItems.DRAGON_CHARGE.get());
            DispenserBlock.registerBehavior(NetherAndEndItems.SHULKER_PEARL.get(), new ShulkerPearlDispenseBehavior(NetherAndEndItems.SHULKER_PEARL.get()));
            DispenserBlock.registerBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get(), new WitheredBoneMealDispenseBehavior(NetherAndEndItems.WITHERED_BONE_MEAL.get()));
        });
    }
}