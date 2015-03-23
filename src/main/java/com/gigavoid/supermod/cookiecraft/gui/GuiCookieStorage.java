package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieStorage;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import net.minecraft.client.gui.GuiScreen;

public class GuiCookieStorage extends GuiScreen {
    public static final int GUI_ID = 21;
    private final TileEntityCookieStorage tileEntity;

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

		ICookieStorage storage = (ICookieStorage) tileEntity.getBlockType();
        fontRendererObj.drawString("Cookies: " + tileEntity.getCookies() + " out of " + storage.getStorageCap(), width / 2, height / 2, 0xff0000);

    }

    public GuiCookieStorage(TileEntityCookieStorage tileEntity) {
        this.tileEntity = tileEntity;
    }


}
