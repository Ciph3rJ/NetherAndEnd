package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.projectiles.DragonChargeProjectileEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class NetherAndEndEntities {
    public static final EntityType<DragonChargeProjectileEntity> DRAGON_CHARGE = register(
            "dragon_charge",
            EntityType.Builder.of(DragonChargeProjectileEntity::new, MobCategory.MISC)
                    .sized(0.3125F, 0.3125F)
                    .eyeHeight(0.0F)
                    .clientTrackingRange(4)
                    .updateInterval(10));

    public static <T extends Entity> EntityType<T> register(String path, EntityType.Builder<T> entityTypeBuilder) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(NetherAndEnd.MOD_ID, path);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }

    public static void loadEntities(){}
}
