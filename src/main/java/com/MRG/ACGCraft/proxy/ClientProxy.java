package com.MRG.ACGCraft.proxy;

import com.MRG.ACGCraft.client.settings.Keybindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.charge);
		ClientRegistry.registerKeyBinding(Keybindings.release);
	}
}
