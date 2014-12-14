package com.MRG.ACGCraft.item;

import java.util.List;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.entity.EntityEndIcePearl;
import com.MRG.ACGCraft.init.ModItems;
import com.MRG.ACGCraft.reference.Reference;
import com.MRG.ACGCraft.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemEnderEye;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemEndIcePearl extends ItemSnowball {
	private int ConsumeDamage = 1000;
	
	public ItemEndIcePearl()
	{
		this.setUnlocalizedName("EndIcePearl");
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
		this.setMaxDamage(20000);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	{
		p_77624_3_.add(StatCollector.translateToLocal("display.ACGCraft:GreyIceSword.Line1"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer entityPlayer) {
		if(!entityPlayer.capabilities.isCreativeMode)
		{
			itemStack.stackSize--;
		}
		
        if (!world.isRemote)
        {
        	world.spawnEntityInWorld(new EntityEndIcePearl(world, entityPlayer));
        }
		return itemStack;
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
