package com.gigavoid.supermod.keybinding;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import scala.Array;

import java.util.List;

/**
 * Created by ineentho on 2014-10-25.
 */
public class SuperKeyBinds {
    public static SuperKeyBinding[] keybinds =  {
            new UpgradeToolKeyBind()
    };

    public static void registerKeybinds() {
        FMLCommonHandler.instance().bus().register(new SuperKeyBinds());

        for(SuperKeyBinding keyBind: keybinds)
            ClientRegistry.registerKeyBinding(keyBind);

    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (FMLClientHandler.instance().isGUIOpen(GuiChat.class))
            return;

        for(SuperKeyBinding keyBind: keybinds)
            if(keyBind.isPressed())
                keyBind.Pressed();
    }
}
