package main;

import javax.sound.sampled.*;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoundManager {

    private Map<String, Clip> sounds = new HashMap<>();
    private Set<String> sustainedNotes = new HashSet<>();

    // 0-10 volume level
    private int volumeLevel = 5;

    // dB value applied to clips
    private float volumeDb;
    
    private boolean sustain = false;
    private boolean sustainEnabled = false;

    public SoundManager() {

        setVolume(volumeLevel);

        // White Keys
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

        // Black Keys
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

                System.out.println(
                        "❌ SOUND NOT FOUND: "
                        + path);

                return;
            }

            AudioInputStream ais =
                    AudioSystem.getAudioInputStream(url);

            Clip clip = AudioSystem.getClip();

            clip.open(ais);

            sounds.put(key, clip);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void play(String key) {

        Clip clip = sounds.get(key);

        if (clip == null) {
            return;
        }

        try {

            FloatControl gain =
                    (FloatControl) clip.getControl(
                            FloatControl.Type.MASTER_GAIN);

            gain.setValue(volumeDb);

        } catch (Exception e) {

            // some systems don't support gain
        }

        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public void stop(String key) {

//        Clip clip = sounds.get(key);
//
//        if (clip == null) {
//            return;
//        }
//    	if (sustain) {
//            return;
//        }
//
//        Clip clip = sounds.get(key);
//
//        if (clip == null) {
//            return;
//        }
    	Clip clip = sounds.get(key);

        if (clip == null) {
            return;
        }

        if (sustain) {
            sustainedNotes.add(key);
            return;
        }


        clip.stop();
    }


    // VOLUME
    public void setVolume(int level) {

        if (level < 0) level = 0;
        if (level > 10) level = 10;

        volumeLevel = level;

        // 0 -> -40dB
        // 10 -> 0dB
        volumeDb = -40f + (level * 4f);

        if (volumeDb > 0f) {
            volumeDb = 0f;
        }
    }

    public void increaseVolume() {

        if (volumeLevel < 10) {

            setVolume(volumeLevel + 1);
        }
    }

    public void decreaseVolume() {

        if (volumeLevel > 0) {

            setVolume(volumeLevel - 1);
        }
    }

    public int getVolumeLevel() {

        return volumeLevel;
    }

    public float getVolumeDb() {

        return volumeDb;
    }
    
    public void setSustain(boolean sustain) {
        this.sustain = sustain;
        
        if (!sustain) {

            for (String key : sustainedNotes) {

                Clip clip = sounds.get(key);

                if (clip != null) {
                    clip.stop();
                }
            }

            sustainedNotes.clear();
        }
    }
    
    public boolean isSustainEnabled() {
        return sustainEnabled;
    }

    public void toggleSustain() {
        sustainEnabled = !sustainEnabled;
    }
}