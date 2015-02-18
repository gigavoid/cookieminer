package com.gigavoid.supermod.jaadu.worldgen.custom;

import com.gigavoid.supermod.jaadu.ModuleJaadu;

import com.gigavoid.supermod.jaadu.biome.JaaduBiomes;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProvider extends net.minecraft.world.WorldProvider {
        public void registerWorldChunkManager() {
            this.worldChunkMgr = new WorldChunkManagerHell(JaaduBiomes.jaaduSky, .0f);
            this.dimensionId = ModuleJaadu.dimensionId;
        }

        public IChunkProvider createChunkGenerator() {
            return new ChunkProvider(worldObj, worldObj.getSeed(), true, "jaadu");
        }

        @Override
        public String getDimensionName() {
        return "Jaadu";
        }

        @Override
        public String getInternalNameSuffix() {
        return "Jaadu";
        }
}
