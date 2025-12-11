package com.natamus.firstjoinmessage.forge.events;

import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFirstSpawnEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFirstSpawnEvent.class);

		EntityJoinLevelEvent.BUS.addListener(ForgeFirstSpawnEvent::onSpawn);
	}

	@SubscribeEvent
	public static void onSpawn(EntityJoinLevelEvent e) {
		FirstSpawnEvent.onSpawn(e.getLevel(), e.getEntity());
	}
}
