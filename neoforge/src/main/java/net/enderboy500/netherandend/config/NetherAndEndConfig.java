package net.enderboy500.netherandend.config;


import net.enderboy500.netherandend.util.enums.IconDesigns;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class NetherAndEndConfig {
    static Pair<NetherAndEndConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(NetherAndEndConfig::new);
    public static final NetherAndEndConfig CONFIG = pair.getLeft();
    public static final ModConfigSpec SPEC = pair.getRight();

    public NetherAndEndConfig(ModConfigSpec.Builder builder) {
        builder.defineEnum("iconDesign", IconDesigns.NONE);
    }
}
