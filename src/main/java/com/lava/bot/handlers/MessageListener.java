package com.lava.bot.handlers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lava.bot.command.text.Controller;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;


public class MessageListener implements EventListener {
    static Logger log = LogManager.getRootLogger();

    @Override
    public void onEvent(GenericEvent event) {
        if (event instanceof MessageReceivedEvent msg) {
            String content = msg.getMessage().getContentDisplay();
            String info = String.format("On any message - %s", content );

            log.info(info);

            if (!content.startsWith("$"))
                return;

            msg.getChannel().sendMessage("Nice");

            String command = content.replace("$", "");
            Controller.distribute(command, msg);
        }
    }
}
