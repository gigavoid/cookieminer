package com.gigavoid.supermod.item.misc;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.EntityBasket;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-22.
 */
public class ItemRopewayBasket extends Item {
    public ItemRopewayBasket() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTransport);
        setUnlocalizedName("ropewayBasket");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState block = world.getBlockState(pos);
        if(block != SuperBlocks.ropeWheel)
            return false;

        if (!world.isRemote) {
            EntityBasket basket = new EntityBasket(world, pos.getX() + .5f, pos.getY() - 1.1f, pos.getZ() + .5f);
            player.worldObj.spawnEntityInWorld(basket);
            //  basket.entityTr
        }
        return true;
    }

}
