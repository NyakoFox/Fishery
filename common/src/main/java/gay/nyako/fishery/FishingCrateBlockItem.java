package gay.nyako.fishery;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.rmi.registry.Registry;

public class FishingCrateBlockItem extends BlockItem {
    private final ResourceKey<LootTable> lootTable;

    public FishingCrateBlockItem(Block block, Properties properties, ResourceLocation lootTableID) {
        super(block, properties);
        lootTable = ResourceKey.create(Registries.LOOT_TABLE, lootTableID);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (world.isClientSide()) return InteractionResultHolder.pass(itemStack);

        LootParams.Builder builder = new LootParams.Builder((ServerLevel) world).withParameter(LootContextParams.TOOL, itemStack).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(user.getOnPos()));
        builder.withLuck(user.getLuck()).withParameter(LootContextParams.THIS_ENTITY, user);

        for (ItemStack itemStack2 : world.getServer().reloadableRegistries().getLootTable(this.lootTable).getRandomItems(builder.create(LootContextParamSets.FISHING)))
        {
            if (user.addItem(itemStack2)) {
                user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2f, ((user.getRandom().nextFloat() - user.getRandom().nextFloat()) * 0.7f + 1.0f) * 2.0f);
                continue;
            }
            ItemEntity itemEntity = user.drop(itemStack2, false);
            if (itemEntity == null) continue;
            itemEntity.setNoPickUpDelay();
            itemEntity.setTarget(user.getUUID());
        }

        itemStack.shrink(1);
        user.awardStat(Stats.ITEM_USED.get(this));
        user.setItemInHand(hand, itemStack);

        return InteractionResultHolder.success(itemStack);
    }
}
