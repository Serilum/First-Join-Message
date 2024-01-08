package com.natamus.firstjoinmessage.forge.events;

import com.natamus.firstjoinmessage.cmds.CommandForget;
import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeFirstSpawnEvent {
	@SubscribeEvent
	public void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public void registerCommands(RegisterCommandsEvent e) {
		CommandForget.register(e.getDispatcher());
	}
}
