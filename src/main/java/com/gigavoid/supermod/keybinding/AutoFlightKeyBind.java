package com.gigavoid.supermod.keybinding;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-11-26.
 */
public class AutoFlightKeyBind extends SuperKeyBinding {

    public static boolean autoFlying = false;

    public AutoFlightKeyBind() {
        super("Auto Flight", Keyboard.KEY_R, "Super Mod");
    }

    @Override
    public void Pressed() {
        autoFlying = !autoFlying;
        KeyBinding.setKeyBindState(Keyboard.KEY_W, autoFlying);

    }
}
