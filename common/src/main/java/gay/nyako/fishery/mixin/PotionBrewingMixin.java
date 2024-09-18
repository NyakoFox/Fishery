package gay.nyako.fishery.mixin;

import gay.nyako.fishery.FisheryItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PotionBrewing.class)
public class PotionBrewingMixin {
    @Inject(method = "mix", at = @At(value = "HEAD"), cancellable = true)
    private void mix(ItemStack ingredient, ItemStack input, CallbackInfoReturnable<ItemStack> cir) {
        Optional<Holder<Potion>> optional = (input.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)).potion();
        if (optional.isEmpty())
        {
            return;
        }

        Potion potion = optional.get().value();
        if (potion == Potions.AWKWARD.value() && ingredient.is(FisheryItems.SPECULAR_FISH)) {
            cir.setReturnValue(new ItemStack(FisheryItems.RECALL_POTION));
            cir.cancel();
        }
    }

    @Inject(method = "isIngredient", at = @At("RETURN"), cancellable = true)
    private void injected(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || stack.is(FisheryItems.SPECULAR_FISH));
    }

    @Inject(method = "hasMix", at = @At("HEAD"), cancellable = true)
    private void injected(ItemStack input, ItemStack ingredient, CallbackInfoReturnable<Boolean> cir) {
        Optional<Holder<Potion>> optional = (input.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)).potion();
        if (optional.isEmpty())
        {
            return;
        }

        if (ingredient.is(FisheryItems.SPECULAR_FISH) && optional.get().value() == Potions.AWKWARD.value()) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}