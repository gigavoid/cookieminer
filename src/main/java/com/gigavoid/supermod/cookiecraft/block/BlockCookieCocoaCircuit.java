package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.Random;

public class BlockCookieCocoaCircuit extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final PropertyBool ACTIVE = PropertyBool.create("active");

    public static final BlockCookieCocoaCircuit instance = new BlockCookieCocoaCircuit();

    private BlockCookieCocoaCircuit() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
        this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ACTIVE);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(ACTIVE, isBlockPowered(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        if (world.isBlockPowered(pos)) {
            world.setBlockState(pos, state.withProperty(ACTIVE, true), 2);
            return 1;
        }
        world.setBlockState(pos, state.withProperty(ACTIVE, false), 2);
        return 0;
    }

	@Override
	public int getGuiId() {
		return GuiCookieGenerator.GUI_ID;
	}

    @Override
    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        if (worldIn.isBlockPowered(pos) && worldIn.isRemote){
            CookieNetwork.getNetwork(worldIn, pos).updateNetwork();
        }
        state.withProperty(ACTIVE, worldIn.isBlockPowered(pos));
    }

    private boolean isBlockPowered(IBlockAccess blockAccess, BlockPos pos) {

        if (!(blockAccess instanceof ChunkCache)) {
            return false;
        }


        ChunkCache chunkCache = (ChunkCache) blockAccess;

        World world = ObfuscationReflectionHelper.getPrivateValue(ChunkCache.class, chunkCache, "worldObj");

        return world != null && world.isBlockPowered(pos);

    }
}
