package com.MRG.ACGCraft.init;

import net.minecraft.block.material.Material;

import com.MRG.ACGCraft.block.BlockACGC;
import com.MRG.ACGCraft.block.BlockFailyTail;
import com.MRG.ACGCraft.block.BlockRepairTable;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockACGC FailyTail = new BlockFailyTail();
	public static final BlockRepairTable RepairTable = new BlockRepairTable(Material.rock);
	
	public static void init()
	{
		GameRegistry.registerBlock(FailyTail, "failytail");
		//GameRegistry.registerBlock(RepairTable, "repairtable");
	}
}
