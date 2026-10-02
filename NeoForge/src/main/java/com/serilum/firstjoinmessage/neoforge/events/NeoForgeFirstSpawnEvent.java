package com.serilum.firstjoinmessage.neoforge.events;

import com.serilum.firstjoinmessage.events.FirstSpawnEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class NeoForgeFirstSpawnEvent {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}
}
