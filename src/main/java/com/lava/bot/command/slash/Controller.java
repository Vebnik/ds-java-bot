package com.lava.bot.command.slash;

import com.lava.bot.command.slash.logic.Weather;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;;

public class Controller {
    public static void distribute(String command, SlashCommandInteractionEvent interaction) {
        switch (command) {
            case "weather" -> Weather.exec(interaction);
            default -> System.out.println("default slash Controller");
        }
    }
}
