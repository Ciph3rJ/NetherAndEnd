package net.enderboy500.netherandend.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.camel.CamelHusk;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.equine.ZombieHorse;
import net.minecraft.world.entity.animal.nautilus.Nautilus;
import net.minecraft.world.entity.animal.nautilus.ZombieNautilus;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.npc.villager.Villager;

public class SterbenEffect extends ParticleEffect {
    ParticleOptions particleOptions;

    public SterbenEffect(ParticleOptions particleOptions) {
        super(MobEffectCategory.NEUTRAL, 0xbe504d, particleOptions);
        this.particleOptions = particleOptions;
    }

    @Override
    public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
        return particleOptions;
    }

    public boolean shouldApplyEffectTickThisTick(int remainingDuration, int amplification) {
        return remainingDuration == 1;
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        if (mob instanceof AbstractPiglin piglin) {
            piglin.convertTo(EntityTypes.ZOMBIFIED_PIGLIN, ConversionParams.single(piglin, true, true), (zombified) -> zombified.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 0)));
        } else if (mob instanceof Hoglin hoglin) {
            hoglin.convertTo(EntityTypes.ZOGLIN, ConversionParams.single(hoglin, true, false), (zoglin) -> zoglin.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 0)));
        } else if (mob instanceof Villager villager) {
            convertVillagerToZombieVillager(level, villager);
        } else if (mob instanceof Horse horse) {
            convertHorseToZombieHorse(level, horse);
        } else if (mob instanceof Nautilus nautilus) {
            convertNautilusToZombieNautilus(level, nautilus);
        }

        return true;
    }

    public boolean convertVillagerToZombieVillager(ServerLevel level, Villager villager) {
        ZombieVillager zombieVillager = villager.convertTo(EntityTypes.ZOMBIE_VILLAGER, ConversionParams.single(villager, true, true), (zombie) -> {
            zombie.setVillagerDataFinalized(villager.getVillagerDataFinalized());
            zombie.finalizeSpawn(level, level.getCurrentDifficultyAt(zombie.blockPosition()), EntitySpawnReason.CONVERSION, new Zombie.ZombieGroupData(false, true));
            zombie.setVillagerData(villager.getVillagerData());
            zombie.setGossips(villager.getGossips().copy());
            zombie.setTradeOffers(villager.getOffers().copy());
            zombie.setVillagerXp(villager.getVillagerXp());
        });
        return zombieVillager != null;
    }

    public boolean convertHorseToZombieHorse(ServerLevel level, Horse horse) {
        ZombieHorse zombieHorse = horse.convertTo(EntityTypes.ZOMBIE_HORSE, ConversionParams.single(horse, true, true), (zombie) -> {
            zombie.setSpeed(horse.getSpeed());
            if (horse.hasCustomName()) zombie.setCustomName(horse.getCustomName());
            zombie.finalizeSpawn(level, level.getCurrentDifficultyAt(zombie.blockPosition()), EntitySpawnReason.CONVERSION, new AgeableMob.AgeableMobGroupData(false, 0));
            zombie.setAge(horse.getAge());
            if (horse.getOwner() != null) zombie.setOwner(horse.getOwner());
            if (horse.hasHome()) zombie.setHomeTo(horse.getHomePosition(), horse.getHomeRadius());
        });
        return zombieHorse != null;
    }

    public boolean convertNautilusToZombieNautilus(ServerLevel level, Nautilus nautilus) {
        ZombieNautilus zombieNautilus = nautilus.convertTo(EntityTypes.ZOMBIE_NAUTILUS, ConversionParams.single(nautilus, true, true), (zombie) -> {
            zombie.setSpeed(nautilus.getSpeed());
            if (nautilus.hasCustomName()) zombie.setCustomName(nautilus.getCustomName());
            zombie.finalizeSpawn(level, level.getCurrentDifficultyAt(zombie.blockPosition()), EntitySpawnReason.CONVERSION, new AgeableMob.AgeableMobGroupData(false, 0));
            zombie.setAge(nautilus.getAge());
            if (nautilus.getOwner() != null) zombie.setOwner(nautilus.getOwner());
            if (nautilus.hasHome()) zombie.setHomeTo(nautilus.getHomePosition(), nautilus.getHomeRadius());
        });
        return zombieNautilus != null;
    }

    public boolean convertCamelToZombieCamel(ServerLevel level, Camel camel) {
        CamelHusk camelHusk = camel.convertTo(EntityTypes.CAMEL_HUSK, ConversionParams.single(camel, true, true), (zombie) -> {
            zombie.setSpeed(camel.getSpeed());
            if (camel.hasCustomName()) zombie.setCustomName(camel.getCustomName());
            zombie.finalizeSpawn(level, level.getCurrentDifficultyAt(zombie.blockPosition()), EntitySpawnReason.CONVERSION, new AgeableMob.AgeableMobGroupData(false, 0));
            if (camel.getOwner() != null) zombie.setOwner(camel.getOwner());
            if (camel.hasHome()) zombie.setHomeTo(camel.getHomePosition(), camel.getHomeRadius());
        });
        return camelHusk != null;
    }
}
