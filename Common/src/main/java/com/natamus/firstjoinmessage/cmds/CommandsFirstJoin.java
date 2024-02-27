package com.natamus.firstjoinmessage.cmds;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.firstjoinmessage.util.MessageFunctions;
import com.natamus.firstjoinmessage.util.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;
import java.util.function.Function;

public class CommandsFirstJoin {
  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    // Forget command
    dispatcher.register(Commands.literal("forget").requires(commandSourceStack -> commandSourceStack.hasPermission(2))
      .then(Commands.argument("players", EntityArgument.players())
        .executes(context -> handlePlayers(context, players -> {
          for (ServerPlayer player : players) {
            player.removeTag("collective.firstJoin." + Reference.MOD_ID);
          }
          StringFunctions.sendMessage(context.getSource(), "The server forgot about the specified players, next time they join they will be greeted again.", ChatFormatting.GRAY);
          return 1;
        }))
      )
    );
    // Greet command
    dispatcher.register(Commands.literal("greet").requires(commandSourceStack -> commandSourceStack.hasPermission(2))
      .then(Commands.argument("players", EntityArgument.players())
        .executes(context -> handlePlayers(context, players -> {
          MessageFunctions.sendBroadcastMessage(players);
          MessageFunctions.sendPrivateMessage(players);
          return 1;
        }))
        .then(Commands.literal("private")
          .executes(context -> handlePlayers(context, players -> {
            MessageFunctions.sendPrivateMessage(players);
            return 1;
          }))
        )
        .then(Commands.literal("broadcast")
          .executes(context -> handlePlayers(context, players -> {
            MessageFunctions.sendBroadcastMessage(players);
            return 1;
          }))
        )
      )
    );
  }

  private static int handlePlayers(CommandContext<CommandSourceStack> context, Function<Collection<ServerPlayer>, Integer> behavior) throws CommandSyntaxException {
    Collection<ServerPlayer> players = EntityArgument.getPlayers(context, "players");
    if (players.isEmpty()) {
      StringFunctions.sendMessage(context.getSource(), "No player could be found.", ChatFormatting.RED);
      return 0;
    }
    return behavior.apply(players);
  }
}
