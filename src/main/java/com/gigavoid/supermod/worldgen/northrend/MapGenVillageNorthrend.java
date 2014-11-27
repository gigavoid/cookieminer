package com.gigavoid.supermod.worldgen.northrend;

import com.gigavoid.supermod.biome.SuperBiomes;
import com.gigavoid.supermod.worldgen.structure.SuperStructureVillagePieces;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MapGenVillageNorthrend extends MapGenVillage {
    public MapGenVillageNorthrend() {
        villageSpawnBiomes = Arrays.asList(new BiomeGenBase[]{SuperBiomes.northPlains, SuperBiomes.northHighlands});
    }
/*
    @Override
    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_) {
        return new MapGenVillageNorthrend.SuperStart(this.worldObj, this.rand, p_75049_1_, p_75049_2_, 1337);
    }
*/
    @Override
    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new MapGenVillageNorthrend.SuperStart(this.worldObj, this.rand, p_75049_1_, p_75049_2_, 0);
       // return new MapGenVillageNorthrend.SuperStart(this., this.rand, p_75049_1_, p_75049_2_, 0);
    }

    public static class SuperStart extends StructureStart
    {
        /** well ... thats what it does */
        private boolean hasMoreThanTwoComponents;
        private static final String __OBFID = "CL_00000515";

        public SuperStart() {}

        public SuperStart(World p_i2092_1_, Random p_i2092_2_, int p_i2092_3_, int p_i2092_4_, int p_i2092_5_)
        {
            super(p_i2092_3_, p_i2092_4_);
            List list = SuperStructureVillagePieces.getStructureVillageWeightedPieceList(p_i2092_2_, p_i2092_5_);
            SuperStructureVillagePieces.SuperStart start = new SuperStructureVillagePieces.SuperStart(p_i2092_1_.getWorldChunkManager(), 0, p_i2092_2_, (p_i2092_3_ << 4) + 2, (p_i2092_4_ << 4) + 2, list, p_i2092_5_);
            this.components.add(start);
            start.buildComponent(start, this.components, p_i2092_2_);
            List list1 = start.field_74930_j;
            List list2 = start.field_74932_i;
            int l;

            while (!list1.isEmpty() || !list2.isEmpty())
            {
                StructureComponent structurecomponent;

                if (list1.isEmpty())
                {
                    l = p_i2092_2_.nextInt(list2.size());
                    structurecomponent = (StructureComponent)list2.remove(l);
                    structurecomponent.buildComponent(start, this.components, p_i2092_2_);
                }
                else
                {
                    l = p_i2092_2_.nextInt(list1.size());
                    structurecomponent = (StructureComponent)list1.remove(l);
                    structurecomponent.buildComponent(start, this.components, p_i2092_2_);
                }
            }

            this.updateBoundingBox();
            l = 0;
            Iterator iterator = this.components.iterator();

            while (iterator.hasNext())
            {
                StructureComponent structurecomponent1 = (StructureComponent)iterator.next();

                if (!(structurecomponent1 instanceof StructureVillagePieces.Road))
                {
                    ++l;
                }
            }

            this.hasMoreThanTwoComponents = l > 2;
        }

        /**
         * currently only defined for Villages, returns true if Village has more than 2 non-road components
         */
        public boolean isSizeableStructure()
        {
            return this.hasMoreThanTwoComponents;
        }

        public void func_143022_a(NBTTagCompound p_143022_1_)
        {
            super.func_143022_a(p_143022_1_);
            p_143022_1_.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }

        public void func_143017_b(NBTTagCompound p_143017_1_)
        {
            super.func_143017_b(p_143017_1_);
            this.hasMoreThanTwoComponents = p_143017_1_.getBoolean("Valid");
        }
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int p_75047_1_, int p_75047_2_) {
        return true;
    }
/*
    public static class SuperStart extends SuperStructureVillagePieces.SuperVillage.SuperWell {
        private boolean hasMoreThanTwoComponents;

        public WorldChunkManager worldChunkMngr;
        /** Boolean that determines if the village is in a desert or not. */
       // public boolean inDesert;
        /** World terrain type, 0 for normal, 1 for flap map */
       /* public int terrainType;
        public StructureVillagePieces.PieceWeight structVillagePieceWeight;
        /**
         * Contains List of all spawnable Structure Piece Weights. If no more Pieces of a type can be spawned, they
         * are removed from this list
         */
        /*public List structureVillageWeightedPieceList;
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

        public WorldChunkManager getWorldChunkManager()
        {
            return this.worldChunkMngr;
        }
    }*/
}