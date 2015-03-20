package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieCrafter extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final RegistryDefaulted dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());


    public BlockCookieCrafter() {
        super(Material.rock);
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
    }

    @Override
    public int tickRate(World worldIn) {
        return 20;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote)
        {
            System.out.println("Kasta kaka!");
            throwCookie(worldIn, pos);
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        }
    }

    private void throwCookie(World worldIn, BlockPos blockPos) {
        ItemStack cookie = new ItemStack(Items.cookie);
        BlockSourceImpl blockSource = new BlockSourceImpl(worldIn, blockPos);

        getDispensBehaviour(cookie).dispense(blockSource, cookie);
    }

    protected IBehaviorDispenseItem getDispensBehaviour(ItemStack itemStack)
    {
        return (IBehaviorDispenseItem)dispenseBehaviorRegistry.getObject(itemStack == null ? null : itemStack.getItem());
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookieCrafter();
    }
}
