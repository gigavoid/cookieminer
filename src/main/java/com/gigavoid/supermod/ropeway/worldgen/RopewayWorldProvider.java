package com.gigavoid.supermod.ropeway.worldgen;

import com.gigavoid.supermod.ropeway.ModuleRopeway;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class RopewayWorldProvider extends WorldProvider {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new RopewayWorldChunkManager(getSeed(), net.minecraft.world.WorldType.DEFAULT, "ropeway");
        this.dimensionId = ModuleRopeway.dimensionId;
    }

    public IChunkProvider createChunkGenerator() {
        return new RoewayChunkProvider(worldObj, worldObj.getSeed(), true, "ropeway");
    }

    public String getDimensionName() {
        return "Skylands";
    }

    @Override
    public String getInternalNameSuffix() {
        return "Skylands";
    }
}
