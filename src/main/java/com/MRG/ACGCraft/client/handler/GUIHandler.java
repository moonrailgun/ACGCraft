package com.MRG.ACGCraft.client.handler;

import com.MRG.ACGCraft.block.TileEntityRepairTable;
import com.MRG.ACGCraft.container.ContainerRepairTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 10:
			return new ContainerRepairTable(player.inventory,(TileEntityRepairTable)player.worldObj.getTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 10:
			return new ContainerRepairTable(player.inventory,(TileEntityRepairTable)player.worldObj.getTileEntity(x, y, z));
		}
		return null;
	}

}
