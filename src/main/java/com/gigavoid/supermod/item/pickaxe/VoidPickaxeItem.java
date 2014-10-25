package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VoidPickaxeItem extends ItemPickaxe {
    public VoidPickaxeItem() {
        super(Item.ToolMaterial.EMERALD);
        setUnlocalizedName("voidPickaxe");
        setTextureName("voidPickaxe");
        setMaxDamage(5000);
    }

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Block.getBlockById(7)){
            p_77648_2_.inventory.addItemStackToInventory(new ItemStack(SuperItems.bedLump));
            p_77648_1_.damageItem(500, p_77648_2_);
            return true;
        }
        return false;
    }
}
