package com.MRG.ACGCraft.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.init.ModBlocks;
import com.MRG.ACGCraft.utility.LogHelper;

public class BlockFailyTail extends BlockACGC {
	public BlockFailyTail()
	{
		super();
		this.setBlockName("FailyTail");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
		this.setHardness(7.0f);
		this.setStepSound(soundTypeStone);
		this.setResistance(5.0f);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		LogHelper.info("打破");
		return Item.getItemFromBlock(ModBlocks.FailyTail);
	}
	
	
}
