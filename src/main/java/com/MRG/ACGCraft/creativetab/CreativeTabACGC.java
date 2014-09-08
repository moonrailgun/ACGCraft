package com.MRG.ACGCraft.creativetab;

import com.MRG.ACGCraft.init.ModItems;
import com.MRG.ACGCraft.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabACGC {
	public static final CreativeTabs ACGC_TAB = new CreativeTabs(Reference.MOD_ID) {
		
		@Override
		public Item getTabIconItem() {
			// TODO �Զ����ɵķ������
			return ModItems.mapleLeaf;
		}
		
		@Override
		public String getTranslatedTabLabel()
		{
			return "ACGC";
		}
	}; 
}
