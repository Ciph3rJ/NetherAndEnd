package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.NetherAndEnd;
import net.enderboy500.netherandend.projectiles.DragonChargeProjectileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class NetherAndEndEntities {
    public static final EntityType<DragonChargeProjectileEntity> DRAGON_CHARGE = register(
            "dragon_charge",
            EntityType.Builder.create(DragonChargeProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.3125F, 0.3125F)
                    .eyeHeight(0.0F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10));

    public static <T extends Entity> EntityType<T> register(String path, EntityType.Builder<T> entityTypeBuilder) {
        Identifier id = Identifier.of(NetherAndEnd.MOD_ID, path);
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);
        return Registry.register(Registries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }

    public static void loadEntities(){}
}
