package com.MRG.ACGCraft.item;

import java.util.List;

import scala.reflect.internal.Trees.This;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.entity.EntityThPic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemThPic extends ItemACGC {
	
	private int title_id = getIdFromItem(this);
	
	public ItemThPic() {
		super();
		this.setUnlocalizedName("Pic");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	{
		p_77624_3_.add(StatCollector.translateToLocal("display.ACGCraft:BugItem.Line1"));
	}
	
	@Override
	public boolean onItemUse(ItemStack item_stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float x_off,
			float y_off, float z_off) {
		if (side == 0)
			return false;
		if (side == 1)
			return false;

		int direction = Direction.rotateOpposite[side-2];
		EntityThPic entity = new EntityThPic(world, x, y, z, direction, title_id);
		
		if (entity.onValidSurface()) {
			if (!world.isRemote) {
				world.spawnEntityInWorld(entity);
			}
			--item_stack.stackSize;
		}

		return true;
	}
}
