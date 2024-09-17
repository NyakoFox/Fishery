package gay.nyako.fishery.datagen;

import gay.nyako.fishery.FisheryItems;
import gay.nyako.fishery.FisheryLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.function.BiConsumer;

public class FishingCrateLootTableGenerator implements LootTableSubProvider {
    public FishingCrateLootTableGenerator(HolderLookup.Provider provider) {

    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.CRATE_LOOT_TABLE),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(FisheryItems.WOODEN_CRATE).setWeight(12))
                                .add(LootItem.lootTableItem(FisheryItems.IRON_CRATE).setWeight(8))
                                .add(LootItem.lootTableItem(FisheryItems.GOLDEN_CRATE).setWeight(6))
                                .add(LootItem.lootTableItem(FisheryItems.DIAMOND_CRATE).setWeight(4))
                                .add(LootItem.lootTableItem(FisheryItems.NETHERITE_CRATE).setWeight(1))
                        )
        );
    }
}
