package com.gigavoid.supermod.northrend.entity;

import com.gigavoid.supermod.common.Register;
import com.gigavoid.supermod.northrend.entity.dragon.NorthEntityDragon;

public class NorthrendEntities {
    public static void registerEntities(Register register){
        register.registerEntity(NorthEntityDragon.class, "north_dragon", 0xDDDDFF, 0x5555FF);
    }
}
