package com.ivan;

import com.beust.jcommander.JCommander;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class RunTimerForComputerWork {

    public static final int DELAY_FOR_WORK_BREAK = 60*60*1000;
    public static final int TEST_DELAY = 3000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Args argsFromMain = new Args();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argsFromMain)
                .build();
        jCommander.parse(args);

        System.out.println("seconds: " + argsFromMain.seconds + "\nminutes: " + argsFromMain.minutes + "\nhours: " + argsFromMain.hours);

        int periodSeconds = argsFromMain.seconds + (argsFromMain.minutes * 60) + (argsFromMain.hours * 60 * 60);
        int periodMiliSeconds = periodSeconds * 1000;

        if (periodMiliSeconds == 0) {periodMiliSeconds = DELAY_FOR_WORK_BREAK;}

        Timer timer = new Timer();
        timer.schedule(new CustomTimerTask(100), periodMiliSeconds, periodMiliSeconds);
        createGUI("myTimer", "Закрой меня и таймер выключится", JFrame.EXIT_ON_CLOSE);
    }

    public static JFrame createGUI(String frameLabel, String labelText, int jFrameCloseVal)
    {
        JFrame frame = new JFrame(frameLabel);
        frame.setDefaultCloseOperation(jFrameCloseVal);

        JLabel label = new JLabel(labelText);
        frame.getContentPane().add(label);

        frame.setPreferredSize(new Dimension(250, 100));

        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}