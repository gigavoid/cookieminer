package com.gigavoid.supermod.cookiecraft.biome;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieBlock;
import com.gigavoid.supermod.cookiecraft.block.BlockCookieBurntCookieBlock;
import com.gigavoid.supermod.cookiecraft.block.CookiecraftBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class CookiecraftBiomeGenBase extends BiomeGenBase {
    int weight = 0;

    public CookiecraftBiomeGenBase(int p_i1971_1_, int weight)
    {
        super(p_i1971_1_, true);
        this.weight = weight;
        this.setEnableSnow();
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        temperature = 1.0f;
        rainfall = 0.0f;
        waterColorMultiplier = 0xFFFFFF;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public int getSkyColorByTemp(float p_76731_1_) {
        return 0x553112;
    }

    @Override
    public final void genTerrainBlocks(World worldIn, Random p_180628_2_, ChunkPrimer p_180628_3_, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        boolean flag = true;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + p_180628_2_.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;

        for (int k1 = 255; k1 >= 0; --k1)
        {
            if (k1 <= p_180628_2_.nextInt(5))
            {
                p_180628_3_.setBlockState(j1, k1, i1, BlockCookieBurntCookieBlock.instance.getDefaultState());
            }
            else
            {
                IBlockState iblockstate2 = p_180628_3_.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    k = -1;
                }
                else if (iblockstate2.getBlock() == BlockCookieBlock.instance)
                {
                    if (k == -1)
                    {
                        if (l <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = BlockCookieBlock.instance.getDefaultState();
                        }
                        else if (k1 >= 59 && k1 <= 64)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (k1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air))
                        {
                            iblockstate = Blocks.air.getDefaultState();
                        }

                        k = l;

                        if (k1 >= 62)
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate);
                        }
                        else if (k1 < 56 - l)
                        {
                            iblockstate = null;
                            iblockstate1 = BlockCookieBlock.instance.getDefaultState();
                        }
                        else
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
                        }
                    }
                    else if (k > 0){
                        --k;
                        p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
                    }
                }
            }
        }
    }
}
