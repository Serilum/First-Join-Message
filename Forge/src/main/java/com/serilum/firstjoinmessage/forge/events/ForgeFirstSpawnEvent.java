package com.serilum.firstjoinmessage.forge.events;

import com.serilum.firstjoinmessage.events.FirstSpawnEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFirstSpawnEvent {
	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}
}
