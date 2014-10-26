package com.gigavoid.supermod.gui;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.container.PickBenchContainer;
import com.gigavoid.supermod.container.VoidBenchContainer;
import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import com.gigavoid.supermod.tileentity.VoidBenchTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class SuperGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(ID == PickBenchGui.GUI_ID && tileEntity instanceof PickBenchTileEntity )
            return new PickBenchContainer(player.inventory, (PickBenchTileEntity) tileEntity);
        else if(ID == VoidBenchGui.GUI_ID && tileEntity instanceof VoidBenchTileEntity)
            return new VoidBenchContainer(player.inventory, (VoidBenchTileEntity) tileEntity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(ID == PickBenchGui.GUI_ID && tileEntity instanceof PickBenchTileEntity)
            return new PickBenchGui(player.inventory, (PickBenchTileEntity) tileEntity);
        else if(ID == VoidBenchGui.GUI_ID && tileEntity instanceof VoidBenchTileEntity)
            return new VoidBenchGui(player.inventory, (VoidBenchTileEntity) tileEntity);
        return null;
    }

    public static void initializeGuis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(SuperMod.instance, new SuperGuiHandler());
        GameRegistry.registerTileEntity(PickBenchTileEntity.class, "pickBench");
        GameRegistry.registerTileEntity(VoidBenchTileEntity.class, "voidBench");
    }
}
