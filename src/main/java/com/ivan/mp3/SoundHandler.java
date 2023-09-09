package com.ivan.mp3;

import com.ivan.res.ResourcesHandler;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class SoundHandler {

    BasicPlayer player;

    public SoundHandler() {
        this.player = new BasicPlayer();
    }

    public void playMusic(String songName){
        try {
            URI uri;
            uri = new ResourcesHandler().getURIFromResource(songName);
            player.open(uri.toURL());
            player.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic(){
        try {
            player.stop();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean isPlay(){
        return player.getStatus() == BasicPlayer.PLAYING;
    }
}
