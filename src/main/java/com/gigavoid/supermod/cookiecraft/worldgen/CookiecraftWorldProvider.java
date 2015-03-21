package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class CookiecraftWorldProvider extends WorldProvider {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new CookiecraftWorldChunkManager(getSeed(), net.minecraft.world.WorldType.DEFAULT, "cookieverse");
        this.dimensionId = ModuleCookiecraft.dimensionId;
    }

    public IChunkProvider createChunkGenerator() {
        return new CookiecraftChunkProvider(worldObj, worldObj.getSeed(), true, "cookieverse");
    }

    public String getDimensionName() {
        return "Cookieverse";
    }

    @Override
    public String getInternalNameSuffix() {
        return "Cookieverse";
    }
}
