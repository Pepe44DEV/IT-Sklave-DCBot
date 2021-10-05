package dev.pepe44.itsklave.listener;

import dev.pepe44.itsklave.ITSKLAVE;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEmoteEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.concurrent.ExecutionException;

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
             if (e.getReactionEmote().getId().equals("892316262670147604")) {
                 System.out.println("Overwatch");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892018368171896862")).queue();

             }else if (e.getReactionEmote().getId().equals("892325560745865296")) {
                 System.out.println("league");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892017040578207794")).queue();
             }else if (e.getReactionEmote().getId().equals("893566703626256484")) {
                 System.out.println("rl");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892019121544384563")).queue();
             }else if (e.getReactionEmote().getId().equals("893566287274446858")) {
                 System.out.println("val");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892019077919412244")).queue();
             }else if (e.getReactionEmote().getId().equals("893566103668809728")) {
                 System.out.println("csgo");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892019015906631691")).queue();
             }else if (e.getReactionEmote().getId().equals("893565946646655006")) {
                 System.out.println("r6");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892018487856357437")).queue();
             }else if (e.getReactionEmote().getId().equals("893565688504008714")) {
                 System.out.println("mc");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892018447259693106")).queue();
             }else if (e.getReactionEmote().getId().equals("893565302351228989")) {
                 System.out.println("apex");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892018309669744661")).queue();
             }else if (e.getReactionEmote().getId().equals("893565108113006645")) {
                 System.out.println("battle");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892017324775854101")).queue();
             }else if (e.getReactionEmote().getId().equals("893564297337253908")) {
                 System.out.println("cod");
                 e.getGuild().addRoleToMember(e.getUser().getId(), e.getJDA().getRoleById("892017252520591390")).queue();
             }

        }
    }

    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent e) {
        System.out.println(e.getReactionEmote().getId());
        if (e.getChannel().getId().equals(ITSKLAVE.CHANNEL_ROLES)) {
            //Overwatch
            if (e.getReactionEmote().getId().equals("892316262670147604")) {
              try {
//                  User m =e.getJDA().retrieveUserById(e.getUserIdLong()).submit().get();

                  e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892018368171896862")).queue();
              }catch (NullPointerException ex) {
                  ex.printStackTrace();
              }
              //league
            }else if (e.getReactionEmote().getId().equals("892325560745865296")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892017040578207794")).queue();
              //rl
            }else if (e.getReactionEmote().getId().equals("893566703626256484")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892019121544384563")).queue();
              //val
            }else if (e.getReactionEmote().getId().equals("893566287274446858")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892019077919412244")).queue();
              //scgo
            }else if (e.getReactionEmote().getId().equals("893566103668809728")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892019015906631691")).queue();
              //r6
            }else if (e.getReactionEmote().getId().equals("892018487856357437")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892018487856357437")).queue();
              //mc
            }else if (e.getReactionEmote().getId().equals("893565688504008714")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892018447259693106")).queue();
              //apex
            }else if (e.getReactionEmote().getId().equals("893565302351228989")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892018309669744661")).queue();
              //battle
            }else if (e.getReactionEmote().getId().equals("893565108113006645")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892017324775854101")).queue();
              //cod
            }else if (e.getReactionEmote().getId().equals("893564297337253908")) {
                e.getGuild().removeRoleFromMember(e.getUserIdLong(), e.getJDA().getRoleById("892017252520591390")).queue();
            }
        }
    }








}
