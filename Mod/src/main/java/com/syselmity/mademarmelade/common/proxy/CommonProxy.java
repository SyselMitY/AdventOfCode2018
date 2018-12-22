package com.syselmity.mademarmelade.common.proxy;

import com.syselmity.mademarmelade.common.block.TestBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy {

    public static final TestBlock testblock = new TestBlock();

    public void registerBlocks() {
        GameRegistry.registerBlock(testblock, testblock.getUnlocalizedName());
    }

    public void registerRecipes() {

    }

}
