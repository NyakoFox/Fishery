package gay.nyako.examplemod;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static ModConfigSpec CONFIG;

    static {
        ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
        create(BUILDER);
        CONFIG = BUILDER.build();
    }

    public static ModConfigSpec.ConfigValue<Boolean> MOBS_REACT_TO_VANITY;

    private static void create(ModConfigSpec.Builder builder) {
        MOBS_REACT_TO_VANITY = builder
                .comment("Mobs will react to your vanity items.")
                .define("mobsReactToVanity", false);
    }
}
