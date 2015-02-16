package com.gigavoid.supermod.ropeway.block;

import com.gigavoid.supermod.common.Register;

public class RopewayBlocks {

    public static final BlockRopewayPylon ropewayPylon = new BlockRopewayPylon();

    public static void initializeBlocks(Register register) {
        register.registerBlock(ropewayPylon, "pylon");
    }
}
