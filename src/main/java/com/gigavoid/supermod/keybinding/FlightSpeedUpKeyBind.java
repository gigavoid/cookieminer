package com.gigavoid.supermod.keybinding;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-11-26.
 */
public class FlightSpeedUpKeyBind extends SuperKeyBinding {
    public FlightSpeedUpKeyBind() {
        super("Flight speed up", Keyboard.KEY_ADD, "Super Mod");
    }

    @Override
    public void Pressed() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        player.capabilities.setFlySpeed(player.capabilities.getFlySpeed() * 1.2f);
    }
}
