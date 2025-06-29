package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.projectile.DragonChargeProjectileEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NetherAndEndEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.createEntities(NetherAndEnd.MOD_ID);

    public static ResourceKey<EntityType<?>> DRAGON_CHARGE_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("dragon_charge"));

    public static final Supplier<EntityType<DragonChargeProjectileEntity>> DRAGON_CHARGE = ENTITIES.register("dragon_charge", () -> EntityType.Builder.<DragonChargeProjectileEntity>of(
            DragonChargeProjectileEntity::new,
            MobCategory.MISC).sized(0.5f, 1.15f).build(DRAGON_CHARGE_KEY));

    public static void loadEntities(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
