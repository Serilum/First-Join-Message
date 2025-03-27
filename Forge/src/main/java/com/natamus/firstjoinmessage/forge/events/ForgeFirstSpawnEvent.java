package com.natamus.firstjoinmessage.forge.events;

import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFirstSpawnEvent {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}
}
