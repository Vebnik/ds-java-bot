package com.lava.bot.command.slash.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lava.bot.service.OpenWeatherClient;
import com.lava.bot.service.OpenWeatherClient.WeatherData;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Weather {
    static Logger log = LogManager.getRootLogger();

    public static void exec(SlashCommandInteractionEvent interaction) {
        log.info(String.format("On interaction - %s", interaction.getName()));

        String city = interaction.getOption("city").getAsString();
        WeatherData weather = OpenWeatherClient.getByCity(city);

        interaction.reply(
            String.format("City - %s | Feels like - %s", weather.name, weather.main.feels_like)
        ).queue();
    }
}
