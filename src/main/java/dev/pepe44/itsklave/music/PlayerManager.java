package dev.pepe44.itsklave.music;

import dev.pepe44.itsklave.ITSKLAVE;

import java.util.concurrent.ConcurrentHashMap;

public class PlayerManager {
    public ConcurrentHashMap<Long, MusicController> controller;

    public PlayerManager(){
        this.controller = new ConcurrentHashMap<Long, MusicController>();
    }

    public MusicController getController(long guildid) {
        MusicController mc = null;

        if (this.controller.containsKey(guildid)) {
            mc = this.controller.get(guildid);
        }else{
            mc = new MusicController((ITSKLAVE.INSTANCE.bot.getGuildById(guildid)));

            this.controller.put(guildid, mc);

        }

        return mc;
    }

}

