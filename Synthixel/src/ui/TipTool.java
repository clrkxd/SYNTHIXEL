package ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class TipTool{

    private String text = "";
    private PianoButton hoveredButton;
//    private ButtonLayer buttonLayer;
    private Image tooltipBg;
    
    private int mouseX;
    private int mouseY;
    
    public TipTool() {

        tooltipBg = new ImageIcon(
                getClass().getResource(
                        "/sprite/mess.png"))
                .getImage();
    }
    

    public void setText(String text) {
        this.text = text;
    }

    public void show(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
    
    

    public void setHoveredButton(PianoButton hoveredButton) {
        this.hoveredButton = hoveredButton;
    }
    
    public void setPosition(int x, int y) {
        mouseX = x;
        mouseY = y;
    }
    
    public void draw(Graphics2D g2) {

        if(text.isEmpty()) return;
        
        g2.setFont(FontManager.pixel14);

//        FontMetrics fm = g2.getFontMetrics();
//
//        int width = fm.stringWidth(text) + 10;
//
//        g2.setColor(new Color(0,0,0,180));
//        g2.fillRoundRect(
//                mouseX + 10,
//                mouseY - 20,
//                width,
//                20,
//                8,
//                8);
//
//        g2.setColor(Color.WHITE);
//        g2.drawString(
//                text,
//                mouseX + 15,
//                mouseY - 5);
        
        FontMetrics fm = g2.getFontMetrics();

        int width = fm.stringWidth(text) + 16;

        int tooltipX = mouseX + 10;

        // If tooltip would go off the right edge,
        // move it to the left side of the cursor.
        if (tooltipX + width > PianoPanel.FIN_WIDTH) {
            tooltipX = mouseX - width - 10;
        }

//        g2.setColor(new Color(0,0,0,180));
//        g2.fillRoundRect(
//                tooltipX,
//                mouseY - 20,
//                width,
//                20,
//                8,
//                8);
        g2.drawImage(
                tooltipBg,
                tooltipX,
                mouseY - 20,
                width,
                20,
                null);

        g2.setColor(new Color(255, 200, 62));
        g2.drawString(
                text,
                tooltipX + 8,
                mouseY - 5);
    }
        
        
}