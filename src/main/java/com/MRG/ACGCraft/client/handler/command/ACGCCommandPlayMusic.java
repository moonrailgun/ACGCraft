package com.MRG.ACGCraft.client.handler.command;

import java.util.Iterator;
import java.util.List;

import com.MRG.ACGCraft.client.handler.SoundHandler;
import com.MRG.ACGCraft.utility.LogHelper;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ACGCCommandPlayMusic extends CommandBase {
	@Override
	public String getCommandName() {
		return "playmusic";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/playmusic <musicname[a|b|c]>";
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) 
	{
		World world = p_71515_1_.getEntityWorld();
		EntityPlayer player;
		
		if(p_71515_1_ instanceof EntityPlayer){
                player = (EntityPlayer)p_71515_1_;
        } 
        else {
        	LogHelper.info("Player Only Command");
            return;
        }
		
		if(p_71515_2_.length == 0)
	    {
			player.addChatComponentMessage(new ChatComponentText("Invalid arguments"));
			return;
	    }
		
        SoundHandler.onEntityPlay(p_71515_2_[0], world, player, 1, 1);
	}
}
