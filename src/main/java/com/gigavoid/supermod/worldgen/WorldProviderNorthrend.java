package com.gigavoid.supermod.worldgen;

import com.gigavoid.supermod.biome.SuperBiomes;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNorthrend extends WorldProvider {

    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(SuperBiomes.northForest, 1f);
        this.dimensionId = 3;
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderNorthrend(worldObj, worldObj.getSeed(), true);
    }

    public String getDimensionName() {
        return "Northrend";
    }
}
