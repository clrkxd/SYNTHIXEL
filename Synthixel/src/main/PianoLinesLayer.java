package main;

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

//        g2.drawImage(
//                lines,
//                100,   // X
//                70,    // Y
//                600,   // W
//                330,   // H
//                null
//        );
    	
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