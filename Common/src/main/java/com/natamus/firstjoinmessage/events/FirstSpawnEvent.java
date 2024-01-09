package com.natamus.firstjoinmessage.events;

import com.natamus.collective.functions.PlayerFunctions;
import com.natamus.firstjoinmessage.util.MessageFunctions;
import com.natamus.firstjoinmessage.util.Reference;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public class FirstSpawnEvent {
  public static void onSpawn(Level world, Entity entity) {
    if (world.isClientSide) {
      return;
    }

    if (!(entity instanceof Player player)) {
      return;
    }

    if (PlayerFunctions.isJoiningWorldForTheFirstTime(player, Reference.MOD_ID)) {
      MessageFunctions.sendBroadcastMessage(List.of(player));
      MessageFunctions.sendPrivateMessage(List.of(player));
    }
  }
}
