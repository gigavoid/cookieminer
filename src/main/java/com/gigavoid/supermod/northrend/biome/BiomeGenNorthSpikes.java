package com.gigavoid.supermod.northrend.biome;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenIcePath;
import net.minecraft.world.gen.feature.WorldGenIceSpike;

import java.util.Random;

public class BiomeGenNorthSpikes extends NorthrendBiomeGenBase {
    private WorldGenIceSpike iceSpikeGen = new WorldGenIceSpike();
    private WorldGenIcePath icePathGen = new WorldGenIcePath(4);

    public BiomeGenNorthSpikes(int id){
        super(id);

        setBiomeName("Northrend Plains");
        setHeight(new Height(.1f, .05f));
        topBlock = Block.getBlockFromName("snow").getDefaultState();
        fillerBlock = Block.getBlockFromName("snow").getDefaultState();
    }

    public void func_180624_a(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
        int i;
        int j;
        int k;

        for (i = 0; i < 3; ++i)
        {
            j = p_180624_2_.nextInt(16) + 8;
            k = p_180624_2_.nextInt(16) + 8;
            this.iceSpikeGen.generate(worldIn, p_180624_2_, worldIn.getHorizon(p_180624_3_.add(j, 0, k)));
        }

        for (i = 0; i < 2; ++i)
        {
            j = p_180624_2_.nextInt(16) + 8;
            k = p_180624_2_.nextInt(16) + 8;
            this.icePathGen.generate(worldIn, p_180624_2_, worldIn.getHorizon(p_180624_3_.add(j, 0, k)));
        }

        super.func_180624_a(worldIn, p_180624_2_, p_180624_3_);
    }
}
