package com.natamus.firstjoinmessage.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.firstjoinmessage.util.Reference;

import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();
	@Entry public static Boolean useBroadcastMessage = false;
	@Entry public static String firstJoinMessage = "You wake up in an unfamiliar place.";
	@Entry public static String firstJoinBroadcastMessage = "%username% just joined the server for the first time.";
	@Entry public static Boolean usePlayerMessage = true;
	@Entry(min = 0, max = 15) public static int firstJoinMessageTextFormattingColourIndex = 2;
	@Entry(min = 0, max = 15) public static int firstJoinBroadcastMessageTextFormattingColourIndex = 2;

	public static void initConfig() {
		configMetaData.put("usePlayerMessage", List.of(
				"Whether to send players a message when they join the first time."
		));
		configMetaData.put("firstJoinMessage", List.of(
				"The message players will receive when they join a world for the first time."
		));
		configMetaData.put("firstJoinMessageTextFormattingColourIndex", List.of(
				"The colour of the message. The possible values are; 0: black, 1: dark_blue, 2: dark_green, 3: dark_aqua, 4: dark_red, 5: dark_purple, 6: gold, 7: gray, 8: dark_gray, 9: blue, 10: green, 11: aqua, 12: red, 13: light_purple, 14: yellow, 15: white."
		));
		configMetaData.put("useBroadcastMessage", List.of(
				"Whether to send broadcast messages when a new player joins."
		));
		configMetaData.put("firstJoinBroadcastMessage", List.of(
				"The message all players will receive when a new player joins a world for the first time."
		));
		configMetaData.put("firstJoinBroadcastMessageTextFormattingColourIndex", List.of(
				"The colour of the broadcasted message. The possible values are; 0: black, 1: dark_blue, 2: dark_green, 3: dark_aqua, 4: dark_red, 5: dark_purple, 6: gold, 7: gray, 8: dark_gray, 9: blue, 10: green, 11: aqua, 12: red, 13: light_purple, 14: yellow, 15: white."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}