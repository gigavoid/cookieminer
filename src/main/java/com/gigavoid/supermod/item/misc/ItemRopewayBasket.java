package com.gigavoid.supermod.item.misc;

import com.gigavoid.supermod.block.SuperBlocks;
import com.gigavoid.supermod.entity.EntityBasket;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-11-22.
 */
public class ItemRopewayBasket extends Item {
    public ItemRopewayBasket() {
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTransport);
        setTextureName("supermod:ropeway_basket_item");
        setUnlocalizedName("ropewayBasket");
    }

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Block block = world.getBlock(x, y, z);
        if(block != SuperBlocks.ropeWheel)
            return false;

        if (!world.isRemote) {
            EntityBasket basket = new EntityBasket(world, x + .5f, y - 1.1f, z + .5f);
            player.worldObj.spawnEntityInWorld(basket);
          //  basket.entityTr
        }
        return true;
    }
}
