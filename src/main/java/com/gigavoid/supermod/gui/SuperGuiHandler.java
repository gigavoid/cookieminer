package com.gigavoid.supermod.gui;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.container.PickBenchContainer;
import com.gigavoid.supermod.container.VoidBenchContainer;
import com.gigavoid.supermod.tileentity.PickBenchTileEntity;
import com.gigavoid.supermod.tileentity.VoidBenchTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class SuperGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == PickBenchGui.GUI_ID && tileEntity instanceof PickBenchTileEntity )
            return new PickBenchContainer(player.inventory, (PickBenchTileEntity) tileEntity);
        else if(ID == VoidBenchGui.GUI_ID && tileEntity instanceof VoidBenchTileEntity)
            return new VoidBenchContainer(player.inventory, (VoidBenchTileEntity) tileEntity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == PickBenchGui.GUI_ID && tileEntity instanceof PickBenchTileEntity)
            return new PickBenchGui(player.inventory, (PickBenchTileEntity) tileEntity);
        else if(ID == VoidBenchGui.GUI_ID && tileEntity instanceof VoidBenchTileEntity)
            return new VoidBenchGui(player.inventory, (VoidBenchTileEntity) tileEntity);
        return null;
    }

    public static void initializeGuis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(SuperMod.instance, new SuperGuiHandler());
    }
}
