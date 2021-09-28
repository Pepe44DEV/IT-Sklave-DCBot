package dev.pepe44.itsklave.commands;

import dev.pepe44.itsklave.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class RolesCommand implements ServerCommand {

    @Override
    public void performCommand(Member m, TextChannel channel, Message message) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setImage("https://cdn2.unrealengine.com/Diesel%2Fblog%2Fepic-games-store-update%2FEGS_Social_Update_News-2560x1440-128a69890d92407b815582c1deba54450e5645f9.jpg");
        builder.setTitle("Roles");
        builder.addField("Info", "Reagiere mit den Unten gezeigten Emojis um Die Spiel Spezifischen bereiche frei zu Schalten", false);
        builder.setColor(Color.decode("#15ad3d"));
        channel.sendMessage(builder.build()).queue(message1 ->  {
            message1.addReaction("overwatch:892316262670147604").queue();
            message1.addReaction("league:892325560745865296").queue();
        });



    }


}
