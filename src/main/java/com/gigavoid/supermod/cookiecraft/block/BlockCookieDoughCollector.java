package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.ModuleCookiecraft;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.gui.GuiCookieGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieDoughCollector extends BlockCookieGeneratorBase implements ICookieGenerator {
    public static final BlockCookieDoughCollector instance = new BlockCookieDoughCollector();

    private BlockCookieDoughCollector() {
        super(Material.ROCK);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public double getCPS(World world, BlockPos pos, IBlockState state) {
        return ModuleCookiecraft.config.outputDoughCollector;
    }

    @Override
    public boolean canAcceptUpgrade(ItemStack itemStack) {
        return super.canAcceptUpgrade(itemStack) || itemStack.getItem() == Items.STONE_AXE;
    }
}
