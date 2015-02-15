package com.gigavoid.supermod.bonus.block;
import static com.gigavoid.supermod.common.Register.registerBlock;
/**
 * Created by SnuRRaN on 2015-02-14.
 */
public class BonusBlocks {
    public static final BlockBonus bonus=new BlockBonus();
    public static void initializeBlocks() {
        registerBlock(bonus,"bonus_block");
    }
}
