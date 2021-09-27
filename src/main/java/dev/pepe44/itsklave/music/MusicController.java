package dev.pepe44.itsklave.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import dev.pepe44.itsklave.ITSKLAVE;
import net.dv8tion.jda.api.entities.Guild;

public class MusicController {

    private Guild guild;
    private AudioPlayer player;

    public MusicController(Guild guild) {
        this.guild = guild;
        this.player = ITSKLAVE.INSTANCE.audioPlayerManager.createPlayer();

        this.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(player));
        this.player.setVolume(10);


    }

    public Guild getGuild() {
        return guild;
    }

    public AudioPlayer getPlayer() {
        return player;
    }
}


