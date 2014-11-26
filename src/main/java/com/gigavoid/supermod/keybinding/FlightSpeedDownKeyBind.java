package com.gigavoid.supermod.keybinding;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-11-26.
 */
public class FlightSpeedDownKeyBind extends SuperKeyBinding {
    public static boolean autoFlying = false;

    public FlightSpeedDownKeyBind() {
        super("Flight speed down", Keyboard.KEY_SUBTRACT, "Super Mod");
    }

    @Override
    public void Pressed() {
        autoFlying = !autoFlying;
        KeyBinding.setKeyBindState(Keyboard.KEY_W, autoFlying);
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        player.capabilities.setFlySpeed(player.capabilities.getFlySpeed() * .8f);
    }
}
