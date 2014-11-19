package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.biome.SuperBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.Arrays;

public class MapGenVillageNorthrend extends MapGenVillage
{
    public MapGenVillageNorthrend() {
        villageSpawnBiomes = Arrays.asList(new BiomeGenBase[]{SuperBiomes.northPlains});
    }

    @Override
    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new MapGenVillageNorthrend.Start(this.worldObj, this.rand, p_75049_1_, p_75049_2_, 0);
    }
}
