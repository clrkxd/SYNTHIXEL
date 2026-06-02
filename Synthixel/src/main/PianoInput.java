package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PianoInput extends KeyAdapter {

    public boolean[] whitePressed = new boolean[10];
    public boolean[] blackPressed = new boolean[7];

    private boolean[] keyHeld = new boolean[256];

    private SoundManager sound;

    public PianoInput(SoundManager sound) {
        this.sound = sound;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // 🚫 BLOCK AUTO REPEAT
        if (keyHeld[key]) return;

        keyHeld[key] = true;
        setKey(key, true);
        
//        System.out.println(e.getKeyChar());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        keyHeld[key] = false;
        setKey(key, false);
    }

    private void setKey(int key, boolean pressed) {

        switch (key) {

            // 🎹 WHITE KEYS
            case KeyEvent.VK_A -> {
                whitePressed[0] = pressed;
                if (pressed) sound.play("C");
                else sound.stop("C");
            }
            case KeyEvent.VK_S -> {
                whitePressed[1] = pressed;
                if (pressed) sound.play("D");
                else sound.stop("D");
            }
            case KeyEvent.VK_D -> {
                whitePressed[2] = pressed;
                if (pressed) sound.play("E");
                else sound.stop("E");
            }
            case KeyEvent.VK_F -> {
                whitePressed[3] = pressed;
                if (pressed) sound.play("F");
                else sound.stop("F");
            }
            case KeyEvent.VK_G -> {
                whitePressed[4] = pressed;
                if (pressed) sound.play("G");
                else sound.stop("G");
            }
            case KeyEvent.VK_H -> {
                whitePressed[5] = pressed;
                if (pressed) sound.play("A");
                else sound.stop("A");
            }
            case KeyEvent.VK_J -> {
                whitePressed[6] = pressed;
                if (pressed) sound.play("B");
                else sound.stop("B");
            }
            case KeyEvent.VK_K -> {
                whitePressed[7] = pressed;
                if (pressed) sound.play("C2");
                else sound.stop("C2");
            }
            case KeyEvent.VK_L -> {
                whitePressed[8] = pressed;
                if (pressed) sound.play("D2");
                else sound.stop("D2");
            }
            case KeyEvent.VK_SEMICOLON -> {
                whitePressed[9] = pressed;
                if (pressed) sound.play("E2");
                else sound.stop("E2");
            }

            // 🎹 BLACK KEYS
            case KeyEvent.VK_W -> {
                blackPressed[0] = pressed;
                if (pressed) sound.play("C#");
                else sound.stop("C#");
            }
            case KeyEvent.VK_E -> {
                blackPressed[1] = pressed;
                if (pressed) sound.play("D#");
                else sound.stop("D#");
            }
            case KeyEvent.VK_T -> {
                blackPressed[2] = pressed;
                if (pressed) sound.play("F#");
                else sound.stop("F#");
            }
            case KeyEvent.VK_Y -> {
                blackPressed[3] = pressed;
                if (pressed) sound.play("G#");
                else sound.stop("G#");
            }
            case KeyEvent.VK_U -> {
                blackPressed[4] = pressed;
                if (pressed) sound.play("A#");
                else sound.stop("A#");
            }
            case KeyEvent.VK_O -> {
                blackPressed[5] = pressed;
                if (pressed) sound.play("C#2");
                else sound.stop("C#2");
            }
            case KeyEvent.VK_P -> {
                blackPressed[6] = pressed;
                if (pressed) sound.play("D#2");
                else sound.stop("D#2");
            }
        }
    }
}