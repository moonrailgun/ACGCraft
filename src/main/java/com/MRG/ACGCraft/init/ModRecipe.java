package com.MRG.ACGCraft.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.MRG.ACGCraft.block.BlockFailyTail;
import com.MRG.ACGCraft.item.ItemACGC;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModRecipe {
	public static void init() {
		//GreyIceEmblemLV1
		GameRegistry.addRecipe(new ItemStack(ModItems.GreyIceEmblemLV1), new Object[]{
			" A ",
			"ABA",
			" A ",
			Character.valueOf('A'),new ItemStack(Item.getItemFromBlock(Blocks.ice)),
			Character.valueOf('B'),ModBlocks.FailyTail
		});
		
		//GreyIceEmblemLV2
		GameRegistry.addRecipe(new ItemStack(ModItems.GreyIceEmblemLV2), new Object[]{
			"ABA",
			"BCB",
			"ABA",
			Character.valueOf('A'),new ItemStack(Item.getItemFromBlock(Blocks.ice)),
			Character.valueOf('B'),ModBlocks.FailyTail,
			Character.valueOf('C'),ModItems.GreyIceEmblemLV1
		});
		
		//GreyIceEmblemLV3
		GameRegistry.addRecipe(new ItemStack(ModItems.GreyIceEmblemLV3), new Object[]{
			"ABA",
			"BCB",
			"ABA",
			Character.valueOf('A'),ModBlocks.FailyTail,
			Character.valueOf('B'),ModItems.GreyIceEmblemLV1,
			Character.valueOf('C'),ModItems.GreyIceEmblemLV2
		});
		
		//EndIce
		GameRegistry.addRecipe(new ItemStack(ModItems.EndIce), new Object[]{
			"ABA",
			"BCB",
			"ABA",
			Character.valueOf('A'),ModBlocks.FailyTail,
			Character.valueOf('B'),ModItems.GreyIceEmblemLV3,
			Character.valueOf('C'),Items.nether_star
		});
		
		//EndIcePearl
		GameRegistry.addRecipe(new ItemStack(ModItems.EndIcePearl), new Object[]{
			"CBC",
			"DAD",
			"CBC",
			Character.valueOf('A'),Items.ender_pearl,
			Character.valueOf('B'),ModItems.EndIce,
			Character.valueOf('C'),ModItems.GreyIceEmblemLV3,
			Character.valueOf('D'),Items.diamond
		});				
		
		//GreyIceSword
		GameRegistry.addRecipe(new ItemStack(ModItems.GreyIceSword), new Object[]{
			"ABA",
			Character.valueOf('A'),ModItems.GreyIceEmblemLV1,
			Character.valueOf('B'),Items.diamond_sword
		});
		
		//OPFlameFruit
		GameRegistry.addRecipe(new ItemStack(ModItems.OPFlameFruit), new Object[]{
			" A ",
			"BCD",
			" A ",
			Character.valueOf('A'),Items.coal,
			Character.valueOf('B'),Items.blaze_powder,
			Character.valueOf('C'),Items.apple,
			Character.valueOf('D'),Items.blaze_rod
		});
	}
}
