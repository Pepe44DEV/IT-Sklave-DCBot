package dev.pepe44.itsklave.commands;

import dev.pepe44.itsklave.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class HelpCommand implements ServerCommand {


    @Override
    public void performCommand(Member m, TextChannel channel, Message message) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Commands");
        //builder.setDescription(help);
        builder.addField("#clear", "Löscht Channel Nachrichten", false);
        builder.addField("#play <link>", "Speilt Musik (Not Implemented yet", false);
        builder.setColor(Color.decode("#15ad3d"));
        channel.sendMessage(builder.build()).queue();


    }

}
