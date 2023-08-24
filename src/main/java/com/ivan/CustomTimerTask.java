package com.ivan;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CustomTimerTask extends TimerTask {

    int msecDurationSound = 0;

    public CustomTimerTask(){
        msecDurationSound = 500;
    }

    public CustomTimerTask(int msecDurationSound){
        this.msecDurationSound = msecDurationSound;
    }

    @Override
    public void run() {
        JFrame frame = RunTimerForComputerWork.createGUI("гудок", "закрой окно чтобы выключить звонок", JFrame.DISPOSE_ON_CLOSE);
        try {
            while (frame.isVisible()){
                SoundUtils.tone(100,msecDurationSound, 0.05);
                SoundUtils.tone(200,msecDurationSound, 0.05);
                SoundUtils.tone(300,msecDurationSound, 0.05);
                SoundUtils.tone(400,msecDurationSound, 0.05);
                SoundUtils.tone(500,msecDurationSound, 0.05);
                SoundUtils.tone(400,msecDurationSound, 0.05);
                SoundUtils.tone(300,msecDurationSound, 0.05);
                SoundUtils.tone(200,msecDurationSound, 0.05);
                SoundUtils.tone(100,msecDurationSound, 0.05);
            }
        } catch (LineUnavailableException e) {
            System.out.println("аудио выход не доступен");
            throw new RuntimeException(e);
        }

    }
}
