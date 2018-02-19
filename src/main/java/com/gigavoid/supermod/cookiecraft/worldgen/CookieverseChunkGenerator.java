package com.gigavoid.supermod.cookiecraft.worldgen;

import com.gigavoid.supermod.cookiecraft.entity.EntityCookiecreeper;
import com.google.common.collect.Lists;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraftforge.event.terraingen.TerrainGen;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;

public class CookieverseChunkGenerator implements IChunkGenerator {
    private final World world;
    private Random random;
    private Biome[] biomesForGeneration;

    private List<Biome.SpawnListEntry> mobs = Lists.newArrayList(new Biome.SpawnListEntry(EntityCookiecreeper.class, 100, 2, 2));

    private MapGenBase caveGenerator = new MapGenCaves();
    private CookieTerrainGenerator terraingen = new CookieTerrainGenerator();

    public CookieverseChunkGenerator(World world) {
        this.world = world;
        long seed = world.getSeed();
        this.random = new Random((seed + 516) * 314);
        terraingen.setup(world, random);
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        return null;
    }

    @Override
    public void populate(int x, int z) {

    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }
}
