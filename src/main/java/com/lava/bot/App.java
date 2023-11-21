package com.lava.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import com.lava.bot.handlers.ReadyListener;;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        JDA jda = JDABuilder.createDefault("OTU4OTg2ODYyNjQ1NjI4OTQ4.GjcGuG.VoyCROx3f8fCAlzyXBjn17iYEp2_Fl-Hjd_IdI")
            .addEventListeners(new ReadyListener())
            .build();

        jda.awaitReady();
    }
}
