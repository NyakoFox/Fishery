package gay.nyako.fishery;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;

public class FisheryMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommonClass.init();

        // Call registry functions here
        FisheryBlocks.register();

        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, Config.CONFIG);
    }
}
