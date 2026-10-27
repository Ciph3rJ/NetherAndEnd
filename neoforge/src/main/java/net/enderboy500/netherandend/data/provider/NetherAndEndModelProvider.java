package net.enderboy500.netherandend.data.provider;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.content.NetherAndEndBlocks;
import net.enderboy500.netherandend.content.NetherAndEndItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class NetherAndEndModelProvider extends ModelProvider {
    public NetherAndEndModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_COAL_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_IRON_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_COPPER_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_REDSTONE_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_EMERALD_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_LAPIS_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.NETHER_DIAMOND_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.CRACKED_BEDROCK.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.CRUMBLING_BASALT.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.CYAN_NETHER_BRICKS.block().get());

        blockModels.createTrivialCube(NetherAndEndBlocks.END_COAL_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_IRON_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_COPPER_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_GOLD_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_REDSTONE_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_LAPIS_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_EMERALD_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.END_DIAMOND_ORE.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.ENDER_PEARL_CLUSTER.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.CHORUS_BLOCK.block().get());
        blockModels.createTrivialCube(NetherAndEndBlocks.CHORUS_PLANKS.block().get());

        itemModels.generateFlatItem(NetherAndEndItems.SHULKER_PEARL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.HARDENED_SHULKER_PEARL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.CHORUS_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.CHORUS_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.ENDER_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.DRAGON_CHARGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.SHULKER_FALCHION.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateFlatItem(NetherAndEndBlocks.WARPED_WART.blockItem().get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.WARPED_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.CRIMSON_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.HOGLIN_SKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.RAW_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.SMOKED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.COOKED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.HARDENED_STRIDER_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.WITHERED_BONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(NetherAndEndItems.WITHERED_BONE_MEAL.get(), ModelTemplates.FLAT_ITEM);
    }
}
