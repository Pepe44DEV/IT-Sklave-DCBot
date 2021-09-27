package dev.pepe44.itsklave.listener;

import dev.pepe44.itsklave.ITSKLAVE;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        String message = event.getMessage().getContentDisplay();

        if (event.isFromType(ChannelType.TEXT)) {
            TextChannel channel = event.getTextChannel();

            if(message.startsWith("#")) {
                String[] args = message.substring(1).split(" ");
                if (args.length > 0) {
                    if(!ITSKLAVE.INSTANCE.getCmdMan().perform(args[0], event.getMember(), channel, event.getMessage())) {
                        channel.sendMessage("```Unbekanntes Kommando```").queue();
                    }

                }
            }

        }

    }

    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent e){
        System.out.println(e.getReactionEmote().getEmoji());
        if (e.getChannel().getId().equals(ITSKLAVE.CHANNEL_ROLES)) {
             if (e.getReactionEmote().getEmoji().equals("\\uD83D\\uDCCE")) {
                 e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById("892017040578207794"));
             }
        }
    }







}
