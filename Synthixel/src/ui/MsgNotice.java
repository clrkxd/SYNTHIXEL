package ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import main.PianoPanel;

public class MsgNotice {

    private String title = "";
    private String text = "";
    private boolean visible = false;

    private Color bg = new Color(23, 35, 31);
    private Color border = new Color(255, 200, 62);
    private Color textColor = new Color(255, 255, 255);
    private Color titleColor = new Color(255, 200, 62);
    
    private Image ok_press;
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    private int buttonX, buttonY;	
    
    public MsgNotice() {

        ok_press = new ImageIcon(
                getClass().getResource("/sprite/ok_press.png"))
                .getImage();
    }

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
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void draw(Graphics2D g2) {

        if (!visible) return;

        g2.setFont(FontManager.pixel14);
        FontMetrics fm = g2.getFontMetrics();

        int padding = 20;

        width = Math.max(
                fm.stringWidth(title),
                fm.stringWidth(text)
        ) + padding * 2;

        height = 90;

        x = (PianoPanel.FIN_WIDTH - width) / 2;
        y = (PianoPanel.FIN_HEIGHT - height) / 2;

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

        // ok button
        buttonX = x + width / 2 - UIConstants.BUTTON_W / 2;
        buttonY = y + 60;

        g2.drawImage(
                ok_press,
                buttonX,
                buttonY,
                UIConstants.BUTTON_W,
                UIConstants.BUTTON_H,
                null);
        
        g2.drawString("OK", buttonX + 12, buttonY + 15);
        
    }

    // optional helper
    public void clickOK(int mouseX, int mouseY) {
        
        if (!visible) return;
        
        if (mouseX >= buttonX &&
            mouseX <= buttonX + UIConstants.BUTTON_W &&
            mouseY >= buttonY &&
            mouseY <= buttonY + UIConstants.BUTTON_H) {

            clear();
        }
    }
    
    
}