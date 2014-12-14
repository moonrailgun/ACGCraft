package com.MRG.ACGCraft.container;

import java.util.List;

import com.MRG.ACGCraft.block.TileEntityRepairTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ContainerRepairTable extends Container {
	private TileEntityRepairTable tile;
	public ContainerRepairTable(InventoryPlayer par1,TileEntityRepairTable par2)
	{
		tile = par2;
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		System.out.println("open gui");
		return true;
	}
}
