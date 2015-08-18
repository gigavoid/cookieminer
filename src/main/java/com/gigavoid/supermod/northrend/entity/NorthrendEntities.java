package com.gigavoid.supermod.northrend.entity;

import com.gigavoid.supermod.common.Register;

public class NorthrendEntities {
    public static void registerEntities(Register register){
        register.registerEntity(EntityNorthrendDragon.class, "north_dragon", 0xDDDDFF, 0x5555FF);
        register.registerEntity(EntityIzrr.class, "izrr", 0x6DC2DE, 0x8D8ADE);
    }
}
