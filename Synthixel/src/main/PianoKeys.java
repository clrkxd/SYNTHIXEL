package main;

import javax.swing.*;
import java.awt.*;

public class PianoKeys {

    private Image whiteKey;
    private Image blackKey;

//    private final int WHITE_W = 43;
//    private final int WHITE_H = 160;
//
//    private final int BLACK_W = 25;
//    private final int BLACK_H = 110;
    
    private final int WHITE_W = UIConstants.WHITE_W;
    private final int WHITE_H = UIConstants.WHITE_H;

    private final int BLACK_W = UIConstants.BLACK_W;
    private final int BLACK_H = UIConstants.BLACK_H;

    private PianoInput input;
    private SoundManager sound;

    public PianoKeys(SoundManager sound) {
    	
    	this.sound = sound;
    	
        whiteKey = new ImageIcon(
                getClass().getResource("/sprite/white_key.png"))
                .getImage();

        blackKey = new ImageIcon(
                getClass().getResource("/sprite/black_key.png"))
                .getImage();

//        sound = new SoundManager();
        input = new PianoInput(sound);
    }

    public PianoInput getInput() {
        return input;
    }

    public void draw(Graphics2D g) {    	
    	int startX = UIConstants.PIANO_X;
    	int y = UIConstants.PIANO_Y;

        int whiteCount = 10;

        // WHITE KEYS
        for (int i = 0; i < whiteCount; i++) {

            int x = startX + i * WHITE_W;

            g.drawImage(
                    whiteKey,
                    x,
                    y,
                    WHITE_W,
                    WHITE_H,
                    null);

            if (input.whitePressed[i]) {

                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(x, y, WHITE_W, WHITE_H);
            }
        }

        // BLACK KEYS
        int[] blackIndex = {0, 1, 3, 4, 5, 7, 8};

        for (int i = 0; i < blackIndex.length; i++) {

            int x =
                    startX +
                    (blackIndex[i] * WHITE_W) +
                    (WHITE_W - BLACK_W / 2);

            g.drawImage(
                    blackKey,
                    x,
                    y,
                    BLACK_W,
                    BLACK_H,
                    null);

            if (input.blackPressed[i]) {
                g.setColor(new Color(255, 255, 255, 80));
                g.fillRect(
                        x,
                        y,
                        BLACK_W,
                        BLACK_H);
            }
        }
    }
}