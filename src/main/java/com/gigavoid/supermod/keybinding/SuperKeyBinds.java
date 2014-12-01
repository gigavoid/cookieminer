package com.gigavoid.supermod.keybinding;

import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * Created by ineentho on 2014-10-25.
 */
public class SuperKeyBinds {
    public static SuperKeyBinding[] keybinds =  {
            new UpgradeToolKeyBind(),
            new AutoFlightKeyBind(),
            new FlightSpeedUpKeyBind(),
            new FlightSpeedDownKeyBind()
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
