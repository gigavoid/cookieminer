package com.gigavoid.supermod.jaadu.block;

import com.gigavoid.supermod.common.Register;

public class JaaduBlocks {
    public static BlockPortalJaadu jaaduPortal;

    public static void initializeBlocks(Register register){
        jaaduPortal = new BlockPortalJaadu();
    }

    public static void registerBlocks(Register register){
        register.registerBlock(jaaduPortal, "jaadu_portal");
    }
}
