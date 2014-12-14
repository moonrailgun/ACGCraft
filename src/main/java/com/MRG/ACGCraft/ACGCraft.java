package com.MRG.ACGCraft;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.MRG.ACGCraft.reference.Reference;
import com.MRG.ACGCraft.utility.LogHelper;
import com.MRG.ACGCraft.client.gui.GuiEnergyBar;
import com.MRG.ACGCraft.client.handler.ConfigurationHandler;
import com.MRG.ACGCraft.client.handler.GUIHandler;
import com.MRG.ACGCraft.client.handler.HookEventHandler;
import com.MRG.ACGCraft.client.handler.KeyInputEventHandler;
import com.MRG.ACGCraft.client.handler.command.ACGCCommandPlayMusic;
import com.MRG.ACGCraft.generators.GeneratorFailTail;
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
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
		

		//init
		ModItems.init();
		
		ModBlocks.init();
		
		proxy.registerKeyBindings();
		
		LogHelper.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//register GUI,tileEntities,crafting recipes etc.
		
		
		ModRecipe.init();
		
		GameRegistry.registerWorldGenerator(new GeneratorFailTail(), 0);
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance ,new GUIHandler());
		
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        
        LogHelper.info("Initialization Complete!");
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GuiEnergyBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new HookEventHandler());
		
		LogHelper.info("Post Initialization Complete!");
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new ACGCCommandPlayMusic());
	}
}
