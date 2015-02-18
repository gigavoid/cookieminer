package com.gigavoid.supermod.common.module;

import com.gigavoid.supermod.common.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 2015-02-13.
 */
public class ModuleLoader {

    private List<Module> moduleList = new ArrayList<Module>();
    private Register register = new Register();
    
    public void registerModule(Module module) {
        module.setRegister(register);
        moduleList.add(module);
    }

    public void preInit(FMLPreInitializationEvent event) {
        for (Module module : moduleList) {
            module.preInit(event);
        }
    }

    public void init(FMLInitializationEvent event) {
        for (Module module : moduleList) {
            module.init(event);
        }
    }

    public void postInit(FMLPostInitializationEvent event) {
        for (Module module : moduleList) {
            module.postInit(event);
        }
    }
}
