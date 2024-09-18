package gay.nyako.fishery;

import net.minecraft.world.food.FoodConstants;
import net.minecraft.world.food.FoodProperties;

import java.util.List;
import java.util.Optional;

public class FisheryFoods {
    public static final FoodProperties OBSIDIFIN = new FoodProperties(2, FoodConstants.saturationByModifier(2, 0.1f), false, 4, Optional.empty(), List.of());
}
