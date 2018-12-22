package com.syselmity.mademarmelade.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends BlockDirt {

    public TestBlock() {
        super();
        this.setHardness(1);
        this.setStepSound(Block.soundTypePiston);
        this.setBlockName("testblock");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName("netherrack");
    }

}
