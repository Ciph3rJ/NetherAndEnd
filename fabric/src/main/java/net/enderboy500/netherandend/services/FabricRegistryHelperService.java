package net.enderboy500.netherandend.services;

import net.enderboy500.netherandend.services.type.RegistryHelperService;
import net.enderboy500.netherandend.services.util.HolderRegistryHandle;
import net.enderboy500.netherandend.services.util.RegistryHandle;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FabricRegistryHelperService implements RegistryHelperService {
    @Override
    public <T extends Item> RegistryHandle<T> registerItem(String id, Function<Item.Properties, T> item) {
        ResourceKey<Item> key = RegistryHelperService.itemKey(id);
        T registered = Registry.register(BuiltInRegistries.ITEM, key.identifier(), item.apply(new Item.Properties().setId(key)));
        return new RegistryHandle<T>() {
            @Override
            public Identifier id() {
                return key.identifier();
            }

            @Override
            public T get() {
                return registered;
            }
        };
    }

    @Override
    public <T extends Block> RegistryHandle<T> registerBlock(String id, Function<BlockBehaviour.Properties, T> block) {
        ResourceKey<Block> key = RegistryHelperService.blockKey(id);
        T registered = Registry.register(BuiltInRegistries.BLOCK, key.identifier(), block.apply(BlockBehaviour.Properties.of().setId(key)));
        return new RegistryHandle<T>() {
            @Override
            public Identifier id() {
                return key.identifier();
            }

            @Override
            public T get() {
                return registered;
            }
        };
    }

    @Override
    public <T extends BlockItem> RegistryHandle<T> registerBlockItem(String id, RegistryHandle<? extends Block> block, BiFunction<Block, Item.Properties, T> item) {
        return registerItem(id, properties -> item.apply(block.get(), properties.useBlockDescriptionPrefix()));
    }

    @Override
    public <T extends Entity> RegistryHandle<EntityType<T>> registerEntity(String id, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = RegistryHelperService.entityKey(id);
        EntityType<T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, key.identifier(), builder.build(key));
        return new RegistryHandle<EntityType<T>>() {
            @Override
            public Identifier id() {
                return key.identifier();
            }

            @Override
            public EntityType<T> get() {
                return registered;
            }
        };
    }
}
