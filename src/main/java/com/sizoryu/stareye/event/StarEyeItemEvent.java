package com.sizoryu.stareye.event;

import com.sizoryu.stareye.StarEye;
import com.sizoryu.stareye.item.StarEyeModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StarEye.MOD_ID)
public class StarEyeItemEvent {

    private static int ticks = 0;
    @SubscribeEvent
    public static void durabilityRegenEvent(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.CLIENT) return;

        if (++ticks >= 20 * 20) {
            ServerPlayer player = (ServerPlayer) event.player;
            Inventory playerInventory = player.getInventory();
            if (playerInventory.contains(StarEyeModItems.STAR_EYE.get().getDefaultInstance())) {
                for (int i = 0; i < playerInventory.getContainerSize(); i++) {
                    ItemStack stack = playerInventory.getItem(i);
                    stack.setDamageValue(Math.max(stack.getDamageValue() - 64, 0));
                }
            }
            ticks = 0;
        }
    }
}
