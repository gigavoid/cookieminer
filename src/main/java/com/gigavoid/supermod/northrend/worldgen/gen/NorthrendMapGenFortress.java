package com.gigavoid.supermod.northrend.worldgen.gen;

import com.gigavoid.supermod.northrend.worldgen.structures.NorthrendStructureFortressPieces;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.List;
import java.util.Random;

/**
 * Created by Rasmus on 3/12/2015.
 */
public class NorthrendMapGenFortress extends MapGenNetherBridge {

    public NorthrendMapGenFortress() {
        super();
    }

    @Override
    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new NorthrendMapGenFortress.Start(this.worldObj, this.rand, p_75049_1_, p_75049_2_);
    }

    public static class Start extends StructureStart
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
                StructureComponent structurecomponent = (StructureComponent)list.remove(k);
                structurecomponent.buildComponent(start, this.components, p_i2040_2_);
            }

            this.updateBoundingBox();
            this.setRandomHeight(worldIn, p_i2040_2_, 88, 110);
        }
    }
}