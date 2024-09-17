package gay.nyako.fishery.datagen;

import gay.nyako.fishery.FisheryLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class DiamondCrateLootTableGenerator implements LootTableSubProvider {
    HolderLookup.Provider registries;
    public DiamondCrateLootTableGenerator(HolderLookup.Provider provider) {
        this.registries = provider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.DIAMOND_CRATE_LOOT_TABLE),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.COD).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.SALMON).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.BOW).setWeight(3).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.25f, 0.50f)))).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(30.0f)))
                                .add(LootItem.lootTableItem(Items.BOOK).setWeight(16).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(70.0f))))
                                .setRolls(ConstantValue.exactly(6))
                                .setBonusRolls(ConstantValue.exactly(2))
                        )
        );
    }
}
