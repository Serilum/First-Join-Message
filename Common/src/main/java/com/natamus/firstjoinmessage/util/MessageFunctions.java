package com.natamus.firstjoinmessage.util;

import com.natamus.collective.functions.StringFunctions;
import com.natamus.firstjoinmessage.config.ConfigHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;

public final class MessageFunctions {
  private MessageFunctions() {}

  public static void sendPrivateMessage(Collection<? extends Player> players) {
    String joinMessage = ConfigHandler.firstJoinMessage;
    Boolean usePlayerMessage = ConfigHandler.usePlayerMessage;
    ChatFormatting colour = ChatFormatting.getById(ConfigHandler.firstJoinMessageTextFormattingColourIndex);

    if (usePlayerMessage && !joinMessage.isBlank() && colour != null) {
      for (Player player : players) {
        StringFunctions.sendMessage(player, joinMessage.replace("%username%", player.getDisplayName().getString()), colour);
      }
    }
  }

  public static void sendBroadcastMessage(Collection<? extends Player> players) {
    String broadcastJoinMessage = ConfigHandler.firstJoinBroadcastMessage;
    Boolean useBroadcastMessage = ConfigHandler.useBroadcastMessage;
    ChatFormatting broadcastColour = ChatFormatting.getById(ConfigHandler.firstJoinBroadcastMessageTextFormattingColourIndex);

    if (useBroadcastMessage && !broadcastJoinMessage.isBlank() && broadcastColour != null) {
      for (Player player : players) {
        StringFunctions.broadcastMessage(player.level(), broadcastJoinMessage.replace("%username%", player.getDisplayName().getString()), broadcastColour);
      }
    }
  }
}
