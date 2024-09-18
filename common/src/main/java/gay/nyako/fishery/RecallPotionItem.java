package gay.nyako.fishery;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.portal.DimensionTransition;

public class RecallPotionItem extends Item {
    public RecallPotionItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);

            player.awardStat(Stats.ITEM_USED.get(this));
            stack.consume(1, player);

            BlockPos blockPos = player.getRespawnPosition();
            float spawnAngle = player.getRespawnAngle();
            ServerLevel spawnWorld = world.getServer().getLevel(player.getRespawnDimension());

            if (blockPos == null)
            {
                blockPos = spawnWorld.getSharedSpawnPos();
                spawnAngle = spawnWorld.getSharedSpawnAngle();
            }

            DimensionTransition transition = player.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);

            if (transition != null)
            {
                ServerLevel newLevel = transition.newLevel();
                if (world.getServer().isLevelEnabled(newLevel)
                        && (newLevel.dimension() == world.dimension() || user.canChangeDimensions(world, newLevel))) {
                    user.changeDimension(transition);
                }
            }

            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }
        user.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 32;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
