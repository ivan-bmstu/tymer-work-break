package com.ivan.timer;

import com.ivan.mp3.SoundHandler;

import javax.swing.*;
import java.net.URISyntaxException;
import java.util.TimerTask;


public class CustomTimerTask extends TimerTask {

    int msecDurationSound;

    public CustomTimerTask(){
        msecDurationSound = 500;
    }

    public CustomTimerTask(int msecDurationSound){
        this.msecDurationSound = msecDurationSound;
    }

    @Override
    public void run() {
        JFrame frame = RunTimerForComputerWork.createGUI("гудок", "закрой окно чтобы выключить звонок", JFrame.DISPOSE_ON_CLOSE);
        String songName = "birdSound.mp3";
        SoundHandler player = new SoundHandler();
        player.playMusic(songName);
        while (true){
            if(!player.isPlay()) player.playMusic(songName);
            if(!frame.isVisible()) {
                player.stopMusic();
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
