package com.MRG.ACGCraft.init;

import com.MRG.ACGCraft.block.BlockACGC;
import com.MRG.ACGCraft.block.BlockFailyTail;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockACGC FailyTail = new BlockFailyTail();
	
	public static void init()
	{
		GameRegistry.registerBlock(FailyTail, "failytail");
	}
}
