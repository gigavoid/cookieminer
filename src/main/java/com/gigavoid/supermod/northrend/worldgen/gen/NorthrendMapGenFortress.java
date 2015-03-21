package com.gigavoid.supermod.northrend.worldgen.gen;

import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureComponent;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureFortressPieces;
import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureStart;
import net.minecraft.world.World;

import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.List;
import java.util.Random;

public class NorthrendMapGenFortress extends MapGenNetherBridge {

    public NorthrendMapGenFortress() {
        super();
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int p_75047_1_, int p_75047_2_) {
        int k = p_75047_1_ >> 4;
        int l = p_75047_2_ >> 4;
        this.rand.setSeed((long) (k ^ l << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return this.rand.nextInt(7) == 0 && (p_75047_1_ == (k << 4) + 4 + this.rand.nextInt(8) && p_75047_2_ == (l << 4) + 4 + this.rand.nextInt(8));
    }

    @Override
    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new NorthrendMapGenFortress.Start(this.worldObj, this.rand, p_75049_1_, p_75049_2_);
    }

    public static class Start extends NorthrendStructureStart
    {
        public Start() {}

        public Start(World worldIn, Random p_i2040_2_, int p_i2040_3_, int p_i2040_4_)
        {
            super(p_i2040_3_, p_i2040_4_);
            NorthrendStructureFortressPieces.Start start = new NorthrendStructureFortressPieces.Start(p_i2040_2_, (p_i2040_3_ << 4) + 2, (p_i2040_4_ << 4) + 2);
            this.components.add(start);
            start.buildComponent(start, this.components, p_i2040_2_);
            List list = start.field_74967_d;

            while (!list.isEmpty())
            {
                int k = p_i2040_2_.nextInt(list.size());
                NorthrendStructureComponent structurecomponent = (NorthrendStructureComponent)list.remove(k);
                structurecomponent.buildComponent(start, this.components, p_i2040_2_);
            }

            this.updateBoundingBox();
            this.setRandomHeight(worldIn, p_i2040_2_, 88, 110);
        }
    }
}