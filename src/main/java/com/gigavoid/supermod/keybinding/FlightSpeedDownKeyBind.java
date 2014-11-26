package com.gigavoid.supermod.keybinding;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-11-26.
 */
public class FlightSpeedDownKeyBind extends SuperKeyBinding {

    public FlightSpeedDownKeyBind() {
        super("Flight speed down", Keyboard.KEY_SUBTRACT, "Super Mod");
    }

    @Override
    public void Pressed() {
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        player.capabilities.setFlySpeed(player.capabilities.getFlySpeed() * .8f);
    }
}
