package com.gigavoid.supermod.item.pickaxe;

import com.gigavoid.supermod.gui.ProgPickUpgrades;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ProgressivePickaxeItem extends ItemPickaxe {
    private String material;
    private int level;

    IIcon pickCanBeUpgraded;

    public ProgressivePickaxeItem() {
        super(ToolMaterial.WOOD);
        setMaxDamage(-1);
        setTextureName("supermod:prog_pickaxe");
    }

    public void setToolLevel(int level) {
        this.level = level;

    }

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

/*    @Override
    public IIcon getIconFromDamage(int damage) {

        return super.getIconFromDamage(damage);
    }*/

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass) {
        return super.getHarvestLevel(stack, toolClass) == -1 ? -1 : 4;
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
    public boolean onBlockDestroyed(ItemStack itemStack, World block, Block world, int x, int y, int z, EntityLivingBase entityLivingBase) {
        ProgPickUpgrades.giveExp(itemStack, 1);
        return super.onBlockDestroyed(itemStack, block, world, x, y, z, entityLivingBase);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer entityPlayer, List description, boolean par4) {
        description.add(EnumChatFormatting.GRAY + "Level " + ProgPickUpgrades.getLevel(stack));
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        return super.getDigSpeed(stack, block, meta) * getSpeedMultiplier(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return "Progressive Pickaxe (Level " + ProgPickUpgrades.getLevel(stack) + ")";
    }



    public float getSpeedMultiplier(ItemStack stack) {
        return (float) (ProgPickUpgrades.getLevel(stack) * 1.1);
    }
}