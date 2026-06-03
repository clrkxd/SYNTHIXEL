package main;

import javax.swing.*;
import java.awt.*;

public class PianoButton {

    private Rectangle bounds;
    private String id;

    private Image volume;

    public PianoButton(
            int x,
            int y,
            int width,
            int height,
            String id) {

        bounds = new Rectangle(
                x,
                y,
                width,
                height);

        this.id = id;

        volume = new ImageIcon(
                getClass().getResource("/sprite/left.png"))
                .getImage();
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(
                volume,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height,
                null);
    }

    public boolean contains(int mouseX, int mouseY) {
        return bounds.contains(mouseX, mouseY);
    }

    public String getId() {
        return id;
    }
}