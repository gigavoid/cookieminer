package com.gigavoid.supermod.ropeway.block;

import com.gigavoid.supermod.common.Register;


public class RopewayBlocks {

    public static final BlockRopewayPylon pylon = new BlockRopewayPylon();
    public static final BlockRopewayEngine engine = new BlockRopewayEngine();
    public static final BlockRopewayPortal portalRopeway = new BlockRopewayPortal();

    public static void initializeBlocks(Register register) {
        register.registerBlock(pylon, "ropeway_pylon");
        register.registerBlock(engine, "ropeway_engine");
        register.registerBlock(portalRopeway, "ropeway_portal");
    }
}
