package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.SuperMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNorthrend extends WorldProvider {

    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerNorthrend(getSeed(), WorldType.DEFAULT);
        this.dimensionId = SuperMod.northrendDimID;
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderNorthrend(worldObj, worldObj.getSeed(), true);
    }

    public String getDimensionName() {
        return "Northrend";
    }
}
