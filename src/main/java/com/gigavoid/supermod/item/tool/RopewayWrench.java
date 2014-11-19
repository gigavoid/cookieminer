package com.gigavoid.supermod.item.tool;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.EntityRope;
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

            Boolean onXAxis = false;
            if(pointA[0] == pointB[0])
                onXAxis = true;

            if(onXAxis) {
                int min = Math.min(pointA[2], pointB[2]);
                int max = Math.max(pointA[2], pointB[2]);
                for(int i = min; i < max; i++) {
                    EntityRope newRope = new EntityRope(world, x, y, i, pointB[0], pointB[1], pointB[2]);
                   /* newRope.targetX = pointB[0];
                    newRope.targetY = pointB[1];
                    newRope.targetZ = pointB[2];*/
                    world.spawnEntityInWorld(newRope);

                }
            } else {
                int min = Math.min(pointA[0], pointB[0]);
                int max = Math.max(pointA[0], pointB[0]);
                for(int i = min; i < max; i++) {
                    EntityRope newRope = new EntityRope(world, i, y, z, pointB[0], pointB[1], pointB[2]);
                  /*  newRope.targetX = pointB[0];
                    newRope.targetY = pointB[1];
                    newRope.targetZ = pointB[2];*/
                    world.spawnEntityInWorld(newRope);

                }
            }



           // TileEntityRopeWheel.addRopeFromTo(world, pointA, pointB);
            //TileEntityRopeWheel.addRopeFromTo(world, pointB, pointA);
            RopewayWrench.clearPathStart(item);
        } else {
            RopewayWrench.setPathStart(item, x, y, z);
        }
        return true;
    }

    private static int[] getPathStart(ItemStack item) {
        int[] startBlocks = item.getTagCompound().getIntArray("startBlock");
        return startBlocks;
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
