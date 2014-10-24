package com.gigavoid.supermod.keybinding;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by ineentho on 2014-10-25.
 */
public class SuperKeybinds {
    public static void registerKeybinds() {
        ClientRegistry.registerKeyBinding(new KeyBinding("upgradeTool", Keyboard.KEY_P, "superMod"));
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (FMLClientHandler.instance().isGUIOpen(GuiChat.class))
            return;
        
    }
}
