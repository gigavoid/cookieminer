package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

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
        fontRendererObj.drawString("CPS: " + Math.round(tileEntity.getCPS() * 1000d) / 1000d, width / 2, height / 2, Color.GREEN.getRGB());

    }

    public GuiCookieCrafter(TileEntityCookieCrafter tileEntity) {
        this.tileEntity = tileEntity;
    }


}
