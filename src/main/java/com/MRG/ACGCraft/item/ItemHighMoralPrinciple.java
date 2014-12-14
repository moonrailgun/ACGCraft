package com.MRG.ACGCraft.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHighMoralPrinciple extends ItemACGC {
	public ItemHighMoralPrinciple()
	{
		super();
		this.setUnlocalizedName("HighMoralPrinciple");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
		this.maxStackSize = 50;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	{
		p_77624_3_.add(StatCollector.translateToLocal("display.ACGCraft:HighMoralPrinciple.Line1"));
		p_77624_3_.add(StatCollector.translateToLocal("display.ACGCraft:HighMoralPrinciple.Line2"));
	}
	
}
