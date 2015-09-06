package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.util.Locale;

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
        fontRendererObj.drawString(String.format(Locale.US, "CPS: %s", CookieNumber.doubleToString(tileEntity.getCPS())), width / 2, height / 2, Color.GREEN.getRGB());

    }

    public GuiCookieCrafter(TileEntityCookieCrafter tileEntity) {
        this.tileEntity = tileEntity;
    }


}
