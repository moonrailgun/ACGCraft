package com.MRG.ACGCraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.MRG.ACGCraft.creativetab.CreativeTabACGC;
import com.MRG.ACGCraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOPFlameFruit extends ItemFood {
	public ItemOPFlameFruit()
	{
		super(2, true);
		this.setUnlocalizedName("OPFlameFruit");
		this.setCreativeTab(CreativeTabACGC.ACGC_TAB);
		this.setAlwaysEdible();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	{
		p_77624_3_.add(StatCollector.translateToLocal("display.ACGCraft:BugItem.Line1"));
	}

	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote)
        {
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.setPotionName("potion.opflame").id, 24000, 20));
        }

        super.onFoodEaten(itemStack, world, player);
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
