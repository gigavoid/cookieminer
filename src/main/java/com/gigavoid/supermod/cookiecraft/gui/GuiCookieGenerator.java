package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieGenerator;
import com.gigavoid.supermod.cookiecraft.block.ICookieStorageBlock;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieGenerator;
import com.gigavoid.supermod.cookiecraft.container.ContainerCookieStorage;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.awt.*;
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
		this.mc.getTextureManager().bindTexture(cookieGeneratorGuiTexture);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		ICookieGenerator generator = (ICookieGenerator) tileEntity.getBlockType();
		double cps = generator.getCPS(tileEntity.getWorld(), tileEntity.getPos(), tileEntity.getWorld().getBlockState(tileEntity.getPos()));

		Boolean online = CookieNetwork.getNetwork(tileEntity.getWorld(), tileEntity.getPos()).findCore() != null;

		// Network lights
		if (online) {
			// Draw green network light
			this.drawTexturedModalRect(6, 73, 8, 166, 8, 8);
		} else {
			// Draw red network light
			this.drawTexturedModalRect(6, 73, 0, 166, 8, 8);
		}


		// Generating lights
		if (cps != 0) {
			// Draw green generating light
			this.drawTexturedModalRect(6, 65, 8, 166, 8, 8);
		} else {
			// Draw red generating light
			this.drawTexturedModalRect(6, 65, 0, 166, 8, 8);
		}

		fontRendererObj.drawString(CookieNumber.doubleToString(cps), 39, 11, 0x222222);

		// Network tooltip
		java.util.List<String> statusTooltip = Collections.singletonList("Connected to cookie network: " +
				(online ? EnumChatFormatting.GREEN + "Online" : EnumChatFormatting.RED + "Offline"));

		if (this.isPointInRegion(6, 73, 6, 6, mouseX, mouseY)) {
			this.drawHoveringText(statusTooltip, mouseX - x, mouseY - y);
		}

		// Generating tooltip
		List<String> generatingTooltip = Collections.singletonList("Is block generating cookies: " +
				(cps != 0 ? EnumChatFormatting.GREEN + "Active" : EnumChatFormatting.RED + "Inactive"));

		if (this.isPointInRegion(6, 65, 6, 6, mouseX, mouseY)) {
			this.drawHoveringText(generatingTooltip, mouseX - x, mouseY - y);
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

}
