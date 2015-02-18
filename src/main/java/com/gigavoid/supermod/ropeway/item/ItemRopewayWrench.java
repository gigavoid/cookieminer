package com.gigavoid.supermod.ropeway.item;

import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import com.gigavoid.supermod.ropeway.creativetab.RopewayCreativeTabs;
import com.gigavoid.supermod.ropeway.tileentity.TileEntityRopewayEngine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemRopewayWrench extends Item{
    public ItemRopewayWrench() {
        setCreativeTab(RopewayCreativeTabs.tabBlock);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState blockState = world.getBlockState(pos);
        if(blockState.getBlock() != RopewayBlocks.engine)
            return false;

        if(ItemRopewayWrench.isPathingInProgress(stack)) {
            BlockPos pointB = ItemRopewayWrench.getPathStart(stack);
            if(pos.getX() - pointB.getX() != 0 && pos.getZ() - pointB.getZ() != 0)
                return false;

            TileEntityRopewayEngine.addRopeFromTo(world, pos, pointB);
            ItemRopewayWrench.clearPathStart(stack);
        } else {
            ItemRopewayWrench.setPathStart(stack, pos);
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
