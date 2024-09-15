package gay.nyako.fishery.datagen;

import gay.nyako.fishery.Constants;
import gay.nyako.fishery.FisheryBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FisheryModelGenerator extends BlockStateProvider {
    public FisheryModelGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(FisheryBlocks.WOODEN_CRATE);
        simpleBlockWithItem(FisheryBlocks.IRON_CRATE);
        simpleBlockWithItem(FisheryBlocks.GOLDEN_CRATE);
        simpleBlockWithItem(FisheryBlocks.DIAMOND_CRATE);
        simpleBlockWithItem(FisheryBlocks.NETHERITE_CRATE);
    }

    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, this.cubeAll(block));
    }
}
