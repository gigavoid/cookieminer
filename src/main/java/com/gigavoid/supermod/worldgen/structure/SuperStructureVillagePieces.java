package com.gigavoid.supermod.worldgen.structure;

import com.gigavoid.supermod.util.SuperReflection;
import com.gigavoid.supermod.worldgen.northrend.MapGenVillageNorthrend;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by ineentho on 2014-11-26.
 */
public class SuperStructureVillagePieces extends StructureVillagePieces{


    public static class SuperPath extends StructureVillagePieces.Road {

        private int averageGroundLevel;
        private static final String __OBFID = "CL_00000528";

        public SuperPath() {}

        public SuperPath(StructureVillagePieces.Start p_i2105_1_, int p_i2105_2_, Random p_i2105_3_, StructureBoundingBox p_i2105_4_, int p_i2105_5_)
        {
            super(p_i2105_1_, p_i2105_2_);
            this.coordBaseMode = p_i2105_5_;
            this.boundingBox = p_i2105_4_;
            this.averageGroundLevel = Math.max(p_i2105_4_.getXSize(), p_i2105_4_.getZSize());
        }

        public static StructureBoundingBox func_74933_a(StructureVillagePieces.Start p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_)
        {
            for (int i1 = 7 * MathHelper.getRandomIntegerInRange(p_74933_2_, 3, 5); i1 >= 7; i1 -= 7)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, i1, p_74933_6_);

                if (StructureComponent.findIntersecting(p_74933_1_, structureboundingbox) == null)
                {
                    return structureboundingbox;
                }
            }

            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
            Block block = this.func_151558_b(Blocks.gravel, 0);

            for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i) {
                for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j) {
                    if (p_74875_3_.isVecInside(i, 64, j)) {
                        int k = p_74875_1_.getTopSolidOrLiquidBlock(i, j) - 1;
                        p_74875_1_.setBlock(i, k, j, block, 0, 2);
                    }
                }
            }

            return true;
        }


        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
            boolean flag = false;
            int i;
            StructureComponent structurecomponent1;

            for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5)) {
                structurecomponent1 = this.getNextComponentNN((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, 0, i);
                StructureBoundingBox boundingBox = (StructureBoundingBox) SuperReflection.getFieldValue("boundingBox", StructureComponent.class, structurecomponent1);
                if (structurecomponent1 != null) {
                    i += Math.max(boundingBox.getXSize(), boundingBox.getZSize());
                    flag = true;
                }
            }

            for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5)) {
                structurecomponent1 = this.getNextComponentPP((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, 0, i);
                StructureBoundingBox boundingBox = (StructureBoundingBox) SuperReflection.getFieldValue("boundingBox", StructureComponent.class, structurecomponent1);
                if (structurecomponent1 != null) {
                    i += Math.max(boundingBox.getXSize(), boundingBox.getZSize());
                    flag = true;
                }
            }

            if (flag && p_74861_3_.nextInt(3) > 0) {
                switch (this.coordBaseMode) {
                    case 0:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 1, this.getComponentType());
                        break;
                    case 1:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                        break;
                    case 2:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, this.getComponentType());
                        break;
                    case 3:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                }
            }

            if (flag && p_74861_3_.nextInt(3) > 0) {
                switch (this.coordBaseMode) {
                    case 0:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 3, this.getComponentType());
                        break;
                    case 1:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                        break;
                    case 2:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, this.getComponentType());
                        break;
                    case 3:
                        SuperStructureVillagePieces.getNextComponentVillagePath((StructureVillagePieces.Start) p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                }
            }
        }
    }


    private static StructureComponent getNextComponentVillagePath(StructureVillagePieces.Start p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_)
    {
        if (p_75080_7_ > 3 + p_75080_0_.terrainType)
        {
            return null;
        }
        else if (Math.abs(p_75080_3_ - p_75080_0_.getBoundingBox().minX) <= 112 && Math.abs(p_75080_5_ - p_75080_0_.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox structureboundingbox = SuperStructureVillagePieces.SuperPath.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);

            if (structureboundingbox != null && structureboundingbox.minY > 10)
            {
                SuperStructureVillagePieces.SuperPath path = new SuperStructureVillagePieces.SuperPath(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
                StructureBoundingBox boundingBox = (StructureBoundingBox) SuperReflection.getFieldValue("boundingBox", SuperStructureVillagePieces.SuperPath.class, path);
                int j1 = (boundingBox.minX + boundingBox.maxX) / 2;
                int k1 = (boundingBox.minZ + boundingBox.maxZ) / 2;
                int l1 = boundingBox.maxX - boundingBox.minX;
                int i2 = boundingBox.maxZ - boundingBox.minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75080_0_.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    p_75080_1_.add(path);
                    p_75080_0_.field_74930_j.add(path);
                    return path;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    public static void registerStructures() {
        MapGenStructureIO.registerStructure(MapGenVillageNorthrend.SuperStart.class, "superStart");
        MapGenStructureIO.registerStructure(SuperStructureVillagePieces.SuperStart.class, "superStartPiece");
        MapGenStructureIO.registerStructure(SuperStructureVillagePieces.SuperVillage.SuperWell.class, "superWell");
        MapGenStructureIO.registerStructure(SuperStructureVillagePieces.SuperPath.class, "superPath");

        MapGenStructureIO.func_143031_a(SuperStructureVillagePieces.SuperStart.class, "superStartPiece");
    }


    private static int func_75079_a(List p_75079_0_)
    {
        boolean flag = false;
        int i = 0;
        StructureVillagePieces.PieceWeight pieceweight;

        for (Iterator iterator = p_75079_0_.iterator(); iterator.hasNext(); i += pieceweight.villagePieceWeight)
        {
            pieceweight = (StructureVillagePieces.PieceWeight)iterator.next();

            if (pieceweight.villagePiecesLimit > 0 && pieceweight.villagePiecesSpawned < pieceweight.villagePiecesLimit)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }


    private static StructureVillagePieces.Village func_75083_a(StructureVillagePieces.Start p_75083_0_, StructureVillagePieces.PieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_)
    {
        Class oclass = p_75083_1_.villagePieceClass;
        Object object = null;

        if (oclass == StructureVillagePieces.House4Garden.class)
        {
            object = StructureVillagePieces.House4Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.Church.class)
        {
            object = StructureVillagePieces.Church.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.House1.class)
        {
            object = StructureVillagePieces.House1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.WoodHut.class)
        {
            object = StructureVillagePieces.WoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.Hall.class)
        {
            object = StructureVillagePieces.Hall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.Field1.class)
        {
            object = StructureVillagePieces.Field1.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.Field2.class)
        {
            object = StructureVillagePieces.Field2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.House2.class)
        {
            object = StructureVillagePieces.House2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == StructureVillagePieces.House3.class)
        {
            object = StructureVillagePieces.House3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else
        {
            object = VillagerRegistry.getVillageComponent(p_75083_1_, p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }

        return (StructureVillagePieces.Village)object;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static StructureVillagePieces.Village getNextVillageComponent(StructureVillagePieces.Start p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_)
    {
        int j1 = func_75079_a(p_75081_0_.structureVillageWeightedPieceList);

        if (j1 <= 0)
        {
            return null;
        }
        else
        {
            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int l1 = p_75081_2_.nextInt(j1);
                Iterator iterator = p_75081_0_.structureVillageWeightedPieceList.iterator();

                while (iterator.hasNext())
                {
                    StructureVillagePieces.PieceWeight pieceweight = (StructureVillagePieces.PieceWeight)iterator.next();
                    l1 -= pieceweight.villagePieceWeight;

                    if (l1 < 0)
                    {
                        if (!pieceweight.canSpawnMoreVillagePiecesOfType(p_75081_7_) || pieceweight == p_75081_0_.structVillagePieceWeight && p_75081_0_.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        StructureVillagePieces.Village village = func_75083_a(p_75081_0_, pieceweight, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);

                        if (village != null)
                        {
                            ++pieceweight.villagePiecesSpawned;
                            p_75081_0_.structVillagePieceWeight = pieceweight;

                            if (!pieceweight.canSpawnMoreVillagePieces())
                            {
                                p_75081_0_.structureVillageWeightedPieceList.remove(pieceweight);
                            }

                            return village;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = StructureVillagePieces.Torch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);

            if (structureboundingbox != null)
            {
                return new StructureVillagePieces.Torch(p_75081_0_, p_75081_7_, p_75081_2_, structureboundingbox, p_75081_6_);
            }
            else
            {
                return null;
            }
        }
    }


    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(SuperStructureVillagePieces.Start p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_)
    {
        if (p_75077_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_75077_3_ - p_75077_0_.getBoundingBox().minX) <= 112 && Math.abs(p_75077_5_ - p_75077_0_.getBoundingBox().minZ) <= 112)
        {
            StructureVillagePieces.Village village = getNextVillageComponent(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);

            if (village != null)
            {
                StructureBoundingBox boundingBox = (StructureBoundingBox) SuperReflection.getFieldValue("boundingBox", Village.class, village);
                int j1 = (boundingBox.minX + boundingBox.maxX) / 2;
                int k1 = (boundingBox.minZ + boundingBox.maxZ) / 2;
                int l1 = boundingBox.maxX - boundingBox.minX;
                int i2 = boundingBox.maxZ - boundingBox.minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75077_0_.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    p_75077_1_.add(village);
                    p_75077_0_.field_74932_i.add(village);
                    return village;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }


    public abstract static class SuperVillage extends Village{


        private StructureVillagePieces.Start startPiece;

        public SuperVillage() {}

        protected SuperVillage(StructureVillagePieces.Start startPiece, int type)
        {
            super(startPiece, type);

            if (startPiece != null)
            {
                this.startPiece = startPiece;
            }
        }

        @Override
        protected Block func_151558_b(Block block, int type) {
            BiomeEvent.GetVillageBlockID event = new BiomeEvent.GetVillageBlockID(startPiece == null ? null : startPiece.biome, block, 1337);
            MinecraftForge.TERRAIN_GEN_BUS.post(event);
            if (event.getResult() == Event.Result.DENY) return event.replacement;
            return super.func_151558_b(block, type);
        }

        public static class SuperWell extends SuperStructureVillagePieces.SuperVillage {

            public SuperWell() {
                super();
            }

            public SuperWell(StructureVillagePieces.Start p_i2109_1_, int p_i2109_2_, Random p_i2109_3_, int p_i2109_4_, int p_i2109_5_) {
                super(p_i2109_1_, p_i2109_2_);
                this.coordBaseMode = p_i2109_3_.nextInt(4);

                switch (this.coordBaseMode)
                {
                    case 0:
                    case 2:
                        this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
                        break;
                    default:
                        this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
                }
            }


            @Override
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 3, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 4, 12, 4, Blocks.cobblestone, Blocks.flowing_water, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 12, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 3, 12, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 12, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 3, 12, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 13, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 14, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 13, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 14, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 13, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 14, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 13, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 14, 4, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 15, 1, 4, 15, 4, Blocks.cobblestone, Blocks.cobblestone, false);

                for (int i = 0; i <= 5; ++i)
                {
                    for (int j = 0; j <= 5; ++j)
                    {
                        if (j == 0 || j == 5 || i == 0 || i == 5)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.gravel, 0, j, 11, i, p_74875_3_);
                            this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 12, i, p_74875_3_);
                        }
                    }
                }

                return true;
            }
        }

    }

    public static class SuperStart extends SuperStructureVillagePieces.SuperVillage.SuperWell {
        private boolean hasMoreThanTwoComponents;

        public WorldChunkManager worldChunkMngr;
        /** Boolean that determines if the village is in a desert or not. */
        public boolean inDesert;
        /** World terrain type, 0 for normal, 1 for flap map */
        public int terrainType;
        public StructureVillagePieces.PieceWeight structVillagePieceWeight;
        /**
         * Contains List of all spawnable Structure Piece Weights. If no more Pieces of a type can be spawned, they
         * are removed from this list
         */
        public List structureVillageWeightedPieceList;
        public List field_74932_i = new ArrayList();
        public List field_74930_j = new ArrayList();
        public BiomeGenBase biome;

        public SuperStart() {

        }

        public SuperStart(WorldChunkManager p_i2104_1_, int p_i2104_2_, Random p_i2104_3_, int p_i2104_4_, int p_i2104_5_, List p_i2104_6_, int p_i2104_7_)
        {
            super(null, 0, p_i2104_3_, p_i2104_4_, p_i2104_5_);
            this.worldChunkMngr = p_i2104_1_;
            this.structureVillageWeightedPieceList = p_i2104_6_;
            this.terrainType = p_i2104_7_;
            BiomeGenBase biomegenbase = p_i2104_1_.getBiomeGenAt(p_i2104_4_, p_i2104_5_);
            this.inDesert = biomegenbase == BiomeGenBase.desert || biomegenbase == BiomeGenBase.desertHills;
            this.biome = biomegenbase;
        }

        /**
         * Gets the next village component, with the bounding box shifted -1 in the X and Z direction.
         */
        protected StructureComponent getNextComponentNN(StructureVillagePieces.Start p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                case 1:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                case 2:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                case 3:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                default:
                    return null;
            }
        }

        /**
         * Gets the next village component, with the bounding box shifted +1 in the X and Z direction.
         */
        protected StructureComponent getNextComponentPP(StructureVillagePieces.Start p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                case 1:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                case 2:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                case 3:
                    return SuperStructureVillagePieces.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                default:
                    return null;
            }
        }

        public WorldChunkManager getWorldChunkManager()
        {
            return this.worldChunkMngr;
        }
    }


}
