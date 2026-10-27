package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.content.FabricBlocks;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class NetherAndEndModelProvider extends FabricModelProvider {
    public NetherAndEndModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_COAL_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_IRON_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_COPPER_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_REDSTONE_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_EMERALD_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_LAPIS_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.NETHER_DIAMOND_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.CRACKED_BEDROCK.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.CRUMBLING_BASALT.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get());

        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_COAL_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_IRON_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_COPPER_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_GOLD_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_REDSTONE_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_LAPIS_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_EMERALD_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.END_DIAMOND_ORE.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.ENDER_PEARL_CLUSTER.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.CHORUS_BLOCK.block().get());
        blockModelGenerators.createTrivialCube(NetherAndEndBlocks.CHORUS_PLANKS.block().get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(NetherAndEndItems.SHULKER_PEARL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.CHORUS_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.CHORUS_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.ENDER_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.DRAGON_CHARGE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.SHULKER_FALCHION.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(NetherAndEndBlocks.WARPED_WART.blockItem().get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.WARPED_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.CRIMSON_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.CRIMSON_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.HOGLIN_SKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.RAW_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.SMOKED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.COOKED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.HARDENED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.WITHERED_BONE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(NetherAndEndItems.WITHERED_BONE_MEAL.get(), ModelTemplates.FLAT_ITEM);
    }
}
