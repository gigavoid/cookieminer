package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.item.SuperItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class VoidPickaxeItem extends ItemPickaxe {
    public VoidPickaxeItem() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName("voidPickaxe");
        setMaxDamage(5000);
        efficiencyOnProperMaterial = 10.0f;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.getBlockState(pos) == Block.getBlockById(7)){
            playerIn.inventory.addItemStackToInventory(new ItemStack(SuperItems.bedLump));
            stack.damageItem(500, playerIn);
            return true;
        }
        return false;
    }
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        return super.getHarvestLevel(stack, toolClass) == -1 ? -1 : 4;
    }
}
