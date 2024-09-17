package gay.nyako.fishery;

import net.fabricmc.api.ModInitializer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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

        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, Config.CONFIG);

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (BuiltInLootTables.FISHING.location().equals(key.location())) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.add(LootItem.lootTableItem(FisheryItems.SPECULAR_FISH).setWeight(1)));
            }

            if (BuiltInLootTables.FISHING_TREASURE.location().equals(key.location())) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.add(NestedLootTable.lootTableReference(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.CRATE_LOOT_TABLE))));
            }
        });
    }
}
