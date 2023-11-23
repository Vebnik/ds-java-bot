package com.lava.bot.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ReadyListener implements EventListener {
    static Logger log = LogManager.getRootLogger();

    @Override
    public void onEvent(GenericEvent event)
    {
        if (event instanceof ReadyEvent ev) {
            String selfName = event.getJDA().getSelfUser().getName();
            log.info(String.format("APP is ready - %s", selfName));
        }
    }
}
