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
		
		if (!(entity instanceof Player)) {
			return;
		}
		
		Player player = (Player)entity;
		if (PlayerFunctions.isJoiningWorldForTheFirstTime(player, Reference.MOD_ID)) {
			String joinmessage = ConfigHandler.firstJoinMessage;
			String broadcastjoinmessage = ConfigHandler.firstJoinBroadcastMessage;

			ChatFormatting colour = ChatFormatting.getById(ConfigHandler.firstJoinMessageTextFormattingColourIndex);
			ChatFormatting broadcastcolour = ChatFormatting.getById(ConfigHandler.firstJoinBroadcastMessageTextFormattingColourIndex);

			if (broadcastcolour == null){
				broadcastcolour = colour;
			}
			if (colour == null) {
				return;
			}
			
			StringFunctions.broadcastMessage(world, broadcastjoinmessage, broadcastcolour);
			StringFunctions.sendMessage(player, joinmessage, colour);
		}
	}
}