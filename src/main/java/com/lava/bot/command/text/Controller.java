package com.lava.bot.command.text;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Controller {
    public static void distribute(String command, MessageReceivedEvent msg) {
        switch (command) {
            case "weather" -> Weather.exec(msg);
            default -> msg.getMessage().reply("Not found command").queue();
        }
    }
}
