package com.ivan.test;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestMP3 {
    public static void main(String[] args) {
        TestMP3 app = new TestMP3();
        app.playMusic();
    }

    private void playMusic(){
        String songName = "birdSound.mp3";
        try {
            BasicPlayer player = new BasicPlayer();
            URI uri;
            uri = getURIFromResource(songName);
            player.open(uri.toURL());
            player.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private URI getURIFromResource(String fileName) throws URISyntaxException{
        ClassLoader classLoader = getClass().getClassLoader();
        URI resource = classLoader.getResource(fileName).toURI();
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return resource;
        }
    }
}
