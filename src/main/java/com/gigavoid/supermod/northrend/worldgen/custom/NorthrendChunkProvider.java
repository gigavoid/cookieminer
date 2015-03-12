package com.gigavoid.supermod.northrend.worldgen.custom;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenCaves;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenFortress;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenRavine;
import com.gigavoid.supermod.northrend.worldgen.gen.NorthrendMapGenVillage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;

public class NorthrendChunkProvider implements IChunkProvider {

    /** RNG. */
    private Random rand;
    private NoiseGeneratorOctaves field_147431_j;
    private NoiseGeneratorOctaves field_147432_k;
    private NoiseGeneratorOctaves field_147429_l;
    private NoiseGeneratorPerlin field_147430_m;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen5;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    /** Reference to the World object. */
    private World worldObj;
    /** are map structures going to be generated (e.g. strongholds) */
    private final boolean mapFeaturesEnabled;
    private net.minecraft.world.WorldType worldType;
    private final double[] field_147434_q;
    private final float[] parabolicField;
    private ChunkProviderSettings chunkProviderSettings;
    private Block oceanFiller;
    private double[] stoneNoise;
    private MapGenBase caveGenerator;
    /** Holds Stronghold Generator */
    private NorthrendMapGenFortress netherBridgeGenerator;
    /** Holds Village Generator */
    private NorthrendMapGenVillage villageGenerator;
    /** Holds Mineshaft Generator */
    private MapGenMineshaft mineshaftGenerator;
    private MapGenScatteredFeature scatteredFeatureGenerator;
    /** Holds ravine generator */
    private MapGenBase ravineGenerator;
    private StructureOceanMonument oceanTempleGenerator;
    /** The biomes that are used to generate the chunk */
    private BiomeGenBase[] biomesForGeneration;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        netherBridgeGenerator = (NorthrendMapGenFortress) TerrainGen.getModdedMapGen(netherBridgeGenerator, STRONGHOLD);
        villageGenerator = (NorthrendMapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);
        mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public NorthrendChunkProvider(World worldIn, long p_i45636_2_, boolean p_i45636_4_, String p_i45636_5_)
    {
        this.oceanFiller = Blocks.ice;
        this.stoneNoise = new double[256];
        this.caveGenerator = new NorthrendMapGenCaves();
        this.netherBridgeGenerator = new NorthrendMapGenFortress();
        this.villageGenerator = new NorthrendMapGenVillage();
        this.mineshaftGenerator = new MapGenMineshaft();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = new NorthrendMapGenRavine();
        this.oceanTempleGenerator = new StructureOceanMonument();
        this.worldObj = worldIn;
        this.mapFeaturesEnabled = p_i45636_4_;
        this.worldType = worldIn.getWorldInfo().getTerrainType();
        this.rand = new Random(p_i45636_2_);
        this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147434_q = new double[825];
        this.parabolicField = new float[25];

        for (int j = -2; j <= 2; ++j)
        {
            for (int k = -2; k <= 2; ++k)
            {
                float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }

        if (p_i45636_5_ != null)
        {
            this.chunkProviderSettings = ChunkProviderSettings.Factory.func_177865_a(p_i45636_5_).func_177864_b();
            this.oceanFiller = NorthrendBlocks.glacialIce;
        }

        NoiseGenerator[] noiseGens = {field_147431_j, field_147432_k, field_147429_l, field_147430_m, noiseGen5, noiseGen6, mobSpawnerNoise};
        noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, noiseGens);
        this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
        this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
        this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
        this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
    }

    public void func_180518_a(int p_180518_1_, int p_180518_2_, ChunkPrimer p_180518_3_)
    {
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_180518_1_ * 4 - 2, p_180518_2_ * 4 - 2, 10, 10);
        this.func_147423_a(p_180518_1_ * 4, 0, p_180518_2_ * 4);

        for (int k = 0; k < 4; ++k)
        {
            int l = k * 5;
            int i1 = (k + 1) * 5;

            for (int j1 = 0; j1 < 4; ++j1)
            {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for (int k2 = 0; k2 < 32; ++k2)
                {
                    double d0 = 0.125D;
                    double d1 = this.field_147434_q[k1 + k2];
                    double d2 = this.field_147434_q[l1 + k2];
                    double d3 = this.field_147434_q[i2 + k2];
                    double d4 = this.field_147434_q[j2 + k2];
                    double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;

                    for (int l2 = 0; l2 < 8; ++l2)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i3 = 0; i3 < 4; ++i3)
                        {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int j3 = 0; j3 < 4; ++j3)
                            {
                                if ((d15 += d16) > 0.0D)
                                {
                                    p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, NorthrendBlocks.northStone.getDefaultState());
                                }
                                else if (k2 * 8 + l2 < this.chunkProviderSettings.field_177841_q - 1)
                                {
                                        p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, this.oceanFiller.getDefaultState());
                                }
                                else if (k2 * 8 + l2 == this.chunkProviderSettings.field_177841_q - 1 && rand.nextFloat() < .1f)
                                {
                                    p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, this.oceanFiller.getDefaultState());
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void func_180517_a(int p_180517_1_, int p_180517_2_, ChunkPrimer p_180517_3_, BiomeGenBase[] p_180517_4_)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_180517_1_, p_180517_2_, p_180517_3_, this.worldObj);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, (double)(p_180517_1_ * 16), (double)(p_180517_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                BiomeGenBase biomegenbase = p_180517_4_[l + k * 16];
                biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_180517_3_, p_180517_1_ * 16 + k, p_180517_2_ * 16 + l, this.stoneNoise[l + k * 16]);
            }
        }
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int p_73154_1_, int p_73154_2_)
    {
        this.rand.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.func_180518_a(p_73154_1_, p_73154_2_, chunkprimer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        this.func_180517_a(p_73154_1_, p_73154_2_, chunkprimer, this.biomesForGeneration);

        if (this.chunkProviderSettings.field_177839_r)
        {
            this.caveGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177850_z)
        {
            this.ravineGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177829_w && this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177831_v && this.mapFeaturesEnabled)
        {
            this.villageGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177833_u && this.mapFeaturesEnabled)
        {
            this.netherBridgeGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177854_x && this.mapFeaturesEnabled)
        {
            this.scatteredFeatureGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        if (this.chunkProviderSettings.field_177852_y && this.mapFeaturesEnabled)
        {
            this.oceanTempleGenerator.func_175792_a(this, this.worldObj, p_73154_1_, p_73154_2_, chunkprimer);
        }

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, p_73154_1_, p_73154_2_);
        byte[] abyte = chunk.getBiomeArray();

        for (int k = 0; k < abyte.length; ++k)
        {
            abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_)
    {
        this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, (double)this.chunkProviderSettings.field_177808_e, (double)this.chunkProviderSettings.field_177803_f, (double)this.chunkProviderSettings.field_177804_g);
        float f = this.chunkProviderSettings.field_177811_a;
        float f1 = this.chunkProviderSettings.field_177809_b;
        this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, (double)(f / this.chunkProviderSettings.field_177825_h), (double)(f1 / this.chunkProviderSettings.field_177827_i), (double)(f / this.chunkProviderSettings.field_177821_j));
        this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, (double)f, (double)f1, (double)f);
        this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, (double)f, (double)f1, (double)f);
        int l = 0;
        int i1 = 0;

        for (int j1 = 0; j1 < 5; ++j1)
        {
            for (int k1 = 0; k1 < 5; ++k1)
            {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                byte b0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                        float f5 = this.chunkProviderSettings.field_177813_n + biomegenbase1.minHeight * this.chunkProviderSettings.field_177819_m;
                        float f6 = this.chunkProviderSettings.field_177843_p + biomegenbase1.maxHeight * this.chunkProviderSettings.field_177815_o;

                        if (this.worldType == net.minecraft.world.WorldType.AMPLIFIED && f5 > 0.0F)
                        {
                            f5 = 1.0F + f5 * 2.0F;
                            f6 = 1.0F + f6 * 4.0F;
                        }

                        float f7 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f5 + 2.0F);

                        if (biomegenbase1.minHeight > biomegenbase.minHeight)
                        {
                            f7 /= 2.0F;
                        }

                        f2 += f6 * f7;
                        f3 += f5 * f7;
                        f4 += f7;
                    }
                }

                f2 /= f4;
                f3 /= f4;
                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;
                double d7 = this.field_147426_g[i1] / 8000.0D;

                if (d7 < 0.0D)
                {
                    d7 = -d7 * 0.3D;
                }

                d7 = d7 * 3.0D - 2.0D;

                if (d7 < 0.0D)
                {
                    d7 /= 2.0D;

                    if (d7 < -1.0D)
                    {
                        d7 = -1.0D;
                    }

                    d7 /= 1.4D;
                    d7 /= 2.0D;
                }
                else
                {
                    if (d7 > 1.0D)
                    {
                        d7 = 1.0D;
                    }

                    d7 /= 8.0D;
                }

                ++i1;
                double d8 = (double)f3;
                double d9 = (double)f2;
                d8 += d7 * 0.2D;
                d8 = d8 * (double)this.chunkProviderSettings.field_177823_k / 8.0D;
                double d0 = (double)this.chunkProviderSettings.field_177823_k + d8 * 4.0D;

                for (int j2 = 0; j2 < 33; ++j2)
                {
                    double d1 = ((double)j2 - d0) * (double)this.chunkProviderSettings.field_177817_l * 128.0D / 256.0D / d9;

                    if (d1 < 0.0D)
                    {
                        d1 *= 4.0D;
                    }

                    double d2 = this.field_147428_e[l] / (double)this.chunkProviderSettings.field_177806_d;
                    double d3 = this.field_147425_f[l] / (double)this.chunkProviderSettings.field_177810_c;
                    double d4 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
                    double d5 = MathHelper.denormalizeClamp(d2, d3, d4) - d1;

                    if (j2 > 29)
                    {
                        double d6 = (double)((float)(j2 - 29) / 3.0F);
                        d5 = d5 * (1.0D - d6) + -10.0D * d6;
                    }

                    this.field_147434_q[l] = d5;
                    ++l;
                }
            }
        }
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int p_73149_1_, int p_73149_2_)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
    {
        BlockFalling.fallInstantly = true;
        int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BlockPos blockpos = new BlockPos(k, 0, l);
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)p_73153_2_ * i1 + (long)p_73153_3_ * j1 ^ this.worldObj.getSeed());
        boolean flag = false;
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(p_73153_2_, p_73153_3_);

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag));

        if (this.chunkProviderSettings.field_177829_w && this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_175794_a(this.worldObj, this.rand, chunkcoordintpair);
        }

        if (this.chunkProviderSettings.field_177831_v && this.mapFeaturesEnabled)
        {
            flag = this.villageGenerator.func_175794_a(this.worldObj, this.rand, chunkcoordintpair);
        }

        if (this.chunkProviderSettings.field_177833_u && this.mapFeaturesEnabled)
        {
            this.netherBridgeGenerator.func_175794_a(this.worldObj, this.rand, chunkcoordintpair);
        }

        if (this.chunkProviderSettings.field_177854_x && this.mapFeaturesEnabled)
        {
            this.scatteredFeatureGenerator.func_175794_a(this.worldObj, this.rand, chunkcoordintpair);
        }

        if (this.chunkProviderSettings.field_177852_y && this.mapFeaturesEnabled)
        {
            this.oceanTempleGenerator.func_175794_a(this.worldObj, this.rand, chunkcoordintpair);
        }

        int k1;
        int l1;
        int i2;

        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && this.chunkProviderSettings.field_177781_A && !flag && this.rand.nextInt(this.chunkProviderSettings.field_177782_B) == 0
                && TerrainGen.populate(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag, LAKE))
        {
            k1 = this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(256);
            i2 = this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Blocks.ice)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
        }

        if (TerrainGen.populate(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag, LAVA) && !flag && this.rand.nextInt(this.chunkProviderSettings.field_177777_D / 10) == 0 && this.chunkProviderSettings.field_177783_C)
        {
            k1 = this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            i2 = this.rand.nextInt(16) + 8;

            if (l1 < 63 || this.rand.nextInt(this.chunkProviderSettings.field_177777_D / 8) == 0)
            {
                (new WorldGenLakes(Blocks.obsidian)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
            }
        }

        if (this.chunkProviderSettings.field_177837_s)
        {
            boolean doGen = TerrainGen.populate(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag, DUNGEON);
            for (k1 = 0; doGen && k1 < this.chunkProviderSettings.field_177835_t; ++k1)
            {
                l1 = this.rand.nextInt(16) + 8;
                i2 = this.rand.nextInt(256);
                int j2 = this.rand.nextInt(16) + 8;
                (new WorldGenDungeons()).generate(this.worldObj, this.rand, blockpos.add(l1, i2, j2));
            }
        }

        biomegenbase.func_180624_a(this.worldObj, this.rand, new BlockPos(k, 0, l));
        if (TerrainGen.populate(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag, ANIMALS))
        {
            SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        }
        blockpos = blockpos.add(8, 0, 8);

        boolean doGen = TerrainGen.populate(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag, ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1)
        {
            for (l1 = 0; l1 < 16; ++l1)
            {
                BlockPos blockpos1 = this.worldObj.func_175725_q(blockpos.add(k1, 0, l1));
                BlockPos blockpos2 = blockpos1.offsetDown();

                if (this.worldObj.func_175675_v(blockpos2))
                {
                    this.worldObj.setBlockState(blockpos2, Blocks.ice.getDefaultState(), 2);
                }

                if (this.worldObj.func_175708_f(blockpos1, true))
                {
                    this.worldObj.setBlockState(blockpos1, Blocks.snow_layer.getDefaultState(), 2);
                }
            }
        }

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(p_73153_1_, worldObj, rand, p_73153_2_, p_73153_3_, flag));

        BlockFalling.fallInstantly = false;
    }

    public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_)
    {
        boolean flag = false;

        if (this.chunkProviderSettings.field_177852_y && this.mapFeaturesEnabled && p_177460_2_.getInhabitedTime() < 3600L)
        {
            flag |= this.oceanTempleGenerator.func_175794_a(this.worldObj, this.rand, new ChunkCoordIntPair(p_177460_3_, p_177460_4_));
        }

        return flag;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_)
    {
        return true;
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    public void saveExtraData() {}

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "RandomLevelSource";
    }

    public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_)
    {
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p_177458_2_);

        if (this.mapFeaturesEnabled)
        {
            if (p_177458_1_ == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.func_175798_a(p_177458_2_))
            {
                return this.scatteredFeatureGenerator.getScatteredFeatureSpawnList();
            }

            if (p_177458_1_ == EnumCreatureType.MONSTER && this.chunkProviderSettings.field_177852_y && this.oceanTempleGenerator.func_175796_a(this.worldObj, p_177458_2_))
            {
                return this.oceanTempleGenerator.func_175799_b();
            }
        }

        return biomegenbase.getSpawnableList(p_177458_1_);
    }

    public BlockPos func_180513_a(World worldIn, String p_180513_2_, BlockPos p_180513_3_)
    {
        return "Stronghold".equals(p_180513_2_) && this.netherBridgeGenerator != null ? this.netherBridgeGenerator.func_180706_b(worldIn, p_180513_3_) : null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void func_180514_a(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_)
    {
        if (this.chunkProviderSettings.field_177829_w && this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
        }

        if (this.chunkProviderSettings.field_177831_v && this.mapFeaturesEnabled)
        {
            this.villageGenerator.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
        }

        if (this.chunkProviderSettings.field_177833_u && this.mapFeaturesEnabled)
        {
            this.netherBridgeGenerator.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
        }

        if (this.chunkProviderSettings.field_177854_x && this.mapFeaturesEnabled)
        {
            this.scatteredFeatureGenerator.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
        }

        if (this.chunkProviderSettings.field_177852_y && this.mapFeaturesEnabled)
        {
            this.oceanTempleGenerator.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
        }
    }

    public Chunk func_177459_a(BlockPos p_177459_1_)
    {
        return this.provideChunk(p_177459_1_.getX() >> 4, p_177459_1_.getZ() >> 4);
    }
}
