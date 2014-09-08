package com.MRG.ACGCraft.item;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemGreyIceSword extends ItemSword{

	public ItemGreyIceSword() {
		super(Item.ToolMaterial.EMERALD);
		this.setUnlocalizedName("GreyIceSword");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
	}
	
	
	@Override
	public boolean onItemUse(ItemStack item_stack, EntityPlayer player,
						World world, int x, int y, int z, int side, float x_off,
						float y_off, float z_off) {
		// side 
    	// 0-下表面 1-上表面 
    	// 2-北表面 3-南表面 
    	// 4-西表面 5-东表面
    	// off 鼠标点击处 距离方块 东-南-上 角的位置
		
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
		
		if (block == Blocks.air) return; // 如果坐标处没有任何方块，则结束
		
		// 给泥土，沙子，草方块覆盖雪块
		if (block == Blocks.sand || block == Blocks.dirt || block == Blocks.grass) {
			
			int y1 = y + 1;
			
			Block tempblock = world.getBlock(x, y1, z);
			
			if ( tempblock == Blocks.air || tempblock == Blocks.tallgrass ) {
				world.setBlock(x, y1, z, Blocks.snow_layer); // 如果符合要求，就设置为积雪
			}
		}
		
		// 替换水为冰块
		if (block == Blocks.flowing_water || block == Blocks.water) {
			world.setBlock(x, y, z, Blocks.ice);
		}
	}
	

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    
    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
