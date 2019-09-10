package com.company.Game;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.AudioFileReader;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioFileFormat.*;

public class SoundGame extends Thread {
    Clip clip;

    public SoundGame(String _Sound) {
        try {
            String filepath = "";
            if (_Sound.equals("Bom")) {
                filepath = "sound/bomb.wav";
            } else {
                if (_Sound.equals("Item")) {
                    filepath = "sound/anitem.wav";
                }
                if (_Sound.equals("die")) {
                    filepath = "sound/die.wav";
                }
                if (_Sound.equals("Nền")) {
                    filepath = "sound/nen.wav";
                }
                if (_Sound.equals("click")) {
                    filepath = "sound/click.wav";
                }
                if (_Sound.equals("Nền Game")) {
                    filepath = "sound/amnen.wav";
                }
                if (_Sound.equals("Win")) {
                    filepath = "sound/win.wav";
                }
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filepath));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Remuse() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void Stop() {
        clip.close();
    }

    @Override
    public void run() {
        try {
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
