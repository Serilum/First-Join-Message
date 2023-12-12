package com.natamus.firstjoinmessage.forge.events;

import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeFirstSpawnEvent {
	@SubscribeEvent
	public void onSpawn(EntityJoinWorldEvent e) {
		FirstSpawnEvent.onSpawn(e.getWorld(), e.getEntity());
	}
}
