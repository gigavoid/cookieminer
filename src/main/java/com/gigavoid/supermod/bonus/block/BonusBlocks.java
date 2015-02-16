package com.gigavoid.supermod.bonus.block;

import com.gigavoid.supermod.common.Register;

public class BonusBlocks {
    public static final BlockBonus bonus = new BlockBonus();

    public static void initializeBlocks(Register register) {
        register.registerBlock(bonus, "bonus_block");
    }
}
