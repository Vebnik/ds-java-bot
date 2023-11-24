package com.lava.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import io.github.cdimascio.dotenv.Dotenv;

import com.lava.bot.handlers.ReadyListener;
import com.lava.bot.handlers.SlashCommandListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lava.bot.command.slash.CommandBuilder;
import com.lava.bot.handlers.MessageListener;


public class App 
{
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws InterruptedException
    {
        Dotenv dotenv = Dotenv.load();

        JDA jda = JDABuilder.createDefault(dotenv.get("BOT_TOKEN"))
            .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
            .setActivity(Activity.playing("Type /ping"))
            .build();

        registerServiceListeners(jda);
        registerMessageListeners(jda);
        registerSlashCommandListeners(jda);

        CommandBuilder.syncCommands(jda);

        jda.awaitReady();
    }

    public static void registerServiceListeners(JDA api) {
        api.addEventListener(new ReadyListener());
    }

    public static void registerMessageListeners(JDA api) {
        api.addEventListener(new MessageListener());
    }

    public static void registerSlashCommandListeners(JDA api) {
        api.addEventListener(new SlashCommandListener());
    }
}
