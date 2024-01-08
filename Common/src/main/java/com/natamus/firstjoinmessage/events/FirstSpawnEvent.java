package com.natamus.firstjoinmessage.events;

import com.natamus.collective.functions.PlayerFunctions;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.firstjoinmessage.config.ConfigHandler;
import com.natamus.firstjoinmessage.util.Reference;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FirstSpawnEvent {
	public static void onSpawn(Level world, Entity entity) {
		if (world.isClientSide) {
			return;
		}

		if (!(entity instanceof Player player)) {
			return;
		}

		if (PlayerFunctions.isJoiningWorldForTheFirstTime(player, Reference.MOD_ID)) {
			String joinMessage = ConfigHandler.firstJoinMessage;
			String broadcastJoinMessage = ConfigHandler.firstJoinBroadcastMessage;
			Boolean useBroadcastMessage = ConfigHandler.useBroadcastMessage;
			Boolean usePlayerMessage = ConfigHandler.usePlayerMessage;
			ChatFormatting colour = ChatFormatting.getById(ConfigHandler.firstJoinMessageTextFormattingColourIndex);
			ChatFormatting broadcastColour = ChatFormatting.getById(ConfigHandler.firstJoinBroadcastMessageTextFormattingColourIndex);

			if (useBroadcastMessage && !broadcastJoinMessage.isBlank() && !(broadcastColour == null && colour == null)) {
				StringFunctions.broadcastMessage(world, broadcastJoinMessage.replace("%username%", player.getDisplayName().getString()), broadcastColour == null ? colour : broadcastColour);
			}
			if (usePlayerMessage && !joinMessage.isBlank() && colour != null) {
				StringFunctions.sendMessage(player, joinMessage.replace("%username%", player.getDisplayName().getString()), colour);
			}
		}
	}
}
