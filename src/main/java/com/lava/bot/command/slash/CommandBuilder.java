package com.lava.bot.command.slash;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class CommandBuilder {
    public static List<CommandData> getCommands() {
        ArrayList<CommandData> cmds = new ArrayList<CommandData>() {};
        
        cmds.add(
            Commands.slash("test", "A test command")
        );

        cmds.add(
            Commands.slash("weather", "Get weather from selected city")
                .addOption(OptionType.STRING, "city", "A just city name", true)
                .setGuildOnly(true)
        );

        return cmds;
    }

    public static void syncCommands(JDA api) {
        api.updateCommands().addCommands(getCommands()).queue();
    }
}

