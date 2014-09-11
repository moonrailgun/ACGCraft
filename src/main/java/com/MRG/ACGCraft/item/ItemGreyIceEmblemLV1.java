package com.MRG.ACGCraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;

public class ItemGreyIceEmblemLV1 extends ItemACGC {
	public ItemGreyIceEmblemLV1()
	{
		super();
		this.setUnlocalizedName("GreyIceEmblemLV1");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
	}
	/*
	@Override
	public boolean onItemUse(ItemStack item_stack, EntityPlayer player,
						World world, int x, int y, int z, int side, float x_off,
						float y_off, float z_off) {
		
		if(world.isRemote) return true;
		
    	for (int dx = -4; dx <= 4; dx++) {
    		for (int dz = -4; dz <= 4; dz++) {        
    			if (Math.abs(dx) + Math.abs(dz) > 6) continue;
    			
    			int new_x = x + dx;
    			int new_y = y;
    			int new_z = z + dz;
    			
    			set_snow_or_ice(world, new_x, new_y, new_z);
			}
    	}
		
		return true;
	}
	
	private void set_snow_or_ice(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.air) return; 
		
		if (block == Blocks.sand || block == Blocks.dirt || block == Blocks.grass) {
			
			int y1 = y + 1;
			
			Block tempblock = world.getBlock(x, y1, z);
			
			if ( tempblock == Blocks.air || tempblock == Blocks.tallgrass ) {
				world.setBlock(x, y1, z, Blocks.snow_layer); 
			}
		}
		
		if (block == Blocks.flowing_water || block == Blocks.water) {
			world.setBlock(x, y, z, Blocks.ice);
		}
	}*/
}
