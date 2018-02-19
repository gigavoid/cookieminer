package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieGenerator;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieGenerator;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.*;
import java.util.List;

public class GuiCookieGenerator extends GuiContainer {
	public static final int GUI_ID = 22;
	private InventoryPlayer playerInventory;
	private TileEntityCookieGenerator tileEntity;
	private static final ResourceLocation cookieGeneratorGuiTexture = new ResourceLocation("supermod", "textures/gui/cookie_block_general.png");


	public GuiCookieGenerator(InventoryPlayer playerInventory, TileEntityCookieGenerator tileEntity) {
		super(new ContainerCookieGenerator(playerInventory, tileEntity));
		this.playerInventory = playerInventory;
		this.tileEntity = tileEntity;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		ICookieGenerator generator = (ICookieGenerator) tileEntity.getBlockType();
		double cps = generator.getModifiedCPS(tileEntity.getWorld(), tileEntity.getPos(), tileEntity.getWorld().getBlockState(tileEntity.getPos()));

		Boolean online = CookieNetwork.getNetwork(tileEntity.getWorld(), tileEntity.getPos()).findCore() != null;

		drawNetworkLight(online, cookieGeneratorGuiTexture);
		drawGeneratingLight(cps, cookieGeneratorGuiTexture);
		drawEffectivenessStrings();
		drawCps(cps);

		drawNetworkTooltip(mouseX, mouseY, x, y, online);
		drawGeneratingTooltip(mouseX, mouseY, x, y, cps);
		drawEffectivenessTooltips(mouseX, mouseY, x, y);
	}

	public void drawCps(double cps) {
		fontRenderer.drawString(CookieNumber.doubleToString(cps), 39, 11, 0x222222);
	}

	public void drawEffectivenessTooltips(int mouseX, int mouseY, int x, int y) {
		for (int i = 0; i < 4; i++) {
			String str = (100 - i * 20) + "%";
			int width = fontRenderer.getStringWidth(str);
			int height = fontRenderer.FONT_HEIGHT;
			int strX = 26 + i * 36 + 8 - width / 2;
			int strY = 45;

			List<String> percentTooltip = Collections.singletonList(String.format("Upgrades in this slot are %s effective", ChatFormatting.AQUA + str + ChatFormatting.WHITE));


			if (this.isPointInRegion(strX, strY, width, height, mouseX, mouseY)) {
				this.drawHoveringText(percentTooltip, mouseX - x, mouseY - y);
			}
		}
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(cookieGeneratorGuiTexture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	public void drawEffectivenessStrings() {
		for (int i = 0; i < 4; i++) {
			String str = (100 - i * 20) + "%";
			int width = fontRenderer.getStringWidth(str);
			int strX = 26 + i * 36 + 8 - width / 2;
			int strY = 45;
			fontRenderer.drawString(str, strX, strY, 0x666666);
		}
	}

	public void drawGeneratingLight(double cps, ResourceLocation texture) {
		this.mc.getTextureManager().bindTexture(texture);

		// Generating lights
		if (cps != 0) {
			// Draw green generating light
			this.drawTexturedModalRect(6, 65, 8, 166, 8, 8);
		} else {
			// Draw red generating light
			this.drawTexturedModalRect(6, 65, 0, 166, 8, 8);
		}

		// Generating tooltip
	}

	public void drawNetworkLight(Boolean online, ResourceLocation texture) {
		this.mc.getTextureManager().bindTexture(texture);

		// Network lights
		if (online) {
			// Draw green network light
			this.drawTexturedModalRect(6, 73, 8, 166, 8, 8);
		} else {
			// Draw red network light
			this.drawTexturedModalRect(6, 73, 0, 166, 8, 8);
		}

	}

	public void drawNetworkTooltip(int mouseX, int mouseY, int x, int y, Boolean online) {
		// Network tooltip
		List<String> statusTooltip = Collections.singletonList("Connected to cookie network: " +
				(online ? ChatFormatting.GREEN + "True" : ChatFormatting.RED + "False"));

		if (this.isPointInRegion(6, 73, 6, 6, mouseX, mouseY)) {
			this.drawHoveringText(statusTooltip, mouseX - x, mouseY - y);
		}
	}

	public void drawGeneratingTooltip(int mouseX, int mouseY, int x, int y, double cps) {
		List<String> generatingTooltip = Collections.singletonList("Is block generating cookies: " +
				(cps != 0 ? ChatFormatting.GREEN + "Active" : ChatFormatting.RED + "Inactive"));

		if (this.isPointInRegion(6, 65, 6, 6, mouseX, mouseY)) {
			this.drawHoveringText(generatingTooltip, mouseX - x, mouseY - y);
		}
	}

}
