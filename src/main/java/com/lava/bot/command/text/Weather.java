package com.lava.bot.command.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Weather {
    static Logger log = LogManager.getRootLogger();

    public static void exec(MessageReceivedEvent msg) {
        log.info("command.text.Weather");



        msg.getMessage().reply("On weather").queue();
    }

    public static void getWeather(String city) {
        
    }
}
