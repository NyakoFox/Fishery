package gay.nyako.fishery.datagen;

import gay.nyako.fishery.Constants;
import gay.nyako.fishery.FisheryItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FisheryItemModelGenerator extends ItemModelProvider {
    public FisheryItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(FisheryItems.SPECULAR_FISH);
    }
}
