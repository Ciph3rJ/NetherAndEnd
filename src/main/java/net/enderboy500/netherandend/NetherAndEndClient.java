package net.enderboy500.netherandend;

import net.enderboy500.netherandend.content.NetherAndEndEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = NetherAndEnd.MOD_ID, dist = Dist.CLIENT)
public class NetherAndEndClient {
    public NetherAndEndClient(ModContainer container) {

    }
}