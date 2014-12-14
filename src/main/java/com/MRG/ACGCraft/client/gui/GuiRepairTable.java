package com.MRG.ACGCraft.client.gui;

import com.MRG.ACGCraft.block.TileEntityRepairTable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;


public class GuiRepairTable extends GuiContainer {
	
	private TileEntityRepairTable tile;

	public GuiRepairTable(Container p_i1072_1_) {
		super(p_i1072_1_);
		this.doesGuiPauseGame();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		
	}



}
