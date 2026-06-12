package ui;

import main.UIConstants;
import javax.swing.*;
import java.awt.*;

public class PianoLinesLayer {

    private Image lines;

    public PianoLinesLayer() {
        lines = new ImageIcon(
                getClass().getResource("/sprite/piano-lines.png"))
                .getImage();
    }

    public void draw(Graphics2D g2) {
    	
    	g2.drawImage(
    	        lines,
    	        UIConstants.LINES_X,
    	        UIConstants.LINES_Y,
    	        UIConstants.LINES_W,
    	        UIConstants.LINES_H,
    	        null
    	);
    }
}