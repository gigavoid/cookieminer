package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.creativetab.CookiecraftCreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookieAcceleratorControl extends BlockCookieAcceleratorBase {
    public BlockCookieAcceleratorControl() {
        super();
        setCreativeTab(CookiecraftCreativeTabs.tabCookiecraft);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    public void updateAcceleratorBlocks(World world, BlockPos pos){
        if (!world.isRemote) {
            boolean built = isAcceleratorBuilt(world, pos);
            CookieNetwork.getNetwork(world, pos).updateAcceleratorBlocks(built);
            System.out.println(built);
        }
    }

    private boolean isAcceleratorBuilt(IBlockAccess world, BlockPos pos){
        boolean north = world.getBlockState(pos.offsetNorth()).getBlock() instanceof BlockCookieAcceleratorBase;
        boolean east = world.getBlockState(pos.offsetEast()).getBlock() instanceof BlockCookieAcceleratorBase;

        int length = 0;
        while (length < 64){
            if (north){
                if (world.getBlockState(pos.offsetNorth(length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                    length++;
                }
                else
                    break;
            }
            else if (world.getBlockState(pos.offsetSouth(length)).getBlock() instanceof BlockCookieAcceleratorBase) {
                length++;
            }
            else
                break;
        }

        if (length < 8){
            return false;
        }

        boolean outerConnected = true;
        for (int i = 0; i < length && outerConnected; i++){
            if (north && east){
                if (!(world.getBlockState(pos.offsetNorth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetNorth(i).offsetEast(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i).offsetNorth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (north && !east){
                if (!(world.getBlockState(pos.offsetNorth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetNorth(i).offsetWest(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i).offsetNorth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (!north && east){
                if (!(world.getBlockState(pos.offsetSouth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetSouth(i).offsetEast(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetEast(i).offsetSouth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
            if (!north && !east){
                if (!(world.getBlockState(pos.offsetSouth(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetSouth(i).offsetWest(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
                if (!(world.getBlockState(pos.offsetWest(i).offsetSouth(length - 1)).getBlock() instanceof BlockCookieAcceleratorBase)){
                    outerConnected = false;
                }
            }
        }

        return outerConnected;
    }
}
