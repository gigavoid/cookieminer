package com.gigavoid.supermod.events;

import com.gigavoid.supermod.teleport.TeleporterNorthrend;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Rasmus on 2014-12-08.
 */
public class SuperWorldEvents {

    @SubscribeEvent
    public void gdyufgahuegbfh(WorldEvent.Load sgfgawr){
        WorldServer asduifhuiah = (WorldServer)sgfgawr.world;
        asduifhuiah.customTeleporters.add(new TeleporterNorthrend(asduifhuiah));
    }
}
