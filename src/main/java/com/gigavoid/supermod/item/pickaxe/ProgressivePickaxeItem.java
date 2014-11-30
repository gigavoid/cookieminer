package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.progpick.ProgPickUpgrade;
import com.gigavoid.supermod.progpick.ProgPickUpgrades;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ProgressivePickaxeItem extends ItemPickaxe {
    private String material;
    private int level;

    //IIcon pickCanBeUpgraded;

    public ProgressivePickaxeItem() {
        super(ToolMaterial.WOOD);
        setMaxDamage(-1);
    }

    public void setToolLevel(int level) {
        this.level = level;

    }
/*
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);

        pickCanBeUpgraded = iconRegister.registerIcon("supermod:prog_pickaxe_upg");
    }

    @Override
    public IIcon getIconIndex(ItemStack stack) {
        if(ProgPickUpgrades.isFullExp(stack))
            return pickCanBeUpgraded;
        return super.getIconIndex(stack);
    }
*/
/*    @Override
    public IIcon getIconFromDamage(int damage) {

        return super.getIconFromDamage(damage);
    }*/

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        return super.getHarvestLevel(stack, toolClass) == -1 ? -1 : ProgPickUpgrades.getProperty(stack, "Harvest Level", 0);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1 - Math.min((double) ProgPickUpgrades.getExp(stack) / (double) ProgPickUpgrades.getMaxExp(stack), 1);
    }



    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World block, Block world, BlockPos pos, EntityLivingBase entityLivingBase) {
        ProgPickUpgrades.giveExp(itemStack, 1);
        return super.onBlockDestroyed(itemStack, block, world, pos, entityLivingBase);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List description, boolean par4) {
        description.add(EnumChatFormatting.AQUA + "Level " + ProgPickUpgrades.getLevel(stack));

        for (ProgPickUpgrade upg : ProgPickUpgrades.upgrades.values()) {
            int val = ProgPickUpgrades.getProperty(stack, upg.name, 0);
            if(val == 0 && !upg.name.equals("Harvest Level"))
                continue;
            description.add(EnumChatFormatting.BLUE + upg.name + EnumChatFormatting.GRAY + " " + upg.getDisplayLevel(val));
        }
    }

    @Override
    public float getDigSpeed(ItemStack stack, IBlockState block) {
        return super.getDigSpeed(stack, block) * getSpeedMultiplier(stack);
    }



    public float getSpeedMultiplier(ItemStack stack) {
        return (float) (ProgPickUpgrades.getLevel(stack) * 1.1);
    }
}