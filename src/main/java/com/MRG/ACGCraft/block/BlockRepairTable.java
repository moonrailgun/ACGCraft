package com.MRG.ACGCraft.block;

import com.MRG.ACGCraft.ACGCraft;
import com.MRG.ACGCraft.creativetab.CreativeTabACGC;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRepairTable extends BlockContainer {

	public BlockRepairTable(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
		this.setBlockName("RepairTable");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityRepairTable();
	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_,
			int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		p_149727_5_.openGui(ACGCraft.instance, 10, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
		return true;
	}

	
}
