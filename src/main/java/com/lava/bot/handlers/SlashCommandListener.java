package com.lava.bot.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class SlashCommandListener implements EventListener {
    static Logger log = LogManager.getRootLogger();

    @Override
    public void onEvent(GenericEvent event) {
        if (event instanceof SlashCommandInteractionEvent interaction) {
            interaction.deferReply(true).queue();
        }
    }    
}
