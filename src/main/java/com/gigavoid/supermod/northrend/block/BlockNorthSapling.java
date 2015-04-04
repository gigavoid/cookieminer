package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import com.gigavoid.supermod.northrend.worldgen.tree.NorthrendWorldGenTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockNorthSapling extends BlockBush implements IGrowable {
    public static final PropertyEnum TYPE_PROP_N = PropertyEnum.create("type", BlockNorthSapling.EnumType.class);
    public static final PropertyInteger STAGE_PROP = PropertyInteger.create("stage", 0, 1);

    private final EnumType type;

    public BlockNorthSapling(BlockNorthSapling.EnumType type) {
        this.type = type;
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE_PROP_N, type).withProperty(STAGE_PROP, 0));
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.blockState.getBaseState().withProperty(TYPE_PROP_N, this.type).withProperty(STAGE_PROP, 0);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.offsetDown()).getBlock() == NorthrendBlocks.northDirt;
    }


    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLightFromNeighbors(pos.offsetUp()) >= 9 && rand.nextInt(7) == 0 && canPlaceBlockAt(worldIn, pos.offsetDown()))
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

    public void func_176476_e(World worldIn, BlockPos pos, IBlockState blockState, Random random)
    {
        WorldGenAbstractTree object = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.DEFAULT);

        switch (BlockNorthSapling.SwitchEnumType.field_177065_a[((BlockNorthSapling.EnumType)blockState.getValue(TYPE_PROP_N)).ordinal()])
        {
            case 1:
                object = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.PINE);
                break;
            case 2:
                object = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.FIR);
                break;
            case 3:
                object = new NorthrendWorldGenTree(true, NorthrendWorldGenTree.TreeType.BIRCH);
                break;
        }

        IBlockState iblockstate1 = Blocks.air.getDefaultState();

        worldIn.setBlockState(pos, iblockstate1, 4);

        if (!(object).generate(worldIn, random, pos.offsetUp()))
        {
            worldIn.setBlockState(pos, blockState, 4);
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockNorthSapling.EnumType)state.getValue(TYPE_PROP_N)).func_176839_a();
    }

    @Override
    public boolean isStillGrowing(World worldIn, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_)
    {
        this.func_176478_d(worldIn, p_176474_3_, p_176474_4_, p_176474_2_);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE_PROP_N, BlockNorthSapling.EnumType.func_176837_a(meta & 7)).withProperty(STAGE_PROP, (meta & 8) >> 3);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockNorthSapling.EnumType)state.getValue(TYPE_PROP_N)).func_176839_a();
        i |= (Integer) state.getValue(STAGE_PROP) << 3;
        return i;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, TYPE_PROP_N, STAGE_PROP);
    }

    static final class SwitchEnumType
    {
        static final int[] field_177065_a = new int[EnumType.values().length];

        static
        {
            try
            {
                field_177065_a[EnumType.PINE.ordinal()] = 1;
            }
            catch (NoSuchFieldError ignored) {}

            try
            {
                field_177065_a[EnumType.FIR.ordinal()] = 2;
            }
            catch (NoSuchFieldError ignored) {}

            try
            {
                field_177065_a[EnumType.BIRCH.ordinal()] = 3;
            }
            catch (NoSuchFieldError ignored) {}
        }
    }

    public static enum EnumType implements IStringSerializable {
        PINE(0, "pine"),
        FIR(1, "fir"),
        BIRCH(2, "birch");
        private static final BlockNorthSapling.EnumType[] enumList = new BlockNorthSapling.EnumType[values().length];
        private final int value;
        private final String string;
        private final String key;

        private EnumType(int value, String key) {
            this(value, key, key);
        }

        private EnumType(int p_i45696_3_, String p_i45696_4_, String p_i45696_5_) {
            this.value = p_i45696_3_;
            this.string = p_i45696_4_;
            this.key = p_i45696_5_;
        }

        public int func_176839_a() {
            return this.value;
        }

        public String toString() {
            return this.string;
        }

        public static BlockNorthSapling.EnumType func_176837_a(int p_176837_0_) {
            if (p_176837_0_ < 0 || p_176837_0_ >= enumList.length) {
                p_176837_0_ = 0;
            }

            return enumList[p_176837_0_];
        }

        public String getName() {
            return this.string;
        }

        public String func_176840_c() {
            return this.key;
        }

        static {
            BlockNorthSapling.EnumType[] var0 = values();

            for (EnumType var3 : var0) {
                enumList[var3.func_176839_a()] = var3;
            }
        }
    }
}