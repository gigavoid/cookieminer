package com.gigavoid.supermod.bettertools.worldgen;

import com.gigavoid.supermod.common.Register;

/**
 * Created by Lukas on 2015-02-18.
 */
public class BetterToolsWorldGens {
    public static void initializeWorldGens(Register register){
        register.registerWorldGenerator(new BetterToolsWorldGenOre(), 13);
    }
}
