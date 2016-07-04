package com.gigavoid.supermod.cookiecraft.gui;

import com.gigavoid.supermod.cookiecraft.block.BlockCookieLavaConverter;
import com.gigavoid.supermod.cookiecraft.block.ICookieGenerator;
import com.gigavoid.supermod.cookiecraft.cookie.CookieNetwork;
import com.gigavoid.supermod.cookiecraft.tileentity.TileEntityCookieGenerator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLavaConverter extends GuiCookieGenerator {
    public static final int GUI_ID = 23;

    private static final ResourceLocation lavaConverterTexture = new ResourceLocation("supermod", "textures/gui/cookie_block_lava_converter.png");
    private final TileEntityCookieGenerator tileEntity;

    private static final int PROGRESSBAR_X = 26, PROGRESSBAR_Y = 76, PROGRESSBAR_WIDTH = 124, PROGRESSBAR_HEIGHT = 4;

    public GuiLavaConverter(InventoryPlayer playerInventory, TileEntityCookieGenerator tileEntity) {
        super(playerInventory, tileEntity);

        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        ICookieGenerator generator = (ICookieGenerator) tileEntity.getBlockType();
        double cps = generator.getModifiedCPS(tileEntity.getWorld(), tileEntity.getPos(), tileEntity.getWorld().getBlockState(tileEntity.getPos()));

        Boolean online = CookieNetwork.getNetwork(tileEntity.getWorld(), tileEntity.getPos()).findCore() != null;

        drawNetworkLight(mouseX, mouseY, x, y, online, lavaConverterTexture);
        drawGeneratingLight(mouseX, mouseY, x, y, cps, lavaConverterTexture);
        drawProgressBar();

        drawEffectivenessStrings(mouseX, mouseY, x, y, cps);
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(lavaConverterTexture);

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    private void drawProgressBar() {
        this.mc.getTextureManager().bindTexture(lavaConverterTexture);

        BlockCookieLavaConverter lavaConverter = (BlockCookieLavaConverter) tileEntity.getBlockType();
        int numberOfLavaBlocks = lavaConverter.nrOfLavaBlocks(tileEntity.getWorld(), tileEntity.getPos());

        int progressVisible = (int) (numberOfLavaBlocks / (double)25 * PROGRESSBAR_WIDTH);

        this.drawTexturedModalRect(PROGRESSBAR_X, PROGRESSBAR_Y,
                16, 166,
                progressVisible, PROGRESSBAR_HEIGHT);

    }
}
