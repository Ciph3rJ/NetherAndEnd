package net.enderboy500.netherandend.data;

import net.enderboy500.netherandend.Constants;
import net.enderboy500.netherandend.data.provider.NetherAndEndBlockTagProvider;
import net.enderboy500.netherandend.data.provider.NetherAndEndItemTagProvider;
import net.enderboy500.netherandend.data.provider.NetherAndEndModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class NetherAndEndDataGenerator {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getReloadableLookupProvider();
        boolean run = false;

        generator.addProvider(run, new NetherAndEndBlockTagProvider(packOutput, lookupProvider, Constants.MOD_ID));
        generator.addProvider(run, new NetherAndEndItemTagProvider(packOutput, lookupProvider, Constants.MOD_ID));
        generator.addProvider(run, new NetherAndEndModelProvider(packOutput));
    }
}
