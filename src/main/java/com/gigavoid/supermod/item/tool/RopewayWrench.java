package com.gigavoid.supermod.item.tool;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-03.
 */
public class RopewayWrench extends Item {
    public RopewayWrench() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTools);
        setUnlocalizedName("ropewayWrench");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState block = world.getBlockState(pos);
        if(block != SuperBlocks.ropeWheel)
            return false;

        if(RopewayWrench.isPathingInProgress(stack)) {
            BlockPos pointB = RopewayWrench.getPathStart(stack);
            if(pos.getX() - pointB.getX() != 0 && pos.getZ() - pointB.getZ() != 0)
                return false;

            TileEntityRopeWheel.addRopeFromTo(world, pos, pointB);
            RopewayWrench.clearPathStart(stack);
        } else {
            RopewayWrench.setPathStart(stack, pos);
        }
        return true;
    }


    private static BlockPos getPathStart(ItemStack item) {
        int[] pos = item.getTagCompound().getIntArray("startBlock");
        return new BlockPos(pos[0], pos[1], pos[2]);
    }

    private static void clearPathStart(ItemStack stack) {
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());

        NBTTagCompound tagCompound = stack.getTagCompound();
        tagCompound.removeTag("startBlock");
    }

    private static void setPathStart(ItemStack item,BlockPos pos) {
        if (!item.hasTagCompound())
            item.setTagCompound(new NBTTagCompound());

        NBTTagCompound tagCompound = item.getTagCompound();
        tagCompound.setIntArray("startBlock", new int[]{pos.getX(), pos.getY(), pos.getZ()});
    }

    private static boolean isPathingInProgress(ItemStack itemStack) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        return tagCompound != null && tagCompound.getIntArray("startBlock") != null && tagCompound.getIntArray("startBlock").length != 0;

    }


}