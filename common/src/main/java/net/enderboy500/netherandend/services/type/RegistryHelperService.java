package net.enderboy500.netherandend.services.type;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.services.util.BlockWithItemRegistryHandle;
import net.enderboy500.netherandend.services.util.HolderRegistryHandle;
import net.enderboy500.netherandend.services.util.RegistryHandle;
import net.minecraft.core.registries.Registries;
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

public interface RegistryHelperService {
    <T extends Item> RegistryHandle<T> registerItem(String id, Function<Item.Properties, T> item);

    <T extends Block> RegistryHandle<T> registerBlock(String id, Function<BlockBehaviour.Properties, T> block);
    <T extends BlockItem> RegistryHandle<T> registerBlockItem(String id, RegistryHandle<? extends Block> block, BiFunction<Block, Item.Properties, T> item);

    <T extends Entity> RegistryHandle<EntityType<T>> registerEntity(String id, EntityType.Builder<T> builder);

    default <T extends Block> BlockWithItemRegistryHandle<T> registerBlockWithItem(String id, Function<BlockBehaviour.Properties, T> block) {
        return registerBlockWithItem(id, block, BlockItem::new);
    }
    default <T extends Block> BlockWithItemRegistryHandle<T> registerBlockWithItem(String id, Function<BlockBehaviour.Properties, T> block, BiFunction<Block, Item.Properties, BlockItem> item) {
        RegistryHandle<T> blockHandle = registerBlock(id, block);
        RegistryHandle<BlockItem> itemHandle = registerBlockItem(id, blockHandle, item);
        return new BlockWithItemRegistryHandle<>(blockHandle, itemHandle);
    }

    static ResourceKey<Item> itemKey(String id) {
        return ResourceKey.create(Registries.ITEM, Constants.id(id));
    }

    static ResourceKey<Block> blockKey(String id) {
        return ResourceKey.create(Registries.BLOCK, Constants.id(id));
    }

    static ResourceKey<EntityType<?>> entityKey(String id) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Constants.id(id));
    }
}
