package com.syselmity.mademarmelade.common;

import com.syselmity.mademarmelade.common.block.TestBlock;
import com.syselmity.mademarmelade.common.proxy.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;

import static cpw.mods.fml.common.FMLLog.log;

@Mod(modid = MadeMarmelade.MODID, useMetadata = true)
public class MadeMarmelade {

    public static final String MODID = "mademarmelade";
    public static final String PACKAGE = "com.syselmity.mademarmelade";

    @Mod.Instance(MadeMarmelade.MODID)
    private static MadeMarmelade instance;

    @SidedProxy(clientSide = PACKAGE + ".client.proxy.ClientProxy", serverSide = PACKAGE + ".server.proxy.ServerProxy")
    private static IProxy proxy;

    public static MadeMarmelade getInstance() {
        return instance;
    }

    public static IProxy getProxy() {
        return proxy;
    }

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.registerBlocks();
        log(Level.INFO, "Test TTEEESSSTT Test 123 Testtt Teset 124");
    }

}
