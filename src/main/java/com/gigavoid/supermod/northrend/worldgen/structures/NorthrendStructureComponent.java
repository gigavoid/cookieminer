package com.gigavoid.supermod.northrend.worldgen.structures;

import com.gigavoid.supermod.northrend.block.NorthrendBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDoor;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class NorthrendStructureComponent extends StructureComponent {
    public NorthrendStructureComponent(){super();}

    protected NorthrendStructureComponent(int p_i2091_1_){
        super(p_i2091_1_);
    }

    @Override
    protected int getMetadataWithOffset(Block block, int meta)
    {
        if (block == Blocks.rail)
        {
            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.EAST)
            {
                if (meta == 1)
                {
                    return 0;
                }

                return 1;
            }
        }
        else if (block instanceof BlockDoor)
        {
            if (this.coordBaseMode == EnumFacing.SOUTH)
            {
                if (meta == 0)
                {
                    return 2;
                }

                if (meta == 2)
                {
                    return 0;
                }
            }
            else
            {
                if (this.coordBaseMode == EnumFacing.WEST)
                {
                    return meta + 1 & 3;
                }

                if (this.coordBaseMode == EnumFacing.EAST)
                {
                    return meta + 3 & 3;
                }
            }
        }
        else if (block != Blocks.stone_stairs && block != Blocks.oak_stairs && block != Blocks.nether_brick_stairs
                && block != Blocks.stone_brick_stairs && block != Blocks.sandstone_stairs && block != NorthrendBlocks.northCobbleStairs
                && block != NorthrendBlocks.northStairs)
        {
            if (block == Blocks.ladder)
            {
                if (this.coordBaseMode == EnumFacing.SOUTH)
                {
                    if (meta == EnumFacing.NORTH.getIndex())
                    {
                        return EnumFacing.SOUTH.getIndex();
                    }

                    if (meta == EnumFacing.SOUTH.getIndex())
                    {
                        return EnumFacing.NORTH.getIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST)
                {
                    if (meta == EnumFacing.NORTH.getIndex())
                    {
                        return EnumFacing.WEST.getIndex();
                    }

                    if (meta == EnumFacing.SOUTH.getIndex())
                    {
                        return EnumFacing.EAST.getIndex();
                    }

                    if (meta == EnumFacing.WEST.getIndex())
                    {
                        return EnumFacing.NORTH.getIndex();
                    }

                    if (meta == EnumFacing.EAST.getIndex())
                    {
                        return EnumFacing.SOUTH.getIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST)
                {
                    if (meta == EnumFacing.NORTH.getIndex())
                    {
                        return EnumFacing.EAST.getIndex();
                    }

                    if (meta == EnumFacing.SOUTH.getIndex())
                    {
                        return EnumFacing.WEST.getIndex();
                    }

                    if (meta == EnumFacing.WEST.getIndex())
                    {
                        return EnumFacing.NORTH.getIndex();
                    }

                    if (meta == EnumFacing.EAST.getIndex())
                    {
                        return EnumFacing.SOUTH.getIndex();
                    }
                }
            }
            else if (block == Blocks.stone_button)
            {
                if (this.coordBaseMode == EnumFacing.SOUTH)
                {
                    if (meta == 3)
                    {
                        return 4;
                    }

                    if (meta == 4)
                    {
                        return 3;
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST)
                {
                    if (meta == 3)
                    {
                        return 1;
                    }

                    if (meta == 4)
                    {
                        return 2;
                    }

                    if (meta == 2)
                    {
                        return 3;
                    }

                    if (meta == 1)
                    {
                        return 4;
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST)
                {
                    if (meta == 3)
                    {
                        return 2;
                    }

                    if (meta == 4)
                    {
                        return 1;
                    }

                    if (meta == 2)
                    {
                        return 3;
                    }

                    if (meta == 1)
                    {
                        return 4;
                    }
                }
            }
            else if (block != Blocks.tripwire_hook && !(block instanceof BlockDirectional))
            {
                if (block == Blocks.piston || block == Blocks.sticky_piston || block == Blocks.lever || block == Blocks.dispenser)
                {
                    if (this.coordBaseMode == EnumFacing.SOUTH)
                    {
                        if (meta == EnumFacing.NORTH.getIndex() || meta == EnumFacing.SOUTH.getIndex())
                        {
                            return EnumFacing.getFront(meta).getOpposite().getIndex();
                        }
                    }
                    else if (this.coordBaseMode == EnumFacing.WEST)
                    {
                        if (meta == EnumFacing.NORTH.getIndex())
                        {
                            return EnumFacing.WEST.getIndex();
                        }

                        if (meta == EnumFacing.SOUTH.getIndex())
                        {
                            return EnumFacing.EAST.getIndex();
                        }

                        if (meta == EnumFacing.WEST.getIndex())
                        {
                            return EnumFacing.NORTH.getIndex();
                        }

                        if (meta == EnumFacing.EAST.getIndex())
                        {
                            return EnumFacing.SOUTH.getIndex();
                        }
                    }
                    else if (this.coordBaseMode == EnumFacing.EAST)
                    {
                        if (meta == EnumFacing.NORTH.getIndex())
                        {
                            return EnumFacing.EAST.getIndex();
                        }

                        if (meta == EnumFacing.SOUTH.getIndex())
                        {
                            return EnumFacing.WEST.getIndex();
                        }

                        if (meta == EnumFacing.WEST.getIndex())
                        {
                            return EnumFacing.NORTH.getIndex();
                        }

                        if (meta == EnumFacing.EAST.getIndex())
                        {
                            return EnumFacing.SOUTH.getIndex();
                        }
                    }
                }
            }
            else
            {
                EnumFacing enumfacing = EnumFacing.getHorizontal(meta);

                if (this.coordBaseMode == EnumFacing.SOUTH)
                {
                    if (enumfacing == EnumFacing.SOUTH || enumfacing == EnumFacing.NORTH)
                    {
                        return enumfacing.getOpposite().getHorizontalIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST)
                {
                    if (enumfacing == EnumFacing.NORTH)
                    {
                        return EnumFacing.WEST.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.SOUTH)
                    {
                        return EnumFacing.EAST.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.WEST)
                    {
                        return EnumFacing.NORTH.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.EAST)
                    {
                        return EnumFacing.SOUTH.getHorizontalIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST)
                {
                    if (enumfacing == EnumFacing.NORTH)
                    {
                        return EnumFacing.EAST.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.SOUTH)
                    {
                        return EnumFacing.WEST.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.WEST)
                    {
                        return EnumFacing.NORTH.getHorizontalIndex();
                    }

                    if (enumfacing == EnumFacing.EAST)
                    {
                        return EnumFacing.SOUTH.getHorizontalIndex();
                    }
                }
            }
        }
        else if (this.coordBaseMode == EnumFacing.SOUTH)
        {
            if (meta == 2)
            {
                return 3;
            }

            if (meta == 3)
            {
                return 2;
            }
        }
        else if (this.coordBaseMode == EnumFacing.WEST)
        {
            if (meta == 0)
            {
                return 2;
            }

            if (meta == 1)
            {
                return 3;
            }

            if (meta == 2)
            {
                return 0;
            }

            if (meta == 3)
            {
                return 1;
            }
        }
        else if (this.coordBaseMode == EnumFacing.EAST)
        {
            if (meta == 0)
            {
                return 2;
            }

            if (meta == 1)
            {
                return 3;
            }

            if (meta == 2)
            {
                return 1;
            }

            if (meta == 3)
            {
                return 0;
            }
        }

        return meta;
    }
}
