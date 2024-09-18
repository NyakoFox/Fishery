package gay.nyako.fishery;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class FisheryItems {
    public static final Item SPECULAR_FISH = register(Utils.id("specular_fish"), new Item(new Item.Properties().food(Foods.TROPICAL_FISH)));
    public static final Item HEARTFISH = register(Utils.id("heartfish"), new HeartFishItem(new Item.Properties()));
    public static final Item BLUE_COD = register(Utils.id("blue_cod"), new Item(new Item.Properties().food(Foods.COD)));
    public static final Item BLUE_COOKED_COD = register(Utils.id("blue_cooked_cod"), new Item(new Item.Properties().food(Foods.COOKED_COD)));
    public static final Item COALFISH = register(Utils.id("coalfish"), new Item(new Item.Properties().food(Foods.TROPICAL_FISH)));
    public static final Item OBSIDIFIN = register(Utils.id("obsidifin"), new Item(new Item.Properties().food(FisheryFoods.OBSIDIFIN)));

    public static final Item RECALL_POTION = register(Utils.id("recall_potion"), new RecallPotionItem(new Item.Properties()));

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
