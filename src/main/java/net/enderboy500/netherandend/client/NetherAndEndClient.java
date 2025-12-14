package net.enderboy500.netherandend.client;

import net.enderboy500.netherandend.NetherAndEnd;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.hoglin.Hoglin;

public class NetherAndEndClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderClient.loadBlockRenderer();
        EntityRenderClient.loadEntityRenderer();

    }
}
