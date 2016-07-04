package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieStorageBlock;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieStorage;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieStorage;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GuiCookieStorage extends GuiContainer {
    public static final int GUI_ID = 21;
    private final TileEntityCookieStorage tileEntity;
	private static final ResourceLocation cookieStorageGuiTexture = new ResourceLocation("supermod", "textures/gui/cookie_storage.png");

	private static final int PROGRESSBAR_X = 148, PROGRESSBAR_Y = 15, PROGRESSBAR_HEIGHT = 54, PROGRESSBAR_WIDTH = 13;

	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(cookieStorageGuiTexture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		ICookieStorageBlock storage = (ICookieStorageBlock) tileEntity.getBlockType();

		CookieNetwork network = CookieNetwork.getNetwork(tileEntity.getWorld(), tileEntity.getPos());

		Boolean online = network.findCore() != null;

		if (online) {
			// Draw green light
			this.drawTexturedModalRect(6, 73, 8, 166, 8, 8);
		} else {
			// Draw red light
			this.drawTexturedModalRect(6, 73, 0, 166, 8, 8);
		}

		double fractionFull = (double)tileEntity.getCookies() / storage.getStorageCap();

		int progressVisible = (int)(fractionFull * 54);

		// Draw progress bar
		this.drawTexturedModalRect(PROGRESSBAR_X,  PROGRESSBAR_Y + (PROGRESSBAR_HEIGHT - progressVisible),
				176, PROGRESSBAR_HEIGHT - progressVisible,
				PROGRESSBAR_WIDTH, progressVisible);

		// Network tooltip
		List<String> statusTooltip = Collections.singletonList("Connected to cookie network: " +
				(online ? EnumChatFormatting.GREEN + "Online" : EnumChatFormatting.RED + "Offline"));

		if (this.isPointInRegion(6, 73, 8, 8, mouseX, mouseY)) {
			this.drawHoveringText(statusTooltip, mouseX - x, mouseY - y);
		}

		// Storage tooltip
		List<String> storageTooltip = Arrays.asList("Stored Cookies:",
				CookieNumber.doubleToString(tileEntity.getCookies()) + " / " + CookieNumber.doubleToString(storage.getStorageCap()));

		// Storage tooltip
		if (this.isPointInRegion(PROGRESSBAR_X, PROGRESSBAR_Y, PROGRESSBAR_WIDTH, PROGRESSBAR_HEIGHT, mouseX, mouseY)) {
			this.drawHoveringText(storageTooltip, mouseX - x, mouseY - y);
		}

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
