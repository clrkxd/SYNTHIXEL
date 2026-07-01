package ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URI;

import javax.swing.ImageIcon;

public class AboutPage {
	
	private String title, subtitle, text;

	private UIManager uiManager;
	private Image abtScr, ghub;
	
	private final int githubX = 100;
	private final int githubY = 310;
	private final int githubWidth = 100;
	private final int githubHeight = 35;
	
	public AboutPage(UIManager uiManager) {
		this.uiManager = uiManager;
		
		abtScr = new ImageIcon(
                getClass().getResource("/sprite/abt.png"))
                .getImage();
		
		ghub = new ImageIcon(
                getClass().getResource("/sprite/github_logo.png"))
                .getImage();
	}
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(abtScr, 15, 12, 482, 364, null);
		
		g2.setColor(new Color(255, 200, 62));
		g2.setFont(FontManager.big40);
		title = "SYNTHIXEL";
		g2.drawString(title, 80, 100);
		
		g2.setFont(FontManager.pixel24);
		g2.drawString("a Java pixel art piano keyboard", 110, 120);
		
		
		g2.setFont(FontManager.pixel18);
		g2.drawString("This application software was made by", 52, 150);
		g2.setColor(new Color(255, 255, 255));
		g2.drawString("JOHN CLARK MELITAR.", 326, 150);
		
		g2.setColor(new Color(255, 200, 62));
		g2.setFont(FontManager.pixel14);
		g2.drawString("Synthixel is a lightweight, open-source virtual piano built with Java Swing.", 46, 180);
		g2.drawString("It features a fully playable keyboard with multiple instruments,", 80, 200);
		g2.drawString("real-time WAV playback, keyboard controls, recording and sustain,", 78, 220);
		g2.drawString("import/export support using .syn files, and custom pixel art—", 85, 240);
		g2.drawString("all without external libraries.", 170, 260);
		
		g2.setColor(new Color(255, 255, 255));
		g2.drawString("For more info, visit this project at", 60, 300);
		
		g2.drawImage(ghub, githubX, githubY, githubWidth, githubHeight, null);
		g2.setFont(FontManager.pixel24);
		g2.drawString("GITHUB", githubX + 35, githubY + 25);
		
		g2.setFont(FontManager.pixel14);
//		g2.drawString("https://github.com/clrkxd/synthixel", 230, 335);
		g2.drawString("click this", 230, 335);
				
		int x = 400;
	    int y = 335;

	    g2.setFont(FontManager.pixel18);
	    g2.setColor(new Color(255, 200, 62));
	    g2.drawString("BACK", x, y);
	    g2.drawString(">", x - 20, y);
	    		
		
	}
	
	
	public void mouseClicked(int mouseX, int mouseY) {

	    if (mouseX >= githubX &&
	        mouseX <= githubX + githubWidth &&
	        mouseY >= githubY &&
	        mouseY <= githubY + githubHeight) {

	        try {
	            Desktop.getDesktop().browse(
	                new URI("https://github.com/clrkxd/synthixel"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	

}
