package com.gigavoid.supermod.ropeway.block;

import static com.gigavoid.supermod.common.Register.registerBlock;

public class RopewayBlocks {

    public static final BlockRopewayPylon pylon = new BlockRopewayPylon();
    public static final BlockRopewayEngine engine = new BlockRopewayEngine();

    public static void initializeBlocks() {
        registerBlock(pylon, "ropeway_pylon");
        registerBlock(engine, "ropeway_engine");
    }

}
