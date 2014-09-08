package com.MRG.ACGCraft.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.item.ItemACGC;
import com.MRG.ACGCraft.item.ItemGreyIceEmblemLV1;
import com.MRG.ACGCraft.item.ItemMapleLeaf;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemACGC mapleLeaf = new ItemMapleLeaf(); 
	public static final ItemACGC GreyIceEmblemLV1 = new ItemGreyIceEmblemLV1(); 
	public static final Item GreyIceSword = new com.MRG.ACGCraft.item.ItemGreyIceSword() ;
	
	public static void init() {
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
		GameRegistry.registerItem(GreyIceEmblemLV1, "GreyIceEmblemLV1");
		GameRegistry.registerItem(GreyIceSword, "GreyIceSword");
	}
}
