package com.natamus.firstjoinmessage.events;

import com.natamus.collective.functions.MessageFunctions;
import com.natamus.collective.functions.PlayerFunctions;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.firstjoinmessage.config.ConfigHandler;
import com.natamus.firstjoinmessage.util.Reference;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FirstSpawnEvent {
	public static void onSpawn(Level level, Entity entity) {
		if (level.isClientSide) {
			return;
		}

		if (!(entity instanceof Player)) {
			return;
		}

		Player player = (Player)entity;
		if (PlayerFunctions.isJoiningWorldForTheFirstTime(player, Reference.MOD_ID)) {
			if (!ConfigHandler.firstJoinMessage.equals("")) {
				ChatFormatting colour = ChatFormatting.getById(ConfigHandler.firstJoinMessageTextFormattingColourIndex);
				if (colour == null) {
					return;
				}

				StringFunctions.sendMessage(player, ConfigHandler.firstJoinMessage, colour);
			}

			if (!ConfigHandler.serverBroadcastMessage.equals("")) {
				ChatFormatting colour = ChatFormatting.getById(ConfigHandler.serverBroadcastMessageTextFormattingColourIndex);
				if (colour == null) {
					return;
				}

				MessageFunctions.broadcastMessage(level, ConfigHandler.serverBroadcastMessage, colour);
			}
		}
	}
}
