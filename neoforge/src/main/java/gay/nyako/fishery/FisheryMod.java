package gay.nyako.fishery;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

@Mod(Constants.MOD_ID)
public class FisheryMod {
    public FisheryMod(ModContainer container) {
        IEventBus eventBus = container.getEventBus();
        CommonClass.init();
        eventBus.addListener(this::onRegister);
        NeoForge.EVENT_BUS.addListener(this::onLootTableLoad);
        container.registerConfig(ModConfig.Type.SERVER, Config.CONFIG);
    }

    private void onRegister(RegisterEvent event)
    {
        // Call registry functions here
        FisheryBlocks.register();
        FisheryItems.register();
    }

    private void onLootTableLoad(LootTableLoadEvent event)
    {
        if (event.getName().equals(BuiltInLootTables.FISHING.location()))
        {
            // Inject our custom fish
            injectLoot(event.getTable(), CommonClass.getFishingEntries());
        }
        if (event.getName().equals(BuiltInLootTables.FISHING_TREASURE.location()))
        {
            // Inject crates into the treasure pool
            injectLoot(event.getTable(), List.of(NestedLootTable.lootTableReference(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.CRATE_LOOT_TABLE))));
        }
    }

    private static void injectLoot(LootTable table, List<LootPoolEntryContainer.Builder<?>> newEntries)
    {
        var pool = table.getPool("main");
        if (pool != null) {
            ArrayList<LootPoolEntryContainer> entries = new ArrayList<>(pool.entries);
            for (var newEntry : newEntries)
            {
                entries.add(newEntry.build());
            }
            pool.entries = entries;
        }
    }
}
