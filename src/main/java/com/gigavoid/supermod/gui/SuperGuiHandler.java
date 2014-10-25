package com.gigavoid.supermod.gui;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ineentho on 2014-10-25.
 */
public class SuperGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof PickBenchTileEntity){
            return new PickBenchContainer(player.inventory, (PickBenchTileEntity) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof PickBenchTileEntity){
            return new PickBenchGui(player.inventory, (PickBenchTileEntity) tileEntity);
        }
        return null;
    }

    public static void initializeGuis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(SuperMod.instance, new SuperGuiHandler());
    }
}
