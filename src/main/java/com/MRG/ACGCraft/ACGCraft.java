package com.MRG.ACGCraft;

import com.MRG.ACGCraft.reference.Reference;
import com.MRG.ACGCraft.utility.LogHelper;
import com.MRG.ACGCraft.handler.ConfigurationHandler;
import com.MRG.ACGCraft.init.ModBlocks;
import com.MRG.ACGCraft.init.ModItems;
import com.MRG.ACGCraft.init.ModRecipe;
import com.MRG.ACGCraft.proxy.IProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_ID, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class ACGCraft 
{
	@Mod.Instance(Reference.MOD_ID)
	public static ACGCraft instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//config,handle etc.
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler() );
		LogHelper.info("Pre Initialization Complete!");
		
		//初始化物品
		ModItems.init();
		
		ModBlocks.init();
		
		
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//register GUI,tileEntities,crafting recipes etc.
		LogHelper.info("Initialization Complete!");
		
		ModRecipe.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Post Initialization Complete!");
	}
}
