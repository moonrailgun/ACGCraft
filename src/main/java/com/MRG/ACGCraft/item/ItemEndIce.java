package com.MRG.ACGCraft.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.utility.LogHelper;

public class ItemEndIce extends ItemACGC{
	public ItemEndIce()
	{
		super();
		this.setUnlocalizedName("EndIce");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
	}
	
	/*
	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_,
			Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		
		if((new Random()).nextInt(40) != 0) return;
		
		//add potion and set potion name
		((EntityPlayer)p_77663_2_.playerEntities.get(0)).addPotionEffect(new PotionEffect(Potion.moveSlowdown.setPotionName("potion.endice").id, 40, 0, false));
	}*/
}
