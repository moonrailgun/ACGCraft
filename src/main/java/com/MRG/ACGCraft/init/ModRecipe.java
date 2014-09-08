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
		GameRegistry.addRecipe(new ItemStack(ModItems.GreyIceEmblemLV1), new Object[]{
			" A ",
			"ABA",
			" A ",
			Character.valueOf('A'),new ItemStack(Item.getItemFromBlock(Blocks.ice)),
			Character.valueOf('B'),ModBlocks.FailyTail
			
		});
	}
}
