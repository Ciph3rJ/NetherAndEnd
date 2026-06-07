package net.enderboy500.netherandend.content;

import net.enderboy500.netherandend.projectile.DragonChargeProjectileEntity;
import net.enderboy500.netherandend.services.Services;
import net.enderboy500.netherandend.services.util.RegistryHandle;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class NetherAndEndEntities {
    public static final RegistryHandle<EntityType<DragonChargeProjectileEntity>> DRAGON_CHARGE = Services.REGISTRY.registerEntity(
            "dragon_charge",
            EntityType.Builder.of(DragonChargeProjectileEntity::new, MobCategory.MISC)
                    .sized(0.3125F, 0.3125F)
                    .eyeHeight(0.0F)
                    .clientTrackingRange(10));

    public static void loadEntities() {}
}
