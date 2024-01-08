package com.natamus.firstjoinmessage.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.firstjoinmessage.util.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public class CommandForget {
  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(Commands.literal("forget").requires(commandSourceStack -> commandSourceStack.hasPermission(2))
      .then(Commands.argument("players", EntityArgument.players())
        .executes(context -> {
          Collection<ServerPlayer> players = EntityArgument.getPlayers(context, "players");
          if (players.isEmpty()) {
            StringFunctions.sendMessage(context.getSource(), "No player could be found.", ChatFormatting.RED);
            return 0;
          }
          for (ServerPlayer player : players) {
            player.removeTag("collective.firstJoin." + Reference.MOD_ID);
          }
          StringFunctions.sendMessage(context.getSource(), "The server forgot about the specified players, next time they join they will be greeted again.", ChatFormatting.DARK_GREEN);
          return 1;
        }))
    );
  }
}
