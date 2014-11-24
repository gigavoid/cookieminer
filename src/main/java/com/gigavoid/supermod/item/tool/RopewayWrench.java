package com.gigavoid.supermod.item.tool;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.tileentity.TileEntityRopeWheel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-03.
 */
public class RopewayWrench extends Item {
    public RopewayWrench() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTools);
        setTextureName("supermod:ropeway_wrench");
        setUnlocalizedName("ropewayWrench");
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Block block = world.getBlock(x, y, z);
        if(block != SuperBlocks.ropeWheel)
            return false;

        if(RopewayWrench.isPathingInProgress(item)) {
            int[] pointA = {x, y, z};
            int[] pointB = RopewayWrench.getPathStart(item);
            if(pointA[0] - pointB[0] != 0 && pointA[2] - pointB[2] != 0)
                return false;

            TileEntityRopeWheel.addRopeFromTo(world, pointA, pointB);
            RopewayWrench.clearPathStart(item);
        } else {
            RopewayWrench.setPathStart(item, x, y, z);
        }
        return true;
    }

    private static int[] getPathStart(ItemStack item) {
        return item.getTagCompound().getIntArray("startBlock");
    }

    private static void clearPathStart(ItemStack stack) {
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());

        NBTTagCompound tagCompound = stack.getTagCompound();
        tagCompound.removeTag("startBlock");
    }

    private static void setPathStart(ItemStack item, int x, int y, int z) {
        if (!item.hasTagCompound())
            item.setTagCompound(new NBTTagCompound());

        NBTTagCompound tagCompound = item.getTagCompound();
        tagCompound.setIntArray("startBlock", new int[]{x, y, z});
    }

    private static boolean isPathingInProgress(ItemStack itemStack) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        if(tagCompound == null)
            return false;

        return tagCompound.getIntArray("startBlock") != null && tagCompound.getIntArray("startBlock").length != 0;
    }


}