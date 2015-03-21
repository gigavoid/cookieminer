package com.gigavoid.supermod.ropeway.item;

import com.gigavoid.supermod.ropeway.block.RopewayBlocks;
import com.gigavoid.supermod.ropeway.creativetab.RopewayCreativeTabs;
import com.gigavoid.supermod.ropeway.entity.EntityRopewayBasket;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemRopewayBasket extends Item {
    public ItemRopewayBasket() {
        setCreativeTab(RopewayCreativeTabs.tabBlock);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState blockState = world.getBlockState(pos);
        if(blockState.getBlock() != RopewayBlocks.engine)
            return false;

        if (!world.isRemote) {
            EntityRopewayBasket basket = new EntityRopewayBasket(world, pos.getX() + .5f, pos.getY() - 1.1f, pos.getZ() + .5f);
            basket.setTarget(pos);
            player.worldObj.spawnEntityInWorld(basket);
        }
        return true;
    }

}
