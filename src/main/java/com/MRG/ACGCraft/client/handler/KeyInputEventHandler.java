package com.MRG.ACGCraft.client.handler;

import com.MRG.ACGCraft.client.settings.Keybindings;
import com.MRG.ACGCraft.reference.Key;
import com.MRG.ACGCraft.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {
	private static Key getPressedKeybinding(){
		if(Keybindings.charge.isPressed()){
			return Key.CHARGE;
		}
		else if (Keybindings.release.isPressed()) {
			return Key.RELEASE;
		}
		else {
			return Key.UNKNOW;
		}
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		
	}
}
