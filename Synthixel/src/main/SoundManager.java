package main;

import javax.sound.sampled.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {

    private Map<String, Clip> sounds = new HashMap<>();

    public SoundManager() {

        load("C", "/sounds/c1.wav");
        load("D", "/sounds/d1.wav");
        load("E", "/sounds/e1.wav");
        load("F", "/sounds/f1.wav");
        load("G", "/sounds/g1.wav");
        load("A", "/sounds/a1.wav");
        load("B", "/sounds/b1.wav");

        load("C2", "/sounds/c2.wav");
        load("D2", "/sounds/d2.wav");
        load("E2", "/sounds/e2.wav");

        load("C#", "/sounds/c-sharp1.wav");
        load("D#", "/sounds/d-sharp1.wav");
        load("F#", "/sounds/f-sharp1.wav");
        load("G#", "/sounds/g-sharp1.wav");
        load("A#", "/sounds/a-sharp1.wav");

        load("C#2", "/sounds/c-sharp2.wav");
        load("D#2", "/sounds/d-sharp2.wav");
    }

    private void load(String key, String path) {
        try {
            URL url = getClass().getResource(path);

            if (url == null) {
                System.out.println("❌ SOUND NOT FOUND: " + path);
                return;
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);

            sounds.put(key, clip);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void play(String key) {
//        Clip clip = sounds.get(key);
//
//        if (clip == null) return;
//
//        clip.stop();
//        clip.setFramePosition(0);
//        clip.start();
//    }
    
    public void play(String key) {
        Clip clip = sounds.get(key);

        if (clip == null) return;

        try {
            FloatControl gain =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            gain.setValue(-5.0f); // volume in dB
        } catch (Exception e) {
            // Some systems/clips don't support MASTER_GAIN
        }
        
//        System.out.println("PLAYING: " + key);

        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void stop(String key) {
        Clip clip = sounds.get(key);

        if (clip == null) return;

        clip.stop();
    }
}