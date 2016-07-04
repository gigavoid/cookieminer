package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.SuperMod;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieGenerator;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieStorage;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CookiecraftGuis implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == GuiCookieStorage.GUI_ID && tileEntity instanceof TileEntityCookieStorage)
            return new ContainerCookieStorage(player.inventory, (TileEntityCookieStorage) tileEntity);
        if(ID == GuiCookieGenerator.GUI_ID && tileEntity instanceof TileEntityCookieGenerator)
            return new ContainerCookieGenerator(player.inventory, (TileEntityCookieGenerator) tileEntity);
        if(ID == GuiLavaConverter.GUI_ID && tileEntity instanceof TileEntityCookieGenerator)
            return new ContainerCookieGenerator(player.inventory, (TileEntityCookieGenerator) tileEntity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if (ID == GuiCookieCrafter.GUI_ID && tileEntity instanceof TileEntityCookieCrafter)
			return new GuiCookieCrafter((TileEntityCookieCrafter) tileEntity);
		if (ID == GuiCookieStorage.GUI_ID && tileEntity instanceof TileEntityCookieStorage)
			return new GuiCookieStorage(player.inventory, (TileEntityCookieStorage) tileEntity);
        if (ID == GuiCookieGenerator.GUI_ID && tileEntity instanceof TileEntityCookieGenerator)
            return new GuiCookieGenerator(player.inventory, (TileEntityCookieGenerator) tileEntity);
        if (ID == GuiLavaConverter.GUI_ID && tileEntity instanceof TileEntityCookieGenerator)
            return new GuiLavaConverter(player.inventory, (TileEntityCookieGenerator) tileEntity);
        return null;
    }

    public static void initializeGuis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(SuperMod.instance, new CookiecraftGuis());
    }
}
