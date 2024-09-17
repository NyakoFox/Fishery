package gay.nyako.fishery;

import gay.nyako.fishery.datagen.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Constants.MOD_ID)
public class FisheryDatagenHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new FisheryBlockStateModelGenerator(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new FisheryItemModelGenerator(output, existingFileHelper));

        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(FishingCrateLootTableGenerator::new, LootContextParamSets.FISHING),
                new LootTableProvider.SubProviderEntry(WoodenCrateLootTableGenerator::new, LootContextParamSets.BLOCK_USE),
                new LootTableProvider.SubProviderEntry(IronCrateLootTableGenerator::new, LootContextParamSets.BLOCK_USE),
                new LootTableProvider.SubProviderEntry(GoldenCrateLootTableGenerator::new, LootContextParamSets.BLOCK_USE),
                new LootTableProvider.SubProviderEntry(DiamondCrateLootTableGenerator::new, LootContextParamSets.BLOCK_USE),
                new LootTableProvider.SubProviderEntry(NetheriteCrateLootTableGenerator::new, LootContextParamSets.BLOCK_USE)
        ), lookupProvider));
    }
}
