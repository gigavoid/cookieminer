package com.gigavoid.supermod.entity;

import net.minecraft.entity.EntityList;

/**
 * Created by Rasmus on 2014-11-05.
 */
public class SuperEntities {
    public static void registerEntities(){
        EntityList.addMapping(EntityYeti.class, "entityYeti", 67, 0xFFFFFF, 0x666666);
    }
}
