package net.enderboy500.netherandend.services;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.services.type.RegistryHelperService;
import net.enderboy500.netherandend.services.util.HolderRegistryHandle;
import net.enderboy500.netherandend.services.util.RegistryHandle;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiFunction;
import java.util.function.Function;

public class NeoForgeRegistryHelperService implements RegistryHelperService {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);
    private static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(Constants.MOD_ID);

    @Override
    public <T extends Item> RegistryHandle<T> registerItem(String id, Function<Item.Properties, T> item) {
        DeferredItem<T> deferredItem = ITEMS.registerItem(id, item);
        return new RegistryHandle<T>() {
            @Override
            public Identifier id() {
                return Constants.id(id);
            }

            @Override
            public T get() {
                return deferredItem.get();
            }
        };
    }

    @Override
    public <T extends Block> RegistryHandle<T> registerBlock(String id, Function<BlockBehaviour.Properties, T> block) {
        DeferredBlock<T> deferredBlock = BLOCKS.registerBlock(id, block);
        return new RegistryHandle<T>() {
            @Override
            public Identifier id() {
                return Constants.id(id);
            }

            @Override
            public T get() {
                return deferredBlock.get();
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
        DeferredHolder<EntityType<?>, EntityType<T>> deferredEntityType = ENTITIES.register(id, () -> builder.build(key));
        return new RegistryHandle<EntityType<T>>() {
            @Override
            public Identifier id() {
                return key.identifier();
            }

            @Override
            public EntityType<T> get() {
                return deferredEntityType.get();
            }
        };
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        ENTITIES.register(eventBus);
    }
}
