package com.gigavoid.supermod.block;

import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import static net.minecraftforge.common.util.ForgeDirection.*;
import static net.minecraftforge.common.util.ForgeDirection.EAST;

/**
 * Created by ineentho on 2014-11-03.
 */
public class BlockRopeWheel extends Block implements ITileEntityProvider {

    protected BlockRopeWheel() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockTextureName("supermod:rope_wheel");
        this.setBlockName("ropeWheel");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);


        return (dir == NORTH && world.isSideSolid(x, y, z + 1, NORTH) && world.getBlock(x, y, z + 1) == SuperBlocks.pylon) ||
                (dir == SOUTH && world.isSideSolid(x, y, z - 1, SOUTH) && world.getBlock(x, y, z - 1) == SuperBlocks.pylon) ||
                (dir == WEST  && world.isSideSolid(x + 1, y, z, WEST) && world.getBlock(x + 1, y, z) == SuperBlocks.pylon) ||
                (dir == EAST  && world.isSideSolid(x - 1, y, z, EAST) && world.getBlock(x - 1, y, z) == SuperBlocks.pylon);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int meta) {
        return new TileEntityRopeWheel();
    }




    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack p_149689_6_) {

        TileEntityRopeWheel te = (TileEntityRopeWheel) world.getTileEntity(x, y, z);
        te.direction = (short)(MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360) + 0.50) & 3);

        System.out.println(te.direction);

        for(int i = 0; i < 2; i++) {

            if (te.direction == 0 && world.getBlock(x, y, z + 1) != SuperBlocks.pylon)
                te.direction = 1;

            if (te.direction == 1 && world.getBlock(x - 1, y, z) != SuperBlocks.pylon)
                te.direction = 2;

            if (te.direction == 2 && world.getBlock(x, y, z - 1) != SuperBlocks.pylon)
                te.direction = 3;

            if (te.direction == 3 && world.getBlock(x + 1, y, z) != SuperBlocks.pylon)
                te.direction = 0;

        }

    }


}
