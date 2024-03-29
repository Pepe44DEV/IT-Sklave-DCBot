package dev.pepe44.itsklave.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public class AudioLoadResult implements AudioLoadResultHandler {
    private final MusicController contorller;
    private final String ur;

    public AudioLoadResult(MusicController contorller, String ur) {
        this.contorller = contorller;
        this.ur = ur;
    }


    @Override
    public void trackLoaded(AudioTrack track) {
        contorller.getPlayer().playTrack(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist audioPlaylist) {

    }

    @Override
    public void noMatches() {

    }

    @Override
    public void loadFailed(FriendlyException e) {

    }
}

