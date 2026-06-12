package ui;

import javax.swing.*;

import audio.InstrumentManager;
import audio.SoundManager;
import input.PianoInput;
import main.UIConstants;

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
    private InstrumentManager instrumentManager;

    public PianoKeys(SoundManager sound, InstrumentManager instrumentManager) {
    	
    	this.sound = sound;
    	this.instrumentManager = instrumentManager;
    	
        whiteKey = new ImageIcon(
                getClass().getResource("/sprite/white_key.png"))
                .getImage();

        blackKey = new ImageIcon(
                getClass().getResource("/sprite/black_key.png"))
                .getImage();

//        sound = new SoundManager();
        input = new PianoInput(sound, instrumentManager);
    }

    public PianoInput getInput() {
        return input;
    }
    
    private final String[] whiteLabels = {
            "A", "S", "D", "F", "G",
            "H", "J", "K", "L", ";"
    };

    private final String[] blackLabels = {
            "W", "E", "T", "Y",
            "U", "O", "P"
    };

//    public void draw(Graphics2D g) {    	
//    	int startX = UIConstants.PIANO_X;
//    	int y = UIConstants.PIANO_Y;
//
//        int whiteCount = 10;

        // WHITE KEYS
//        for (int i = 0; i < whiteCount; i++) {
//
//            int x = startX + i * WHITE_W;
//
//            g.drawImage(
//                    whiteKey,
//                    x,
//                    y,
//                    WHITE_W,
//                    WHITE_H,
//                    null);
//
//            if (input.whitePressed[i]) {
//
//                g.setColor(new Color(0, 0, 0, 80));
//                g.fillRect(x, y, WHITE_W, WHITE_H);
//            }
//        }
        
//     // WHITE KEYS
//        g.setFont(new Font("Arial", Font.BOLD, 18));
//
//        for (int i = 0; i < whiteCount; i++) {
//
//            int x = startX + i * WHITE_W;
//
//            g.drawImage(
//                    whiteKey,
//                    x,
//                    y,
//                    WHITE_W,
//                    WHITE_H,
//                    null);
//
//            if (input.whitePressed[i]) {
//
//                g.setColor(new Color(0, 0, 0, 80));
//                g.fillRect(x, y, WHITE_W, WHITE_H);
//            }
//
//            g.setColor(Color.BLACK);
//
//            FontMetrics fm = g.getFontMetrics();
//
//            int textX =
//                    x +
//                    (WHITE_W - fm.stringWidth(whiteLabels[i])) / 2;
//
//            int textY = y + WHITE_H - 15;
//
//            g.drawString(
//                    whiteLabels[i],
//                    textX,
//                    textY);
//
//        // BLACK KEYS
////        int[] blackIndex = {0, 1, 3, 4, 5, 7, 8};
////
////        for (int i = 0; i < blackIndex.length; i++) {
////
////            int x =
////                    startX +
////                    (blackIndex[i] * WHITE_W) +
////                    (WHITE_W - BLACK_W / 2);
////
////            g.drawImage(
////                    blackKey,
////                    x,
////                    y,
////                    BLACK_W,
////                    BLACK_H,
////                    null);
////
////            if (input.blackPressed[i]) {
////                g.setColor(new Color(255, 255, 255, 80));
////                g.fillRect(
////                        x,
////                        y,
////                        BLACK_W,
////                        BLACK_H);
////            }
////        }
//         // BLACK KEYS
//            g.setFont(new Font("Arial", Font.BOLD, 14));
//
//            int[] blackIndex = {0, 1, 3, 4, 5, 7, 8};
//
//            for (int i = 0; i < blackIndex.length; i++) {
//
//                int x =
//                        startX +
//                        (blackIndex[i] * WHITE_W) +
//                        (WHITE_W - BLACK_W / 2);
//
//                g.drawImage(
//                        blackKey,
//                        x,
//                        y,
//                        BLACK_W,
//                        BLACK_H,
//                        null);
//
//                if (input.blackPressed[i]) {
//
//                    g.setColor(new Color(255, 255, 255, 80));
//                    g.fillRect(
//                            x,
//                            y,
//                            BLACK_W,
//                            BLACK_H);
//                }
//
//                g.setColor(Color.WHITE);
//
//                FontMetrics fm = g.getFontMetrics();
//
//                int textX =
//                        x +
//                        (BLACK_W - fm.stringWidth(blackLabels[i])) / 2;
//
//                int textY = y + BLACK_H - 10;
//
//                g.drawString(
//                        blackLabels[i],
//                        textX,
//                        textY);
//            }
//    }
    public void draw(Graphics2D g) {

        int startX = UIConstants.PIANO_X;
        int y = UIConstants.PIANO_Y;

        int whiteCount = 10;

        // =========================
        // WHITE KEYS
        // =========================
//        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setFont(FontManager.pixel18);

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
                g.fillRect(
                        x,
                        y,
                        WHITE_W,
                        WHITE_H);
            }

            g.setColor(Color.BLACK);

            FontMetrics whiteFm = g.getFontMetrics();

            int textX =
                    x +
                    (WHITE_W - whiteFm.stringWidth(whiteLabels[i])) / 2;

            int textY = y + WHITE_H - 15;

            g.drawString(
                    whiteLabels[i],
                    textX,
                    textY);
        }

        // =========================
        // BLACK KEYS
        // =========================
//        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setFont(FontManager.pixel14);

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

            g.setColor(Color.WHITE);

            FontMetrics blackFm = g.getFontMetrics();

            int textX =
                    x +
                    (BLACK_W - blackFm.stringWidth(blackLabels[i])) / 2;

            int textY = y + BLACK_H - 10;

            g.drawString(
                    blackLabels[i],
                    textX,
                    textY);
        }
    }
}
