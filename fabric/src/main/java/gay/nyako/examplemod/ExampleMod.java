package gay.nyako.examplemod;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;

public class ExampleMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();

        // Call registry functions here

        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, Config.CONFIG);
    }
}
