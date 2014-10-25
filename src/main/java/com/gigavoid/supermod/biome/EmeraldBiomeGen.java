package com.gigavoid.supermod.biome;

import com.gigavoid.supermod.block.SuperBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class EmeraldBiomeGen extends BiomeGenBase {
    public EmeraldBiomeGen(){
        super(40);

        setBiomeName("Emerald Forest");
        setHeight(new BiomeGenBase.Height(1.0f, 1.0f));
        topBlock = Block.getBlockById(2);
        fillerBlock = Block.getBlockById(3);
        temperature = 1.0f;
        rainfall = 0.6f;
    }
}
