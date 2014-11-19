package com.gigavoid.supermod.chat;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Created by ineentho on 2014-11-06.
 */
public class SuperChatCommands {
    public static void initializeChatCommands(FMLServerStartingEvent e) {
        e.registerServerCommand(new SpawnLineCommand());
    }
}
