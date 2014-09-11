package com.MRG.ACGCraft.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.item.ItemACGC;
import com.MRG.ACGCraft.item.ItemEndIce;
import com.MRG.ACGCraft.item.ItemEndIcePearl;
import com.MRG.ACGCraft.item.ItemGreyIceEmblemLV1;
import com.MRG.ACGCraft.item.ItemGreyIceEmblemLV2;
import com.MRG.ACGCraft.item.ItemGreyIceEmblemLV3;
import com.MRG.ACGCraft.item.ItemMapleLeaf;
import com.MRG.ACGCraft.item.ItemOPFlameFruit;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemACGC mapleLeaf = new ItemMapleLeaf(); 
	public static final ItemACGC GreyIceEmblemLV1 = new ItemGreyIceEmblemLV1(); 
	public static final ItemACGC GreyIceEmblemLV2 = new ItemGreyIceEmblemLV2(); 
	public static final ItemACGC GreyIceEmblemLV3 = new ItemGreyIceEmblemLV3(); 
	public static final ItemACGC EndIce = new ItemEndIce();
	public static final Item GreyIceSword = new com.MRG.ACGCraft.item.ItemGreyIceSword() ;
	public static final Item OPFlameFruit = new ItemOPFlameFruit(); 
	public static final Item EndIcePearl = new ItemEndIcePearl(); 
	
	public static void init() {
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
		GameRegistry.registerItem(GreyIceEmblemLV1, "GreyIceEmblemLV1");
		GameRegistry.registerItem(GreyIceEmblemLV2, "GreyIceEmblemLV2");
		GameRegistry.registerItem(GreyIceEmblemLV3, "GreyIceEmblemLV3");
		GameRegistry.registerItem(EndIce, "EndIce");
		GameRegistry.registerItem(EndIcePearl, "EndIcePearl");
		GameRegistry.registerItem(GreyIceSword, "GreyIceSword");
		GameRegistry.registerItem(OPFlameFruit, "OPFlameFruit");
	}
}
