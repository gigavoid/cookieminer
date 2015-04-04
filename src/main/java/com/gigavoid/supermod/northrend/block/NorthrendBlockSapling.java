package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenTree;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class NorthrendBlockSapling extends BlockSapling {
    public static final PropertyEnum TYPE = PropertyEnum.create("type", NorthrendWorldGenTree.TreeType.class);
    
    protected NorthrendBlockSapling()
    {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, NorthrendWorldGenTree.TreeType.PINE).withProperty(STAGE_PROP, 0));
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.offsetUp()) >= 9 && rand.nextInt(7) == 0)
            {
                this.func_176478_d(worldIn, pos, state, rand);
            }
        }
    }

    public void func_176478_d(World worldIn, BlockPos p_176478_2_, IBlockState p_176478_3_, Random p_176478_4_)
    {
        if ((Integer) p_176478_3_.getValue(STAGE_PROP) == 0)
        {
            worldIn.setBlockState(p_176478_2_, p_176478_3_.cycleProperty(STAGE_PROP), 4);
        }
        else
        {
            this.func_176476_e(worldIn, p_176478_2_, p_176478_3_, p_176478_4_);
        }
    }

    public void func_176476_e(World worldIn, BlockPos p_176476_2_, IBlockState p_176476_3_, Random p_176476_4_)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, p_176476_4_, p_176476_2_)) return;
        Object object = p_176476_4_.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch (NorthrendBlockSapling.SwitchEnumType.types[((NorthrendWorldGenTree.TreeType)p_176476_3_.getValue(TYPE)).ordinal()])
        {
            case 1:
                label78:

                for (i = 0; i >= -1; --i)
                {
                    for (j = 0; j >= -1; --j)
                    {
                        if (this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j + 1), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j + 1), BlockPlanks.EnumType.SPRUCE))
                        {
                            object = new WorldGenMegaPineTree(false, p_176476_4_.nextBoolean());
                            flag = true;
                            break label78;
                        }
                    }
                }

                if (!flag)
                {
                    j = 0;
                    i = 0;
                    object = new WorldGenTaiga2(true);
                }

                break;
            case 2:
                object = new WorldGenForest(true, false);
                break;
            case 3:
                label93:

                for (i = 0; i >= -1; --i)
                {
                    for (j = 0; j >= -1; --j)
                    {
                        if (this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j + 1), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j + 1), BlockPlanks.EnumType.JUNGLE))
                        {
                            object = new WorldGenMegaJungle(true, 10, 20, BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a());
                            flag = true;
                            break label93;
                        }
                    }
                }

                if (!flag)
                {
                    j = 0;
                    i = 0;
                    object = new WorldGenTrees(true, 4 + p_176476_4_.nextInt(7), BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a(), false);
                }

                break;
            case 4:
                object = new WorldGenSavannaTree(true);
                break;
            case 5:
                label108:

                for (i = 0; i >= -1; --i)
                {
                    for (j = 0; j >= -1; --j)
                    {
                        if (this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(worldIn, p_176476_2_.add(i, 0, j + 1), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(worldIn, p_176476_2_.add(i + 1, 0, j + 1), BlockPlanks.EnumType.DARK_OAK))
                        {
                            object = new WorldGenCanopyTree(true);
                            flag = true;
                            break label108;
                        }
                    }
                }

                if (!flag)
                {
                    return;
                }
            case 6:
        }

        IBlockState iblockstate1 = Blocks.air.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(p_176476_2_.add(i, 0, j), iblockstate1, 4);
            worldIn.setBlockState(p_176476_2_.add(i + 1, 0, j), iblockstate1, 4);
            worldIn.setBlockState(p_176476_2_.add(i, 0, j + 1), iblockstate1, 4);
            worldIn.setBlockState(p_176476_2_.add(i + 1, 0, j + 1), iblockstate1, 4);
        }
        else
        {
            worldIn.setBlockState(p_176476_2_, iblockstate1, 4);
        }

        if (!((WorldGenerator)object).generate(worldIn, p_176476_4_, p_176476_2_.add(i, 0, j)))
        {
            if (flag)
            {
                worldIn.setBlockState(p_176476_2_.add(i, 0, j), p_176476_3_, 4);
                worldIn.setBlockState(p_176476_2_.add(i + 1, 0, j), p_176476_3_, 4);
                worldIn.setBlockState(p_176476_2_.add(i, 0, j + 1), p_176476_3_, 4);
                worldIn.setBlockState(p_176476_2_.add(i + 1, 0, j + 1), p_176476_3_, 4);
            }
            else
            {
                worldIn.setBlockState(p_176476_2_, p_176476_3_, 4);
            }
        }
    }

    public boolean func_176477_a(World worldIn, BlockPos p_176477_2_, BlockPlanks.EnumType p_176477_3_)
    {
        IBlockState iblockstate = worldIn.getBlockState(p_176477_2_);
        return iblockstate.getBlock() == this && iblockstate.getValue(TYPE) == p_176477_3_;
    }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockPlanks.EnumType)state.getValue(TYPE)).func_176839_a();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockPlanks.EnumType[] aenumtype = BlockPlanks.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
            BlockPlanks.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.func_176839_a()));
        }
    }

    public boolean isStillGrowing(World worldIn, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_)
    {
        this.func_176478_d(worldIn, p_176474_3_, p_176474_4_, p_176474_2_);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, BlockPlanks.EnumType.func_176837_a(meta & 7)).withProperty(STAGE_PROP, (meta & 8) >> 3);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockPlanks.EnumType)state.getValue(TYPE)).func_176839_a();
        i |= (Integer) state.getValue(STAGE_PROP) << 3;
        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, TYPE, STAGE_PROP);
    }

    static final class SwitchEnumType
    {
        static final int[] types = new int[NorthrendWorldGenTree.TreeType.values().length];

        static
        {
            try
            {
                types[NorthrendWorldGenTree.TreeType.DEFAULT.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                types[NorthrendWorldGenTree.TreeType.PINE.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                types[NorthrendWorldGenTree.TreeType.FIR.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                types[NorthrendWorldGenTree.TreeType.BIRCH.ordinal()] = 4;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }
        }
    }
}
