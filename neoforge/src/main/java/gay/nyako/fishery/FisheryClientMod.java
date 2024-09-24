package gay.nyako.fishery;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class FisheryClientMod {
    public FisheryClientMod(ModContainer container)
    {
        var eventBus = container.getEventBus();
        eventBus.addListener(this::buildContents);

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(FisheryItems.WOODEN_CRATE);
            event.accept(FisheryItems.IRON_CRATE);
            event.accept(FisheryItems.GOLDEN_CRATE);
            event.accept(FisheryItems.DIAMOND_CRATE);
            event.accept(FisheryItems.NETHERITE_CRATE);
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(FisheryItems.SPECULAR_FISH);
            event.accept(FisheryItems.HEARTFISH);
            event.accept(FisheryItems.BLUE_COD);
            event.accept(FisheryItems.BLUE_COOKED_COD);
            event.accept(FisheryItems.COALFISH);
            event.accept(FisheryItems.OBSIDIFIN);
            event.accept(FisheryItems.SNAPPER);
            event.accept(FisheryItems.COOKED_SNAPPER);
        }
    }
}
