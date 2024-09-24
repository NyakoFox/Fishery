package gay.nyako.fishery;

import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;

import java.util.List;

public class CommonClass {
    public static void init() {
        /*
        if (Services.PLATFORM.isModLoaded("fishery")) {

            Constants.LOG.info("Hello to fishery");
        }*/
    }

    public static List<LootPoolEntryContainer.Builder<?>> getFishingEntries() {
        return List.of(
                LootItem.lootTableItem(FisheryItems.SPECULAR_FISH).setWeight(2),
                LootItem.lootTableItem(FisheryItems.HEARTFISH).setWeight(2),
                LootItem.lootTableItem(FisheryItems.BLUE_COD).setWeight(2),
                LootItem.lootTableItem(FisheryItems.COALFISH).setWeight(8),
                LootItem.lootTableItem(FisheryItems.OBSIDIFIN).setWeight(1),
                LootItem.lootTableItem(FisheryItems.SNAPPER).setWeight(8)
        );
    }
}