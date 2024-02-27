package com.natamus.firstjoinmessage.neoforge.events;

import com.natamus.firstjoinmessage.cmds.CommandsFirstJoin;
import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeFirstSpawnEvent {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent e) {
		CommandsFirstJoin.register(e.getDispatcher());
	}
}
