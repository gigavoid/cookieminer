package com.gigavoid.supermod.northrend.event;

import com.gigavoid.supermod.northrend.ModuleNorthrend;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NorthrendEventHandler {

    int tickNum = 0;

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            tickNum++;
        }
    }
    @SubscribeEvent
    public void livingUpdateEvent(PlayerEvent.LivingUpdateEvent e) {
        if (tickNum % 200 == 0 && e.entity instanceof EntityPlayer && e.entity.dimension == ModuleNorthrend.dimensionId) {
             e.entity.attackEntityFrom(ModuleNorthrend.freeze, 2f);
        }
    }
}
