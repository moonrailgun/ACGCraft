package com.MRG.ACGCraft.client.handler;

import com.MRG.ACGCraft.utility.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class SoundHandler {
	public static void onEntityPlay(String name,World world,Entity entityName,float volume,float pitch)
	{
		LogHelper.info("Music " + name + " is playing!");
		world.playSoundAtEntity(entityName, ("acgcraft:" + name), (float)volume, (float) pitch);
	}
}
