package ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import main.PianoPanel;

public class MsgNotice {

    private String title = "";
    private String text = "";
    private boolean visible = false;

    // colors (Synthixel style)
    private Color bg = new Color(23, 35, 31);
    private Color border = new Color(255, 200, 62);
    private Color textColor = new Color(255, 255, 255);
    private Color titleColor = new Color(255, 200, 62);

    public void show(String title, String text) {
        this.title = title;
        this.text = text;
        this.visible = true;
    }

    public void clear() {
        visible = false;
        title = "";
        text = "";
    }

    public boolean isVisible() {
        return visible;
    }

    public void draw(Graphics2D g2) {

        if (!visible) return;

        g2.setFont(FontManager.pixel14);
        FontMetrics fm = g2.getFontMetrics();

        int padding = 20;

        int width = Math.max(
                fm.stringWidth(title),
                fm.stringWidth(text)
        ) + padding * 2;

        int height = 90;

        int x = (PianoPanel.FIN_WIDTH - width) / 2;
        int y = (PianoPanel.FIN_HEIGHT - height) / 2;

        // background
        g2.setColor(bg);
        g2.fillRect(x, y, width, height);

        // border
        g2.setColor(border);
        g2.drawRect(x, y, width, height);

        // title
        g2.setColor(titleColor);
        g2.drawString(title, x + padding, y + 25);

        // message
        g2.setColor(textColor);
        g2.drawString(text, x + padding, y + 50);

        // OK button (fake pixel button)
        g2.setColor(border);
        g2.drawRect(x + width / 2 - 25, y + 60, 50, 20);

        g2.setColor(titleColor);
        g2.drawString("OK", x + width / 2 - 8, y + 75);
    }

    // optional helper
    public void clickOK(int mouseX, int mouseY) {
        if (!visible) return;

        int width = 100;
        int height = 90;

        int x = (PianoPanel.FIN_WIDTH - width) / 2;
        int y = (PianoPanel.FIN_HEIGHT - height) / 2;

        int okX = x + width / 2 - 25;
        int okY = y + 60;

        if (mouseX >= okX && mouseX <= okX + 50 &&
            mouseY >= okY && mouseY <= okY + 20) {
            clear();
        }
    }
}