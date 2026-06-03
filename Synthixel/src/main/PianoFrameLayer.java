package main;

import javax.swing.*;
import java.awt.*;

public class PianoFrameLayer {

    private Image frame;

    public PianoFrameLayer() {
        frame = new ImageIcon(
                getClass().getResource("/sprite/piano-frame.png"))
                .getImage();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(frame, 0, 0, 512, 384, null);
    }
}