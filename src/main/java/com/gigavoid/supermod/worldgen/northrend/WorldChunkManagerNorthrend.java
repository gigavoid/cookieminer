package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.biome.SuperBiomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldChunkManagerNorthrend extends WorldChunkManager {
    public static ArrayList<BiomeGenBase> allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(
            SuperBiomes.northForest, SuperBiomes.northFirForest, SuperBiomes.northGlacier, SuperBiomes.northMountains,
            SuperBiomes.northPlains, SuperBiomes.northHighlands, SuperBiomes.northHugeMountains));
    private GenLayer genBiomes;
    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    private GenLayer biomeIndexLayer;
    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;
    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;
    private static final String __OBFID = "CL_00000166";

    protected WorldChunkManagerNorthrend()
    {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
        this.biomesToSpawnIn.addAll(allowedBiomes);
    }

    public WorldChunkManagerNorthrend(long p_i1975_1_, WorldType p_i1975_3_)
    {
        this();
        GenLayer[] agenlayer = NorthrendGenLayerBiome.initializeAllBiomeGenerators(p_i1975_1_, SuperMod.northrend);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerNorthrend(World p_i1976_1_)
    {
        this(p_i1976_1_.getSeed(), p_i1976_1_.getWorldInfo().getTerrainType());
    }
}
