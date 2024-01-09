package com.natamus.firstjoinmessage;

import com.natamus.collective.check.RegisterMod;
import com.natamus.firstjoinmessage.cmds.CommandsFirstJoin;
import com.natamus.firstjoinmessage.events.FirstSpawnEvent;
import com.natamus.firstjoinmessage.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel world) -> {
			FirstSpawnEvent.onSpawn(world, entity);
		});

		CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
			CommandsFirstJoin.register(dispatcher);
		}));
	}

	private static void setGlobalConstants() {

	}
}
