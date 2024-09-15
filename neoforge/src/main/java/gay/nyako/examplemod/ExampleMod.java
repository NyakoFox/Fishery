package gay.nyako.examplemod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class ExampleMod {
    public ExampleMod(ModContainer container) {
        IEventBus eventBus = container.getEventBus();
        CommonClass.init();
        eventBus.addListener(this::onRegister);
        container.registerConfig(ModConfig.Type.SERVER, Config.CONFIG);
    }

    private void onRegister(RegisterEvent event)
    {
        // Call registry functions here
    }
}