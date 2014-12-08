package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.biome.SuperBiomes;
import com.google.common.collect.Lists;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldChunkManagerNorthrend extends WorldChunkManager {
    public static ArrayList<BiomeGenBase> allowedBiomes = Lists.newArrayList(
            (BiomeGenBase)SuperBiomes.northForest, (BiomeGenBase)SuperBiomes.northFirForest,
            (BiomeGenBase)SuperBiomes.northGlacier, (BiomeGenBase)SuperBiomes.northMountains,
            (BiomeGenBase)SuperBiomes.northPlains, (BiomeGenBase)SuperBiomes.northHighlands,
            (BiomeGenBase)SuperBiomes.northHugeMountains);
    private GenLayer genBiomes;
    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    private GenLayer biomeIndexLayer;
    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;
    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;
    private String field_180301_f;
    private static final String __OBFID = "CL_00000166";

    protected WorldChunkManagerNorthrend()
    {
        this.biomeCache = new BiomeCache(this);
        this.field_180301_f = "";
        this.biomesToSpawnIn = new ArrayList();
        this.biomesToSpawnIn.addAll(allowedBiomes);
    }

    public WorldChunkManagerNorthrend(long seed, WorldType type, String ngtStr)
    {
        this();
        this.field_180301_f = ngtStr;
        GenLayer[] agenlayer = NorthrendGenLayerBiome.func_180781_a(seed, SuperMod.northrend, ngtStr);
        agenlayer = getModdedBiomeGenerators(type, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerNorthrend(World p_i1976_1_)
    {
        this(p_i1976_1_.getSeed(), p_i1976_1_.getWorldInfo().getTerrainType(), p_i1976_1_.getWorldInfo().getGeneratorOptions());
    }

    @Override
    public float[] getRainfall(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_)
    {
        IntCache.resetIntCache();

        if (p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_)
        {
            p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
        }

        int[] aint = this.biomeIndexLayer.getInts(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);

        for (int i1 = 0; i1 < p_76936_4_ * p_76936_5_; ++i1)
        {
            try
            {
                float f = (float)BiomeGenBase.getBiomeFromBiomeList(aint[i1], BiomeGenBase.field_180279_ad).getIntRainfall() / 65536.0F;

                if (f > 1.0F)
                {
                    f = 1.0F;
                }

                p_76936_1_[i1] = f;
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("DownfallBlock");
                crashreportcategory.addCrashSection("biome id", Integer.valueOf(i1));
                crashreportcategory.addCrashSection("downfalls[] size", Integer.valueOf(p_76936_1_.length));
                crashreportcategory.addCrashSection("x", Integer.valueOf(p_76936_2_));
                crashreportcategory.addCrashSection("z", Integer.valueOf(p_76936_3_));
                crashreportcategory.addCrashSection("w", Integer.valueOf(p_76936_4_));
                crashreportcategory.addCrashSection("h", Integer.valueOf(p_76936_5_));
                throw new ReportedException(crashreport);
            }
        }

        return p_76936_1_;
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_)
    {
        IntCache.resetIntCache();

        if (p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_)
        {
            p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
        }

        if (p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 15) == 0 && (p_76931_3_ & 15) == 0)
        {
            BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(p_76931_2_, p_76931_3_);
            System.arraycopy(abiomegenbase1, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
            return p_76931_1_;
        }
        else
        {
            int[] aint = this.biomeIndexLayer.getInts(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);

            for (int i1 = 0; i1 < p_76931_4_ * p_76931_5_; ++i1)
            {
                p_76931_1_[i1] = BiomeGenBase.getBiomeFromBiomeList(aint[i1], BiomeGenBase.field_180279_ad);
            }

            return p_76931_1_;
        }
    }
}
