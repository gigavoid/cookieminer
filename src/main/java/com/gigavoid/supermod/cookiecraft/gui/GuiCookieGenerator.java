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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiCookieGenerator extends GuiContainer {
	public static final int GUI_ID = 22;
	private InventoryPlayer playerInventory;
	private TileEntityCookieGenerator tileEntity;
	private static final ResourceLocation cookieGeneratorGuiTexture = new ResourceLocation("supermod", "textures/gui/cookie_storage.png");


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
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		ICookieGenerator generator = (ICookieGenerator) tileEntity.getBlockType();
		double cps;
		int color;
		String connected;
		if (CookieNetwork.getNetwork(tileEntity.getWorld(), tileEntity.getPos()).findCore() != null) {
			cps = generator.getCPS(tileEntity.getWorld(), tileEntity.getPos(), tileEntity.getWorld().getBlockState(tileEntity.getPos()));
			color = Color.GREEN.getRGB();
			connected = " (Connected)";
		} else {
			cps = 0;
			color = Color.RED.getRGB();
			connected = " (Not Connected)";
		}
		fontRendererObj.drawString("Generating CPS: " + CookieNumber.doubleToString(cps) + connected, width / 2, height / 2, color);
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
