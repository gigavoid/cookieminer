package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieStorageBlock;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieStorage;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCookieStorage extends GuiContainer {
    public static final int GUI_ID = 21;
    private final TileEntityCookieStorage tileEntity;
	private static final ResourceLocation cookieStorageGuiTexture = new ResourceLocation("supermod", "textures/gui/cookie_storage.png");

	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		ICookieStorageBlock storage = (ICookieStorageBlock) tileEntity.getBlockType();
		fontRendererObj.drawString("Cookies: " + CookieNumber.doubleToString(tileEntity.getCookies()) + " out of " + CookieNumber.doubleToString(storage.getStorageCap()), 5, 5, 0x222222);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(cookieStorageGuiTexture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	public GuiCookieStorage(InventoryPlayer playerInventory, TileEntityCookieStorage tileEntity) {
		super(new ContainerCookieStorage(playerInventory, tileEntity));
		this.tileEntity = tileEntity;
    }
}
