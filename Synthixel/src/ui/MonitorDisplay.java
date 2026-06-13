package ui;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import audio.InstrumentManager;

public class MonitorDisplay {

	private InstrumentManager instrumentManager;
	private Image mntr;
	
	
	public MonitorDisplay() {
		mntr = new ImageIcon(
                getClass().getResource("/sprite/monitor.png"))
                .getImage();
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(mntr, 32, 14, 267, 118, null);
	}
	
}
