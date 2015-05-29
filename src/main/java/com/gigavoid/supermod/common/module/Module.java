package com.gigavoid.supermod.common.module;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Henrik on 2015-02-13.
*/
public abstract class Module {
    private Register register;

    protected void setRegister(Register register) {
        this.register = register;
    }

    public Register getRegister(Side side) {
		register.setSide(side);
        return register;
    }

    public void preInit(FMLPreInitializationEvent e) {} ;
    public void init(FMLInitializationEvent e) {};
    public void postInit(FMLPostInitializationEvent e) {};
}
