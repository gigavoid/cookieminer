package com.gigavoid.supermod.bonus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SnuRRaN on 2015-02-14.
 */
public class BlockBonus extends Block {
    private Random random = new Random();

    public BlockBonus() {
        super(Material.rock);
        this.setHardness(20.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> bonusItems=new ArrayList<ItemStack>();
        bonusItems.add(new ItemStack(Blocks.diamond_block));
        bonusItems.add(new ItemStack(Blocks.lapis_block,5));
        bonusItems.add(new ItemStack(Items.redstone,64));
        int booknumber = random.nextInt(8);
        ItemStack book = new ItemStack(Items.enchanted_book, 1);
        if (booknumber == 0) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.looting, 3));
        }
        if (booknumber == 1) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.fortune, 3));
        }
        if (booknumber == 2) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.efficiency, 5));
        }
        if (booknumber == 3) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.unbreaking, 3));
        }
        if (booknumber == 4) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.silkTouch, 1));
        }
        if (booknumber == 5) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.field_180314_l, 5));
        }
        if (booknumber == 6) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.field_180310_c, 4));
        }
        if (booknumber == 7) {
            Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.field_180309_e, 4));
        }
        bonusItems.add(book);
        return bonusItems;
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        this.dropXpOnBlockBreak(worldIn, pos, 10000);
    }
}

