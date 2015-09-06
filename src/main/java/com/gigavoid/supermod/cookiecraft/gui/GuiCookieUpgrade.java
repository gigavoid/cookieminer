package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.ICookieUpgrade;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieCrafter;
import com.gigavoid.supermod.cookiecraft.util.CookieNumber;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.awt.*;

public class GuiCookieUpgrade extends GuiScreen {
	public static final int GUI_ID = 22;
	private World world;
	private BlockPos pos;

	public GuiCookieUpgrade(World world, BlockPos pos) {
		this.world = world;
		this.pos = pos;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		Block block = world.getBlockState(pos).getBlock();
		ICookieUpgrade upg = (ICookieUpgrade) block;
		double cps;
		int color;
		String connected;
		if (CookieNetwork.getNetwork(world, pos).findCrafter() != null) {
			cps = upg.getCPS(world, pos, world.getBlockState(pos));
			color = Color.GREEN.getRGB();
			connected = " (Connected)";
		} else {
			cps = 0;
			color = Color.RED.getRGB();
			connected = " (Not Connected)";
		}
		fontRendererObj.drawString("Generating CPS: " + CookieNumber.doubleToString(cps) + connected, width / 2, height / 2, color);

	}

}
