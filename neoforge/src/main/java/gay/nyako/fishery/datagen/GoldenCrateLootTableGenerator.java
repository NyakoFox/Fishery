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

public class GoldenCrateLootTableGenerator implements LootTableSubProvider {
    HolderLookup.Provider registries;
    public GoldenCrateLootTableGenerator(HolderLookup.Provider provider) {
        this.registries = provider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(ResourceKey.create(Registries.LOOT_TABLE, FisheryLoot.GOLDEN_CRATE_LOOT_TABLE),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.COD).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.SALMON).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 6.0f))))
                                .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .add(LootItem.lootTableItem(Items.BOW).setWeight(6).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.25f, 0.50f)))).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(30.0f)))
                                .add(LootItem.lootTableItem(Items.FISHING_ROD).setWeight(2).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.25f, 0.50f)))).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(30.0f)))
                                .add(LootItem.lootTableItem(Items.BOOK).setWeight(16).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, ConstantValue.exactly(50.0f))))
                                .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0f, 8.0f))))
                                .setRolls(ConstantValue.exactly(6))
                                .setBonusRolls(ConstantValue.exactly(2))
                        )
        );
    }
}
