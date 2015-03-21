package com.gigavoid.supermod.northrend.worldgen.structures;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class NorthrendStructureMineshaftStart extends StructureStart
{
    private static final String __OBFID = "CL_00000450";

    public NorthrendStructureMineshaftStart() {}

    public NorthrendStructureMineshaftStart(World worldIn, Random p_i2039_2_, int p_i2039_3_, int p_i2039_4_)
    {
        super(p_i2039_3_, p_i2039_4_);
        NorthrendStructureMineshaftPieces.Room room = new NorthrendStructureMineshaftPieces.Room(0, p_i2039_2_, (p_i2039_3_ << 4) + 2, (p_i2039_4_ << 4) + 2);
        this.components.add(room);
        room.buildComponent(room, this.components, p_i2039_2_);
        this.updateBoundingBox();
        this.markAvailableHeight(worldIn, p_i2039_2_, 10);
    }
}