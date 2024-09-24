package gay.nyako.fishery;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.fml.config.ModConfig;

public class FisheryMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommonClass.init();

        // Call registry functions here
        FisheryBlocks.register();
        FisheryItems.register();

        registerItemGroups();

        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, Config.CONFIG);

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (BuiltInLootTables.FISHING.location().equals(key.location())) {
                tableBuilder.modifyPools(poolBuilder -> {
                    var entries = CommonClass.getFishingEntries();
                    for (var entry : entries)
                    {
                        poolBuilder.add(entry);
                    }
                });
            }

            if (BuiltInLootTables.FISHING_TREASURE.location().equals(key.location())) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.add(NestedLootTable.lootTableReference(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.CRATE_LOOT_TABLE))));
            }
        });
    }

    private void registerItemGroups()
    {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.accept(FisheryItems.WOODEN_CRATE);
                    itemGroup.accept(FisheryItems.IRON_CRATE);
                    itemGroup.accept(FisheryItems.GOLDEN_CRATE);
                    itemGroup.accept(FisheryItems.DIAMOND_CRATE);
                    itemGroup.accept(FisheryItems.NETHERITE_CRATE);
                });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((itemGroup) -> {
                    itemGroup.accept(FisheryItems.SPECULAR_FISH);
                    itemGroup.accept(FisheryItems.HEARTFISH);
                    itemGroup.accept(FisheryItems.BLUE_COD);
                    itemGroup.accept(FisheryItems.BLUE_COOKED_COD);
                    itemGroup.accept(FisheryItems.COALFISH);
                    itemGroup.accept(FisheryItems.OBSIDIFIN);
                    itemGroup.accept(FisheryItems.SNAPPER);
                    itemGroup.accept(FisheryItems.COOKED_SNAPPER);
                });
    }
}
