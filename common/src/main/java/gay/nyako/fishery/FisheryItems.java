package gay.nyako.fishery;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class FisheryItems {
    public static final Item SPECULAR_FISH = register(Utils.id("specular_fish"), new Item(new Item.Properties()));
    public static final Item WOODEN_CRATE = register(Utils.id("wooden_crate"), new FishingCrateBlockItem(FisheryBlocks.WOODEN_CRATE, new Item.Properties().stacksTo(16), FisheryLoot.WOODEN_CRATE_LOOT_TABLE));
    public static final Item IRON_CRATE = register(Utils.id("iron_crate"), new FishingCrateBlockItem(FisheryBlocks.IRON_CRATE, new Item.Properties().stacksTo(16), FisheryLoot.IRON_CRATE_LOOT_TABLE));
    public static final Item GOLDEN_CRATE = register(Utils.id("golden_crate"), new FishingCrateBlockItem(FisheryBlocks.GOLDEN_CRATE, new Item.Properties().stacksTo(16), FisheryLoot.GOLDEN_CRATE_LOOT_TABLE));
    public static final Item DIAMOND_CRATE = register(Utils.id("diamond_crate"), new FishingCrateBlockItem(FisheryBlocks.DIAMOND_CRATE, new Item.Properties().stacksTo(16), FisheryLoot.DIAMOND_CRATE_LOOT_TABLE));
    public static final Item NETHERITE_CRATE = register(Utils.id("netherite_crate"), new FishingCrateBlockItem(FisheryBlocks.NETHERITE_CRATE, new Item.Properties().stacksTo(16), FisheryLoot.NETHERITE_CRATE_LOOT_TABLE));

    public static Item register(ResourceLocation id, Item item)
    {
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void register() {
        // Do nothing
    }
}
