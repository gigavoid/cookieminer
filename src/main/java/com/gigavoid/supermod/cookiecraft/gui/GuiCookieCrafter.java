package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.client.gui.GuiScreen;

public class GuiCookieCrafter extends GuiScreen {
    public static final int GUI_ID = 20;
    private final TileEntityCookieCrafter tileEntity;

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        fontRendererObj.drawString("CPS: " + tileEntity.getCPS(), width / 2, height / 2, 0xff0000);

    }

    public GuiCookieCrafter(TileEntityCookieCrafter tileEntity) {
        this.tileEntity = tileEntity;
    }


}
