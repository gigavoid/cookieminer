package com.gigavoid.supermod.northrend.worldgen.gen;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenRavine;


public class NorthrendMapGenRavine extends MapGenRavine
{
    protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop)
    {
        net.minecraft.world.biome.BiomeGenBase biome = worldObj.getBiomeGenForCoords(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        IBlockState state = data.getBlockState(x, y, z);
        IBlockState top = biome.topBlock;
        IBlockState filler = biome.fillerBlock;

        if (state.getBlock() == Blocks.stone || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock() || state.getBlock() == NorthrendBlocks.northStone || state.getBlock() == NorthrendBlocks.glacialIce)
        {
            if (y < 10)
            {
                data.setBlockState(x, y, z, Blocks.obsidian.getDefaultState());
            }
            else
            {
                data.setBlockState(x, y, z, Blocks.air.getDefaultState());

                if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock())
                {
                    data.setBlockState(x, y - 1, z, top.getBlock().getDefaultState());
                }
            }
        }
    }
}