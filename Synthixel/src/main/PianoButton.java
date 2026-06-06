package main;

import javax.swing.*;
import java.awt.*;

public class PianoButton {

    private Rectangle bounds;
    private String id;
	private Image image;

    public PianoButton(
            int x,
            int y,
            int width,
            int height,
            String id,
            Image image) {

        this.bounds = new Rectangle(
                x,
                y,
                width,
                height);

        this.id = id;
        this.image = image;
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(
                image,
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
    
    public int getX() {

        return bounds.x;
    }

    public int getY() {

        return bounds.y;
    }

    public int getWidth() {

        return bounds.width;
    }

    public int getHeight() {

        return bounds.height;
    }

    public Rectangle getBounds() {

        return bounds;
    }
}