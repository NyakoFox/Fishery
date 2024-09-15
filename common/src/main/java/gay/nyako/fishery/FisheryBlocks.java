package gay.nyako.fishery;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FisheryBlocks {
    public static final Block WOODEN_CRATE    = register(Utils.id("wooden_crate"),    new Block(Blocks.CHEST.properties()));
    public static final Block IRON_CRATE      = register(Utils.id("iron_crate"),      new Block(Blocks.IRON_BLOCK.properties()));
    public static final Block GOLDEN_CRATE    = register(Utils.id("golden_crate"),    new Block(Blocks.GOLD_BLOCK.properties()));
    public static final Block DIAMOND_CRATE   = register(Utils.id("diamond_crate"),   new Block(Blocks.DIAMOND_BLOCK.properties()));
    public static final Block NETHERITE_CRATE = register(Utils.id("netherite_crate"), new Block(Blocks.NETHERITE_BLOCK.properties()));

    public static Block register(ResourceLocation id, Block block)
    {
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void register() {
        // Do nothing
    }
}
