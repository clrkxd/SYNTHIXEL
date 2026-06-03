package main;

import javax.swing.*;
import java.awt.*;

public class PianoKeys extends JPanel {

    private Image whiteKey;
    private Image blackKey;

    private final int WHITE_W = 40;
    private final int WHITE_H = 180;

    private final int BLACK_W = 25;
    private final int BLACK_H = 110;

    private PianoInput input;
    private SoundManager sound;

    public PianoKeys() {

        setPreferredSize(new Dimension(11 * WHITE_W, 220));
        setBackground(Color.WHITE);
        setFocusable(true);

        // 🎨 LOAD SPRITES
//        whiteKey = new ImageIcon("res/sprite/white_key.png").getImage();
//        blackKey = new ImageIcon("res/sprite/black_key.png").getImage();
        whiteKey = new ImageIcon(
                getClass().getResource("/sprite/white_key.png"))
                .getImage();

        blackKey = new ImageIcon(
                getClass().getResource("/sprite/black_key.png"))
                .getImage();

        // 🔊 SOUND SYSTEM (LIKE YOUR 2D GAME STYLE)
        sound = new SoundManager();

        // 🎹 INPUT (PASS SOUND)
        input = new PianoInput(sound);
        addKeyListener(input);

        // 🎯 FOCUS FIX
        SwingUtilities.invokeLater(this::requestFocusInWindow);

        // 🔁 repaint loop
        new Timer(16, e -> repaint()).start();

        // 🖱 regain focus on click
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                requestFocusInWindow();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = 20;
        int y = 20;

        int whiteCount = 10;

        // 🎹 WHITE KEYS
        for (int i = 0; i < whiteCount; i++) {
            int x = startX + i * WHITE_W;

            g.drawImage(whiteKey, x, y, WHITE_W, WHITE_H, null);

            if (input.whitePressed[i]) {
                g.setColor(new Color(0, 0, 0, 80));
                g.fillRect(x, y, WHITE_W, WHITE_H);
            }
        }

        // 🎹 BLACK KEYS
        int[] blackIndex = {0, 1, 3, 4, 5, 7, 8};

        for (int i = 0; i < blackIndex.length; i++) {

            int x = startX +
                    (blackIndex[i] * WHITE_W) +
                    (WHITE_W - BLACK_W / 2);

            g.drawImage(blackKey, x, y, BLACK_W, BLACK_H, null);

            if (input.blackPressed[i]) {
                g.setColor(new Color(255, 255, 255, 80));
                g.fillRect(x, y, BLACK_W, BLACK_H);
            }
        }
    }
}