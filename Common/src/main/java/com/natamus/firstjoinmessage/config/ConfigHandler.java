package com.natamus.firstjoinmessage.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.firstjoinmessage.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static String firstJoinMessage = "You wake up in an unfamiliar place.";
	@Entry(min = 0, max = 15) public static int firstJoinMessageTextFormattingColourIndex = 2;
	@Entry public static String serverBroadcastMessage = "";
	@Entry(min = 0, max = 15) public static int serverBroadcastMessageTextFormattingColourIndex = 3;

	public static void initConfig() {
		configMetaData.put("firstJoinMessage", Arrays.asList(
			"The message players will receive when they join a world for the first time. To disable, leave it empty."
		));
		configMetaData.put("firstJoinMessageTextFormattingColourIndex", Arrays.asList(
			"The colour of the message. The possible values are; 0: black, 1: dark_blue, 2: dark_green, 3: dark_aqua, 4: dark_red, 5: dark_purple, 6: gold, 7: gray, 8: dark_gray, 9: blue, 10: green, 11: aqua, 12: red, 13: light_purple, 14: yellow, 15: white."
		));
		configMetaData.put("serverBroadcastMessage", Arrays.asList(
			"A message that's broadcasted to the server when a player joins for the first time. To disable, leave it empty. %s can be used in place of the player name."
		));
		configMetaData.put("serverBroadcastMessageTextFormattingColourIndex", Arrays.asList(
			"The colour of the message. The possible values are; 0: black, 1: dark_blue, 2: dark_green, 3: dark_aqua, 4: dark_red, 5: dark_purple, 6: gold, 7: gray, 8: dark_gray, 9: blue, 10: green, 11: aqua, 12: red, 13: light_purple, 14: yellow, 15: white."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}