package com.gigavoid.supermod.northrend.block;

import com.gigavoid.supermod.northrend.creativetab.NorthrendCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockNorthRedstoneOre extends Block{
    private final boolean isOn;

    public BlockNorthRedstoneOre(boolean p_i45420_1_)
    {
        super(Material.rock);
        setCreativeTab(NorthrendCreativeTabs.tabNorthrend);
        this.setHardness(3.0f);
        this.setHarvestLevel("pickaxe", 2);

        if (p_i45420_1_)
        {
            this.setTickRandomly(true);
            setLightLevel(.5f);
        }

        this.isOn = p_i45420_1_;
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World worldIn)
    {
        return 30;
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        this.setOn(worldIn, pos);
        super.onBlockClicked(worldIn, pos, playerIn);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block)
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
    {
        this.setOn(worldIn, pos);
        super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        this.setOn(worldIn, pos);
        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    private void setOn(World worldIn, BlockPos p_176352_2_)
    {
        this.spawnRedstoneParticles(worldIn, p_176352_2_);

        if (this == NorthrendBlocks.redstoneOre)
        {
            worldIn.setBlockState(p_176352_2_, NorthrendBlocks.lit_redstoneOre.getDefaultState());
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this == NorthrendBlocks.lit_redstoneOre)
        {
            worldIn.setBlockState(pos, NorthrendBlocks.redstoneOre.getDefaultState());
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     *
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.redstone;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     *
     * @param chance The chance that each Item is actually spawned (1.0 = always, 0.0 = never)
     * @param fortune The player's fortune level
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(world.getBlockState(pos), RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isOn)
        {
            this.spawnRedstoneParticles(worldIn, pos);
        }
    }

    private void spawnRedstoneParticles(World worldIn, BlockPos p_180691_2_)
    {
        Random random = worldIn.rand;
        double d0 = 0.0625D;

        for (int i = 0; i < 6; ++i)
        {
            double d1 = (double)((float)p_180691_2_.getX() + random.nextFloat());
            double d2 = (double)((float)p_180691_2_.getY() + random.nextFloat());
            double d3 = (double)((float)p_180691_2_.getZ() + random.nextFloat());

            if (i == 0 && !worldIn.getBlockState(p_180691_2_.offsetUp()).getBlock().isOpaqueCube())
            {
                d2 = (double)p_180691_2_.getY() + d0 + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(p_180691_2_.offsetDown()).getBlock().isOpaqueCube())
            {
                d2 = (double)p_180691_2_.getY() - d0;
            }

            if (i == 2 && !worldIn.getBlockState(p_180691_2_.offsetSouth()).getBlock().isOpaqueCube())
            {
                d3 = (double)p_180691_2_.getZ() + d0 + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(p_180691_2_.offsetNorth()).getBlock().isOpaqueCube())
            {
                d3 = (double)p_180691_2_.getZ() - d0;
            }

            if (i == 4 && !worldIn.getBlockState(p_180691_2_.offsetEast()).getBlock().isOpaqueCube())
            {
                d1 = (double)p_180691_2_.getX() + d0 + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(p_180691_2_.offsetWest()).getBlock().isOpaqueCube())
            {
                d1 = (double)p_180691_2_.getX() - d0;
            }

            if (d1 < (double)p_180691_2_.getX() || d1 > (double)(p_180691_2_.getX() + 1) || d2 < 0.0D || d2 > (double)(p_180691_2_.getY() + 1) || d3 < (double)p_180691_2_.getZ() || d3 > (double)(p_180691_2_.getZ() + 1))
            {
                worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d1, d2, d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(NorthrendBlocks.redstoneOre);
    }
}
