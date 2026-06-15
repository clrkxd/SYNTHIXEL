package ui;

import java.awt.Color;
import java.awt.Graphics2D;

import audio.InstrumentManager;

public class DisplayManager {

	private String title = "SYNTHIXEL";
	public InstrumentManager instrumentManager;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setIns(InstrumentManager instrumentManager) {
		this.instrumentManager = instrumentManager;
	}
	
	public void draw(Graphics2D g2) {
		

		g2.setColor(new Color(255, 200, 62));
		g2.setFont(FontManager.pixel32);
		g2.drawString(title, 135, 50);

		if(instrumentManager != null) {
	        String insD = instrumentManager.getCurrentInstrument().getName();
			g2.setColor(new Color(255, 200, 62));
			g2.setFont(FontManager.big32);
	        g2.drawString(insD, 50, 115);

	        int intNum = instrumentManager.getCurrentIndex();
	        String insN = String.valueOf(intNum + 1);
	        g2.setFont(FontManager.big24);
	        g2.drawString(insN, 50, 55);
	    }
		
	}
}
