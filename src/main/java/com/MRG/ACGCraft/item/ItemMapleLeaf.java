package com.MRG.ACGCraft.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemMapleLeaf extends ItemACGC{
	public ItemMapleLeaf()
	{
		super();
		this.setUnlocalizedName("mapleLeaf");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
	}
}