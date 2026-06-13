package ui;

import java.awt.Color;
import java.awt.Graphics2D;

public class DisplayManager {

	private String title = "SYNTHIXEL";
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(new Color(255, 200, 62));
		g2.setFont(FontManager.pixel32);
		g2.drawString(title, 135, 50);
	}
}
