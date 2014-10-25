package com.gigavoid.supermod.keybinding;

import net.minecraft.client.settings.KeyBinding;

/**
 * Created by ineentho on 2014-10-25.
 */
public abstract class SuperKeyBinding extends KeyBinding {
    public SuperKeyBinding(String name, int key, String category) {
        super(name, key, category);
    }

    public abstract void Pressed();
}
