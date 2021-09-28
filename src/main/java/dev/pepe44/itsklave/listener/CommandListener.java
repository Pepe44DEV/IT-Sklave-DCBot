package dev.pepe44.itsklave.listener;

import dev.pepe44.itsklave.ITSKLAVE;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEmoteEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
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
        System.out.println(e.getReactionEmote().getId());
        if (e.getChannel().getId().equals(ITSKLAVE.CHANNEL_ROLES)) {
            System.out.println("ss");
             if (e.getReactionEmote().getId().equals("481071864135942144")) {
                 System.out.println("reaction ressieved");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892018368171896862")).queue();

             }else if (e.getReactionEmote().getId().equals("892325560745865296")) {
                 System.out.println("league");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892017040578207794")).queue();
             }

        }
    }

    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent e) {
        System.out.println(e.getReactionEmote().getId());
        if (e.getChannel().getId().equals(ITSKLAVE.CHANNEL_ROLES)) {
            //Overwatch
            if (e.getReactionEmote().getId().equals("481071864135942144")) {
              try {
                  e.getGuild().removeRoleFromMember(e.getUser().getId(), e.getJDA().getRoleById("892018368171896862")).queue();
              }catch (NullPointerException ex) {
                  ex.printStackTrace();
              }

            }
        }
    }








}
