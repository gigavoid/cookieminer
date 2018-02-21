package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import com.gigavoid.supermod.cookiecraft.item.IItemCookieUpgrade;
import com.gigavoid.supermod.cookiecraft.item.ItemFlatCPSUpgrade;
import com.gigavoid.supermod.cookiecraft.item.ItemMultiplicativeCPSUpgrade;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import com.gigavoid.supermod.cookiecraft.upgrade.MultiplicativeBoost;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public abstract class BlockCookieGeneratorBase extends BlockCookieNetworkBase implements ICookieGenerator{
    public BlockCookieGeneratorBase(String name, Material material) {
        super(name, material);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieGenerator();
    }


    public TileEntityCookieGenerator getTileEntity(World world, BlockPos pos) {
        return (TileEntityCookieGenerator) world.getTileEntity(pos);
    }


    public boolean canAcceptUpgrade(ItemStack itemStack) {
        return itemStack.getItem() instanceof ItemFlatCPSUpgrade || itemStack.getItem() instanceof ItemMultiplicativeCPSUpgrade;
    }

    @Override
    public int getGuiId() {
        return GuiCookieGenerator.GUI_ID;
    }

    @Override
    public double getModifiedCPS(World world, BlockPos pos, IBlockState state) {
        double cps = this.getCPS(world, pos, state);

        double flatBoosts = 0;
        Map<String, Double> multiplicativeBoosts = new HashMap<>();

        TileEntityCookieGenerator tileEntity = getTileEntity(world, pos);
        double efficiency = 1.2;
        for (ItemStack stack : tileEntity.getUpgrades()) {
            efficiency -= .2;
            final double finalEfficiency = efficiency;
            if (stack == null) {
                continue;
            }
            if (stack.getItem() instanceof IItemCookieUpgrade) {
                IItemCookieUpgrade upgrade = (IItemCookieUpgrade) stack.getItem();

                flatBoosts += upgrade.getFlatBoost() * stack.getCount() * efficiency;

                MultiplicativeBoost multiplicativeBoost = upgrade.getMultiplicativeBoost();

                if (multiplicativeBoost != null) {
                    multiplicativeBoosts.computeIfPresent(multiplicativeBoost.getKey(), (k, v) -> v + multiplicativeBoost.getBoost() * finalEfficiency * stack.getCount());
                    multiplicativeBoosts.putIfAbsent(multiplicativeBoost.getKey(), multiplicativeBoost.getBoost() * efficiency * stack.getCount());
                }
            }
        }

        cps += flatBoosts;

        for (Double boost : multiplicativeBoosts.values()) {
            cps *= boost;
        }

        return cps;
    }
}
