package dev.pepe44.itsklave;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import dev.pepe44.itsklave.commands.CommandManager;
import dev.pepe44.itsklave.listener.CommandListener;
import dev.pepe44.itsklave.music.PlayerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class ITSKLAVE {

    public static ITSKLAVE INSTANCE;
    public AudioPlayerManager audioPlayerManager;
    public PlayerManager playerManager;
    public JDA bot;
    private CommandManager cmdMan;
    public static final String CHANNEL_ROLES = "892019593672003675";

    public static void main(String[] args) throws LoginException {
        new ITSKLAVE();
    }
    public ITSKLAVE() throws LoginException {
        INSTANCE = this;

        JDABuilder b = JDABuilder.createDefault("");
        b.setActivity(Activity.playing("#help"));
        b.setStatus(OnlineStatus.ONLINE);

        this.audioPlayerManager = new DefaultAudioPlayerManager();
        this.playerManager = new PlayerManager();
        this.cmdMan = new CommandManager();
        b.addEventListeners(new CommandListener());
        bot = b.build();
        System.out.println("Bot online");

        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        audioPlayerManager.getConfiguration().setFilterHotSwapEnabled(true);
    }

    public CommandManager getCmdMan() {
        return cmdMan;
    }
}
