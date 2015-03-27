package com.gigavoid.supermod.northrend.worldgen.custom;

import com.gigavoid.supermod.northrend.ModuleNorthrend;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NorthrendWorldProvider extends WorldProvider {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new NorthrendWorldChunkManager(getSeed(), net.minecraft.world.WorldType.DEFAULT, "northrend");
        this.dimensionId = ModuleNorthrend.dimensionId;
    }

    public IChunkProvider createChunkGenerator() {
        return new NorthrendChunkProvider(worldObj, worldObj.getSeed(), true, "northrend");
    }

    public String getDimensionName() {
        return "Northrend";
    }

    @Override
    public void updateWeather() {
        worldObj.getWorldInfo().setRaining(true);
    }

    @Override
    public String getInternalNameSuffix() {
        return "Northrend";
    }
}
